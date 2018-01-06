//var bookStoreApp =  angular.module('BookstoreApp', []);

bookStoreApp.controller('RegistrationCtrl', [
		'$scope',
		'$http',
		'$location',
		function($scope, $http, $location) {

			$scope.firstName = "";
			$scope.lastName = "";
			$scope.userName = "";
			$scope.phone = "";
			$scope.username = "";
			$scope.password = "";
			$scope.email = "";
			$scope.registrationStatus = false;
			$scope.registrationFailed = false;

			$scope.registerUser = function() {

				if ($scope.firstName != "" && $scope.lastName != ""
						&& $scope.email != "" && $scope.password != ""
						&& $scope.userName != "") {

					var registrationData = {

						"firstName" : $scope.firstName,
						"lastName" : $scope.lastName,
						"email" : $scope.email,
						"password" : $scope.password,
						"userName" : $scope.userName,
						"phone" : $scope.phone,
						"userRoleId" : 1
					}

					$http.post(
							window.serviceUrl
									+ "/rest/bookstore/v1/insert_user",
							registrationData).then(function(response) {
						$scope.registrationStatus = response.data;
						//$location.path(path);
					});
				} else {
					$scope.registrationFailed = true;

				}
			}
			

			$scope.okRegister = function() {
				$location.path("/login");
			}
			$scope.okFailed = function() {
				$scope.registrationFailed = false;
			}

		} ]);