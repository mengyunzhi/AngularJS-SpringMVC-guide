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
    'ngTouch'
  ])
  .config(function ($routeProvider) {
    $routeProvider
    // 注册一个路由地址为： /
      .when('/', {
        templateUrl: 'views/main.html', // v层文件位置为：views/main.html
        controller: 'MainCtrl',  // C层为 MainCtrl
        controllerAs: 'main'
      })

      // 注册了一个路由,地址为：/about
      .when('/about', {
        templateUrl: 'views/about.html',  // 
        controller: 'AboutCtrl',  // 
        controllerAs: 'about' // 
      })

      // 当没有找到注册的路由时，那么跳转至默认路由 /
      .otherwise({
        redirectTo: '/'
      });
  });
