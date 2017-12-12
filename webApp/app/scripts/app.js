'use strict';

/**
 * @ngdoc overview
 * @name webAppApp
 * @description
 * # webAppApp
 *
 * Main module of the application.
 */
angular
  .module('webAppApp', [
    'ngAnimate',
    'ngCookies',
    'ngResource',
    'ngRoute',
    'ngSanitize',
    'ngTouch',
    'ui.router'
  ])
  .config(function ($stateProvider, $urlRouterProvider) {
    $stateProvider
    .state({
      name: 'main', // 名称
      url: '/main', 
      controller: 'MainCtrl', // 控制器名称
      templateUrl: 'views/main.html' // V层名称
    })

    // 创建一个新路由
    .state({
      name: 'main.add', // 继承main路由，并声明自己的名字为add
      url: '/add',      // 相当于 /main/add 由于继承了main路由
      templateUrl: 'views/main/add.html',
      controller: 'MainAddCtrl' // 控制器名称
    })

    // 创建一个查看路由
    .state({
      name: 'main.view',
      url: '/view/:id',
      templateUrl: 'views/main/view.html',
      controller: 'MainViewCtrl'
    })

    // 创建一个编辑路由
    .state({
      name: 'main.edit',
      url: '/edit/:id',
      templateUrl: 'views/main/edit.html',
      controller: 'MainEditCtrl'
    })

    .state({
      name: 'klass', // 名称
      url: '/klass', 
      controller: 'KlassIndexCtrl', // 控制器名称
      templateUrl: 'views/klass/index.html' // V层名称
    })

      // 创建一个新路由
    .state({
      name: 'klass.add', // 继承main路由，并声明自己的名字为add
      url: '/add',      // 相当于 /main/add 由于继承了main路由
      templateUrl: 'views/klass/add.html',
      controller: 'KlassAddCtrl' // 控制器名称
    });



    $urlRouterProvider.otherwise('/main');
   
  });
