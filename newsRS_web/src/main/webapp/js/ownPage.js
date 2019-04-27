var app = angular.module('newsRS',[]);
app.filter('trustHtml',function ($sce) {
    return function (data) {
        return $sce.trustAsHtml(data);
    }
});