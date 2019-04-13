var app = angular.module('newsRS',[]);
app.service('baseService',function ($http) {
    path=getAbsolutePath();
    this.getSomeCategory = function () {
        return $http.get(path + "category/findAll?type=first");
    }
    this.getAllCategory = function () {
        return $http.get(path + "category/findAll?type=more");
    }
});
app.controller('baseController',function ($scope,baseService) {
    $scope.path = getAbsolutePath();
    $scope.getSomeCategory=baseService.getSomeCategory().success(
        function (response) {
            $scope.categories = response;
        }
    );
    $scope.getAllCategory=baseService.getAllCategory().success(
        function (response) {
            $scope.allCategories = response;
        }
    );
});
function getAbsolutePath() {
    var pathname = location.pathname; //newsRS_web/pages/news_list.jsp
    // alert("pathname:"+pathname);
    pathname = pathname.substring(1); // newsRS_web/pages/news_list.jsp
    // alert("pathname截掉第一个/:"+pathname);
    pathname = pathname.substring(0, pathname.indexOf("/") + 1); // newsRS_web/
    // alert("pathname项目名:"+pathname);
    var href = location.href; //http://localhost:8080/newsRS_web/pages/news_list.jsp
    // alert(href);
    href = href.substring(0, href.indexOf(pathname) + pathname.length); // http://localhost:8080/newsRS_web/
    // alert(href);
    return href;
}