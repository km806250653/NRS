app.service('newsListService', function ($http) {
    this.findUser = function () {
        return $http.get('../user/getUser.do');
    }
});