dashboardApp.factory('ResourceCRUDService', function($http, $q, $state) {
	return {
		deleteResource : function(resource) {
			var deferred = $q.defer();
			$http.post('/dashboard/data/deleteResource', resource).success(
					function(data) {
						deferred.resolve({});
					}).error(function(msg, code) {
				deferred.reject(msg);
			});
			return deferred.promise;
		},

		addResource : function(resource) {
			var deferred = $q.defer();
			$http.post('/dashboard/data/saveResource', resource).success(
					function(data) {						
						deferred.resolve(data);
					}).error(function(msg, code) {
				deferred.reject(msg);
				$('#addresource').modal('toggle');
				$(".modal-backdrop").remove();
			});
			return deferred.promise;
		},
		
		updateResource : function(resource) {
			var deferred = $q.defer();
			$http.post('/dashboard/data/updateResource', resource).success(
					function(data) {						
						deferred.resolve(data);
					}).error(function(msg, code) {
				deferred.reject(msg);
				$('#viewallresource').modal('toggle');
				$(".modal-backdrop").remove();
			});
			return deferred.promise;
		},

		getResources : function() {
			var deferred = $q.defer();
			$http.get('/dashboard/data/getResource').success(function(data) {
				deferred.resolve(data);
			}).error(function(data, headers) {
				deferred.reject();
			});
			return deferred.promise;

		},
		
		getResourceForChart : function() {
			var deferred = $q.defer();
			$http.get('/dashboard/data/getResourceForChart').success(function(data) {
				deferred.resolve(data);
			}).error(function(data, headers) {
				deferred.reject();
			});
			return deferred.promise;

		}
	}
});