var app = angular.module('newsRS', ['pagination']);
//过滤器
app.filter('trustHtml',function ($sce) {
    return function (data) {
        return $sce.trustAsHtml(data);
    }
});
var allPath = {
    projectPath: getAbsolutePath(),
    casServerPath: 'http://192.168.25.136:8080/',
    defaultHeaderImagePath: 'http://localhost:8080/newsRS_web/pages/img/photo.png'
}
//服务层
app.service('baseService', function ($http) {
    path = allPath.projectPath;
    this.getCategory = function (type) {
        return $http.get(path + "category/findAll.do?type=" + type);
    }
    this.getIp = function () {
        //第三方天气api
        return $http.get('https://www.tianqiapi.com/api/?version=v1');
    }
    //获取登录用户
    this.getUser = function () {
        return $http.get(path + 'user/getUser.do');
    }
    //登出
    this.logout = function () {
        return $http.get('http://192.168.25.136:8080/cas/logout', {
            //携带cookie
            withCredentials: true
        })
    }
    this.findNewsList = function (cid,pageNum,pageSize) {
        return $http.get('../news/findList.do?cid='+cid+'&pageNum='+pageNum+'&pageSize='+pageSize);
    }

});

//控制层
app.controller('baseController', function ($scope, $interval, baseService) {
    $scope.pathJson = allPath;

    $scope.loadDataFirst == 1
    //分页控件
    $scope.paginationConf = {
        currentPage: 1,
        totalItems: 10,
        itemsPerPage: 8,
        perPageOptions: [8, 12, 16, 20, 24],
        onChange: function(){
            if($scope.loadDataFirst == 1) {
                $scope.findList($scope.cid);//重新加载
                $scope.loadDataFirst = 2;
            }else if($scope.loadDataFirst == 2) {
                $scope.loadDataFirst = 0;
            }else if ($scope.loadDataFirst == 0) {
                $scope.findList($scope.cid); //重新加载
            }
        }
    };

    //初始化方法
    //获取分类列表
    $scope.getSomeCategory = baseService.getCategory('first').success(function (response) {
            $scope.categories = response;
        }
    );

    //获取用户信息
    $scope.getUser = function () {
        baseService.getUser().success(function (response) {
                $scope.user = response.object;
            });
    }
    $scope.getUser();

    //获取天气
    $scope.getWeather = baseService.getIp().success(function (response) {
        $scope.weather = response;
        $scope.selectDate = response.data[0];
    });

    //定时器 时钟
    $interval(function () {
        var date = new Date();
        var day = date.getDate();
        var hours = date.getHours();
        var minutes = date.getMinutes();
        var seconds = date.getSeconds();
        $scope.time = day + "日  " + hours + ":" + minutes + ":" + seconds;
    },0, 1000);

    //待调用方法
    //加载剩下的分类列表
    $scope.getAllCategory = function () {
        baseService.getCategory('more').success(
            function (response) {
                $scope.allCategories = response;
            }
        );
    }
    $scope.chooseDate = function (index) {
        $scope.selectDate = $scope.weather.data[index];
    }

    //登出
    $scope.logout = function () {
        //登出
        baseService.logout().error(function () {
            $scope.getUser();
        });
    }

    //
    $scope.findNewsList = function(id){
        $scope.cid = id;
        var number = location.href.indexOf("news_list.html");
        if(number>=0){
            //在新闻列表页点击分类，发送ajax请求
            $scope.findList($scope.cid);
        }else {
            //由其它页面点击分类，跳转到新闻列表页
            location.href = $scope.pathJson.projectPath+'pages/news_list.html#?id='+$scope.cid;
        }
    }
    $scope.findList = function (id) {
        baseService.findNewsList(id,$scope.paginationConf.currentPage,$scope.paginationConf.itemsPerPage).success(function (response) {
            $scope.list = response.rows;
            $scope.paginationConf.totalItems = response.total;
        });
    }
});



function getAbsolutePath() {
    var pathname = location.pathname; //newsRS_web/pages/news_list.html
    // alert("pathname:"+pathname);
    pathname = pathname.substring(1); // newsRS_web/pages/news_list.html
    // alert("pathname截掉第一个/:"+pathname);
    pathname = pathname.substring(0, pathname.indexOf("/") + 1); // newsRS_web/
    // alert("pathname项目名:"+pathname);
    var href = location.href; //http://localhost:8080/newsRS_web/pages/news_list.jsp
    // alert(href);
    href = href.substring(0, href.indexOf(pathname) + pathname.length); // http://localhost:8080/newsRS_web/
    // alert(href);
    return href;
}