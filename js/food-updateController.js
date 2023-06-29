/**
 * Access the previously created module 'bnbapp'
 */

(function() {
 	let bnbapp = angular.module('bnbapp');
 
 	bnbapp.controller('food-updateController', function($scope, $http, $routeParams, $location) {
	 
	 	$scope.getFoodItemsById = function() {
			 $http.get("/broodnbarley/webapi/menu/foodmenu/" + $routeParams.foodId)
			 .then(function(response) {
				 var fooditems = response.data;
				 if(fooditems.length == 1){
					 $scope.fooditem = fooditems[0];
				 }else {
					 
				 }
			 }, function(response) {
				 console.log('error http GET movies by id: ' + response.status);
			 });
		 }
		 
		 $scope.getFoodItemsById();
		 
		 $scope.genres = ['Appetizer', 'Entree', 'Dessert'];
		 
		 $scope.updateFoodItem = function() {
			 $http.put("/broodnbarley/webapi/menu/foodmenu", $scope.fooditem)
			 .then(function(response){
				 $scope.updateStatus = 'update successful!';
			}, function(response) {
				$scope.updateStatus = 'error trying to update food item';
				console.log('error http PUT food items: ' + response.status);
			 });
		 }
		 
		 $scope.deleteFoodItem = function() {
			 $http.delete("/broodnbarley/webapi/menu/foodmenu/" + $scope.fooditem.foodId)
			 .then(function(response) {
				 $scope.updateStatus = 'delete successful!';
				 $scope.disableUpdate = true;
			}, function(response) {
				$scope.updateStatus = 'error trying to delete food item';
				console.log('error http DELETE food items: ' + response.status);
			
			 });
		 }
		 
		 $scope.goToSearchView  = function() {
			 $location.path('/search');
		 }
	 
 	});
 
 })()