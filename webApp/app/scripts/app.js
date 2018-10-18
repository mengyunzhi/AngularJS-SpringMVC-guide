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
    .config(function ($provide) {
        $provide.constant('routes',
            [
                {
                    name: 'main', // 名称
                    url: '/main',
                    controller: 'MainCtrl', // 控制器名称
                    templateUrl: 'views/main.html', // V层名称
                    data: {
                        title: '教师管理',
                        show: true
                    }
                },
                {
                    name: 'main.add', // 继承main路由，并声明自己的名字为add
                    url: '/add', // 相当于 /main/add 由于继承了main路由
                    templateUrl: 'views/main/add.html',
                    controller: 'MainAddCtrl', // 控制器名称
                    data: {
                        title: '增加',
                        show: false
                    }
                },
                {
                    name: 'main.edit',
                    url: '/edit/:id',
                    templateUrl: 'views/main/edit.html',
                    controller: 'MainEditCtrl',
                    data: {
                        title: '编辑',
                        show: false
                    }
                },
                {
                    name: 'main.view',
                    url: '/view/:id',
                    templateUrl: 'views/main/view.html',
                    controller: 'MainViewCtrl',
                    data: {
                        title: '查看',
                        show: false
                    }
                },
                {
                    name: 'klass', // 名称
                    url: '/klass',
                    controller: 'KlassIndexCtrl', // 控制器名称
                    templateUrl: 'views/klass/index.html', // V层名称
                    data: {
                        title: '班级管理',
                        show: true
                    }
                },
                {
                    name: 'klass.add', // 继承klass路由，并声明自己的名字为add
                    url: '/add', // 相当于 /klass/add 由于继承了klass路由
                    templateUrl: 'views/klass/add.html',
                    controller: 'KlassAddCtrl', // 控制器名称
                    data: {
                        title: '增加',
                        show: false
                    }
                },
                {
                    name: 'klass.edit', // 继承klass路由，并声明自己的名字为edit
                    url: '/edit/:id', // 相当于 /klass/edit 由于继承了klass路由
                    templateUrl: 'views/klass/edit.html',
                    controller: 'KlassEditCtrl', // 控制器名称
                    data: {
                        title: '编辑',
                        show: false
                    }
                }
            ]);
    })
    .config(function ($stateProvider, $urlRouterProvider, $provide, $httpProvider, routes) {
        // 循环注册路由
        angular.forEach(routes, function (value) {
            $stateProvider
                .state(value);
        });

        $urlRouterProvider.otherwise('/main');

        // 注册一个用于拦截http的拦截器
        $provide.factory('myHttpInterceptor', function () {
            return {
                // 拦截请求信息
                'request': function (config) {
                    // 如果以html结尾，那么就不进行URL的改写, 否则就进行改写
                    var suffix = config.url.split('.').pop();
                    if (suffix !== 'html') {
                        config.url = 'http://localhost:8200/api' + config.url;
                    }

                    return config;
                }
            };
        });

        $httpProvider.interceptors.push('myHttpInterceptor');

    });
