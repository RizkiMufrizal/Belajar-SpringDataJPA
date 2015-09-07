'use strict';

angular.module('Belajar')
  .controller('PembelianController', ['$scope', 'PembelianFactory', function($scope, PembelianFactory) {

    $scope.dataPembelian = {};

    function getPembelian() {
      PembelianFactory.getPembelian(1, 10).get(function(data) {
        $scope.dataPembelian = data;
      });
    }

    getPembelian();

    $scope.deletePembelian = function(idPembelian) {
      PembelianFactory.deletePembelian(idPembelian).query({}).$promise.then(function(data) {
        alert(data.Info);
        getPembelian();
      });
    };

  }]);
