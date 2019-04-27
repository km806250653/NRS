app.controller('newsEditController',function ($scope, editService) {
    $scope.init = function(){
        $scope.findUser();
    }
    $scope.findUser = function () {
        editService.findUser().success(function (response) {
            $scope.user  = response.object;
        });
    }
});