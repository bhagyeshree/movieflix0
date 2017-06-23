/**
 * Created by Koushik on 12/22/2016.
 */

(function () {
    angular.module('movieflix')
        .controller('AdminController', AdminController);
    AdminController.$inject = ['TitlesService', 'DeleteTitleService'];
    function AdminController(TitleService, DeleteTitleService) {

        var actl = this;

        actl.pageSize = 8;
        actl.currentPage = 1;

        actl.open = function (data) {
            actl.title = data;
            actl.deleteTitle = function (id) {
                DeleteTitleService.deleteTitle(id)
                    .then(function (resp) {
                        actl.status = resp;
                        console.log(status);
                    }, function (err) {
                        console.log(err);
                    })
            }
        }

        TitleService.getTitles()
            .then(function (resp) {
                actl.titles = resp;
            }, function (err) {
                console.log(err);
            })

    }
})();