'use strict';


// Declare app level module which depends on filters, and services
angular.module('myApp', [
  'ngRoute',
  'myApp.filters',
  'myApp.services',
  'myApp.directives',
  'LogsearchWeb.controllers'
]).
config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/view1', {templateUrl: 'partials/view1.html', controller: 'view1Controller'});
  $routeProvider.when('/view2', {templateUrl: 'partials/view2.html', controller: 'view2Controller'});
  $routeProvider.when('/getit', {templateUrl: 'partials/getit.html', controller: 'getitController'});
  $routeProvider.otherwise({redirectTo: '/view1'});
}]);
