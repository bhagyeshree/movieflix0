/**
 * Created by Koushik on 12/22/2016.
 */
(function () {
    'use strict';
    angular.module('movieflix')
        .service('MovieUpdateService',MovieUpdateService);
    MovieUpdateService.$inject = ['$http','CONFIG'];
    function MovieUpdateService($http,CONFIG) {
        this.updateTitle = function (id, moviedetails) {

            var updateTitleConfig = {
                url:CONFIG.API_HOST+'/admin/titles/'+id,
                method:'PUT',
                data:moviedetails
            }

            return $http(updateTitleConfig)
                .then(function (resp) {
                    return resp = resp.status;
                },function (err) {
                    return err;
                })
        }
    }
})();