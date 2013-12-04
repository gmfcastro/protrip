<%-- 
    Document   : admin
    Created on : Dec 2, 2013, 1:52:16 AM
    Author     : guilherme
--%>

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
  </head>

  <body>

    <div class="container">

      <div class="masthead">
        <h3 class="text-muted">Admin Ez Trip</h3>
        <ul class="nav nav-justified">
          <li class="active"><a href="#">Home</a></li>
          <li><a href="<c:url value='/admin/region'/>">Regiões</a></li>
          <li><a href="<c:url value='/admin/country'/>">Países</a></li>
          <li><a href="<c:url value='/admin/fromandto'/>">Destinos</a></li>
          <li><a href="<c:url value='/admin/reports'/>">Relatórios</a></li>
        </ul>
      </div>

      <!-- Jumbotron -->
      <div class="jumbotron">
        <h1>Ez Admin!</h1>
        <p class="lead">Controle os registros do Ez Trip com facilidade!</p>
        <p><a class="btn btn-lg btn-success" href="http://eztrip.co" role="button">Ez Trip!</a></p>
      </div>

      <!-- Example row of columns -->
      <div class='row'>
        <h1>Ez Relatórios!</h1>
      </div>
      <div class="row">
        <div class="col-lg-4">
          <h2>Destinos</h2>
          <p>Saiba quais os destinos que são mais procurados aqui!</p>
          <p><a class="btn btn-primary" href="<c:url value='/admin/reports/destinations'/>" role="button">Ez Destinos!</a></p>
        </div>
        <div class="col-lg-4">
          <h2>Origens</h2>
          <p>Saiba da onde saem mais viajantes aqui!</p>
          <p><a class="btn btn-primary" href="<c:url value='/admin/reports/from'/>" role="button">Ez Origens!</a></p>
       </div>
        <div class="col-lg-4">
          <h2>Viagens</h2>
          <p>Saiba quais roteiros são os mais procurados aqui!</p>
          <p><a class="btn btn-primary" href="<c:url value='/admin/reports/travels'/>" role="button">Ez Viagens!</a></p>
        </div>
      </div>

      <!-- Site footer -->
      <div class="footer">
        <p>&copy; Eztrip.co 2013</p>
      </div>

    </div> <!-- /container -->


    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
  </body>
</html>
