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
  .controller('MainCtrl', function ($scope) {
  	var lists = [
  		{
  			id: 1,
  			username: 'zhangsan',
  			name: '张三',
  			email: 'zhangsan@yunzhiclub.com',
  			sex: '男'
  		},
  		{
  			id: 2,
  			username: 'lisi',
  			name: '李四',
  			email: 'lisi@yunzhiclub.com',
  			sex: '女'
  		}
  	];
  	console.log(lists);
  	$scope.lists = lists;
    this.awesomeThings = [
      'HTML5 Boilerplate',
      'AngularJS',
      'Karma'
    ];
    console.log('hello world1!');
  });
