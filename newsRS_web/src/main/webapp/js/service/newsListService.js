app.service('newsListService',function ($http) {
    this.findOne= function (id) {
        return $http.get('../news/findOne.do?id='+id);
    }

    this.findList = function (cid) {
        return $http.get('../news/findList.do?cid='+cid);
    }
});