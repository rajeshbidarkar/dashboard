dashboardApp.controller('sowController', function($scope, $http, $q,
		$rootScope, $state, $filter, AuthService, SOWCRUDService, CRUDService, $localStorage,$window,
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
	$scope.associates = [];
	$scope.selected = false; 
	$scope.selectedObj = {};
	$scope.sowsGoingToExpire = {};
	$scope.isIndented = true;
    
    $scope.getClass = function(sow) {
    	var date = new Date();
    	var fromDate = $filter('date')(date, 'MM-dd-yyyy');
		var toDate = $filter('date')(date.setDate(date.getDate() + 30), 'MM-dd-yyyy');
		var expDate = $filter('date')(sow.expirydate, 'MM-dd-yyyy');
		return dateCheck(fromDate,toDate,expDate);
    }

	$scope.init = function() {
		console.log("Init caleed SOW")
		var defer = $q.defer;
		SOWCRUDService.getSOWs().then(function(data, headers) {
			$scope.sows = data;
			$rootScope._.uniq($scope.sows);
			if ($rootScope._.findWhere($scope.sows, temp) == null) {
				$scope.sows = temp;
			}
			
		},function() {
			$state.go("home");

		});
		
		CRUDService.getContact().then(function(data, headers) {
			 $scope.contacts = data;	
		});
		 
		SOWCRUDService.getSOWForChart().then(function(data, headers) {
			$scope.data = data;		
		});				
		
		sowsGoingToExpire();
	};

	$scope.saveSOW = function() {
		var dataObj = {
				client : $scope.clientname,
				msatsopocemailid : $scope.msatspocemailid,
				contracttype : $scope.contracttype,
				recordtype : $scope.recordtype,
				opnumber : $scope.opnumber,
				wanumber : $scope.wanumber,
				watype : $scope.watype,
				wastatus : $scope.wastatus,
				wastatusdate : $scope.wastatusdate,
				startdate  : $scope.startdate,
				expirydate : $scope.expirydate,
				waamount : $scope.waamount,
				wabalance : $scope.wabalance,
				projectname : $scope.projectname,
				msatpid : $scope.msatpid,				
				contractno : $scope.contractno,
				location : $scope.location,
				tag : $scope.tag,
				upside : $scope.upside,
				associates : $scope.associates,
		};
		
		if($scope.id!==null){
			dataObj.id= $scope.id;
		}
		
		SOWCRUDService.addSOW(dataObj).then(function (response) {
			 var message = response.data;
			 console.log(" message "+message);
			 if(message=="already exist"){
				 $scope.notAdded=true;
				 $scope.message="SOW already exist...!!";
		     }else if(message=="saved"){
		    	 $scope.added=true;
		    	 $scope.message="SOW Saved Successfully...!!";
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
	
	$scope.updateSOW = function() {		
		var dataObj = [];
		if($scope.sow.id!==null){
			dataObj= $scope.sow;
			$scope.message="SOW Resource Details Updated Successfully...!!";
		}
		else {
				dataObj = {
					client : $scope.clientname,
					msatsopocemailid : $scope.msatspocemailid,
					contracttype : $scope.contracttype,
					recordtype : $scope.recordtype,
					opnumber : $scope.opnumber,
					wanumber : $scope.wanumber,
					watype : $scope.watype,
					wastatus : $scope.wastatus,
					wastatusdate : $scope.wastatusdate,
					startdate  : $scope.startdate,
					expirydate : $scope.expirydate,
					waamount : $scope.waamount,
					wabalance : $scope.wabalance,
					projectname : $scope.projectname,
					msatpid : $scope.msatpid,				
					contractno : $scope.contractno,
					location : $scope.location,
					tag : $scope.tag,
					upside : $scope.upside,
					associates : $scope.associates,
				};
			if($scope.id!==null){
				dataObj.id= $scope.id;
			}	
		}
		
		SOWCRUDService.updateSOW(dataObj).then(function (response) {
			 var message = response.data;
			 if(message=="updated"){
				 $scope.updated=true;
		    	 $scope.message="SOW Details Updated Successfully...!!";
		     }else{
		    	 $scope.message="Service not Exists....!";
		     }
			 
		 }, function() {
			 console.log(" function ");
			 $scope.message = "Service not Exists";
		});
		//$state.go($state.current, {}, {reload: false});
	};
	
	
	$scope.deleteSOWDetails = function(sow) {
		$scope.added=false;
		SOWCRUDService.deleteSOW(sow).then(function(data) {
			$scope.updated=true;
			$scope.message="SOW Details Deleted...!!";
			for (i in $scope.sows) {
				if ($scope.sows[i].id == sow.id) {
					$scope.sows.splice(i, 1);
					$scope.newsow = {};
				}
			}	
		}, function() {
			$scope.error = true;
			$scope.message = 'Unable to delete SOW';
			$state.go("viewallsow");
		});
		$('#viewallsow').modal('hide');
	};
	
	$scope.logout = function() {
		$scope.added=false;
		AuthService.deleteToken();
		$localStorage.authenticated = false;
		$state.go("home");
	};

	$scope.home = function() {
		$scope.sows = [];
		$state.go("home");
	};
	
	$scope.clean = function() {
		$scope.error = false;
		$scope.updated=false;
		$scope.sow = {};
		$("#form").trigger('reset'); //jquery
	};
	
	$scope.editSOW = false;
	$scope.deleteSOW = false;
	$scope.sow;
	
	$scope.sort = function(keyname){
		$scope.sortKey = keyname;   //set the sortKey to the param passed
		$scope.reverse = !$scope.reverse; //if true make it false and vice versa
	}

	$scope.edit = function(sow){
		$scope.deleteSOW = false;
		$scope.editSOW = true;		
		$scope.sow = $filter('filter')($scope.sows, {id:sow.id })[0];
		$scope.associates = $scope.sow.associates;						
	}
		
	function dateCheck(from,to,exp) {
	    var fDate,lDate,expDate;
	    fDate = Date.parse(from);
	    lDate = Date.parse(to);
	    expDate = Date.parse(exp);			
	    if(expDate <= fDate) {
	    	return 'alreadyExpire';
	    }else if((expDate <= lDate && expDate >= fDate)) {
	        return 'renewalDue';
	    }else if(expDate > lDate) {
	    	return 'normal';
	    }	    
	    return 'noidea';
	}

	
	$scope.editResourceList = function(sow){
		$scope.deleteSOW = false;
		$scope.editSOW = true;		
		$scope.sow = $filter('filter')($scope.sows, {id:sow.id})[0];
		console.log(" $scope.sow.associates "+$scope.sow.associates);
	}

	$scope.updateSOWDetails = function(sow) {
		SOWCRUDService.updateSOW(sow).then(function(newSow) {
			$scope.updated=true;
			$scope.message="SOW Details Updated Successfully...!!";
			refreshSOWList();
		}, function() {
			$state.go("viewallSOW");
		});
		$('#updateSOW').modal('hide');
	};
	
	
	$scope.submit = function(sow){
		$scope.editSOW = false;
		$scope.deleteSOW = false;
	}
	
	$scope.cancel = function(){		
		$scope.editSOW = true;
		$scope.deleteSOW = true;		
	}

	$scope.delete = function(sow){
		$scope.deleteSOW = true;
		$scope.editSOW = false;
		$scope.sow = $filter('filter')($scope.sows, {id:sow.id })[0];
		console.log(" $scope.associates = "+$scope.associates);
		//$scope.associates = [];		
	}
	
	refreshSOWList = function(){
		$http.get("/dashboard/data/getSOW").success(function(response){ 
			$scope.sows = response;  //ajax request to fetch data into $scope.data
		});
	}
	
	sowsGoingToExpire = function(){
		$http.get("/dashboard/data/getSowExpireData").success(function(response){ 
			$scope.sowsGoingToExpire = response;
		});
	}
	
	$scope.addToResourceList = function(resource) {
		var results = $filter('filter')($scope.sow.associates, {associateid : resource.associateid}, true);
		 if(results==0){
			 $scope.selected = true;
			 $scope.sow.associates.push(resource);
		 }	
	}
	
	$scope.removeFromResourceList = function(resource) {		
		$scope.sow.associates.pop(resource);
	      if($scope.sow.associates.length==0)
				$scope.selected = false;
	}
	
	$scope.saveResourceLists = function() {
		$scope.updateSOW();		
		$('#selectResource').modal('hide');
	}
	$scope.selectedObject = function(selected) {
		$scope.clientname = selected.originalObject.senior_manager; 
		console.log(" $scope.clientname "+$scope.clientname);
	}	
});


		



