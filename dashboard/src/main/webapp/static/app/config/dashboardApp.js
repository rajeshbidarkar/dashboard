dashboardApp.config([
		'$stateProvider',
		'$urlRouterProvider',
		'$locationProvider',
		'$httpProvider',
		function($stateProvider, $urlRouterProvider, $locationProvider,
				$httpProvider) {

			$urlRouterProvider.otherwise('/');
			$stateProvider.

			state('home', {
				url : '/',
				templateUrl : 'static/templates/login.html',
				controller : 'mainController'
			}).
			
			state('viewall', {
				url : '/viewall',
				templateUrl : 'static/templates/customer/viewall.html',
				controller : 'landingController'
			}).
			
			state('viewallresource', {
				url : '/viewallresource',
				templateUrl : 'static/templates/resource/viewall.html',
				controller : 'resoureController'
			}).			
			
			state('viewallmaster', {
				url : '/viewallmaster',
				templateUrl : 'static/templates/WAMaster/viewall.html',
				controller : 'landingController'
			}).
			
			state('viewallsow', {
				url : '/viewallsow',
				templateUrl : 'static/templates/sow/viewall.html',
				controller : 'sowController'
			}).
			
			state('profile', {
				url : '/profile',
				templateUrl : 'static/templates/profile.html',
				controller : 'mainController'
			}).
			
			state('addcontact', {
				url : '/addcontact',
				templateUrl : 'static/templates/customer/addcontact.html',
				controller : 'landingController'
			}).
			
			state('addresource', {
				url : '/addresource',
				templateUrl : 'static/templates/resource/addresource.html',
				controller : 'resoureController'
			}).
			
			state('addwadetails', {
				url : '/addwadetails',
				templateUrl : 'static/templates/WAMaster/addwadetails.html',
				controller : 'landingController'
			}).
						
			state('addSOW', {
				url : '/addSOW',
				templateUrl : 'static/templates/sow/addSOW.html',
				controller : 'sowController'
			}).
			
			state('data', {
				url : '/data',
				templateUrl : 'static/templates/landing.html',
				controller : 'landingController'

			}).state('error', {
				url : '/error',
				templateUrl : 'static/templates/error.html'

			});

			$httpProvider.interceptors.push('AuthInterceptor');

		} ]);

dashboardApp.run(['$rootScope','$localStorage','AuthService',
		function($rootScope, $localStorage, AuthService,$window) {
			$rootScope.$on('$stateChangeStart', function(event, toState,toParams, fromState, fromParams) {
				if ((toState.name == 'data' || toState.name == 'viewall' || 
						toState.name == 'addcontact' || toState.name == 'profile' ||
						toState.name == 'viewallresource' || toState.name == 'viewallmaster' ||
						toState.name == 'addresource' || toState.name == 'addwadetails'|| 
						toState.name == 'viewallsow' || toState.name == 'addSOW') && fromState.name == '') {
					$rootScope.authenticated = $localStorage.authenticated;
				}
				if (toState.name == 'home' && fromState.name == 'data') {
					$localStorage.authenticated = false;
					$rootScope.authenticated = $localStorage.authenticated;
					AuthService.deleteToken();
				}				
		})
} ]);


dashboardApp.run(['$rootScope','$localStorage','AuthService',
   		function($rootScope, $localStorage, AuthService,$window) {
			$rootScope.$on('$windowClosed', function(event, toState,toParams, fromState, fromParams) {
     		$rootScope.authenticated = $localStorage.authenticated;

		})
} ]);