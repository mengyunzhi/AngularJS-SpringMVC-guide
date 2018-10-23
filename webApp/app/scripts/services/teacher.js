'use strict';

/**
 * @ngdoc service
 * @name webAppApp.teacher
 * @description
 * # 教师
 * Service in the webAppApp.
 */
angular.module('webAppApp')
    .service('teacher', function($http) {
        // AngularJS will instantiate a singleton by calling "new" on this function
        var self = this;

        // 观察者
        self.observerCallbacks = [];

        // 注册观察者
        self.registerObserverCallback = function(callback) {
            self.observerCallbacks.push(callback);
        };  


        // 通知观察者们
        self.notifyObserver = function(currentLoginTeacher) {
            angular.forEach(self.observerCallbacks, function(callback) {
                callback(currentLoginTeacher);
            });
        };

        /**
         * 获取所有的教师
         * @param  {Function} callback [description]
         * @return {[type]}            [description]
         */
        self.getAllTeachers = function(callback) {
            var url = '/Teacher/';
            $http.get(url)
                .then(function success(response) {
                    if (callback) {
                        callback(response.data);
                    }
                }, function error() {
                    console.log('请求教师列表发生错误');
                });
        };

        // 用户登录
        self.login = function(user) {
            var url = '/Teacher/login';
            return $http.post(url, user);
        };

        self.logout = function(callback) {
            var url = '/Teacher/logout';
            $http.post(url)
                .then(function success(response) {
                    self.notifyObserver({});
                    if (callback) { callback(response); }
                }, function error(response) {
                    console.error('logout error:', response);
                });
        };

        // 获取当前登录教师
        self.getCurrentLoginTeacher = function(callback) {
            var url = '/Teacher/me';
            $http.get(url)
                .then(function success(response) {
                    self.notifyObserver(response.data);
                    if (callback) {callback(response.data);}
                }, function error(response) {
                    var teacher = {};
                    self.notifyObserver(teacher);
                    console.error('获取当前登录教师错误', response);
                });
        };

        return {
            getAllTeachers: self.getAllTeachers,
            login: self.login,
            logout: self.logout,
            getCurrentLoginTeacher: self.getCurrentLoginTeacher,
            registerObserverCallback: self.registerObserverCallback
        };
    });
