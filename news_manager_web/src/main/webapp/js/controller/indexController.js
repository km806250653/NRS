app.controller('indexController',function ($scope,indexService) {

    $scope.init = function(){
        $scope.getUser();
    }
    $scope.getUser = function () {
        indexService.getUser().success(function (response) {
            $scope.manager = response;
        });
    }

    $scope.updatePassword = function () {
        if($scope.confirmPassword!=$scope.newPassword){
            alert("两次密码输入不一致");
            return;
        }
        indexService.updatePassword($scope.manager.id,$scope.oldPassword,$scope.newPassword).success(function (response) {
            if(!response.success){
                alert(response.msg);
            }
        });
    }
});