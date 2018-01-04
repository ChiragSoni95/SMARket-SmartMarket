<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<style>
table {
    border-collapse: collapse;
    width: 100%;
}


 th,td {
    padding: 8px;
    text-align: center;
    border-bottom: 1px solid #ddd;
      
}


tr:hover{background-color:#f5f5f5}
</style>


 <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="Creative - Bootstrap 3 Responsive Admin Template">
    <meta name="author" content="GeeksLabs">
    <meta name="keyword" content="Creative, Dashboard, Admin, Template, Theme, Bootstrap, Responsive, Retina, Minimal">
    <link rel="shortcut icon" href="img/favicon.png">

    <title>Existing Products</title>

    <!-- Bootstrap CSS -->    
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- bootstrap theme -->
    <link href="css/bootstrap-theme.css" rel="stylesheet">
    <!--external css-->
    <!-- font icon -->
    <link href="css/elegant-icons-style.css" rel="stylesheet" />
    <link href="css/font-awesome.min.css" rel="stylesheet" />    
    <!-- full calendar css-->
    <link href="assets/fullcalendar/fullcalendar/bootstrap-fullcalendar.css" rel="stylesheet" />
	<link href="assets/fullcalendar/fullcalendar/fullcalendar.css" rel="stylesheet" />
    <!-- easy pie chart-->
    <link href="assets/jquery-easy-pie-chart/jquery.easy-pie-chart.css" rel="stylesheet" type="text/css" media="screen"/>
    <!-- owl carousel -->
    <link rel="stylesheet" href="css/owl.carousel.css" type="text/css">
	<link href="css/jquery-jvectormap-1.2.2.css" rel="stylesheet">
    <!-- Custom styles -->
	<link rel="stylesheet" href="css/fullcalendar.css">
	<link href="css/widgets.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
    <link href="css/style-responsive.css" rel="stylesheet" />
	<link href="css/xcharts.min.css" rel=" stylesheet">	
	<link href="css/jquery-ui-1.10.4.min.css" rel="stylesheet">
    <!-- HTML5 shim and Respond.js IE8 support of HTML5 -->
    <!--[if lt IE 9]>
      <script src="js/html5shiv.js"></script>
      <script src="js/respond.min.js"></script>
      <script src="js/lte-ie7.js"></script>
    <![endif]-->
</head>
<body>



<!-- container section start -->
  <section id="container" class="">
     
      
      <header class="header dark-bg">
            <div class="toggle-nav">
                <div class="icon-reorder tooltips" data-original-title="Toggle Navigation" data-placement="bottom"><i class="icon_menu"></i></div>
            </div>

            <!--logo start-->
            <!--<a href="" class="logo">DNA <span class="lite">Admin</span></a>-->
			<a href="<%=request.getContextPath()%>/Controller?action=home" class="logo"><img src="uploads/logo1.jpg" width="90" height="41" ><span class="lite"></span></a>
            <!--logo end-->

          

            <div class="top-nav notification-row">                
                <!-- notificatoin dropdown start-->
                <ul class="nav pull-right top-menu">
                    
                    <!-- task notificatoin start -->
                                       <!-- user login dropdown start-->
                    <li class="dropdown">
                        <a data-toggle="dropdown" class="dropdown-toggle" href="#">
                            <span class="profile-ava">
                                <img alt="" src="img/<%=session.getAttribute("userpic")%>.jpg" width="30" height="40">
                            </span>
                            <span class="username"><%=session.getAttribute("username")%></span>
                            <b class="caret"></b>
                        </a>
                        <ul class="dropdown-menu extended logout">
                            <div class="log-arrow-up"></div>
                          
                            <li>
                                <a href="<%=request.getContextPath()%>/Controller?action=log-out"><i class="icon_key_alt"></i> Log Out</a>
                            </li>
                        </ul>
                    </li>
                    <!-- user login dropdown end -->
                </ul>
                <!-- notificatoin dropdown end-->
            </div>
      </header>      
      <!--header end-->

      <!--sidebar start-->
      <aside>
      
      
          <div id="sidebar"  class="nav-collapse ">
              <!-- sidebar menu start-->
              <ul class="sidebar-menu">                
                  <li class="active">
                      <a class="" href="<%=request.getContextPath()%>/Controller?action=home">
                          <i class="icon_house_alt"></i>
                          <span>Dashboard</span>
                      </a>
                  </li>
				  <li class="sub-menu">
                      <a href="javascript:;" class="">
                          <i class="icon_document_alt"></i>
                          <span>Check</span>
                          <span class="menu-arrow arrow_carrot-right"></span>
                      Inventory</a>
                      <ul class="sub">
                          <li><a class="" href="<%=request.getContextPath()%>/Controller?action=sale_table">Monthly Sales</a></li>                          
                          <li><a class="" href="<%=request.getContextPath()%>/Controller?action=order_table">Orders</a></li>
                      </ul>
                  </li>   
				      
                  <li class="sub-menu">
                      <a href="javascript:;" class="">
                          <i class="icon_desktop"></i>
                          <span>Order Stock</span>
                          <span class="menu-arrow arrow_carrot-right"></span>
                      </a>
                      <ul class="sub">
                          <li><a class="" href="<%=request.getContextPath()%>/Controller?action=existing_inventory">Exisitng Product</a></li>
                          <li><a class="" href="<%=request.getContextPath()%>/Controller?action=new_inventory">New Product</a></li>
                      </ul>
                  </li>
                  
				   <li class="sub-menu">
                      <a href="javascript:;" class="">
                          <i class="icon_desktop"></i>
                          <span>Analytics </span>
                          <span class="menu-arrow arrow_carrot-right"></span>
                      </a>
                      <ul class="sub">
                          <li><a class="" href="<%=request.getContextPath()%>/Controller?action=cluster" onClick="alert('Products Categorized Successfully !')"> Categorize Products</a></li>
						  <li><a class="" href="<%=request.getContextPath()%>/Controller?action=hot">BestFit Products</a></li>
						  <li><a class="" href="<%=request.getContextPath()%>/Controller?action=warm">GoodFit Products</a></li>
						  <li><a class="" href="<%=request.getContextPath()%>/Controller?action=cold">LowFit Products</a></li>
						  
						  </ul>
						  </li>
						  
                          
                        <li class="sub-menu">
                      <a href="javascript:;" class="">
                          <i class="icon_desktop"></i>
                          <span>ClassifyProduct</span>
						  
                          <span class="menu-arrow arrow_carrot-right"></span>
                      </a>
                      <ul class="sub">
                          <li><a class="" href="<%=request.getContextPath()%>/Controller?action=existing_data"">Exisitng Product</a></li>
                          <li><a class="" href="<%=request.getContextPath()%>/Controller?action=new_data">New Product</a></li>
                      </ul>
                  </li> 
                   
                
				  
				  <li class="sub-menu">
                      <a href="javascript:;" class="">
                          <i class="icon_desktop"></i>
                          <span>Forecasting</span>
                          <span class="menu-arrow arrow_carrot-right"></span>
                      </a>
                      <ul class="sub">
                          <li><a class="" href="<%=request.getContextPath()%>/Controller?action=regression">Predictive Analysis</a></li>
                          <li><a class="" href="<%=request.getContextPath()%>/Controller?action=outlier">Remove Products</a></li>
                      </ul>
                  </li>
                  
				  
               <li class="sub-menu">
                      <a href="javascript:;" class="">
                           <i class="icon_piechart"></i>
                          <span>Statistics</span>
                           <span class="menu-arrow arrow_carrot-right"></span>
                          
                      </a>
					   <ul class="sub">
                          <li><a class="" href="<%=request.getContextPath()%>/Controller?action=category_wise">Category Wise</a></li>
                          <li><a class="" href="<%=request.getContextPath()%>/Controller?action=brand_wise">Brand Wise</a></li>
                          <li><a class="" href="<%=request.getContextPath()%>/Controller?action=product_wise">Product wise</a></li>
                      </ul>
                                         
                  </li>
                             
                       <li class="sub-menu">
                      <a href="<%=request.getContextPath()%>/Controller?action=about_us" class="">
                          <i class="icon_desktop"></i>
                          <span>About Us</span>
                          <span class="menu-arrow arrow_carrot-right"></span>
                      </a>
                     
                  </li>
                        
                  
                  
                  
              </ul>
              <!-- sidebar menu end-->
          </div>
      </aside>
      <!--sidebar end-->
      
      <!--main content start-->
      <section id="main-content">
          <section class="wrapper">            
              <!--overview start-->
			  <div class="row">
				<div class="col-lg-12">
					
					<ol class="breadcrumb">
						<li><i class="fa fa-home"></i>Classify</li>
						<li><i class="fa fa-laptop"></i>Existing Products</li>						  	
					</ol>
				</div>
			</div>
              
    
	    <h1>Monthly Sale</h1>

	<sql:query dataSource="${ds}" var="result">
SELECT * from decem where category='<%=request.getAttribute("category")%>' AND brand='<%=request.getAttribute("brand")%>' ;
</sql:query>

	<table border="1" width="90%">
		<tr>
			<th>Product_id</th>
			<th>Category</th>
			<th>Brand</th>
			<th>Sub-Category</th>
			<th>Stock_Available</th>
			<th>Cost_Price</th>
			<th>Storage_Price</th>
			<th>Selling_Price</th>
			<th>Profit_Loss</th>
			<th>Stock_Sold</th>
			<th>Sold_Percent</th>
			<th><center>---</center></th>


		</tr>
		<c:forEach var="row" items="${result.rows}">
			<tr>
				<td><c:out value="${row.product_id}" /></td>
				<td><c:out value="${row.category}" /></td>
				<td><c:out value="${row.brand}" /></td>
				<td><c:out value="${row.sub_category}" /></td>
				<td><c:out value="${row.stock_available}" /></td>
				<td><c:out value="${row.cost_price}" /></td>
				<td><c:out value="${row.storage_price}" /></td>
				<td><c:out value="${row.selling_price}" /></td>
				<td><c:out value="${row.profit_loss}" /></td>
				<td><c:out value="${row.stock_sold}" /></td>
				<td><c:out value="${row.sold_percent}" /></td>
				<td><a class="btn btn-success" href="<%=request.getContextPath() %>/Controller?action=classify1&product_id=<c:out value="${row.product_id}"/>&category=<c:out value="${row.category}"/>&brand=<c:out value="${row.brand}"/>&sub_category=<c:out value="${row.sub_category}"/>&stock_available=<c:out value="${row.stock_available}"/>&cost=<c:out value="${row.cost_price}"/>&stock_sold=<c:out value="${row.stock_sold}"/>&holding_cost=<c:out value="${row.storage_price/row.stock_available}"/>" >Check Class</a></td>
				
			</tr>
		</c:forEach>
	</table>

	            
		
		

				</div><!--/col-->
				
                  <div class="widget-foot">
                    <!-- Footer goes here -->
                  </div>
                </div>
              </div>
              
            </div>
                        
          </div> 
              <!-- project team & activity end -->

          </section>
      </section>
      <!--main content end-->
  </section>
  <!-- container section start -->

    <!-- javascripts -->
    <script src="js/jquery.js"></script>
	<script src="js/jquery-ui-1.10.4.min.js"></script>
    <script src="js/jquery-1.8.3.min.js"></script>
    <script type="text/javascript" src="js/jquery-ui-1.9.2.custom.min.js"></script>
    <!-- bootstrap -->
    <script src="js/bootstrap.min.js"></script>
    <!-- nice scroll -->
    <script src="js/jquery.scrollTo.min.js"></script>
    <script src="js/jquery.nicescroll.js" type="text/javascript"></script>
    <!-- charts scripts -->
    <script src="assets/jquery-knob/js/jquery.knob.js"></script>
    <script src="js/jquery.sparkline.js" type="text/javascript"></script>
    <script src="assets/jquery-easy-pie-chart/jquery.easy-pie-chart.js"></script>
    <script src="js/owl.carousel.js" ></script>
    <!-- jQuery full calendar -->
    <<script src="js/fullcalendar.min.js"></script> <!-- Full Google Calendar - Calendar -->
	<script src="assets/fullcalendar/fullcalendar/fullcalendar.js"></script>
    <!--script for this page only-->
    <script src="js/calendar-custom.js"></script>
	<script src="js/jquery.rateit.min.js"></script>
    <!-- custom select -->
    <script src="js/jquery.customSelect.min.js" ></script>
	<script src="assets/chart-master/Chart.js"></script>
   
    <!--custome script for all page-->
    <script src="js/scripts.js"></script>
    <!-- custom script for this page-->
    <script src="js/sparkline-chart.js"></script>
    <script src="js/easy-pie-chart.js"></script>
	<script src="js/jquery-jvectormap-1.2.2.min.js"></script>
	<script src="js/jquery-jvectormap-world-mill-en.js"></script>
	<script src="js/xcharts.min.js"></script>
	<script src="js/jquery.autosize.min.js"></script>
	<script src="js/jquery.placeholder.min.js"></script>
	<script src="js/gdp-data.js"></script>	
	<script src="js/morris.min.js"></script>
	<script src="js/sparklines.js"></script>	
	<script src="js/charts.js"></script>
	<script src="js/jquery.slimscroll.min.js"></script>
  <script>

      //knob
      $(function() {
        $(".knob").knob({
          'draw' : function () { 
            $(this.i).val(this.cv + '%')
          }
        })
      });

      //carousel
      $(document).ready(function() {
          $("#owl-slider").owlCarousel({
              navigation : true,
              slideSpeed : 300,
              paginationSpeed : 400,
              singleItem : true

          });
      });

      //custom select box

      $(function(){
          $('select.styled').customSelect();
      });
	  
	  /* ---------- Map ---------- */
	$(function(){
	  $('#map').vectorMap({
	    map: 'world_mill_en',
	    series: {
	      regions: [{
	        values: gdpData,
	        scale: ['#000', '#000'],
	        normalizeFunction: 'polynomial'
	      }]
	    },
		backgroundColor: '#eef3f7',
	    onLabelShow: function(e, el, code){
	      el.html(el.html()+' (GDP - '+gdpData[code]+')');
	    }
	  });
	});



  </script>





	

</body>
</html>