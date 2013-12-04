<%-- 
    Document   : admin
    Created on : Dec 2, 2013, 1:52:16 AM
    Author     : guilherme
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="shortcut icon" href="../../docs-assets/ico/favicon.png">

    <title>Ez Trip - Admin</title>

    <!-- Bootstrap core CSS -->
    <link href="<c:url value='/css/bootstrap.css'/>" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="<c:url value='/css/justified-nav.css'/>" rel="stylesheet">

    <!-- Just for debugging purposes. Don't actually copy this line! -->
    <!--[if lt IE 9]><script src="../../docs-assets/js/ie8-responsive-file-warning.js"></script><![endif]-->

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->
 <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>
    <script type="text/javascript">
   $(function () {
       var destinos = '<c:out value="${destinos}"/>';
       var velores = '<c:out value="${valores}"/>';
        $('#highchart').highcharts({
            chart: {
                type: 'bar'
            },
            title: {
                text: 'Quantidade de viagens da data selecionada'
            },
            subtitle: {
                text: 'Source: eztrip.co'
            },
            xAxis: {
                categories: ['<c:forEach items="${destinos}" var="destino">','<c:out value="${destino}"/>','</c:forEach>'],
                title: {
                    text: null
                }
            },
            yAxis: {
                min: 0,
                title: {
                    text: 'Viagens',
                    align: 'high'
                },
                labels: {
                    overflow: 'justify'
                }
            },
            tooltip: { 
            },
            plotOptions: {
                bar: {
                    dataLabels: {
                        enabled: false
                    }
                }
            },
            legend: {
            },
            credits: {
                enabled: false
            },
            series: [{
                data: ["<c:forEach items='${valores}' var='valor'>",parseInt("<c:out value='${valor}'/>"),"</c:forEach>"]
            }]
        });
    });
    
    </script>
  </head>

  <body>

    <div class="container">

      <div class="masthead">
        <h3 class="text-muted">Admin Ez Trip</h3>
        <ul class="nav nav-justified">
          <li><a href="<c:url value='/admin'/>">Home</a></li>
          <li><a href="<c:url value='/admin/region'/>">Regiões</a></li>
          <li><a href="<c:url value='/admin/country'/>">Países</a></li>
          <li><a href="<c:url value='/admin/fromandto'/>">Destinos</a></li>
          <li class="active"><a href="<c:url value='/admin/reports'/>">Relatórios</a></li>
        </ul>
      </div>

      <!-- Example row of columns -->
      <div class="container">
            <div class="row">
            <h1>Relatórios</h1>
            </div>
            <hr>
            <div class="row">
                <div class="col-md-3"></div>
                <div class="col-md-6 pull-left">
                    <form class="form-inline" action='<c:url value="/admin/report/destinations/generate"/>' method="POST">
                        <label>Datas:</label>
                        <div class="form-group">
                          <input type="Date" placeholder="Data Ida" name="dataIda" class="form-control">
                        </div>
                        <label>a</label>
                        <div class="form-group">
                          <input type="Date" placeholder="Data Volta" name="dataVolta" class="form-control">
                        </div>
                        <button type="submit" class="btn btn-success">Ez!</button>
                     </form>
                </div>
            </div>
            <c:if test="${destinos != null}">
                <div class="row" id="highchart" onload="chartGO(${destinos},${valores})"></div>
            </c:if>
            <br/>
        </div>
      <!-- Site footer -->
      <div class="footer">
        <p>&copy; Eztrip.co 2013</p>
      </div>

    </div> <!-- /container -->
    <script src="<c:url value='/js/Highcharts-3.0.7/js/highcharts.js'/>"></script>
    <script src="<c:url value='/js/Highcharts-3.0.7/js/modules/exporting.js'/>"></script>
    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
  </body>
</html>
