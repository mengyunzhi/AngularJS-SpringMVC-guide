'use strict';

/**
 * @ngdoc directive
 * @name webAppApp.directive:yunzhiTeacherList
 * @description
 * # yunzhiTeacherList
 */
angular.module('webAppApp')
    .directive('yunzhiTeacherList', function (teacher) {
        var self = {};
        /**
         * 获取所有的教师
         * @return
         * panjie
         */
        self.getAllTeachers = function($scope) {
            teacher.getAllTeachers(function(teachers) {
                $scope.teachers = teachers;
            });
        };
    
        return {
            templateUrl: 'views/directive/yunzhiTeacherList.html',
            restrict: 'E',
            link: function postLink($scope) {
                self.getAllTeachers($scope);
            }
        };
  });
