/**
 * Created by Koushik on 12/21/2016.
 */

(function () {
    'use strict';
    angular.module('movieflix')
        .controller('SignUp',SignUp);

     SignUp.$inject=['SignUpService'];
    function SignUp(SignUpService) {
        var siup = this;
        siup.master = {};

        siup.addUser = function(user) {
            siup.master= user;
            SignUpService.registerUser(user)
                .then(function (resp) {
                    siup.status = status;
                },function (err) {
                    siup.status = err;
                })
        }
    }
})();