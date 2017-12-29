'use strict';

/**
 * @ngdoc service
 * @name webAppApp.klass
 * @description
 * # klass
 * 班级
 */
angular.module('webAppApp')
    .service('klass', function ($http) {
        var self = this;
        self.delete = function(object, callback) {
            var url = '/Klass/' + object.id;
            $http.delete(url)
            .then(function success(response) {
                if (callback)  {callback();}
            }, function error(response) {
                console.log('error', response);
            });
            
        };

        return {
            delete: self.delete
        };
    });
