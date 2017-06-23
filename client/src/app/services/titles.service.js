/**
 * Created by Koushik on 12/22/2016.
 */
(function () {
    'use strict';
    angular.module('movieflix')
        .service('TitlesService',TitlesService);
    TitlesService.$inject = ['$http','CONFIG'];

    function TitlesService($http,CONFIG) {
        this.getTitles = function () {

            var titlesConfig = {
                url:CONFIG.API_HOST+'/titles',
                method:'GET'
            };

            return $http(titlesConfig)
                .then(function (resp) {
                    return resp.data;
                },function (err) {
                    return err;
                })
        }
    }
})();
