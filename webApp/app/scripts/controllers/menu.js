'use strict';

/**
 * @ngdoc function
 * @name webAppApp.controller:MenuCtrl
 * @description
 * # MenuCtrl
 * 菜单导航
 * panjie
 */
angular.module('webAppApp')
    .controller('MenuCtrl', function ($scope, $state, $timeout) {
        var self = this;
        self.init = function() {

        };

        self.isActive = function(name) {
            // 如果当前的路由是teacher，返回真
            if ($state.current.name === name) {
                return true;
            } else {
                return false;
            }
        };

        self.init();
        $scope.isActive = self.isActive;

    });
