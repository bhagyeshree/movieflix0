/**
 * Created by Koushik on 12/19/2016.
 */
(function () {
    'use strict';
    angular.module('movieflix')
        .config(movieConfig);

    movieConfig.$inject = ['$routeProvider', '$locationProvider'];
    function movieConfig($routeProvider, $locationProvider) {
        $routeProvider
            .when('/home', {
                templateUrl: 'app/movies/homepage.html'
            })
            .when('/movies', {
                templateUrl: 'app/movies/movieslist.html',
                controller: 'MovieController',
                controllerAs: 'mVm'
            })
            .when('/movies/:titleId', {
                templateUrl: 'app/movies/title.html',
                controller: 'TitleDetails',
                controllerAs: 'title'
            })
            .when('/series', {
                templateUrl: 'app/movies/series.html',
                controller: 'SeriesController',
                controllerAs: 'sVm'
            })
            .when('/series/:titleId', {
                templateUrl: 'app/movies/title.html',
                controller: 'TitleDetails',
                controllerAs: 'title'
            })
            .when('/signup', {
                templateUrl: 'app/user/signup.html',
                controller: 'SignUp',
                controllerAs: 'siup'
            })
            .when('/admin', {
                templateUrl: 'app/admin/home.html',
                controller: 'AdminController',
                controllerAs: 'actl'
            })
            .when('/edit/:titleId', {
                templateUrl: 'app/admin/edittitle.html',
                controller: 'EditController',
                controllerAs: 'ectl'
            })
            .when('/add', {
                templateUrl: 'app/admin/addtitle.html',
                controller: 'AddTitleController',
                controllerAs: 'actl'
            })
            .otherwise({
                redirectTo: '/home'
            });
        $locationProvider.html5Mode(false).hashPrefix('!');

    }

})();