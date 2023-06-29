/**
 * Access the previously created module 'bnbapp'
 */

(function() {
 	let bnbapp = angular.module('bnbapp');
 	
 
 	bnbapp.controller('food-menuController', function($scope, $http, $location){
		
	 
	 	$scope.getFoodMenu = function() {
			 $http.get("/broodnbarley/webapi/menu/foodmenu/genre/Appetizer")
			 .then(function(response){
				 $scope.appetizers = response.data;
				 console.log('number of fooditems: ' + $scope.appetizers.length);
			 }, function(response) {
				 console.log('error http GET foodmenu: ' + response.status);
			 });
			 $http.get("/broodnbarley/webapi/menu/foodmenu/genre/Entree")
			 .then(function(response){
				 $scope.entrees = response.data;
				 console.log('number of fooditems: ' + $scope.entrees.length);
			 }, function(response) {
				 console.log('error http GET foodmenu: ' + response.status);
			 });
			 $http.get("/broodnbarley/webapi/menu/foodmenu/genre/Dessert")
			 .then(function(response){
				 $scope.desserts = response.data;
				 console.log('number of fooditems: ' + $scope.desserts.length);
			 }, function(response) {
				 console.log('error http GET foodmenu: ' + response.status);
			 }); 
		 }
		 
		 $scope.getFoodMenu();
		 
		 $scope.cartTotal = 0;
		 
		 $scope.addToCart = function(fooditem) {
			 
			 $scope.cartTotal = $scope.cartTotal + fooditem.price;
				
			if (localStorage.getItem('cart') != null) {
				$scope.cart = JSON.parse(localStorage.getItem('cart'));
				$scope.cart.push(fooditem);
				localStorage.setItem('cart', JSON.stringify($scope.cart));

			} else {
				// new cart
				$scope.cart = [fooditem];

				localStorage.setItem('cart', JSON.stringify($scope.cart));

			}			
		}

		$scope.getCart = function() {

			if (localStorage.getItem('cart') != null) {
				$scope.cart = JSON.parse(localStorage.getItem('cart'));				
				for (var j = 0; j < $scope.cart.length; j++) {
					$scope.cartTotal = $scope.cartTotal + $scope.cart[j].price;
					}
			} else {				
				$scope.cart = [];				

			}			
		}

		$scope.getCart();

		$scope.viewCart = false;

		$scope.viewMyCart = function() {			
			$scope.viewCart = true;

		}

		$scope.hideMyCart = function() {			
			$scope.viewCart = false;

		}

		$scope.emptyMyCart = function() {

			if (localStorage.getItem('cart') != null) {
				$scope.cartTotal = 0;
				$scope.cart = [];
				localStorage.setItem('cart', JSON.stringify($scope.cart));			

			}			
		}
	 	 
 	});
 
 })()