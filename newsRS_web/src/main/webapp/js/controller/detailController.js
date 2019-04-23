app.controller('detailController',function ($scope,$controller,$location,detailService) {

    $controller('baseController',{$scope:$scope});

    $scope.findNews = function () {
        var id  = $location.search()['id'];
        detailService.findNews(id).success(function (response) {
            $scope.news = response.news;
            $scope.list = response.comments;
        });
    }

    //发表评论
    $scope.releaseComment = function (pid) {
        if($scope.user==null){
            alert("未登录")
            return;
        }
        $scope.comment = {};
        if(pid){
            //有pid，是子评论，设置文本为子文本框的值
            if(!$scope.childTexts[pid]){
                alert("评论不能为空")
                return;
            }
            $scope.comment.parentId = pid;
            $scope.comment.text = $scope.childTexts[pid];
            $scope.childTexts[pid] = '';
        }else{
            //无pid，是根评论，设置文本为根文本框的值
            if(!$scope.text){
                alert("评论不能为空")
                return;
            }
            $scope.comment.text =$scope.text;
            $scope.text = '';
        }
        $scope.comment.nid = $scope.news.id;
        $scope.comment.uid = $scope.user.id;
        detailService.releaseComment($scope.comment).success(function (response) {
            if(response.success){
                $scope.findComment(nid);
            }else{
                alert("评论失败!");
            }

        });
    }
});