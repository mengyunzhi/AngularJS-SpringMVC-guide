'use strict';

/**
 * @ngdoc function
 * @name webAppApp.controller:KlassAddCtrl
 * @description
 * # KlassAddCtrl
 * 班级管理 增加
 */
angular.module('webAppApp')
  .controller('KlassAddCtrl', function ($scope) {
    	// 需要获取所有教师信息的后台API
    	// 需要一个保存班级信息的后台API
    	// 
    	var self = this;

    	self.init = function() {

    	};

    	self.submit = function() {
    		console.log('hello');
    	};

    	self.init();
    	$scope.submit = self.submit;
  });
