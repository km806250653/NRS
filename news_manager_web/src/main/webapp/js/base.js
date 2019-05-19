var app = angular.module('newsRS', ['pagination']);
//过滤器
app.filter('trustHtml',function ($sce) {
    return function (data) {
        return $sce.trustAsHtml(data);
    }
});

app.controller('baseController',function ($scope) {
        $scope.paginationConf = {
            currentPage: 1,
            totalItems: 10,
            itemsPerPage: 8,
            perPageOptions: [8, 12, 16, 20, 24],
            onChange: function () {
                $scope.ids = [];
                $scope.findPage();
            }
        }

        $scope.ids = [];
        $scope.updateChecked = function ($event, id) {
                if($event.target.checked){//如果是被选中,则增加到数组
                    $scope.ids.push(id);
                }else{
                    $scope.ids.splice($scope.ids.indexOf(id), 1);//删除
                }
        }
    });