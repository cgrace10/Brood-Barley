/**
 * Access the previously created module 'bnbapp'
 */

(function() {
 	let bnbapp = angular.module('bnbapp');
 
 	bnbapp.controller('createController', function($scope, $http) {
	 
	 $scope.foodGenres = ['Appetizer', 'Entree', 'Dessert'];
	 
	 $scope.createFoodItem = function() {
		 $http.post("/broodnbarley/webapi/menu/foodmenu", $scope.fooditem)
		 .then(function(response) {
			 $scope.createStatus = 'create successful!'
			 $scope.disableCreate = true;
		 }, function(response) {
			 $scope.createStatus = 'error trying to create food item';
			 console.log('error http POST food items: ' + response.status);
		 });
	 }
	 
	 $scope.clearFood = function() {
		 $scope.fooditem.foodTitle = '';
		 $scope.fooditem.descriptions = '';
		 $scope.fooditem.genre = '';
		 $scope.fooditem.price = '';
		 $scope.disableCreate = false;
	 }
	 
	 $scope.drinkGenres = ['Beer', 'Wine', 'SignatureCocktail', 'SeasonalCocktail', 'Mocktail'];
	 
	 $scope.createDrinkItem = function() {
		 $http.post("/broodnbarley/webapi/menu/drinkmenu", $scope.drinkitem)
		 .then(function(response) {
			 $scope.createStatus = 'create successful!'
			 $scope.disableCreate = true;
		 }, function(response) {
			 $scope.createStatus = 'error trying to create food item';
			 console.log('error http POST drink items: ' + response.status);
		 });
	 }
	 
	 $scope.clearDrink = function() {
		 $scope.drinkitem.drinkTitle = '';
		 $scope.drinkitem.descriptions = '';
		 $scope.drinkitem.genre = '';
		 $scope.drinktem.price = '';
		 $scope.drinkitem.abv = '';
		 $scope.disableCreate = false;
	 }
	 
	 $scope.button_text = 'Create Drink Item';
	 $scope.showCreateDrinkItem = false;
		  
		 $scope.showHide = function() {
			 if ($scope.showCreateDrinkItem) {
				 $scope.showCreateDrinkItem = false;
				 $scope.button_text = 'Create Drink Item';
			 }else {
				 $scope.showCreateDrinkItem = true;
				 $scope.button_text = 'Create Food Item';
			 }
		 }
	 
	 
 	});
 
 })()