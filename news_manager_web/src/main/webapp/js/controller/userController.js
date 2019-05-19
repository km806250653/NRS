app.controller('userController',function ($scope,$controller, userService) {
    $controller('baseController',{$scope:$scope})

    $scope.init = function () {
        $scope.findPage();
    }

    $scope.findPage = function () {
        if(!$scope.keywords){
            $scope.keywords=''
        }
        userService.findPage($scope.paginationConf.currentPage,$scope.paginationConf.itemsPerPage,$scope.keywords).success(function (reponse) {
            $scope.list = reponse.rows;
            $scope.paginationConf.totalItems = reponse.total;
        });
    }


    $scope.findOne = function (id) {
        userService.findOne(id).success(function (response) {
            $scope.entity = response;
        });
    }
});