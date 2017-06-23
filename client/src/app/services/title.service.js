/**
 * Created by Koushik on 12/20/2016.
 */

(function () {
    'use strict';
    angular.module('movieflix')
        .service('TitleService',TitleService);

    TitleService.$inject = ['$http','$q','CONFIG'];
    function TitleService($http,$q,CONFIG) {
        this.getTitle = function (id) {

            var defer = $q.defer();

            var titleConfig = {
                url:CONFIG.API_HOST+'/titles/'+id,
                method:'GET'
            }

            $http(titleConfig)
                .then(function (resp) {
                    defer.resolve(resp.data);
                },function (err) {
                    defer.reject(err);
                })


            return defer.promise;
        }
    }
})();