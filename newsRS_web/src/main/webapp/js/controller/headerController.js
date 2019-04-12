app.controller("header", function ($scope, $http,$location) {
    $scope.path = getAbsolutePath();
    $scope.getSomeCategory = function () {
        $http.get($scope.path + "category/findAll?type=first").success(function (response) {
            $scope.categories = response;
        });
    }
    $scope.getAllCategory = function () {
        $http.get($scope.path + "category/findAll?type=more").success(function (response) {
            $scope.allCategories = response;
        });
    }
});