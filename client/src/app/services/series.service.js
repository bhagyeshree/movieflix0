/**
 * Created by Koushik on 12/19/2016.
 */
(function () {
    'use strict';
    angular.module('movieflix')
        .service('SeriesService',SeriesService);
    SeriesService.$inject = ['$http','CONFIG'];

    function SeriesService($http,CONFIG) {
        this.getSeries = function () {

            var seriesConfig = {
                url:CONFIG.API_HOST+'/titles/type/series',
                method:'GET'
            };

            return $http(seriesConfig)
                .then(function (resp) {
                    return resp.data;
                },function (err) {
                    return err;
                })
        }
    }
})();