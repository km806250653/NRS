app.controller('registerController', function ($scope, $controller, registerService) {
    $controller('baseController', {$scope: $scope});

    $scope.init = function(){
        $scope.urlArr = [];
        $scope.entity={image:'img/photo.png'}
    }
    $scope.register = function () {
        if ($scope.entity.password != $scope.confirmPassword) {
            alert("两次密码不一致");
            return;
        }
        //去除最终选择的图片
        $scope.urlArr.splice($scope.urlArr.indexOf($scope.entity.image),1);
        //删除未选择的图片
        registerService.deleImage($scope.urlArr);

        registerService.register($scope.entity).success(
            function (response) {
                if (response.success) {
                    location.href = $scope.pathJson.projectPath;
                } else {
                    alert(response.msg);
                }
            }
        );
    }

    $scope.upload = function () {
        registerService.upload().success(function (response) {
            if (response.error == "0") {
                $scope.entity.image = response.url;
                $scope.urlArr.push(response.url);
            } else {
                alert(response.message);
            }
        }).error(function() {
            alert("上传发生错误");
        });
    }
});