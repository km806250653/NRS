app.service('indexService',function ($http) {
    this.findHot = function () {
        return $http.get('news/findHot.do');
    }

    this.findRank = function () {
        return $http.get('news/findRank.do');
    }
});