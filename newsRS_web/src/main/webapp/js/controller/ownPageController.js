app.controller('ownPageController', function ($scope,$location, ownPageService) {
    $scope.init = function () {
        ownPageService.findUser().success(function (response) {
            $scope.user = response.object;
            $scope.currentId = $location.search()['id'];
            $scope.currentId = $scope.currentId == null ? $scope.user.id : $scope.currentId;
            $scope.findCurrentUser();
    });
        //定义新闻状态
        $scope.statusArr = [
            {status:-1,text:'全部'},
            {status:2,text:'已被驳回'},
            {status:3,text:'二次审核'},
            {status:4,text:'已删除'}
        ]
        $scope.tipArr = [null,null,'已被管理员驳回，请修改您的新闻','正在为您审核','请尽快删除'];
        $scope.status = -1;
        $scope.examine ={};
    }
    //查找新闻集合
    $scope.findNews = function () {
        $scope.newsCurrentPage += 1;
        ownPageService.findNews($scope.currentUser.id, $scope.newsCurrentPage).success(function (response) {
            $scope.newsList = $scope.newsList.concat(response.rows);
            $scope.newsCount = response.total;
        });
    }
    //查找收藏的新闻
    $scope.findFavorite = function () {
        $scope.favoriteCurrentPage +=1;
        ownPageService.findFavorite($scope.currentUser.id, $scope.favoriteCurrentPage).success(function (response) {
            $scope.favoriteList = $scope.favoriteList.concat(response.rows);
            $scope.favoriteCount = response.total;
        });
    }
    //取消收藏
    $scope.removeFavorite = function(nid){
        ownPageService.removeFavorite(nid, $scope.user.id).success(function (response) {
            if (response.success) {
                //刷新数据
                $scope.findCurrentUser();
            } else {
                alert($scope.msg)
            }
        });
    }
    //查找异常新闻
    $scope.findExceptionNews = function(){
        ownPageService.findExceptionNews($scope.user.id,$scope.status).success(function (response) {
            $scope.exceptionNewsList = response;
        })
    }
    //监听下拉框状态
    $scope.$watch('status',function (newValue, oldValue) {
        $scope.findExceptionNews();
    });
    //查询审核详情
    $scope.examineNews = function(id){
        ownPageService.examineNews(id).success(function (response) {
            $scope.news = response.news;
            $scope.examineList= response.examines;
        });
    }
    //提交审核
    $scope.updateStatus = function(){
        ownPageService.updateStatus($scope.news.id,$scope.examine.content).success(function (response) {
            if(response.success){
                $scope.findExceptionNews();
            }else {
                alert(response.msg);
            }
        });
    }

    $scope.go = function(keywords){
        location.href = "../pages/search.html#?keywords="+keywords;
    }

    $scope.findComments = function () {
        $scope.commentCurrentPage += 1;
        ownPageService.findComments($scope.currentUser.id, $scope.commentCurrentPage).success(function (response) {
            $scope.commentList = $scope.commentList.concat(response.rows);
            $scope.commentCount = response.total;
        });
    }

    $scope.delete = function(id){
        ownPageService.delete(id).success(function (response) {
            if(response.success){
                //刷新数据
                $scope.findCurrentUser();
                $scope.findExceptionNews();
            }else{
                alert(response.msg);
            }
        });
    }


    //关注
    $scope.follow = function () {
        ownPageService.follow($scope.currentUser.id, $scope.user.id).success(function (response) {
            if (response.success) {
                $scope.findCurrentUser($scope.currentUser.id);
            } else {
                alert(response.msg);
            }
        });
    }

    //取消关注
    $scope.removeFollow = function () {
        ownPageService.removeFollow($scope.currentUser.id, $scope.user.id).success(function (response) {
            if (response.success) {
                $scope.findCurrentUser($scope.currentUser.id);
            } else {
                alert(response.msg);
            }
        });
    }

    //是否已关注
    $scope.isFollow = function () {
        ownPageService.isFollow($scope.currentUser.id, $scope.user.id).success(function (response) {
            $scope.followFlag = response.success;
        });
    }

    $scope.findCurrentUser = function (id) {
        if(id){
            $scope.currentId = id;
        }
        ownPageService.findCurrentUser($scope.currentId).success(function (response) {
            $scope.currentUser = response;
            //重新查找当前用户时,重置参数
            $scope.newsCurrentPage = 0;
            $scope.commentCurrentPage = 0;
            $scope.favoriteCurrentPage =0;
            $scope.newsList = [];
            $scope.commentList = [];
            $scope.favoriteList = [];
            $scope.findNews();
            $scope.findComments();
            $scope.findFavorite();
            if (!$scope.isOwn() && $scope.user) {
                //不是自己的个人中心,并且已登录，发出请求查看是否已关注当前用户
                $scope.isFollow();
            }
        });
    }

    $scope.isOwn = function () {
        if (!$scope.user || !$scope.currentUser)
            return false;
        if ($scope.currentUser.id == $scope.user.id)
            return true;
        return false;
    }


});