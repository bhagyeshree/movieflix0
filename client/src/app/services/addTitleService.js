/**
 * Created by Koushik on 12/23/2016.
 */

(function () {
    'use strict';
    angular.module('movieflix')
        .service('AddTitleService',AddTitleService);
    AddTitleService.$inject = ['$http','CONFIG'];
    function AddTitleService($http,CONFIG) {

        this.addTitle = function (moviedetails) {

            var addTitleConfig = {
                url:CONFIG.API_HOST + '/admin/titles',
                method:'POST',
                data:moviedetails
            };

            return $http(addTitleConfig)
                .then(function (resp) {
                    return resp = resp.data;
                },function (err) {
                    return err;
                })
        }

    }


})();