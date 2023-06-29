/**
 * Access the previously created module 'bnbapp'
 */

(function() {
 	let bnbapp = angular.module('bnbapp');
 
 	bnbapp.controller('drink-updateController', function($scope, $http, $routeParams, $location) {
	 
	 	$scope.getDrinkItemsById = function() {
			 $http.get("/broodnbarley/webapi/menu/drinkmenu/" + $routeParams.drinkId)
			 .then(function(response) {
				 var drinkitems = response.data;
				 if(drinkitems.length == 1){
					 $scope.drinkitem = drinkitems[0];
				 }else {
					 
				 }
			 }, function(response) {
				 console.log('error http GET drinks by id: ' + response.status);
			 });
		 }
		 
		 $scope.getDrinkItemsById();
		 
		 $scope.genres = ['Beer', 'Wine', 'SignatureCocktail', 'SeasonalCocktail', 'Mocktail'];
		 
		 $scope.updateDrinkItem = function() {
			 $http.put("/broodnbarley/webapi/menu/drinkmenu", $scope.drinkitem)
			 .then(function(response){
				 $scope.updateStatus = 'update successful!';
			}, function(response) {
				$scope.updateStatus = 'error trying to update drink item';
				console.log('error http PUT drink items: ' + response.status);
			 });
		 }
		 
		 $scope.deleteDrinkItem = function() {
			 $http.delete("/broodnbarley/webapi/menu/drinkmenu/" + $scope.drinkitem.drinkId)
			 .then(function(response) {
				 $scope.updateStatus = 'delete successful!';
				 $scope.disableUpdate = true;
			}, function(response) {
				$scope.updateStatus = 'error trying to delete drink item';
				console.log('error http DELETE drink items: ' + response.status);
			
			 });
		 }
		 
		 $scope.goToSearchView  = function() {
			 $location.path('/search');
		 }
	 
 	});
 
 })()