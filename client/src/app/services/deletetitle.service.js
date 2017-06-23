/**
 * Created by Koushik on 12/22/2016.
 */

(function () {
    'use strict';
    angular.module('movieflix')
        .service('DeleteTitleService',DeleteTitleService);
    DeleteTitleService.$inject = ['$http','CONFIG'];
    function DeleteTitleService($http,CONFIG) {
        this.deleteTitle = function (id) {

            var deleteTitleConfig = {
                method:'DELETE',
                url:CONFIG.API_HOST+'/admin/titles/'+id
            };

            return $http(deleteTitleConfig)
                .then(function (resp) {
                    return resp = resp.data;
                    console.log(resp)
                },function (err) {
                    return err;
                })
        }
    }
})();