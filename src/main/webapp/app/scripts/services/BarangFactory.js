'use strict';

angular.module('Belajar')
  .factory('BarangFactory', ['$resource', function($resource) {
    var service = {
      getBarang: function(page, jumlah) {
        return $resource('/api/barang?page=' + page + '&jumlah=' + jumlah);
      },
      saveBarang: function() {
        return $resource('/api/barang', {}, {
          query: {
            method: 'POST',
            headers: {
              'Content-Type': 'application/json'
            }
          }
        });
      },
      updateBarang: function() {
        return $resource('/api/barang', {}, {
          query: {
            method: 'PUT',
            headers: {
              'Content-Type': 'application/json'
            }
          }
        });
      },
      deleteBarang: function(idBarang) {
        return $resource('/api/barang/' + idBarang, {}, {
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
  }]);
