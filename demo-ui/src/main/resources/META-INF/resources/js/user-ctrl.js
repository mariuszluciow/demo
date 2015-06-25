'use strict';

angular.module('app')
        .controller('UserCtrl', ['UserResource', '$scope',
            function (UserResource, $scope) {
                $scope.register = function () {
                    UserResource.save({login: $scope.login});
                };
                $scope.getUser = function () {
                    UserResource.get({login: $scope.login}).$promise.then(function (data) {
                        $scope.user = data;
                    });
                };
                $scope.activate = function () {
                    UserResource.activate({login: $scope.login});
                };
            }
        ]);





