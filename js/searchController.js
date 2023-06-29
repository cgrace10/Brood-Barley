/**
 * Access the previously created module 'bnbapp'
 */

(function() {
 	let bnbapp = angular.module('bnbapp');
 
 	bnbapp.controller('searchController', function($scope, $http, $location){
	 
	 	$scope.getFoodMenu = function() {
			 $http.get("/broodnbarley/webapi/menu/foodmenu")
			 .then(function(response){
				 $scope.foodmenu = response.data;
				 console.log('number of fooditems: ' + $scope.foodmenu.length);
			 }, function(response) {
				 console.log('error http GET foodmenu: ' + response.status);
			 });
		 }
		 
		 $scope.getFoodMenu();
	 	 
	 	 $scope.goToFoodUpdateView = function(foodId) {
			  console.log('foodId: ' + foodId);
			  $location.path('/food-update/' + foodId);
		  }
		  
		  $scope.getDrinkMenu = function() {
			 $http.get("/broodnbarley/webapi/menu/drinkmenu")
			 .then(function(response){
				 $scope.drinkmenu = response.data;
				 console.log('number of drinkitems: ' + $scope.drinkmenu.length);
			 }, function(response) {
				 console.log('error http GET drinkmenu: ' + response.status);
			 });
		 }
		 
		 $scope.getDrinkMenu();
		 
		 $scope.goToDrinkUpdateView = function(drinkId) {
			  console.log('drinkId: ' + drinkId);
			  $location.path('/drink-update/' + drinkId);
		  }
		 
		 $scope.button_text = 'Show Drink Menu';
		 $scope.showDrinkMenu = false;
		  
		 $scope.showHide = function() {
			 if ($scope.showDrinkMenu) {
				 $scope.showDrinkMenu = false;
				 $scope.button_text = 'Show Drink Menu';
			 }else {
				 $scope.showDrinkMenu = true;
				 $scope.button_text = 'Show Food Menu';
			 }
		 }
 	});
 
 })()