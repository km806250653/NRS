app.controller('ownpageController', function ($scope, $location, ownpageService) {
    $scope.init = function () {
        ownpageService.findUser().success(function (response) {
            $scope.user = response.object;
            var currentId = $location.search()['id'];
            currentId = currentId == null ? $scope.user.id : currentId;
            $scope.findCurrentUser(currentId);
        });
    }

    $scope.findCurrentUser = function (id) {
        ownpageService.findCurrentUser(id).success(function (response) {
            $scope.currentUser = response;
        });
    }

    $scope.isOwn = function () {
        if ($scope.user ==null|| $scope.currentUser==null)
            return;
        if ($scope.currentUser.user.id == $scope.user.id)
            return true;
        return false;
    }
});