'use strict';

/**
 * @ngdoc filter
 * @name webAppApp.filter:yunzhiSex
 * @function
 * @description
 * # 性别过滤器
 * 为真显示男，否则女
 * @Author panjie
 */
angular.module('webAppApp')
    .filter('yunzhiSex', function () {
        return function (input) {
            var output = '';
            if (input) {
                output = '男';
            } else {
                output = '女';
            }

            return output;
        };
    });
