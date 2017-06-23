(function () {
    'use strict';
    angular.module('movieflix')
        .controller('TitleDetails', TitleDetails);

    TitleDetails.$inject = ['TitleService', '$routeParams'];

    function TitleDetails(TitleService, $routeParams) {
        var title = this;

        TitleService.getTitle($routeParams.titleId)
            .then(function (resp) {
                title.movie = resp;
            }, function (err) {
                console.log(err);
            })
    }

})();