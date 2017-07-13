dashboardApp.factory('SOWCRUDService', function($http, $q, $state) {
	return {
		deleteSOW : function(sow) {
			var deferred = $q.defer();
			$http.post('/dashboard/data/deleteSOW', sow).success(
					function(data) {
						deferred.resolve({});
					}).error(function(msg, code) {
				deferred.reject(msg);
			});
			return deferred.promise;
		},

		addSOW : function(sow) {
			var deferred = $q.defer();
			$http.post('/dashboard/data/saveSOW', sow).success(
					function(data) {						
						deferred.resolve(data);
					}).error(function(msg, code) {
				deferred.reject(msg);
				$('#addSOW').modal('toggle');
				$(".modal-backdrop").remove();
			});
			return deferred.promise;
		},
		
		updateSOW : function(sow) {
			var deferred = $q.defer();
			$http.post('/dashboard/data/updateSOW', sow).success(
					function(data) {						
						deferred.resolve(data);
					}).error(function(msg, code) {
				deferred.reject(msg);
				$('#viewallsow').modal('toggle');
				$(".modal-backdrop").remove();
			});
			return deferred.promise;
		},

		getSOWs : function() {
			var deferred = $q.defer();
			$http.get('/dashboard/data/getSOW').success(function(data) {
				deferred.resolve(data);
			}).error(function(data, headers) {
				deferred.reject();
			});
			return deferred.promise;

		},
		
		getSowExpireData : function() {
			var deferred = $q.defer();
			$http.get('/dashboard/data/getSowExpireData').success(function(data) {
				deferred.resolve(data);
			}).error(function(data, headers) {
				deferred.reject();
			});
			return deferred.promise;

		},
		
		getSOWForChart : function() {
			var deferred = $q.defer();
			$http.get('/dashboard/data/getSOWForChart').success(function(data) {
				deferred.resolve(data);
			}).error(function(data, headers) {
				deferred.reject();
			});
			return deferred.promise;

		}
	}
});