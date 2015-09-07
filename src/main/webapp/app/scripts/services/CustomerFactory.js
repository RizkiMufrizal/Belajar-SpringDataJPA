'use strict';

angular.module('Belajar')
  .factory('CustomerFactory', ['$resource', function($resource) {
    var service = {
      findCustomerByEmail: function(email) {
        return $resource('/api/customer/email/' + email);
      }
    };

    return service;
  }]);
