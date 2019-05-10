app.service('ownpageService',function ($http) {
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

    this.delete = function (id) {
        return $http.get('../news/delete.do?id='+id);
    }
});