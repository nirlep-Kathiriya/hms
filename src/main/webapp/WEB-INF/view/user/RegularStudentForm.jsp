<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
   <title>Hostel Management System</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/signinsignupResources/assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/signinsignupResources/assets/fonts/font-awesome.min.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/signinsignupResources/assets/fonts/simple-line-icons.min.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/signinsignupResources/assets/css/style.css">
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
<body style="background-image: url(&quot;<%=request.getContextPath()%>/signinsignupResources/assets/img/b.jpg&quot;);">

    <jsp:include page="headerOfUserSide.jsp"></jsp:include>
    
    <div class="registration-form" style="background-size: contain;background-repeat: no-repeat;">
        <form class="text-monospace d-block" action="varifyRegularStudent" method="post" >
            <div class="form-icon" style="background-color: rgb(20, 133, 238); padding-top: 30px"><span><i class="icon-user icon" ></i></span></div>
            <div class="form-group">
            <input class="form-control item" type="text" id="username" placeholder="Email Id" minlength="3" required="" name="email">
            </div>
            <div class="form-group">
            <br><span style="color: red">${ErrorOfRegularStudent}</span>
            <button class="btn btn-primary btn-block create-account" type="submit"  style="background-color:  rgb(20, 133, 238);">Apply as regular</button>
            </div>
         </form>
         <div class="social-media" style="background-color: rgb(20, 133, 238);">
		</div>
             
    </div>
    
    <script src="<%=request.getContextPath()%>/signinsignupResources/assets/js/jquery.min.js"></script>
    <script src="<%=request.getContextPath()%>/signinsignupResources/assets/bootstrap/js/bootstrap.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.15/jquery.mask.min.js"></script>
    <script src="<%=request.getContextPath()%>/signinsignupResources/assets/js/script.js"></script>
    <script src="https://cdn.rawgit.com/PascaleBeier/bootstrap-validate/v2.2.0/dist/bootstrap-validate.js" ></script>
    <script>
        bootstrapValidate('#username','email:Enter a valid email address.')        
    </script>

</body>
</html>