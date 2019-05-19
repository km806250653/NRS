app.controller('detailController', function ($scope, $controller, $location, detailService, baseService) {

    $controller('baseController', {$scope: $scope});
    $scope.init = function () {
        baseService.getUser().success(function (response) {
            $scope.user = response.object;
            $scope.nid = $location.search()['id'];
            $scope.findNews();
            $scope.childTexts = []
        });
    }


    $scope.findNews = function () {
        var uid
        if ($scope.user) {
            uid = $scope.user.id;
        } else {
            uid = -1;
        }
        detailService.findNews($scope.nid, uid).success(function (response) {
            $scope.newsGroup = response;
        });
    }

    //发表评论
    $scope.releaseComment = function (pid) {
        if (!$scope.user) {
            alert("未登录")
            return;
        }
        $scope.comment = {};
        if (pid) {
            //有pid，是子评论，设置文本为子文本框的值
            if (!$scope.childTexts[pid]) {
                alert("评论不能为空")
                return;
            }
            $scope.comment.parentId = pid;
            $scope.comment.text = $scope.childTexts[pid];
            $scope.childTexts[pid] = '';
        } else {
            //无pid，是根评论，设置文本为根文本框的值
            if (!$scope.text) {
                alert("评论不能为空")
                return;
            }
            $scope.comment.text = $scope.text;
            $scope.text = '';
        }
        $scope.comment.nid = $scope.newsGroup.news.id;
        $scope.comment.uid = $scope.user.id;
        detailService.releaseComment($scope.comment).success(function (response) {
            if (response.success) {
                $scope.findNews();
            } else {
                alert("评论失败!");
            }

        });
    }

    //收藏
    $scope.favorite = function () {
        if (!$scope.user) {
            alert("未登录")
            return;
        }

        if ($scope.newsGroup.favorite) {
            detailService.removeFavorite($scope.nid, $scope.user.id).success(function (response) {
                if (response.success) {
                    $scope.findNews();
                } else {
                    alert($scope.msg)
                }
            });
        } else {
            detailService.favorite($scope.nid, $scope.user.id).success(function (response) {
                if (response.success) {
                    $scope.findNews();
                } else {
                    alert($scope.msg)
                }
            });
        }
    }

    $scope.delete = function(id){
        detailService.delete(id).success(function (response) {
            if(response.success){
                //刷新页面
                $scope.findNews();
            }else {
                alert(response.msg);
            }
        });
    }

    //评论点赞
    $scope.like = function (commentGroup) {
        if (!$scope.user) {
            alert("未登录");
            return;
        }
        if (commentGroup.like) {
            detailService.removeLike(commentGroup.comment.id, $scope.user.id).success(function (response) {
                if (response.success) {
                    $scope.findNews();
                } else {
                    alert(response.msg)
                }
            });
        } else {
            detailService.like(commentGroup.comment.id, $scope.user.id).success(function (response) {
                if (response.success) {
                    $scope.findNews();
                } else {
                    alert(response.msg)
                }
            });
        }

    }
});