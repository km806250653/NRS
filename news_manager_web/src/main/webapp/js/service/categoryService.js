app.service('categoryService',function ($http) {
   this.findPage = function (currentPage,pageSize,keywords) {
       return $http.get('../category/findPage.do?currentPage='+currentPage+'&pageSize='+pageSize+'&keywords='+keywords);
   }

   this.add = function (entity) {
       return $http.post('../category/add.do',entity);
   }

    this.update = function (entity) {
        return $http.post('../category/update.do',entity);
    }
    this.delete = function (ids) {
        return $http.get('../category/delete.do?ids='+ids);
    }

    this.findOne = function (id) {
        return $http.get('../category/findOne.do?id='+id);
    }
    this.findAll = function () {
        return $http.get('../category/findAll.do');
    }
});