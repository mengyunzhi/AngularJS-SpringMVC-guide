'use strict';

/**
 * @ngdoc function
 * @name webAppApp.controller:MainEditCtrl
 * @description
 * # MainEditCtrl
 * Controller of the webAppApp
 * 教师管理 编辑
 * panjie
 */
angular.module('webAppApp')
  .controller('MainEditCtrl', function($stateParams, $http, $scope, $state) {
    // 固定写法，初始化C层文件
    var self = this;
    self.init = function() {
      // 接收ID，然后呢使用这个ID获取我们想要编辑的实体
      // 接收ID
      var id = $stateParams.id;
      // 使用这个ID去请求信息
      var url = '/Teacher/' + id;

      $http.get(url)
        .then(function success(response) {
          // 将请求来的信息绑定给V层 
          $scope.data = response.data;
        }, function error(response) {
          console.log(url + 'error');
          console.log(response);
        });
    };

    self.submit = function() {
    	var id = $stateParams.id;
    	var url = '/Teacher/' + id;

    	$http.put(url, $scope.data)
    	.then(function success(response){
    		console.log('更新成功');
    		$state.go('main', {}, {reload: true});
    	}, function error(response){
    		console.log('更新失败');
    	})

    };

    self.init();
    $scope.submit = self.submit;


  });
