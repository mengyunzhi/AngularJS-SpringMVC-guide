'use strict';

/**
 * @ngdoc function
 * @name webAppApp.controller:MainAddCtrl
 * @description
 * # MainAddCtrl
 * Controller of the webAppApp
 * 教师管理 增加
 */
angular.module('webAppApp')
  .controller('MainAddCtrl', function($scope, $http) {
    // 初始化操作
    var self = this;
    self.init = function() {
      $scope.data = {
        username: '',
        name: '',
        sex: 'true',
        email: ''
      };
    };

    self.submit = function() {
    	// 把数据提交到 /Teadcher/ 这个地址，提交的方法为post
    	var url = '/Teacher/';
    	$http.post(url)
    	.then(function(response){
    		console.log('success');
    	}, function(response){
    		console.log('error');
    	});
    }
    
    self.init();
    $scope.submit = self.submit();
  });
