app.controller('searchController',function ($scope,$location,searchService) {
    $scope.init = function(){
        $scope.findUser();
        $scope.keywords = $location.search()['keywords'];
        $scope.paginationConf = {
            currentPage: 1,
            totalItems: 10,
            itemsPerPage: 10,
            perPageOptions: [10, 20, 30, 40, 50],
            onChange: function(){
                $scope.search();
            }
        };
        $scope.search();
        $scope.findBox();
    }

    $scope.go=function(keywords){
        $scope.paginationConf.currentPage=1;
        $scope.keywords = keywords;
        $scope.search();
    }

    $scope.findUser = function () {
        searchService.findUser().success(function (response) {
            $scope.user = response.object;
        });
    }

    $scope.search = function () {
        searchService.search($scope.keywords,$scope.paginationConf.currentPage,$scope.paginationConf.itemsPerPage).success(function (response) {
            $scope.list = response.rows;
            $scope.paginationConf.totalItems = response.total;
        });
    }
    $scope.findBox = function () {
        searchService.findBox().success(function (response) {
            $scope.box = response;
        });
    }
});