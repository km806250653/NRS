app.service('newsService',function ($http) {
   this.findPage = function (currentPage,pageSize,cid,keywords,type) {
       return $http.get('../news/findPage.do?currentPage='+currentPage+'&pageSize='+pageSize+'&cid='+cid+'&keywords='+keywords+'&type='+type);
   }

    this.delete = function (ids) {
        return $http.get('../news/delete.do?ids='+ids);
    }
    this.updateStatus = function (examine,status) {
        return $http.post('../news/updateStatus.do?status='+status,examine);
    }

    this.examineNews = function (id) {
        return $http.get('../news/examine.do?id='+id);
    }

    this.updateStatusMultiple = function (ids,status,content) {
        return $http.get('../news/updateStatusMultiple.do?nids='+ids+'&status='+status+'&content='+content);
    }
});