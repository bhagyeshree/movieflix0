/**
 * Created by Koushik on 12/19/2016.
 */

(function () {
    'use strict';
    angular.module('movieflix')
        .service('MovieService',MovieService);

    MovieService.$inject = ['$http','CONFIG'];
    function MovieService($http,CONFIG) {

        this.getMovies = function () {

            var config = {

                method:'GET',
                url:CONFIG.API_HOST+'/titles/type/movie'
            }
            
            return $http(config).then(function (resp) {
                return resp.data;
            },function (err) {
                console.log(err);
                return err;
            })
        }
    }
})();