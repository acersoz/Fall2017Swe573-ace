//var bookStoreApp =  angular.module('BookstoreApp', []);

bookStoreApp.controller('BookInsertCtrl', ['$scope', '$http', function($scope, $http) {
    
	$scope.name = "";
	$scope.author = "";
	$scope.publisher = "";
	$scope.publishedDate = "";
	$scope.description = "";
	$scope.saveStatus = false;

	$scope.insertBook = function() {
		
		 var book = {
			"name": $scope.name,
			"author": $scope.author,
			"publisher": $scope.publisher,
			"publishedDate": $scope.publishedDate,
			"description": $scope.description
		 }
		
		 $http.post(window.serviceUrl + "/rest/bookstore/v1/book", book)
		 .then(function(response){
	        $scope.saveStatus = response.data;
	     });
	}
	
	$scope.loadBookFromGoogleApi = function() {
		
		if($scope.name.length > 0) {
			$http.get("https://www.googleapis.com/books/v1/volumes?q=" + $scope.name +"&maxResults=1")
			 .then(function(response){
				 
				 var bookItems = response.data.items;
				 if(bookItems && bookItems.length > 0) {
					 loadFormFieldsWithApiData(bookItems[0]);
				 }
		     });
		}
	}
	
	var loadFormFieldsWithApiData = function(bookItem) {
		
		var volumeInfo = bookItem.volumeInfo;
		if(volumeInfo) {
			$scope.name = volumeInfo.title || "";
			$scope.author = prepareAuthorsInformation(volumeInfo.authors);
			$scope.publisher = volumeInfo.publisher || "";
			$scope.publishedDate = volumeInfo.publishedDate || "";
			$scope.description = volumeInfo.description || "";
		}
	}
	
	var prepareAuthorsInformation = function(authors) {

		var fullAuthorInformation = "";
		
		if(authors && authors.length) {
			for(var i=0; i < authors.length; i++) {
				var author = authors[i];
				fullAuthorInformation += author;
				
				if(i != (authors.length - 1)) {
					fullAuthorInformation += ",";
				}
			}
		}
		
		return fullAuthorInformation;
	}
}]);