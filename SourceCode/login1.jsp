<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="Creative - Bootstrap 3 Responsive Admin Template">
    <meta name="author" content="GeeksLabs">
    <meta name="keyword" content="Creative, Dashboard, Admin, Template, Theme, Bootstrap, Responsive, Retina, Minimal">
    <link rel="shortcut icon" href="img/favicon.png">

    <title>SMARkeT</title>

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
  
  <sql:setDataSource var="ds" driver="com.mysql.jdbc.Driver"
		url="jdbc:mysql://localhost/smarket" user="root" password=""
		scope="application" />
		
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
                    
                   
 <sql:query dataSource="${ds}" var="result5">
SELECT category,brand,sub_category
FROM buffer
ORDER BY stock_left  
LIMIT 1;

</sql:query> 
                  
                    <!-- alert notification start-->
                    <li id="alert_notificatoin_bar" class="dropdown">
                        <a data-toggle="dropdown" class="dropdown-toggle" href="#">

                            <i class="icon-bell-l"></i>
                            <span class="badge bg-important">4</span>
                        </a>
                        <ul class="dropdown-menu extended notification">
                            <div class="notify-arrow notify-arrow-blue"></div>
                            <li>
                                <p class="blue">You have 4 new notifications</p>
                            </li>
                           
                            <li>
                                <a href="#">
                                    <span class="label label-warning"><i class="icon_pin"></i></span>  
                                    Newly Launched Iphone 7 is available.
                                    
                               </a>
                            </li>
                            
                            <li>
                                <a href="#">
                                    <span class="label label-success"><i class="icon_like"></i></span> 
                                   
                                   <%=session.getAttribute("best")%> sale has gone up.
                                   
                                </a>
                            </li> 
                            
                            
                            <li>
                                <a href="#">
                                    <span class="label label-danger"><i class="icon_book_alt"></i></span> 
                                   <c:forEach var="row" items="${result5.rows}">
                                  <c:out value="${row.brand}" /> is out of stock.
                                   </c:forEach>
                                   
                                </a>
                            </li> 
                            
                            <li>
                                <a href="#">
                                    <span class="label label-danger"><i class="icon_book_alt"></i></span> 
                                    <%=session.getAttribute("worst")%> sale has gone down.
                                   
                                </a>
                            </li>                           
                           
                        </ul>
                    </li>
                    <!-- alert notification end-->
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
					<h3 class="page-header"><i class="fa fa-laptop"></i> Dashboard</h3>
					<ol class="breadcrumb">
						<li><i class="fa fa-home"></i><a href="<%=request.getContextPath()%>/Controller?action=home">Home</a></li>
						<li><i class="fa fa-laptop"></i>Dashboard</li>						  	
					</ol>
				</div>
			</div>
               <sql:query dataSource="${ds}" var="result1">
SELECT count(product_id) as product_nos from orders;
</sql:query> 

  <sql:query dataSource="${ds}" var="result2">
SELECT count(product_id) as product_nos1 from decem;
</sql:query> 

  <sql:query dataSource="${ds}" var="result3">
SELECT SUM(profit_loss) as product_nos2 from decem;
</sql:query> 

 <sql:query dataSource="${ds}" var="result4">
SELECT category, AVG( profit_loss )
FROM decem
GROUP BY category
ORDER BY sold_percent DESC 
LIMIT 1;

</sql:query> 
 


            <div class="row">
				<div class="col-lg-3 col-md-3 col-sm-12 col-xs-12">
					<div class="info-box blue-bg">
						<i class="fa fa-cloud-download"></i>
						<c:forEach var="row" items="${result1.rows}">
						<div class="count"><font size="4"><c:out value="${row.product_nos} units" /></font></div>
						</c:forEach>
						<div class="title"><font size="4">ORDERS</font></div>						
					</div><!--/.info-box-->			
				</div><!--/.col-->
				
				<div class="col-lg-3 col-md-3 col-sm-12 col-xs-12">
					<div class="info-box brown-bg">
						<i class="fa fa-shopping-cart"></i>
						<c:forEach var="row" items="${result2.rows}">
						<div class="count"><font size="4"><c:out value="${row.product_nos1} units" /></font></div>
						</c:forEach>
						<div class="title"><font size="4">PRODUCTS</font></div>						
					</div><!--/.info-box-->			
				</div><!--/.col-->
				
				<div class="col-lg-3 col-md-3 col-sm-12 col-xs-12">
					<div class="info-box dark-bg">
						<i class="fa fa-thumbs-o-up"></i>
						<c:forEach var="row" items="${result3.rows}">
						<div class="count"><font size="4"><c:out value="Rs. ${row.product_nos2} " /></font></div>
						</c:forEach>
						<div class="title"><font size="4">PROFIT</font></div>						
					</div><!--/.info-box-->			
				</div><!--/.col-->
				
					<div class="col-lg-3 col-md-3 col-sm-12 col-xs-12">
					<div class="info-box green-bg">
						<i class="fa fa-cubes"></i>
						<c:forEach var="row" items="${result4.rows}">
						<div class="count"><font size="4"><c:out value="${row.category} " /></font></div>
						</c:forEach>
						<div class="title"><font size="4">Best Category</font></div>						
					</div><!--/.info-box-->			
				</div><!--/.col-->
			
				
			</div><!--/.row-->
		
			
           <div class="row">
		    			
					
						<div class="panel-heading">
						<center>	<h2><i class="fa fa-map-marker red"></i><strong>Current Month's Glimpse</strong></h2></center>
							
						</div>
						
		<center>					
		<!-- Start cssSlider.com -->
		<!-- Generated by cssSlider.com 2.1 -->
		<link rel="stylesheet" href="cssslider_files/csss_engine1/style.css">
		<!--[if IE]><link rel="stylesheet" href="cssslider_files/csss_engine1/ie.css"><![endif]-->
		<!--[if lte IE 9]><script type="text/javascript" src="cssslider_files/csss_engine1/ie.js"></script><![endif]-->
		 <div class="csslider1 autoplay ">
		<input name="cs_anchor1" id="cs_slide1_0" type="radio" class="cs_anchor slide">
		<input name="cs_anchor1" id="cs_slide1_1" type="radio" class="cs_anchor slide">
		<input name="cs_anchor1" id="cs_slide1_2" type="radio" class="cs_anchor slide">
		<input name="cs_anchor1" id="cs_slide1_3" type="radio" class="cs_anchor slide">
		<input name="cs_anchor1" id="cs_play1" type="radio" class="cs_anchor" checked="">
		<input name="cs_anchor1" id="cs_pause1_0" type="radio" class="cs_anchor pause">
		<input name="cs_anchor1" id="cs_pause1_1" type="radio" class="cs_anchor pause">
		<input name="cs_anchor1" id="cs_pause1_2" type="radio" class="cs_anchor pause">
		<input name="cs_anchor1" id="cs_pause1_3" type="radio" class="cs_anchor pause">
		<ul>
			<li class="cs_skeleton"><img src="cssslider_files/csss_images1/image001.png" style="width: 100%;"></li>
			<li class="num0 img slide"> <img src="cssslider_files/csss_images1/image001.png" alt="image001" title="image001" style="width: 100%;"></li>
			<li class="num1 img slide"> <img src="cssslider_files/csss_images1/image001-2.png" alt="image001" title="image001" style="width:100%"></li>
			<li class="num2 img slide"> <img src="cssslider_files/csss_images1/image002-2.png" alt="image001" title="image001" style="width:100%"></li>
			<li class="num3 img slide"> <img src="cssslider_files/csss_images1/Hairoil.jpg" alt="Hairoil" title="Hairoil" style="width:100%"></li>
		</ul><div class="cs_engine"><a href="http://cssslider.com">cssslider.com</a> by cssSlider.com v2.1</div>
		
		
		
		<div class="cs_bullets">
			<label class="num0" for="cs_slide1_0"> <span class="cs_point"></span>
				<span class="cs_thumb"><img src="cssslider_files/csss_tooltips1/image001.png" alt="image001" title="image001" style="width:100%"></span></label>
			<label class="num1" for="cs_slide1_1"> <span class="cs_point"></span>
				<span class="cs_thumb"><img src="cssslider_files/csss_tooltips1/image001-2.png" alt="image001" title="image001" style="width:100%"></span></label>
			<label class="num2" for="cs_slide1_2"> <span class="cs_point"></span>
				<span class="cs_thumb"><img src="cssslider_files/csss_tooltips1/image002-2.png" alt="image001" title="image001" style="width:100%"></span></label>
			<label class="num3" for="cs_slide1_3"> <span class="cs_point"></span>
				<span class="cs_thumb"><img src="cssslider_files/csss_tooltips1/Hairoil.jpg" alt="Hairoil" title="Hairoil5" style="width:100%"></span></label>
		</div>
		</div>
		<!-- End cssSlider.com -->
</center>
				
	
					
				
			 
           </div>  
            
		  
		  <!-- Today status end -->
			
            <sql:query dataSource="${ds}" var="result">
SELECT category,SUM(stock_available) as stock_available,SUM(stock_sold) as stock_sold,avg(sold_percent) as sold_percent from decem group by category;
</sql:query> 
				
			<div class="row">
               	
				<div class="col-lg-9 col-md-12">	
					<div class="panel panel-default">
						<div class="panel-heading">
							<h2><i class="fa fa-flag-o red"></i><strong>Overview of Sales</strong></h2>
							
						</div>
						<div class="panel-body">
							<table class="table bootstrap-datatable countries">
								<thead>
									<tr>
										
										<th>Category</th>
										<th>Stock Available</th>
										<th>Stock Sold</th>
											<th>Percentage Sold</th>
									</tr>
								</thead>   
								<tbody>
								<c:forEach var="row" items="${result.rows}">
									<tr>
										
										<td><c:out value="${row.category}" /></td>
										<td><c:out value="${row.stock_available}" /></td>
										<td><c:out value="${row.stock_sold}" /></td>
										
										<td>
											<div class="progress thin">
												<div class="progress-bar progress-bar-danger" role="progressbar" aria-valuenow="<c:out value="${row.sold_percent}" />" aria-valuemin="0" aria-valuemax="100" style="width: <c:out value="${row.sold_percent}" />%">
												</div>
												<div class="progress-bar progress-bar-warning" role="progressbar" aria-valuenow="<c:out value="${100-row.sold_percent}" />" aria-valuemin="0" aria-valuemax="100" style="width:<c:out value="${100-row.sold_percent}" />%">
											  	</div>
											</div>
											<span class="sr-only"><c:out value="${row.sold_percent}" />%</span>   	
										</td>
									</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
	
					</div>	

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
