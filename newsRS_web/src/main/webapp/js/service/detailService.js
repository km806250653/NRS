app.service('detailService',function ($http) {
    this.findNews = function (nid,uid) {
        return $http.get('../news/findOne.do?nid='+nid+'&uid='+uid);
    }

    this.releaseComment = function (comment) {
        return $http.post('../comment/releaseComment.do',comment);
    }

    //收藏相关
    this.favorite = function (nid,uid) {
        return $http.get('../news/favorite.do?nid='+nid+'&uid='+uid)
    }
    this.removeFavorite = function (nid,uid) {
        return $http.get('../news/removeFavorite.do?nid='+nid+'&uid='+uid)
    }

    //点赞相关
    this.like = function (cid,uid) {
        return $http.get('../comment/like.do?commentId='+cid+'&uid='+uid)
    }
    this.removeLike = function (cid,uid) {
        return $http.get('../comment/removeLike.do?commentId='+cid+'&uid='+uid)
    }

});