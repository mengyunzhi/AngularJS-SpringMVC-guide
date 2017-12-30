'use strict';

/**
 * @ngdoc directive
 * @name webAppApp.directive:yunzhiPage
 * @description
 * # 分页
 * panjie
 */
angular.module('webAppApp')
    .directive('yunzhiPage', function () {
        return {
            templateUrl: 'views/directive/yunzhiPage.html',
            restrict: 'E',
            link: function postLink(scope, element, attrs) {

            }
        };
    });
