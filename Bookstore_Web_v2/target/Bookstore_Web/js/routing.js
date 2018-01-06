window.serviceUrl = //"http://localhost:8080/Bookstore_Web"; 
					"http://boun-bookstore.herokuapp.com";
var bookStoreApp = angular.module("BookstoreApp", ["ngRoute"]);
bookStoreApp.config(function($routeProvider) {
    $routeProvider
    .when("/login", {
        templateUrl : "login.html",
        controller : "LoginCtrl"
    })
    .when("/dashboard", {
        templateUrl : "dashboard.html",
        controller : "DashboardCtrl"
    })
    .when("/deneme", {
        templateUrl : "deneme.html"
        //controller : "londonCtrl"
    })
    .when("/registration", {
        templateUrl : "user_registration.html",
        controller : "RegistrationCtrl"
    })
    .when("/registered", {
        templateUrl : "UserRegistered.html",
        controller : "UserRegisteredCtrl"
    })
    .when("/bookadd", {
        templateUrl : "book_insert.html",
        controller : "BookInsertCtrl"
    })
    .when("/book", {
        templateUrl : "Book.html",
        controller : "BookCtrl"
    })
    .otherwise({
		redirectTo: '/login'
	});
    
    
});