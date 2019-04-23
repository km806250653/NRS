app.service('ownpageService',function ($http) {
    this.findCurrentUser=function (id) {
        return $http.get('../user/findCurrentUser.do?id='+id);
    }

    this.findUser = function () {
        return $http.get('../user/getUser.do');
    }
});