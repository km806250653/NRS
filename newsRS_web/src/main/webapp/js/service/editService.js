app.service('editService',function ($http) {
    //上传文件
    this.upload=function(type){
        var formData = new FormData();
        if(type =='backImage'){
            formData.append("imgFile",backImage.files[0]);
        }else if(type == 'headImage'){
            formData.append("imgFile",headImage.files[0]);
        }else {
            formData.append("imgFile",newsImage.files[0]);
        }


        return $http({
            method:'POST',
            data:formData,
            url:'../upload.do',
            headers: {'Content-Type':undefined},
            transformRequest: angular.identity
        });
    }

    //从文件服务器删除文件
    this.deleImage = function(urlArr){
        return $http.get("../deleImage.do?urlArr="+urlArr);
    }

    this.findUser = function () {
        return $http.get('../user/getUser.do');
    }

    //修改
    this.updateUser = function (editUser) {
        return $http.post('../user/update.do',editUser);
    }
    //查找分类
    this.findCategory = function () {
        return $http.get('../category/findAll.do');
    }
    //发布新闻
    this.insertNews = function (editNews) {
        return $http.post('../news/insert.do',editNews);
    }
});