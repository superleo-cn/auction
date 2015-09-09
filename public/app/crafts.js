webApp.controller('Craft', ['$scope', '$rootScope', '$http', function ($scope, $rootScope, $http) {
    $scope.method = 'GET';
    $scope.data = {};
    $scope.params = {};
    $scope.template = function (operation, jsonUrl) {
        $scope.code = null;
        $scope.response = null;
        $http({
            method: $scope.method,
            url: jsonUrl,
            params: $scope.params,
            headers: {'Content-Type': 'application/x-www-form-urlencoded'}
        }).success(operation).error(function (data, status) {
            $scope.data = data || "Request failed";
            $scope.status = status;
        });
    };

    $scope.getStatusText = function (status) {
        if (status == 1) {
            return "Active";
        }
        return "Inactive";
    };

    $scope.getStatusClass = function (status) {
        if (status == 1) {
            return "success";
        }
        return "danger";
    };

    $scope.template(function (data, status) {
        //hideLoading();
        $scope.status = status;
        debugger;
        if (data && data.code == '1') {
            $scope.data = data.datas;
        }
    }, "/crafts/findAll");

}]);
$(function () {

});