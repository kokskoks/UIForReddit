app.controller("formController", function($scope, $http) {
	$scope.selectedTestAccount = null;
	$scope.categories = [];
	$scope.reddits = [];

	$http.get('/categories').then(function(response) {
		$scope.categories = response.data.categories;
	});

	$scope.searchByUser = function(user) {
		$http({
			method : 'GET',
			url : '/newsByUser',
			params : {
				user : user
			}
		}).then(function successCallback(response) {
			$scope.reddits = response.data.news;
		}, function errorCallback(response) {
		});
	}

	$scope.searchBySubreddit = function(subreddit, category) {
		$http({
			method : 'GET',
			url : '/subbredditWithCategory',
			params : {
				sub : subreddit,
				cat : category.name
			}
		}).then(function successCallback(response) {
			$scope.reddits = response.data.news;
		}, function errorCallback(response) {
		});
	}

	$scope.searchByKeywords = function(keyword) {
		$http({
			method : 'GET',
			url : '/newsByKeywords',
			params : {
				keywords : keyword
			}
		}).then(function successCallback(response) {
			$scope.reddits = response.data.news;
		}, function errorCallback(response) {
		});
	}

});