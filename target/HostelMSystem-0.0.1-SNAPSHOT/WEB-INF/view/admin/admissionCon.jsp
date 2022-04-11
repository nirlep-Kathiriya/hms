<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>HMS ADMIN</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="<%=request.getContextPath()%>/adminResources/css/app.min.css">
<!-- Template CSS -->
<link rel="stylesheet" href="<%=request.getContextPath()%>/adminResources/css/style.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/adminResources/css/components.css">
<!-- Custom style CSS -->
<link rel="stylesheet" href="<%=request.getContextPath()%>/adminResources/css/custom.css">
<link rel='shortcut icon' type='image/x-icon'
	href='<%=request.getContextPath()%>/adminResources/image/favicon.ico' />
<link rel="stylesheet" href="<%=request.getContextPath()%>/adminResources/css/toggleButton.css">
	

<script type="text/javascript">

function changeStatus(){
	var activeStatus = document.getElementById("activeStatus");
	
	  if(activeStatus.value == 'false'){
		  activeStatus.value = true;
		 message = 'Registration Process Start';
 		}
	  else{
		  activeStatus.value = false;  
	 	 message = 'Registration Process Stop';
 		}
	  alert(message);
	window.location.replace("addAdmissionControlDetail?activeStatus="+activeStatus.value );


}
</script>

</head>
<body>

<div class="loader"></div>
	<div id="app">
		<div class="main-wrapper main-wrapper-1">
			<div class="navbar-bg"></div>



			<jsp:include page="header.jsp"></jsp:include>



			<jsp:include page="menu.jsp"></jsp:include>


			<div class="main-content">
				<section class="section">
					<div class="section-body">
						<div class="row">
							<div class="col-12 col-md-12 col-lg-12">
								<div class="card">
									<form class="needs-validation" novalidate="">
										<div class="card-header">
											<h4 style="font-family:cursive;font-size: 30px;color: blue;margin-left:30%">Activate Or Deactivate Admission Process</h4>
										</div>
										<div class="card-body">
											<div class="form-group">
												<label class="switch" >
                                                  <input type="checkbox"  onchange="changeStatus()" id="activeStatus"
                                                       <c:if test="${sessionScope.statusOfButton eq 'ON'}">
                                                           checked="checked" value="true" </c:if>
                                                            <c:if test="${sessionScope.statusOfButton eq 'OFF'}">
		                                                      value="false"
                                                       	</c:if>
                                                  >
  
                                                  <span class="slider round" ></span>
                                                  </label>
											</div>
											<div class="form-group mb-0">
												
											</div>
										</div>
										
									</form>
								</div>
							</div>
						</div>
					</div>
				</section>
				
           </div>
				<section>	<jsp:include page="footer.jsp"></jsp:include></section>
		
	</div>
	<!-- General JS Scripts -->
	<script src="<%=request.getContextPath()%>/adminResources/js/app.min.js"></script>
	<!-- JS Libraies -->
	<!-- Page Specific JS File -->
	<!-- Template JS File -->
	<script src="<%=request.getContextPath()%>/adminResources/js/scripts.js"></script>
	<!-- Custom JS File -->
	<script src="<%=request.getContextPath()%>/adminResources/js/custom.js"></script>

</body>
</html>