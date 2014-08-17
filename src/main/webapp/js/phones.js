angular.module('PhoneApp', [])
	.controller('PhoneCtrl', function($scope, $http) {
		$http.get('api/phones')
			.success(function(response) {
				$scope.phones = response;
			});

		$scope.orderProp = 'age';
	});