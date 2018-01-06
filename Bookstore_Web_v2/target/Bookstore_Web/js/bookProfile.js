//var bookStoreApp =  angular.module('BookstoreApp', ["ngRoute"]);

bookStoreApp.controller('BookCtrl', [
		'$scope',
		'$rootScope',
		'$location',
		'$http',
		function($scope, $rootScope, $location, $http) {
			
			$scope.tagAdded = false;
/*
			$http.get(
					window.serviceUrl + "/rest/bookstore/v1/book/"
							+ $rootScope.selected_book.bookId).then(
					function(response) {
						$rootScope.tags = response.data.bookTags;
					})

			$http.get(window.serviceUrl + "/rest/bookstore/v1/tags").then(
					function(response) {
						$rootScope.allTags = response.data;
					})*/

			$scope.addBookTag = function() {

				// var x = $rootScope.selected_book.bookId;
				// var y = $scope.selectedTag.tagId;
				// var y = $rootScope.user.userId;

				$http.post(
						window.serviceUrl
								+ "/rest/bookstore/v1/tag/addBookTag/"
								+ $rootScope.selected_book.bookId + "/"
								+ $scope.selectedTag.tagId + "/"
								+ $rootScope.user.userId).then(
						function(response) {

							$scope.tagAdded = response.data;
						});

			}
			

			$scope.okBookTag = function() {
				$scope.tagAdded = false;
				$location.path("/dashboard");
				
			}
			
			$scope.location = function(path) {
				$location.path(path);
			}

		} ]);