app.controller('newsListController',function ($scope,$controller, newsService,categoryService) {
    $controller('baseController',{$scope:$scope})

    $scope.init = function () {
        $scope.cid = -1;
        $scope.keywords = '';
        $scope.type = 'all';
        //状态可视化
        $scope.statusArr = ['未审核','审核通过','已驳回','重新审核','已删除']
        $scope.categoryArr = [];
        $scope.findPage();
        $scope.findCategory();
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
            $scope.categories.unshift({id:-1,text:'全部'});
        });
    }

    $scope.delete = function (id) {
        var idList=[]
        if(id){
            idList.push(id);
        }else {
            idList = $scope.ids;
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

    $scope.goDetail = function (id) {
        //iframe跨域问题未解决
        // location.href="http://localhost/newsRS_web/pages/details.html#?id="+id;
        window.open("http://localhost/newsRS_web/pages/details.html#?id="+id);
    }

$scope.$watch('cid',function (newValue, oldValue) {
    $scope.findPage();
});

});