app.controller('registerController',function ($scope,$controller,registerService) {
    $controller('baseController',{$scope:$scope});
    $scope.register = function () {
        registerService.register($scope.entity).success(
            function (response) {
                if(response.success){
                    location.href=$scope.path;
                }else {
                    alert(response.msg);
                }
            }
        );
    }
});