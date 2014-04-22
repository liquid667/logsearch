'use strict';

/* Services */

var services = angular.module('LogsearchWeb.services', []);

services.value('version', '0.1');

services.factory('loginService', function($http) {
    var loginAPI = {};

    loginAPI.login = function(user) {
        return $http({
            method: 'JSONP',
            url: 'http://localhost:8084/logsearch-backend/webapi/authenticate?username=' + user.username + '&password=' + user.password + '&callback=JSON_CALLBACK'
        });
    };

    return loginAPI;

});