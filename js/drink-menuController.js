/**
 * Access the previously created module 'bnbapp'
 */

(function() {
 	let bnbapp = angular.module('bnbapp');
 	
 
 	bnbapp.controller('drink-menuController', function($scope, $http, $location){
		
	 
	 	$scope.getDrinkMenu = function() {
			 $http.get("/broodnbarley/webapi/menu/drinkmenu/genre/SignatureCocktail")
			 .then(function(response){
				 $scope.signaturecocktails = response.data;
				 console.log('number of drinkitems: ' + $scope.signaturecocktails.length);
			 }, function(response) {
				 console.log('error http GET drinkmenu: ' + response.status);
			 });
			 $http.get("/broodnbarley/webapi/menu/drinkmenu/genre/SeasonalCocktail")
			 .then(function(response){
				 $scope.seasonalcocktails = response.data;
				 console.log('number of drinkitems: ' + $scope.seasonalcocktails.length);
			 }, function(response) {
				 console.log('error http GET drinkmenu: ' + response.status);
			 });
			 $http.get("/broodnbarley/webapi/menu/drinkmenu/genre/Beer")
			 .then(function(response){
				 $scope.beers = response.data;
				 console.log('number of drinkitems: ' + $scope.beers.length);
			 }, function(response) {
				 console.log('error http GET drinkmenu: ' + response.status);
			 });
			 $http.get("/broodnbarley/webapi/menu/drinkmenu/genre/Wine")
			 .then(function(response){
				 $scope.wines = response.data;
				 console.log('number of drinkitems: ' + $scope.wines.length);
			 }, function(response) {
				 console.log('error http GET drinkmenu: ' + response.status);
			 }); 
			 $http.get("/broodnbarley/webapi/menu/drinkmenu/genre/Mocktail")
			 .then(function(response){
				 $scope.mocktails = response.data;
				 console.log('number of drinkitems: ' + $scope.mocktails.length);
			 }, function(response) {
				 console.log('error http GET drinkmenu: ' + response.status);
			 }); 
		 }
		 
		 $scope.getDrinkMenu();
		 
	 	 
 	});
 
 })()