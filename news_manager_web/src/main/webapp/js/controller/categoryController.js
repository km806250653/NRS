app.controller('categoryController',function ($scope,$controller, categoryService) {
    $controller('baseController',{$scope:$scope})

    $scope.init = function () {
        $scope.findPage();
    }

    $scope.findPage = function () {
        if(!$scope.keywords){
            $scope.keywords=''
        }
        categoryService.findPage($scope.paginationConf.currentPage,$scope.paginationConf.itemsPerPage,$scope.keywords).success(function (reponse) {
            $scope.list = reponse.rows;
            $scope.paginationConf.totalItems = reponse.total;
        });
    }

    $scope.update = function () {
        var object;
        if($scope.entity.id){
            object = categoryService.update($scope.entity);
        }else {
            object = categoryService.add($scope.entity);
        }
        object.success(function (response) {
            if(response.success){
                $scope.findPage();
            }else {
                alert(response.msg);
            }
        });
    }

    $scope.findOne = function (id) {
        categoryService.findOne(id).success(function (response) {
            $scope.entity = response;
        });
    }

    $scope.delete = function (id) {
        var idList=[]
        if(id){
            idList.push(id);
        }else {
            idList = $scope.ids;
        }
        categoryService.delete(idList).success(function (response) {
            $scope.ids=[];
            if(response.success){
                $scope.findPage();
            }else{
                alert(response.msg);
            }
        })
    }

});