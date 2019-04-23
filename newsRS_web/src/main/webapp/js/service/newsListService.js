app.service('newsListService',function ($http) {
    this.findOne= function (id) {
        return $http.get('../news/findOne.do?id='+id);
    }
});