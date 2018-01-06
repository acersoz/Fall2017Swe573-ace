//var bookStoreApp =  angular.module('BookstoreApp', ["ngRoute"]);

bookStoreApp.controller('DashboardCtrl', [
		'$scope',
		'$rootScope',
		'$location',
		'$http',
		function($scope, $rootScope, $location, $http, $mdDialog) {
			
			$scope.isAdminDash = $rootScope.isAdmin;
			$scope.tagStatus = false;
			$scope.tagName = "";

			$http.get(window.serviceUrl + "/rest/bookstore/v1/books").then(
					function(response) {
						$scope.books = response.data;
					});

			$scope.addTag = function() {
				if($scope.tagName != ""){
				$http.post(
						window.serviceUrl + "/rest/bookstore/v1/tag/"
								+ $scope.tagName).then(function(response) {

					$scope.tagStatus = response.data;
					$scope.message = "Tag added successfully";
				});
				}
				else{
					var x = 1;
					$scope.tagStatus = true;
					$scope.message = "Tag cannot be blank";
				}
			}

			$scope.selBook = function(book) {
				$rootScope.selected_book = book;

				$http.get(
						window.serviceUrl + "/rest/bookstore/v1/book/"
								+ book.bookId).then(function(response) {
					$rootScope.tags = response.data.bookTags;
				})

				$http.get(window.serviceUrl + "/rest/bookstore/v1/tags").then(
						function(response) {
							$rootScope.allTags = response.data;
						})

				$location.path("/book");

			}
			
			$scope.okTag = function(path) {
				$scope.tagStatus = false;
			}

			$scope.dashboard = function(path) {
				$location.path(path);
			}

			$scope.logOut = function() {
				$location.path("/login");
			}

		} ]);