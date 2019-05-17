app.controller('indexController',function ($scope, $controller,$interval,indexService ) {
    $controller('baseController',{$scope:$scope});
    $scope.init =function(){
        $scope.getUser();
        $scope.findHot();
        $scope.hotIndex = 0;
        $scope.findRank();
    }
    $scope.findHot = function () {
        indexService.findHot().success(function (response) {
            $scope.hotListImage = response.listImage;
            $scope.hotList = response.list;
            $scope.hotImageNews = $scope.hotListImage[0];
            $interval(function () {
                $scope.hotImageNews = $scope.hotListImage[$scope.hotIndex];
                $scope.hotIndex+=1;
                if($scope.hotIndex==$scope.hotListImage.length){
                    $scope.hotIndex = 0;
                }
            },3000);
        })
    }

    $scope.findRank = function () {
        indexService.findRank().success(function (response) {
            $scope.list = response;
        });
    }
});