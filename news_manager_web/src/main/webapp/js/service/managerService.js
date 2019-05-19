app.service('managerService',function ($http) {
   this.findPage = function (currentPage,pageSize,keywords) {
       return $http.get('../manager/findPage.do?currentPage='+currentPage+'&pageSize='+pageSize+'&keywords='+keywords);
   }

    this.findOne = function (id) {
        return $http.get('../manager/findOne.do?id='+id);
    }

    this.add = function (entity) {
        return $http.post('../manager/add.do',entity)
    }

    this.delete = function (id) {
        return $http.get('../manager/delete.do?id='+id);
    }
});