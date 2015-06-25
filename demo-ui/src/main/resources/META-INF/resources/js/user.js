'use strict';

angular.module('app')
        .factory('UserResource', ['$resource',
            function ($resource) {
                return $resource('/user', {}, {
                    activate: {method: 'POST', url: '/user/:login', params: {login: '@login'}},
                    get: {method: 'GET', url: '/user/:login'}
                });
            }
        ]);





