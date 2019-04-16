app.controller('newsListController',function ($scope,$controller,$location,newsListService) {
    $controller('baseController',{$scope:$scope});
    $scope.findOne=function (id) {
        newsListService.findOne(id).success(function (response) {
            $scope.entity = response;
        });
    }

    $scope.findList = function () {
        var cid = $location.search().cid;
        newsListService.findList(cid).success(function (response) {
            $scope.list = response;
        });
    }

    $scope.randomNum = function () {
        $scope.random = Math.floor(Math.random()*10000);
    }
})