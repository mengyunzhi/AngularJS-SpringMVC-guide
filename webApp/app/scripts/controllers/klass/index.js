'use strict';

/**
 * @ngdoc function
 * @name webAppApp.controller:KlassIndexCtrl
 * @description
 * # KlassIndexCtrl
 * 班级管理 列表页
 */
angular.module('webAppApp')
  .controller('KlassIndexCtrl', function($http, $scope, klass) {
    var self = this;

    self.init = function() {
    	var url = '/Klass/';
            $http.get(url)
            .then(function success(response){
                $scope.lists = response.data;
            }, function error(){
                console.log('请求教师列表发生错误');
            });
    };

    /**
     * 删除
     * @param  {[type]} object 要删除的对象
     * @return {}        
     * panjie
     */
    self.delete = function(object) {
        // 应该去触发后台的删除操作
        klass.delete(object, function() {
            // 将元素隐藏掉
            object._delete = true;
        });
    };

    self.init();
    $scope.delete = self.delete;

  });
