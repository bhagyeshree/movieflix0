/**
 * Created by Koushik on 12/15/2016.
 */

(function () {
    'use strict';
    angular.module('movieflix')
        .controller('MovieController', MovieController)

    MovieController.$inject = ['MovieService'];
    function MovieController(MovieService) {
        var mVm = this;

        mVm.pageSize = 18;
        mVm.currentPage = 1;
        MovieService.getMovies()
            .then(successFn, errorFn);

        function successFn(resp) {
            mVm.movies = resp;
        }

        function errorFn(err) {
            console.log(err);
        }
    }

})();