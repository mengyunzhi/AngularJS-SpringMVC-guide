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
        // 
        var self = this;

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
                if (callback) {callback(response);}
            }, function error(response) {
                console.error('logout error:', response);
            });
        };

        return {
            getAllTeachers: self.getAllTeachers,
            login: self.login,
            logout: self.logout
        };
    });
