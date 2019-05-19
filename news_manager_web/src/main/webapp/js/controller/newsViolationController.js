app.controller('newsViolationController',function ($scope,$controller, newsService,categoryService) {
    $controller('baseController',{$scope:$scope})

    $scope.init = function () {
        $scope.cid = -1;
        $scope.keywords = '';
        $scope.type = 'violation';
        $scope.findPage();
        $scope.findCategory();
        //状态可视化
        $scope.statusArr = ['未审核','审核通过','驳回','重新审核','删除']
        $scope.categoryArr = [];
        $scope.examine = {};
    }

    $scope.findPage = function () {
        $scope.deleteId = -1;
        if(!$scope.keywords){
            $scope.keywords=''
        }
        newsService.findPage($scope.paginationConf.currentPage,$scope.paginationConf.itemsPerPage,$scope.cid,$scope.keywords,$scope.type).success(function (reponse) {
            $scope.list = reponse.rows;
            $scope.paginationConf.totalItems = reponse.total;
        });
    }

    $scope.findCategory = function(){
        categoryService.findAll().success(function (response) {
            $scope.categories = response;
            for (var i = 0; i <$scope.categories.length ; i++) {
                $scope.categoryArr[$scope.categories[i].id] = $scope.categories[i].text;
            }
        });
    }



    $scope.examineNews = function(id){
        newsService.examineNews(id).success(function (response) {
            $scope.news = response.news;
            $scope.examineList= response.examines;
        });
    }
    $scope.delete = function () {
        var idList=[]
        if($scope.deleteId==-1){
            idList = $scope.ids;
        }else {
            idList.push($scope.deleteId);
        }
        newsService.delete(idList).success(function (response) {
            $scope.ids=[];
            if(response.success){
                $scope.findPage();
            }else{
                alert(response.msg);
            }
        })
    }

    $scope.setId = function (id) {
        $scope.deleteId = id;
    }
});