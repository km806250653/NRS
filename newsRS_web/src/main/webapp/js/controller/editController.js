app.controller('editController',function ($scope, editService) {
    $scope.init = function(){
        $scope.findUser();
        $scope.backgroundArr = [];
        $scope.headImageArr = [];
    }

    $scope.findUser = function () {
        editService.findUser().success(function (response) {
            $scope.user  = response.object;
            $scope.cloneUser();
        });
    }

    $scope.go = function(keywords){
        location.href = "../pages/search.html#?keywords="+keywords;
    }

    //深克隆user
    $scope.cloneUser = function(){
        var JsonStr = JSON.stringify($scope.user)
        $scope.editUser = JSON.parse(JsonStr);
    }

    $scope.upload = function (type) {
        editService.upload(type).success(function (response) {
            if (response.error == "0") {
                if(type == 'backImage'){
                    $scope.editUser.background = response.url;
                    $scope.backgroundArr.push(response.url)
                }else{
                    $scope.editUser.image = response.url;
                    $scope.headImageArr.push(response.url)
                }
            } else {
                alert(response.message);
            }

        });
    }
    //修改
    $scope.update = function () {
        //表单校验不通过时
        if(!$scope.editForm.$valid){
            alert("请认真填写哦~");
            return;
        }

        //去除最终选择的图片
        $scope.headImageArr.splice($scope.headImageArr.indexOf($scope.editUser.image),1);
        $scope.backgroundArr.splice($scope.backgroundArr.indexOf($scope.editUser.background),1);
        //删除未选择的图片
        if($scope.headImageArr.length>0){
            editService.deleImage($scope.headImageArr);
        }
        if($scope.backgroundArr.length>0){
            editService.deleImage($scope.backgroundArr);
        }
        editService.updateUser($scope.editUser).success(function (response) {
            if(response.success){
                location.href = 'own_page.html#?id='+$scope.user.id;
            }else {
                alert("修改出现错误");
            }
        });
    }
});