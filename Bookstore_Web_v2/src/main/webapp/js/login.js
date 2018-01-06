//var bookStoreApp =  angular.module('BookstoreApp', ["ngRoute"]);

bookStoreApp.controller('LoginCtrl', [
		'$scope',
		'$rootScope',
		'$location',
		'$http',
		function($scope, $rootScope, $location, $http) {

			$scope.userName = "";
			$scope.password = "";
			// $scope.loginStatus = false;
			$scope.loginFailed = false;

			$scope.login = function(path) {

				var authenticationInfo = {
					'userName' : $scope.userName,
					'passWord' : $scope.password
				}

				$http.post(window.serviceUrl + "/rest/bookstore/v1/login/user",
						authenticationInfo).then(function(response) {
					$rootScope.user = response.data;
					if (typeof $rootScope.user.userName != 'undefined') {
						
						$rootScope.isAdmin = false;
						
						angular.forEach($rootScope.user.userRoles, function(role){
						      if(role.role.name == "ADMIN"){
						    	  $rootScope.isAdmin = true;
						      }
						   });
						
						$location.path(path);
					} else {
						$scope.loginFailed = true;
					}
				});
			}

			$scope.signUp = function() {
				$location.path("/registration");
			}

			$scope.okLogin = function() {
				$scope.loginFailed = false;
			}
		} ]);