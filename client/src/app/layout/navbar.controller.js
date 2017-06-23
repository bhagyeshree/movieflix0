/**
 * Created by Koushik on 12/21/2016.
 */

(function () {
    angular.module('movieflix')
        .controller('NavbarController',NavbarController);

    NavbarController.$inject = ['$location','$scope'];
    
    function NavbarController($location,$scope) {
        $scope.isActive = function (viewLocation) {
            return viewLocation === $location.path();
        };
    }

})();