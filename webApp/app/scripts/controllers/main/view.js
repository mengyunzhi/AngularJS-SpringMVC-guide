'use strict';

/**
 * @ngdoc function
 * @name webAppApp.controller:MainViewCtrl
 * @description
 * # MainViewCtrl
 * Controller of the webAppApp
 */
angular.module('webAppApp')
  .controller('MainViewCtrl', function($stateParams, $http, $scope) {
    var self = this;
    self.init = function() {
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

    // 调用这个init方法来初始化
    self.init();
  });
