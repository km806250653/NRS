app.controller('detailController',function ($scope,$controller,detailService) {

    $controller('baseController',{$scope:$scope});

    $scope.findComment = function (nid) {
        detailService.findComment(nid).success(function (response) {
            $scope.list = response;
        });
    }

    //发表评论
    $scope.releaseComment = function (nid,pid) {
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
        }else{
            //无pid，是根评论，设置文本为根文本框的值
            if(!$scope.text){
                alert("评论不能为空")
                return;
            }
            $scope.comment.text =$scope.text;
        }
        $scope.comment.nid = nid;
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