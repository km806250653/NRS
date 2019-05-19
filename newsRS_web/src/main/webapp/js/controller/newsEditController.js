app.controller('newsEditController',function ($scope,$location, editService) {
    $scope.init = function(){
        $scope.findUser();
        $scope.findCategory();
        $scope.entity = {};
        $scope.origin = '1';
        $scope.imageArr = [];
        var id = $location.search()['id'];
        if(id){
            $scope.entity.id = id;
            $scope.findOne();
        }
    }

    $scope.go = function(keywords){
        location.href = "../pages/search.html#?keywords="+keywords;
    }
    //回显新闻
    $scope.findOne = function(){
        editService.findOne($scope.entity.id).success(function (response) {
            $scope.entity = response;
            editor.html($scope.entity.content);
        });
    }
    $scope.findUser = function () {
        editService.findUser().success(function (response) {
            $scope.user  = response.object;
        });
    }

    $scope.findCategory = function () {
            editService.findCategory().success(function (response) {
                $scope.categories = response;
                $scope.entity.cid = $scope.categories[0].id;
            });
    }

    $scope.insertNews = function () {
        if(!$scope.user){
            alert("未登录!");
            return;
        }
        //封面图片处理
        $scope.imageArr.splice($scope.imageArr.indexOf($scope.entity.image),1);
        editService.deleImage($scope.imageArr);

        //正文
        $scope.entity.content = editor.html();
        //发布者id
        $scope.entity.uid = $scope.user.id;
        if($scope.origin == '1'){
            //原创
            //作者为当前登录用户
            $scope.entity.author = $scope.user.name;
            //来源置空，后台处理
            $scope.entity.source = '';
        }
        var object = $scope.entity.id? editService.updateNews($scope.entity):editService.insertNews($scope.entity);
        object.success(function (response) {
            if(response.success){
                location.href = 'own_page.html#?id='+$scope.user.id;
            }
        });
    }
    //清空
    $scope.reset = function () {
        if($scope.entity.id){
            $scope.findOne();
        }else {
            $scope.entity = {};
            editor.html('');
        }
    }

    //上传
    $scope.upload = function () {
        editService.upload().success(function (response) {
            if (response.error == "0") {
                    $scope.entity.image = response.url;
                    $scope.imageArr.push(response.url)
            } else {
                alert(response.message);
            }

        });
    }


});