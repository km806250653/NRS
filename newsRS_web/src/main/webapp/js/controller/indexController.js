app.controller('indexController',function ($scope, $controller ) {
    $controller('baseController',{$scope:$scope});
    $scope.getUser();
});