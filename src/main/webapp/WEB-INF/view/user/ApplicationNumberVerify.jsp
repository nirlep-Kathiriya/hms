<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Hostel Management System</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
 
    <link rel="stylesheet" href="<%=request.getContextPath()%>/forgetPasswordResources/assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/forgetPasswordResources/assets/fonts/font-awesome.min.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/forgetPasswordResources/assets/fonts/simple-line-icons.min.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/forgetPasswordResources/assets/css/style.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/messResources/assets/css/myheader.css">
    <link rel="stylesheet"
	href="<%=request.getContextPath()%>/homePageResources/assets/css/Footer-Basic.css">
    <link rel="stylesheet"
	href="<%=request.getContextPath()%>/homePageResources/assets/css/Footer-Dark.css">
	
	<link rel="stylesheet" href="<%=request.getContextPath()%>/UserHeaderSidebar/fonts/fontawesome-all.min.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/UserHeaderSidebar/fonts/font-awesome.min.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/UserHeaderSidebar/fonts/fontawesome5-overrides.min.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/UserHeaderSidebar/sidebar.css">
    <script src="<%=request.getContextPath()%>/UserHeaderSidebar/sidebar.js"></script>	
</head>

<body>
<%-- <form action="VerifyApplicationNumber" method="post">
	Application number<input type="text" name="applicationno"/><br>
	email id<input type="email" name="email"/><br>
	<span style="color:red">${error}</span>
	<input type="submit"/>

</form>
 --%>
 <body style="background-image: url(&quot;<%=request.getContextPath()%>/forgetPasswordResources/assets/img/b.jpg&quot;);">
 
   <jsp:include page="headerOfUserSide.jsp"></jsp:include>
   
	<div class="registration-form" style="background-size: contain; background-repeat: no-repeat" >
		<form class="text-monospace d-block" style="margin: default;" action="VerifyApplicationNumber" method="post">
			
			<div class="form-group">
				<input class="form-control item" type="email" id="username-2"
					placeholder="Email Id" minlength="3" required="" name="email" autocomplete="on">
			</div>
			<div class="form-group">
				<input class="form-control item" type="text" 
					placeholder="Application Number" required="" name="applicationno">
			</div>
			<span style="color:red">${error}</span>
			<div class="form-group">
				<button class="btn btn-primary btn-block create-account"
					type="submit" 
					style="background-color:rgb(20, 133, 238)">submit</button>
			</div>
		</form>
		
	    <div class="social-media" style="background-color:rgb(20, 133, 238);">
		</div>
	</div>
	
	<script src="<%=request.getContextPath()%>/forgetPasswordResources/assets/js/jquery.min.js"></script>
	<script src="<%=request.getContextPath()%>/forgetPasswordResources/assets/bootstrap/js/bootstrap.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.15/jquery.mask.min.js"></script>
 </body>
</html>