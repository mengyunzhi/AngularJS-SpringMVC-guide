'use strict';

/**
 * @ngdoc function
 * @name webAppApp.controller:MainCtrl
 * @description
 * # MainCtrl
 * 首页控制制
 * Controller of the webAppApp
 */
angular.module('webAppApp')
  .controller('MainCtrl', function($scope, $http, $state) {
    var self = this;
    self.init = function() {
      // 定义url请求地址
      var url = '/Teacher';

      $http.get(url)
        .then(function success(response) {
          $scope.lists = response.data;
          console.log('success');
        }, function error() {
          console.log('error');
        });
    };


    self.delete = function(teacher) {
      var url = '/Teacher/' + teacher.id;
      $http.delete(url)
        .then(function success() {
          console.log('删除数据成功');
          $state.reload();
        }, function error() {
          console.log('error');
        });
    };

    self.init();
    $scope.delete = self.delete;

  });
