'use strict';

/**
 * @ngdoc function
 * @name webAppApp.controller:KlassIndexCtrl
 * @description
 * # KlassIndexCtrl
 * 班级管理 列表页
 */
angular.module('webAppApp')
  .controller('KlassIndexCtrl', function($http, $scope) {
    var self = this;

    self.init = function() {
    	var url = 'http://127.0.0.1:8080/Klass/';
            $http.get(url)
            .then(function success(response){
                $scope.lists = response.data;
            }, function error(){
                console.log('请求教师列表发生错误');
            });
    };

    self.init();

  });
