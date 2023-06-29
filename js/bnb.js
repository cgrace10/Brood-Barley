/**
 * creates a new module named 'bnbapp'
 * All my controllers will be contained in this module.
 */

(function(){
 	let movieapp = angular.module('bnbapp', ['ngRoute']);
 	
 	movieapp.config(function($routeProvider) {			
	  $routeProvider
	  .when("/bnb-home", {
	    templateUrl : "bnb-home.html"
	  })
	  .when("/food-menu", {
	    templateUrl : "food-menu.html",
	    controller : "food-menuController"
	  })
	  .when("/drink-menu", {
	    templateUrl : "drink-menu.html",
	    controller : "drink-menuController"
	  })
	  .when("/search", {
	    templateUrl : "search.html",
	    controller : "searchController"
	  })
	  .when("/create", {
	    templateUrl : "create.html",
	    controller : "createController"
	  })
	  .when("/food-update/:foodId", {
	    templateUrl : "food-update.html",
	    controller : "food-updateController"
	  })
	  .when("/drink-update/:drinkId", {
	    templateUrl : "drink-update.html",
	    controller : "drink-updateController"
	  })
	  .when("/resume", {
	    templateUrl : "resume.html"
	  })
	  .otherwise({
		 templateUrl : "bnb-home.html" 
	  });			
	})
 
 })()