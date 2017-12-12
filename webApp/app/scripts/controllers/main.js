'use strict';

/**
 * @ngdoc function
 * @name webAppApp.controller:MainCtrl
 * @description
 * # MainCtrl
 * 首页控制制
 * Controller of the webAppApp
 */
angular.module('webAppApp')
  .controller('MainCtrl', function($scope, $http) {
    var self = this;
    // 定义url请求地址
    var url = 'http://127.0.0.1:8080/Teacher';

    // 定义一个方法，名字为success , 参数为response
    var success = function(response) {
      $scope.lists = response.data;
      console.log('success');
    };

    /**
     * 定义一个error方法
     * @return {[type]} [description]
     */
    var error = function() {
      console.log('error');
    };

    // 发起请求，并获取一个promise对象
    var promise = $http.get(url);

    // 调用这个对象的then方法，当上面的请求成功时，调用第一个参数（success),并且把请求的信息给sucess方法的第一个参数
    // 当请求失败时，调用第二个方法 error
    promise.then(success, error);

    self.delete = function(teacher) {
       var url = 'http://127.0.0.1:8080/Teacher/' + teacher.id;
       $http.delete(url)
       .then(function success(){
          console.log('删除数据成功');
       }, function error(){
          console.log('error');
       });
    };

    $scope.delete = self.delete;


  });
