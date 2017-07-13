dashboardApp.controller('resoureController', function($scope, $http, $q,
		$rootScope, $state, $filter, AuthService, ResourceCRUDService, $localStorage,$window,
		LoginService) {

	var config = {
		headers : {
			'Content-Type' : 'application/x-www-form-urlencoded;charset=utf-8;'
		}
	};
	
	var temp = [];
	$scope.added=false;
	$scope.notAdded=false;
	$scope.updated=false;
	$scope.error=false;
	$scope.message='';
	$scope.init = function() {
		console.log("Init caleed Resource")
		var defer = $q.defer;
		 ResourceCRUDService.getResources().then(function(data, headers) {
			$scope.resources = data;
			$rootScope._.uniq($scope.resources);
			if ($rootScope._.findWhere($scope.resources, temp) == null) {
				$scope.resources = temp;
			}
			
		},function() {
			$state.go("home");

		});
		ResourceCRUDService.getResourceForChart().then(function(data, headers) {
			$scope.data = data;		
		});
	};

	$scope.saveResource = function() {
	
		var dataObj = {
				associateid : $scope.associateid,
				associatename : $scope.associatename,
				reportingmanager : $scope.reportingmanager,
				msatpid : $scope.msatpid,
				location : $scope.location,
				status : $scope.status,
				inactivereason : $scope.inactivereason,
				remarks : $scope.remarks,
				emailid : $scope.emailid,
				scotiaemailid : $scope.scotiaemailid,
				band : $scope.band,
				billingrate : $scope.billingrate,
				
		};
		
		if($scope.id!==null){
			dataObj.id= $scope.id;
		}
		
		 ResourceCRUDService.addResource(dataObj).then(function (response) {
			 var message = response.data;
			 console.log(" message "+message);
			 if(message=="already exist"){
				 $scope.notAdded=true;
				 $scope.message="Resource already exist...!!";
		     }else if(message=="saved"){
		    	 $scope.added=true;
		    	 $scope.message="Resource Saved Successfully...!!";
		     }else{
		    	 $scope.notAdded=true;
		    	 $scope.message="Service not Exists....!";
		     }
			 
		 }, function() {
			 console.log(" function ");
			 $scope.notAdded=false;
			 $scope.message = "Service not Exists";
		});
		//$state.go($state.current, {}, {reload: false});
	};
	
	$scope.updateResource = function() {
		var dataObj = {
				id : $scope.id,
				associatename : $scope.associatename,
				reportingmanager : $scope.reportingmanager,
				msatpid : $scope.msatpid,
				location : $scope.location,
				status : $scope.status,
				inactivereason : $scope.inactivereason,
				remarks : $scope.remarks,
				emailid : $scope.emailid,
				scotiaemailid : $scope.scotiaemailid,
				band : $scope.band,				
		};
		
		if($scope.id!==null){
			dataObj.id= $scope.id;
		}
		
		 ResourceCRUDService.updateResource(dataObj).then(function (response) {
			 var message = response.data;
			 if(message=="updated"){
				 $scope.updated=true;
		    	 $scope.message="Resource Details Updated Successfully...!!";
		     }else{
		    	 $scope.message="Service not Exists....!";
		     }
			 
		 }, function() {
			 console.log(" function ");
			 $scope.message = "Service not Exists";
		});
		//$state.go($state.current, {}, {reload: false});
	};
	
	
	$scope.deleteResourceDetails = function(resource) {
		$scope.added=false;
		ResourceCRUDService.deleteResource(resource).then(function(data) {
			$scope.updated=true;
			$scope.message="Resource Details Deleted...!!";
			for (i in $scope.resources) {
				if ($scope.resources[i].associateid == resource.associateid) {
					$scope.resources.splice(i, 1);
					$scope.newresource = {};
				}
			}
		}, function() {
			$scope.error = true;
			$scope.message = 'Unable to delete resource';
			$state.go("viewallresource");
		});
		
				
		$('#updateResource').modal('hide');
	};
	
	$scope.logout = function() {
		$scope.added=false;
		AuthService.deleteToken();
		$localStorage.authenticated = false;
		$state.go("home");
	};

	$scope.home = function() {
		$scope.coresource= [];
		$state.go("home");
	};
	
	$scope.clean = function() {
		$scope.error = false;
		$scope.updated=false;
		$scope.resource = {};
		$("#form").trigger('reset'); //jquery
	};
	
	$scope.editResource = false;
	$scope.deleteResource = false;
	$scope.resource;
	
	$scope.sort = function(keyname){
		$scope.sortKey = keyname;   //set the sortKey to the param passed
		$scope.reverse = !$scope.reverse; //if true make it false and vice versa
	}

	$scope.edit = function(resource){
		$scope.deleteResource = false;
		$scope.editResource = true;		
		$scope.resource = $filter('filter')($scope.resources, {id:resource.id })[0];
	}

	$scope.updateResourceDetails = function(resource) {
		ResourceCRUDService.updateResource(resource).then(function(newResource) {
			$scope.updated=true;
			$scope.message="Resource Details Updated Successfully...!!";
			refreshResourceList();
		}, function() {
			$state.go("viewallresource");
		});
		$('#updateResource').modal('hide');
	};
	
	
	$scope.submit = function(resource){
		$scope.editResource = false;
		$scope.deleteResource = false;
	}
	
	$scope.cancel = function(){		
		$scope.editResource = true;
		$scope.deleteResource = true;		
	}

	$scope.delete = function(resource){
		$scope.deleteResource = true;
		$scope.editResource = false;
		$scope.resource = $filter('filter')($scope.resources, {id:resource.id })[0];
	}
	
	refreshResourceList = function(){
		$http.get("/dashboard/data/getResource").success(function(response){ 
			$scope.resources = response;  //ajax request to fetch data into $scope.data
		});
	}
	
});


		



