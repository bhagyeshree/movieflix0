/**
 * Created by Koushik on 12/23/2016.
 */
(function () {
    angular.module('movieflix')
        .controller('AddTitleController', AddTitleController);
    AddTitleController.$inject = ['AddTitleService'];
    function AddTitleController(AddTitleService) {
        var atctl = this;

        this.addTitle = function (moviedetails) {

            AddTitleService.addTitle(moviedetails)
                .then(function (resp) {
                    atctl.status = resp;
                }, function (err) {
                    console.log(err);
                })

        }


    }
})();