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
    }]);

/* loginController */
controllers.controller('loginController', ['$scope', '$http', 'loginService', function($scope, $http, loginService) {
        $scope.data = null;
        $scope.status = null;

        $http.jsonp('http://localhost:8084/logsearch-backend/webapi/authenticate?username=mikjoh&password=s3cr3t&callback=JSON_CALLBACK')
                .success(function(data, status) {
                    $scope.data = data;
                    $scope.status = status;
                })
                .error(function(data, status) {
                    $scope.data = data;
                    $scope.status = status;
                });
    }]);

controllers.controller('myController', ['$scope', 'loginService', function($scope, loginService) {
        
}]);