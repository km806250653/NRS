app.service('searchService',function ($http) {
    this.findUser = function () {
        return $http.get('../user/getUser.do');
    }

    this.search = function (keywords,currentPage,pageSize) {
        return $http.get('../search.do?keywords='+keywords+'&currentPage='+currentPage+'&pageSize='+pageSize);
    }
    this.findBox = function () {
        return $http.get('../findBox.do');
    }
});