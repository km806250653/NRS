app.controller('detailController',function ($scope,$controller,detailService) {

    $controller('baseController',{$scope:$scope});

    $scope.findComment = function (nid) {
        detailService.findComment(nid).success(function (response) {
            $scope.list = response;
        });
    }
});