app.controller('newsListController',function ($scope,$controller,$location,newsListService) {
    $controller('baseController',{$scope:$scope});
    $scope.findOne=function (id) {
        newsListService.findOne(id).success(function (response) {
            $scope.entity = response;
        });
    }
    $scope.init = function () {
        var id = $location.search()['id'];
        $scope.findList(id);
    }
});