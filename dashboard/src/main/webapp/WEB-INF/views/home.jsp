<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Dashboard</title>
<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
<link rel="stylesheet" href="static/css/bootstrap.css">
<link rel="stylesheet" href="static/css/font-awesome.min.css">
<link rel="stylesheet" href="static/css/ionicons.min.css">
<link rel="stylesheet" href="static/css/AdminLTE.css">
<link rel="stylesheet" href="static/css/skin-blue.min.css">
<link href="static/css/app.css" rel="stylesheet">
<link href="static/css/ui-grid.css" rel="stylesheet">
</head>
<!--  #ecf0f5; -->
<body class="hold-transition skin-blue sidebar-mini"  ng-app="dashboardApp" style="height: 100vh;" ng-cloak>
<div ng-controller="landingController">
  <header class="main-header" ng-show="authenticated">
    <a data-target="#data" ui-sref="data" class="logo">      
      <span class="logo-lg"><b>Dashboard</b></span>
    </a>
    <nav class="navbar navbar-static-top" role="navigation">
      <a class="sidebar-toggle" data-toggle="offcanvas" role="button">
        <span class="sr-only">Toggle navigation</span>
      </a>
      <div class="navbar-custom-menu">
        <ul class="nav navbar-nav">
          <li class="dropdown user user-menu">
            <a class="dropdown-toggle" data-toggle="dropdown">
              <img src="static/images/admin.jpg" class="user-image" alt="User Image">
              <span class="hidden-xs">Admin</span>
            </a>
            <ul class="dropdown-menu">              
              <li class="user-header">
                <img src="static/images/admin.jpg" class="img-circle" alt="User Image">
                <p>
                  Admin
                  <small>Member since Dec. 2016</small>
                </p>
              </li>
              <!-- Menu Body -->
              <!-- Menu Footer-->
              <li class="user-footer">
                <div class="pull-left">
                  <a data-target="#profile" ui-sref="profile" href="#" class="btn btn-default btn-flat">Profile</a>
                </div>
                <div class="pull-right">
                  <a href="" ng-click="logout()" data-toggle="modal" data-target="#logout" class="btn btn-default btn-flat">Sign out</a>
                </div>
              </li>
            </ul>            
          </li>          
        </ul>
      </div>
    </nav>
  </header>
  <aside class="main-sidebar" ng-show="authenticated">
	<section class="sidebar">
	  <ul class="sidebar-menu">
        <li class="active"><a data-target="#data" ui-sref="data"><i class="fa fa-link"></i> <span>Overview</span></a></li>
        <li class="treeview">
          <a><i class="fa fa-link"></i><span>Customer</span>
            <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
          </a>
          <ul class="treeview-menu">
            <li><a data-target="#addcontact" ui-sref="addcontact">Add</a></li>
            <li><a data-target="#viewall" ui-sref="viewall">View All</a></li>
          </ul>          
        </li>
        <li class="treeview">
          <a><i class="fa fa-link"></i><span>Resource</span>
            <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
          </a>
          <ul class="treeview-menu">
            <li><a data-target="#addresource" ui-sref="addresource">Add</a></li>
            <li><a data-target="#viewallresource" ui-sref="viewallresource">View All</a></li>
          </ul>          
        </li>
        <!-- <li class="treeview">
          <a><i class="fa fa-link"></i><span>WA Master</span>
            <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
          </a>
          <ul class="treeview-menu">
            <li><a data-target="#addwadetails" ui-sref="addwadetails">Add</a></li>
            <li><a data-target="#viewallmaster" ui-sref="viewallmaster">View All</a></li>
          </ul>          
        </li> -->
        
        <li class="treeview">
          <a><i class="fa fa-link"></i><span>SOW</span>
            <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
          </a>
          <ul class="treeview-menu">
            <li><a data-target="#addSOW" ui-sref="addSOW">Add</a></li>
            <li><a data-target="#viewallsow" ui-sref="viewallsow">View All</a></li>
          </ul>          
        </li>
                 
      </ul> 
    </section>    
  </aside>

 
<div ui-view></div>

<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->

<script src="static/js/jquery.min.js"></script>
<script src="static/js/angular.js"></script>
<script src="static/js/highcharts.js"></script>
<!-- Exporting chart as pdf or img <script src="static/js/exporting.js"></script> -->
<script src="static/js/ng-highcharts.js"></script>
<script src="static/js/ui-grid.js"></script>
<script src="static/js/tether.min.js" integrity="sha384-DztdAPBWPRXSA/3eYEEUWrWCy7G5KFbe8fFjk5JAIxUYHKkDx6Qin1DkWx51bBrb" crossorigin="anonymous"></script>
<script src="static/js/bootstrap.min.js"></script>
<script src="static/js/app.min.js"></script>
<script type="text/javascript" src="static/js/angular-resource.js"></script>
<script type="text/javascript" src="static/js/angular-route.js"></script>
<script type="text/javascript" src="static/js/angular-ui-router.min.js"></script>
<script type="text/javascript" src="static/js/ngStorage.min.js"></script>
<script type="text/javascript" src="static/js/underscore-min.js"></script>
<script type="text/javascript" src="static/js/lib/dirPagination.js"></script>
<script type="text/javascript" src="static/js/lib/angucomplete-alt.min.js"></script>
<script src="static/app/app.js"></script>
<script src="static/app/constant/constants.js"></script>
<script src="static/app/module/underscoreModule.js"></script>
<script src="static/app/config/dashboardApp.js"></script>
<script src="static/app/controller/maincontroller.js"></script>
<script src="static/app/controller/resourcecontroller.js"></script>
<script src="static/app/controller/sowcontroller.js"></script>
<script src="static/app/controller/landingcontroller.js"></script>
<script src="static/app/directive/drawpiechart.js"></script>
<script type="text/javascript" src="static/app/services/AuthService.js">
</script><script type="text/javascript" src="static/app/services/AuthInterceptor.js"></script>
<script type="text/javascript" src="static/app/services/LoginService.js"></script>
<script type="text/javascript" src="static/app/services/CRUDService.js"></script>
<script type="text/javascript" src="static/app/services/ResourceCRUDService.js"></script>
<script type="text/javascript" src="static/app/services/SOWCRUDService.js"></script>
</div>
</body>
</html>