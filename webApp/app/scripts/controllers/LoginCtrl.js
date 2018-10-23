'use strict';

/**
 * @ngdoc function
 * @name webAppApp.controller:AboutCtrl
 * @description
 * # AboutCtrl
 * 登录控制器
 */
angular.module('webAppApp')
    .controller('LoginCtrl', function($scope, teacher, $location) {
        var self = this;

        self.init = function() {
        	$scope.user = {
        		username: '',
        		password: ''
        	};

        	// 显示出错信息
        	$scope.showErrorBox = false;
        };

        self.submit = function() {
        	teacher.login($scope.user)
        	.then(function success(response) {
        		$scope.showErrorBox = false;
                teacher.getCurrentLoginTeacher(function() {
                    $location.url('/main');
                });
        	}, function error(response) {
        		$scope.showErrorBox = true;
        		console.log('error', response);
        	});
        };

        self.init();
        $scope.submit = self.submit;
    });
