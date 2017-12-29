'use strict';

/**
 * @ngdoc function
 * @name webAppApp.controller:KlassAddCtrl
 * @description
 * # KlassAddCtrl
 * 班级管理 增加
 */
angular.module('webAppApp')
  .controller('KlassAddCtrl', function($scope, $http, $state, teacher) {
    // 需要获取所有教师信息的后台API
    // 需要一个保存班级信息的后台API
    // 
    var self = this;

    self.init = function() {
      $scope.data = {
        name: '',
        teacher: {}
      };
    };

    self.submit = function() {
      var url = 'http://127.0.0.1:8080/Klass/';
      $http.post(url, $scope.data)
        .then(function success(response) {
          console.log(response);
          $state.transitionTo('klass', {}, { reload: true });

        }, function error() {
          console.log('请求教师列表发生错误');
        });
    };


    self.init();
    $scope.submit = self.submit;
  });
