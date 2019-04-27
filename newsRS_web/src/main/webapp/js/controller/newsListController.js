app.controller('newsListController',function ($scope,$controller,$location,newsListService) {
    $controller('baseController',{$scope:$scope});
    $scope.init = function () {
        $scope.cid = $location.search()['id'];
        $scope.findList();
        $scope.getUser();
    }
});