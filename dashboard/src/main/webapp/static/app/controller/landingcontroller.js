dashboardApp.controller('landingController', function($scope, $http, $q,
		$rootScope, $state, AuthService, $filter, CRUDService, $localStorage,$window,
		LoginService) {

	var config = {
		headers : {
			'Content-Type' : 'application/x-www-form-urlencoded;charset=utf-8;'
		}
	};
	$scope.chartdata ;
	var temp = [];
	$scope.added=false;
	$scope.notAdded=false;
	$scope.updated=false;
	$scope.message='';
	$scope.failed=false;
	
	$scope.init = function() {
		console.log("Init caleed")
		var defer = $q.defer;
		 CRUDService.getContact().then(function(data, headers) {
			$scope.contacts = data;
			$rootScope._.uniq($scope.contacts);
			if ($rootScope._.findWhere($scope.contacts, temp) == null) {
				$scope.contacts = temp;
			}
			
		},function() {
			$state.go("home");

		});
		CRUDService.getContactForChart().then(function(data, headers) {
			$scope.data = data;		
		});
	};

	$scope.saveContact = function() {
		var dataObj = {
			vp : $scope.vp,
			svp : $scope.svp,
			director : $scope.director,
			senior_manager : $scope.senior_manager,
			department_name : $scope.department_name,
			emailid : $scope.emailid,
			emailtosendinvoice : $scope.emailtosendinvoice,
		};
		if($scope.id!==null){
			dataObj.id= $scope.id;
		}
		 CRUDService.addContact(dataObj).then(function(response) {			
			var message = response.data;
			console.log("message "+message);
			 if(message=="saved"){
				 $scope.added=true;	
				 $scope.message="Customer Details Saved Successfully...!!";
		     }else{
		    	 $scope.notAdded=true;
		    	 $scope.message="Service not Exists....!";
		     }
		 }, function() {
			$state.go("home");
		});
		//$state.go($state.current, {}, {reload: true});
	};
	
	$scope.deleted = function(contact) {
		$scope.added=false;
		CRUDService.deleteContact(contact).then(function(data) {
			$scope.updated=true;
			$scope.message="Customer Details Deleted...!!";
		}, function() {
			$scope.message = 'unable to delete contact';
			$state.go("viewall");
		});
		for (i in $scope.contacts) {
			if ($scope.contacts[i].id == contact.id) {
				$scope.contacts.splice(i, 1);
				$scope.contact = {};
			}
		}
		$('#editCustomer').modal('hide');		
	};
	
	$scope.logout = function() {
		$scope.added=false;
		AuthService.deleteToken();
		$localStorage.authenticated = false;
		$state.go("home", {}, {reload: true});		
	};

	$scope.home = function() {
		$scope.contacts = [];
		$state.go("home");
	};

	$scope.edit = function(contact) {
		$scope.added=false;
		for (i in $scope.contacts) {
			if ($scope.contacts[i].vp == vp) {
				 $scope.newcontact = angular.copy($scope.contacts[i]);
			}
		}
	};
	
	$scope.clean = function(form) {	
		$scope.contact = {};
		$scope.added=false;
		$scope.updated=false;
		$("#form").trigger('reset'); //jquery
	};
	
	$scope.editContact = false;
	$scope.deleteContact = false;
	$scope.contact;
	
	$scope.sort = function(keyname){
		$scope.sortKey = keyname;   //set the sortKey to the param passed
		$scope.reverse = !$scope.reverse; //if true make it false and vice versa
	}

	$scope.edit = function(contact){
		$scope.deleteContact = false;
		$scope.editContact = true;
		$scope.updated=false;
		$scope.contact = $filter('filter')($scope.contacts, {id:contact.id })[0];		
	}

	$scope.editContactDetails = function(contact) {
		console.log("contact.vp"+contact.vp);
		console.log("contact.svp"+contact.svp);
		CRUDService.addContact(contact).then(function(newContact) {
			$scope.updated=true;
			$scope.message="Customer Details Updated Successfully...!!";
			refreshResourceList();
		}, function() {
			$scope.failed=true;
			$scope.message="Service not Exists...!!";
			$state.go("viewall");
		});
		$('#editCustomer').modal('hide');
		$state.go("viewall");
	};
	
	
	$scope.submit = function(contact){
		$scope.editContact = false;
		$scope.deleteContact = false;
	}
	
	$scope.cancel = function(){
		$scope.editContact = true;
		$scope.deleteContact = true;		
	}

	$scope.delete = function(contact){
		$scope.deleteContact = true;
		$scope.editContact = false;
		$scope.updated=false;
		$scope.contact = $filter('filter')($scope.contacts, {id:contact.id })[0];
	}
	
	refreshResourceList = function(){
		$http.get("/dashboard/data/getContact").success(function(response){ 
			$scope.contacts = response;  
		});
	}
	
});
