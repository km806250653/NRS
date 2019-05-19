app.controller('newsExamineController',function ($scope,$controller, newsService,categoryService) {
    $controller('baseController',{$scope:$scope})

    $scope.init = function () {
        $scope.cid = -1;
        $scope.keywords = '';
        $scope.type = 'examine';
        $scope.findPage();
        $scope.findCategory();
        //状态可视化
        $scope.statusArr = ['未审核','审核通过','驳回','重新审核','删除']
        $scope.categoryArr = [];
        $scope.examine = {};
        $scope.status = 1;
    }

    $scope.findPage = function () {
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

    $scope.updateStatus = function(){
        $scope.examine.operation = $scope.statusArr[$scope.status];
        $scope.examine.nid = $scope.news.id;
        newsService.updateStatus($scope.examine,$scope.status).success(function (response) {
            if(response.success){
                $scope.findPage();
            }else {
                alert(response.msg);
            }
        });
    }

    $scope.updateStatusMultiple = function(){
        if($scope.ids.length<=0){
            alert('您尚未选择任何条目');
            return;
        }
        newsService.updateStatusMultiple($scope.ids,$scope.status,$scope.examine.content).success(function (response) {
            $scope.ids=[];
            if(response.success){
                $scope.findPage();
            }else{
                alert(response.msg);
            }
        });
    }

    $scope.examineNews = function(id){
        newsService.examineNews(id).success(function (response) {
            $scope.news = response.news;
            $scope.examineList= response.examines;
        });
    }


});