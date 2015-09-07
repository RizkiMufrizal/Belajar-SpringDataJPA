'use strict';

angular.module('Belajar')
  .factory('PembelianFactory', ['$resource', function($resource) {
    var service = {
      getPembelian: function(page, jumlah) {
        return $resource('/api/pembelian?page=' + page + '&jumlah=' + jumlah);
      },
      savePembelian: function(idCustomer, idBarang) {
        return $resource('/api/pembelian?idCustomer=' + idCustomer + '&idBarang=' + idBarang, {}, {
          query: {
            method: 'POST',
            headers: {
              'Content-Type': 'application/json'
            }
          }
        });
      },
      deletePembelian: function(idPembelian) {
        return $resource('/api/pembelian/' + idPembelian, {}, {
          query: {
            method: 'DELETE',
            headers: {
              'Content-Type': 'application/json'
            }
          }
        });
      }
    };

    return service;

  }])
