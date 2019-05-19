var app = angular.module('newsRS', []);
app.service('indexService',function ($http) {
    this.getUser = function () {
        return $http.get('manager/getUser.do');
    }
    this.updatePassword = function (id,oldPassword,newPassword) {
        return $http.get('manager/updatePassword.do?id='+id+'&oldPassword='+oldPassword+'&newPassword='+newPassword);
    }
});