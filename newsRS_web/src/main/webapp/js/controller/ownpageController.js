app.controller('ownpageController', function ($scope, $location, ownpageService) {
    $scope.init = function () {
        ownpageService.findUser().success(function (response) {
            $scope.user = response.object;
            $scope.currentId = $location.search()['id'];
            $scope.currentId = $scope.currentId == null ? $scope.user.id : $scope.currentId;
            $scope.findCurrentUser();
    });
    }
    //查找新闻集合
    $scope.findNews = function () {
        $scope.newsCurrentPage += 1;
        ownpageService.findNews($scope.currentUser.id, $scope.newsCurrentPage).success(function (response) {
            $scope.newsList = $scope.newsList.concat(response.rows);
            $scope.newsCount = response.total;
        });
    }


    $scope.findComments = function () {
        $scope.commentCurrentPage += 1;
        ownpageService.findComments($scope.currentUser.id, $scope.commentCurrentPage).success(function (response) {
            $scope.commentList = $scope.commentList.concat(response.rows);
            $scope.commentCount = response.total;
        });
    }

    $scope.delete = function(id){
        ownpageService.delete(id).success(function (response) {
            if(response.success){
                //刷新数据
                $scope.findCurrentUser();
            }else{
                alert(response.msg);
            }
        });
    }


    //关注
    $scope.follow = function () {
        ownpageService.follow($scope.currentUser.id, $scope.user.id).success(function (response) {
            if (response.success) {
                $scope.findCurrentUser($scope.currentUser.id);
            } else {
                alert(response.msg);
            }
        });
    }

    //取消关注
    $scope.removeFollow = function () {
        ownpageService.removeFollow($scope.currentUser.id, $scope.user.id).success(function (response) {
            if (response.success) {
                $scope.findCurrentUser($scope.currentUser.id);
            } else {
                alert(response.msg);
            }
        });
    }

    //是否已关注
    $scope.isFollow = function () {
        ownpageService.isFollow($scope.currentUser.id, $scope.user.id).success(function (response) {
            $scope.followFlag = response.success;
        });
    }

    $scope.findCurrentUser = function () {
        ownpageService.findCurrentUser($scope.currentId).success(function (response) {
            $scope.currentUser = response;
            //重新查找当前用户时,重置参数
            $scope.newsCurrentPage = 0;
            $scope.commentCurrentPage = 0;
            $scope.newsList = [];
            $scope.commentList = [];
            $scope.findNews();
            $scope.findComments();
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