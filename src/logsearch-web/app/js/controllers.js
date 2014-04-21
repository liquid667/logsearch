'use strict';

/* Controllers */

var controllers = angular.module('LogsearchWeb.controllers', []);

controllers.controller('view1Controller', [function() {

    }]);

controllers.controller('view2Controller', [function() {

    }]);
controllers.controller('getitController', ['$scope', '$http', function($scope, $http) {
        $scope.data = null;
        $scope.status = null;

        $http.jsonp('http://localhost:8084/logsearch-backend/webapi/helloworld?callback=JSON_CALLBACK')
                .success(function(data, status) {
                    $scope.data = data;
                    $scope.status = status;
                })
                .error(function(data, status) {
                    $scope.data = data;
                    $scope.status = status;
                });

//        $http({
//            method: 'JSONP',
//            url: 'http://localhost:8084/logsearch-backend2/webapi/myresource?callback=JSON_CALLBACK'
//        }).success(function(data, status, headers, config) {
//            $scope.data = data;
//            $scope.status = status;
//        }).error(function(data, status, headers, config) {
//            $scope.message = data || 'request failed!';
//            $scope.status = status;
//        });
    }]);
