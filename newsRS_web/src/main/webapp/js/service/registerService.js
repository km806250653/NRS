app.service('registerService',function ($http) {
    this.register = function (entity) {
        return $http.post("../user/register.do",entity);
    }
    //上传文件
    this.upload=function(){
        var formData = new FormData();
        formData.append("imgFile",file.files[0]);

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


});