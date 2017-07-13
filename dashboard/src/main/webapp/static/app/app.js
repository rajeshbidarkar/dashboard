var dashboardApp = angular.module('dashboardApp', 
[ 
  'ui.router', 
  'ngStorage', 
  'ngHighcharts',
  'angularUtils.directives.dirPagination',
  'angucomplete-alt'
 ]);

dashboardApp.run([ '$rootScope', '$log', function($rootScope, $log) {
	$rootScope._ = window._;
} ]);
