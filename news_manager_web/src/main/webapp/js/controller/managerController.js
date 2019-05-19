app.controller('managerController',function ($scope,$controller, managerService) {
    $controller('baseController',{$scope:$scope})

    $scope.init = function () {
        $scope.findPage();
    }

    $scope.findPage = function () {
        if(!$scope.keywords){
            $scope.keywords=''
        }
        managerService.findPage($scope.paginationConf.currentPage,$scope.paginationConf.itemsPerPage,$scope.keywords).success(function (reponse) {
            $scope.list = reponse.rows;
            $scope.paginationConf.totalItems = reponse.total;
        });
    }


    $scope.findOne = function (id) {
        managerService.findOne(id).success(function (response) {
            $scope.entity = response;
        });
    }

    $scope.add = function () {
        if($scope.confirmPassword!=$scope.entity.password){
            alert("两次密码输入不一致");
            return;
        }
        managerService.add($scope.entity).success(function (response) {
            if(response.success){
               $scope.findPage();
            }else{
                alert(response.msg);
            }
        });
    }

    $scope.delete = function (id) {
        managerService.delete(id).success(function (response) {
            if(response.success){
                $scope.findPage();
            }else {
                alert(response.msg);
            }
        });
    }
});