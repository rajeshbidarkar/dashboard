dashboardApp.directive('drawPieChart', function () {
    return function (scope, element, attrs) {
    	    	
    	
        var container = $(element).attr("id");
        scope.$watch('data', function () {
            drawPlot();
        }, true);

        var drawPlot = function () {
            var chart;
            chart = new Highcharts.Chart({
                chart: {
                    renderTo: container
                },
                credits: {
                    enabled: false
                },
                title: {
                    text: ''
                },
                tooltip: {
                    pointFormat: '{series.name}: <b>{point.percentage}%</b>',
                    percentageDecimals: 1
                },
                plotOptions: {
                    pie: {
                        dataLabels: {
                            enabled: false
                        }
                    }
                },
                series: [{
                    type: 'pie',
                    name: 'Browser share',
                    data: scope.data
                }]
            });
        }

    }
});