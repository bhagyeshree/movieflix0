/**
 * Created by Koushik on 12/21/2016.
 */

(function () {
    'use strict';
    angular.module('movieflix')
        .service('SignUpService',SignUpService);

    SignUpService.$inject=['$http','CONFIG'];
    function SignUpService($http,CONFIG) {

        this.registerUser = function (user) {

            var signUpConfig = {
                url:CONFIG.API_HOST+'/users',
                method:'POST',
                data:user
            }
            return $http(signUpConfig)
                .then(function (resp) {
                    return resp.data;
                },function (err) {
                    return err;
                })

        }
    }
})();