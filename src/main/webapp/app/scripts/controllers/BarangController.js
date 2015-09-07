'use strict';

angular.module('Belajar')
  .controller('BarangController', ['$scope', 'BarangFactory', 'PembelianFactory', 'CustomerFactory', function($scope, BarangFactory, PembelianFactory, CustomerFactory) {

    //Barang

    $scope.dataBarang = {};
    $scope.inputBarang = {};

    function getDataBarang() {
      BarangFactory.getBarang(1, 10).get(function(data) {
        $scope.dataBarang = data;
      });
    }

    getDataBarang();

    $scope.clear = function() {
      $scope.inputBarang.namaBarang = '';
      $scope.inputBarang.jenisBarang = '';
      $scope.inputBarang.jumlahBarang = '';
      $scope.inputBarang.tanggalKadaluarsa = '';
      $scope.enable = false;
    };

    $scope.tambahBarang = function(b) {
      BarangFactory.saveBarang().query({}, b).$promise.then(function(data) {
        getDataBarang();
        console.log(data);
      });
    };

    $scope.edit = function(b) {
      $scope.inputBarang.namaBarang = b.namaBarang;
      $scope.inputBarang.jenisBarang = b.jenisBarang;
      $scope.inputBarang.jumlahBarang = b.jumlahBarang;
      $scope.inputBarang.tanggalKadaluarsa = b.tanggalKadaluarsa;
      $scope.enable = true;
    };

    $scope.updateBarang = function(b) {
      BarangFactory.updateBarang().query({}, b).$promise.then(function(data) {
        getDataBarang();
        console.log(data);
      });
    };

    $scope.deleteBarang = function(idBarang) {
      BarangFactory.deleteBarang(idBarang).query({}).$promise.then(function(data) {
        getDataBarang();
        console.log(data);
      });
    };

    //pembelian

    $scope.inputPembelianBarang = {};

    $scope.pilihBarang = function(b) {
      $scope.inputPembelianBarang.idBarang = b.idBarang;
      $scope.inputPembelianBarang.namaBarang = b.namaBarang;
      $scope.inputPembelianBarang.hargaBarang = b.hargaBarang;
      $scope.inputPembelianBarang.email = '';
      $scope.inputPembelianBarang.jumlahBarang = '';
    };

    $scope.pembelianBarang = function(p) {
      CustomerFactory.findCustomerByEmail(p.email).get(function(data) {
        if (data.customer !== null) {
          p.totalHarga = p.hargaBarang * p.jumlahBarang;
          PembelianFactory.savePembelian(data.customer.idCustomer, p.idBarang).query({}, p).$promise.then(function(data) {
            getDataBarang();
            alert('data tersimpan');
          });
        } else {
          alert('Data user tidak ada');
        }
      });
    };

  }]);
