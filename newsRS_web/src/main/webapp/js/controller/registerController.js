app.controller('registerController',function ($scope,$controller,registerService) {
    $controller('baseController',{$scope:$scope});
    $scope.register = function () {
        if($scope.entity.password!=$scope.confirmPassword){
            alert("两次密码不一致");
            return;
        }

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