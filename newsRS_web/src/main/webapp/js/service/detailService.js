app.service('detailService',function ($http) {
    this.findNews = function (id) {
        return $http.get('../news/findOne.do?id='+id);
    }

    this.releaseComment = function (comment) {
        return $http.post('../comment/releaseComment.do',comment);
    }
});