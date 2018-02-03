'use strict';

/**
 * @ngdoc function
 * @name webAppApp.controller:KlassIndexCtrl
 * @description
 * # KlassIndexCtrl
 * 班级管理 列表页
 */
angular.module('webAppApp')
    .controller('KlassIndexCtrl', function ($http, $scope, klass) {
        var self = this;

        // 初始化
        self.init = function () {
            $scope.params = {page: 0, size: 3};
            self.load();
        };

        // 加载数据
        self.load = self.reload = function () {
            klass.page($scope.params, function (data) {
                $scope.data = data;
            });
        };

        // 分页时重新加载数据
        self.reloadByPage = function (page) {
            $scope.params.page = page;
            self.reload();
        };

        // 进行每页大小
        self.reloadBySize = function(size) {
            $scope.params.size = size;
            self.load();
        };

        /**
         * 删除
         * @param  {[type]} object 要删除的对象
         * @return {}
         * panjie
         */
        self.delete = function (object) {
            // 应该去触发后台的删除操作
            klass.delete(object, function () {
                // 将元素隐藏掉
                object._delete = true;
            });
        };

        self.init();
        $scope.delete = self.delete;
        $scope.reloadByPage = self.reloadByPage;
        $scope.reloadBySize = self.reloadBySize;
    });
