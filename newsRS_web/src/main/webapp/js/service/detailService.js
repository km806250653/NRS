app.service('detailService',function ($http) {
    this.findComment = function (nid) {
        return $http.get('../comment/findByNid.do?nid='+nid);
    }

    this.releaseComment = function (comment) {
        return $http.post('../comment/releaseComment.do',comment);
    }
});