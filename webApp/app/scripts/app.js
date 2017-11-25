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
    .state({
      name: 'about', // 名称
      url: '/about', 
      controller: 'AboutCtrl', // 控制器名称
      templateUrl: 'views/about.html' // V层名称
    });

    $urlRouterProvider.otherwise('/main');
   
  });
