/**
 * Created by superleo on 8/9/15.
 */
jQuery.ajaxSettings.traditional = true;
var webApp = angular.module('webApp', []);
webApp.filter('format', function () {
    return function (input) {
        if (input == null) {
            return "";
        }
        var _date = $filter('date')(new Date(input), format);
        return _date.toUpperCase();
    };
});
webApp.filter('ddMMyyyy', function ($filter) {
    return function (input) {
        if (input == null) {
            return "";
        }
        var _date = $filter('date')(new Date(input), 'dd/MM/yyyy');
        return _date.toUpperCase();
    };
});