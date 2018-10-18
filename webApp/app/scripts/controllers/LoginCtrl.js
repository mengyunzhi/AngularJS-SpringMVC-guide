'use strict';

/**
 * @ngdoc function
 * @name webAppApp.controller:AboutCtrl
 * @description
 * # AboutCtrl
 * 登录控制器
 */
angular.module('webAppApp')
    .controller('LoginCtrl', function($scope, teacher) {
        var self = this;

        self.init = function() {
        	$scope.user = {
        		username: '',
        		password: ''
        	};
        };

        self.submit = function() {
        	teacher.login($scope.user)
        	.then(function success(response) {
        		console.log('success', response);
        	}, function error(response) {
        		console.log('error', response);
        	});
        };

        self.init();
        $scope.submit = self.submit;
    });
