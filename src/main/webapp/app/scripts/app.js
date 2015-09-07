'use strict';

angular
  .module('Belajar', [
    'ngRoute',
    'ngResource'
  ])
  .config(['$routeProvider', function($routeProvider) {
    $routeProvider
      .when('/', {
        templateUrl: 'app/views/main.html'
      })
      .when('/barang', {
        templateUrl: 'app/views/barang.html',
        controller: 'BarangController'
      })
      .when('/pembelian', {
        templateUrl: 'app/views/pembelian.html',
        controller: 'PembelianController'
      })
      .when('/about', {
        templateUrl: 'app/views/about.html'
      });
  }]);
