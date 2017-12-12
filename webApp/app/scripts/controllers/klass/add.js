'use strict';

/**
 * @ngdoc function
 * @name webAppApp.controller:KlassAddCtrl
 * @description
 * # KlassAddCtrl
 * 班级管理 增加
 */
angular.module('webAppApp')
  .controller('KlassAddCtrl', function ($scope, $http) {
    	// 需要获取所有教师信息的后台API
    	// 需要一个保存班级信息的后台API
    	// 
    	var self = this;

    	self.init = function() {
            $scope.data = {
                name: '',
                teacher: {}
            };
            self.getAllTeachers();

    	};

        /**
         * 获取所有的教师
         * @return
         * panjie
         */
        self.getAllTeachers = function() {
            var url = 'http://127.0.0.1:8080/Teacher/';
            $http.get(url)
            .then(function success(response){
                $scope.teachers = response.data;
            }, function error(){
                console.log('请求教师列表发生错误');
            });
        };


    	self.submit = function() {
    		 var url = 'http://127.0.0.1:8080/Klass/';
             $http.post(url, $scope.data)
             .then(function success(response){
                console.log(response);
            }, function error(){
                console.log('请求教师列表发生错误');
            });
    	};


    	self.init();
    	$scope.submit = self.submit;
  });
