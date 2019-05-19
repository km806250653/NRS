app.service('ownPageService',function ($http) {
    this.findCurrentUser=function (id) {
        return $http.get('../user/findCurrentUser.do?id='+id);
    }

    this.findUser = function () {
        return $http.get('../user/getUser.do');
    }

    this.follow = function (uid,followId) {
        return $http.get('../user/follow.do?uid='+uid+'&followId='+followId);
    }
    this.removeFollow =function (uid,followId) {
        return $http.get('../user/removeFollow.do?uid='+uid+'&followId='+followId);
    }

    this.isFollow = function (uid,followId) {
        return $http.get('../user/isFollow.do?uid='+uid+'&followId='+followId);
    }

    this.findNews = function (uid, currentPage) {
        return $http.get('../news/findListByUid.do?uid='+uid+'&pageNum='+currentPage);
    }
    this.findComments = function (uid, currentPage) {
        return $http.get('../comment/findByUid.do?uid='+uid+'&pageNum='+currentPage)
    }

    this.findFavorite= function (uid, currentPage) {
        return $http.get('../news/findFavoriteByUid.do?uid='+uid+'&pageNum='+currentPage)
    }

    this.removeFavorite = function (nid,uid) {
        return $http.get('../news/removeFavorite.do?nid='+nid+'&uid='+uid)
    }

    this.delete = function (id) {
        return $http.get('../news/delete.do?id='+id);
    }

    this.findExceptionNews = function (uid,status) {
        return $http.get('../news/findExceptionNews.do?status='+status+'&uid='+uid);
    }
    //查找审核详情
    this.examineNews = function (id) {
        return $http.get('../news/examine.do?id='+id);
    }
    //提交审核
    this.updateStatus = function (id,content) {
        return $http.get('../news/updateStatus.do?content='+content+'&nid='+id);
    }
});