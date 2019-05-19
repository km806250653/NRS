app.service('userService',function ($http) {
   this.findPage = function (currentPage,pageSize,keywords) {
       return $http.get('../user/findPage.do?currentPage='+currentPage+'&pageSize='+pageSize+'&keywords='+keywords);
   }

    this.findOne = function (id) {
        return $http.get('../user/findOne.do?id='+id);
    }


});