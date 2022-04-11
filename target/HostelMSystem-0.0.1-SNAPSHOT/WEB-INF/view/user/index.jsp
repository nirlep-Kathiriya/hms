<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Hostel Management System</title>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
<title>DashBoard_user</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/UserIndexResources/assets/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/UserIndexResources/assets/fonts/fontawesome-all.min.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/UserIndexResources/assets/css/Features-Boxed.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/UserIndexResources/assets/css/Footer-Dark.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/UserIndexResources/assets/css/My_nav.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/UserIndexResources/assets/css/mynav-1.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/UserIndexResources/assets/css/Navigation-Clean.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/UserIndexResources/assets/css/styles.css">
<script type="text/javascript">

function admissionOFF() {
	alert("admission process off");
}
</script>
</head>
<body>
	
		<nav
		class="navbar navbar-light navbar-expand-md sticky-top shadow navigation-clean-button"
		style="background-color: rgb(20,133,238);height: 65px;">
	<div class="container-fluid">
		<a class="navbar-brand" href="index" style="color: #ffffff;">HosteL</a>
		<button data-toggle="collapse" class="navbar-toggler"
			data-target="#navcol-1" style="color: rgb(0, 0, 0);">
			<span class="sr-only" style="background-color: #1485ee;">Toggle
				navigation</span><span class="navbar-toggler-icon"
				style="background-color: #1485ee;"></span>
		</button>
		<div class="collapse navbar-collapse" id="navcol-1"
			style="background-color: #1485ee;">
			<ul class="nav navbar-nav mr-auto" style="background-color: #1485ee;">
            </ul>
			<span class="navbar-text actions" style="background-color: #1485ee;">
			</span>
			<div class="dropleft">
				<a class="dropdown-toggle" data-toggle="dropdown"
					aria-expanded="false" href="#"
					style="color: rgb(255, 255, 255); font-size: 28px;"><i
					class="fas fa-user-circle"></i></a>
				<div class="dropdown-menu" role="menu">
					<a class="dropdown-item" role="presentation"
						href="loadEditProfile">
						Profile</a><a class="dropdown-item" role="presentation"
						href="/logout">Sign out</a>
				</div>
			</div>
			<span class="navbar-text actions" style="background-color: #1485ee;">
			</span><span class="navbar-text actions" style="background-color: #1485ee;">
			</span><span class="navbar-text actions" style="background-color: #1485ee;">
			</span>
		</div>
	</div>
	</nav>



	<div id="back" class="features-boxed"
		style="background-color: rgb(255, 255, 255);">
		<div id="op"></div>
		<div class="container">
			<div class="intro">
				<h2 class="text-center" style="filter: blur(0px) brightness(0%);">Features
				</h2>

			</div>
			<div class="row justify-content-center features">

				<div class="col-sm-6 col-md-5 col-lg-4 item">
					<a <c:if test="${addmissionStatus eq true}">href="loadApplicationForm"</c:if>
					   <c:if test="${addmissionStatus eq false}">href="" onclick="admissionOFF()"</c:if>
					 >
						<div class="box">
							<i class="fab fa-wpforms icon"></i>
							<h3 class="name">Apply As Freshers</h3>
						</div>
					</a>
				</div>

				<div class="col-sm-6 col-md-5 col-lg-4 item">
					<a 
					   <c:if test="${addmissionStatus eq true}">href="loadApplicationNumberVerify"</c:if>
					   <c:if test="${addmissionStatus eq false}">href="" onclick="admissionOFF()"</c:if>
					>
						<div class="box">
							<i class="fas fa-edit icon"></i>
							<h3 class="name">Upload Document Of Fresher</h3>
						</div>
					</a>
				</div>

				<div class="col-sm-6 col-md-5 col-lg-4 item">
					<a 
					   <c:if test="${addmissionStatus eq true}">href="loadRegularForm"</c:if>
					   <c:if test="${addmissionStatus eq false}">href="" onclick="admissionOFF()"</c:if>
					>
						<div class="box">
							<i class="fas fa-user-check icon"></i>
							<h3 class="name">Apply As regular</h3>
						</div>
					</a>
				</div>

				<!-- <div class="col-sm-6 col-md-5 col-lg-4 item">
					<a href="www.google.com" data-toggle="modal" data-target="#pop">
						<div class="box">
							<i class="fas fa-envelope-open-text icon"></i>
							<h3 class="name">Complaints</h3>
						</div>
					</a>
				</div>
 -->

				<div class="col-sm-6 col-md-5 col-lg-4 item">
					<a href="" data-toggle="modal" data-target="#pop">
						<div class="box">
							<i class="fas fa-envelope-open-text icon"></i>
							<h3 class="name">Complaints</h3>
						</div>
					</a>
				</div>


                <!--Pop up for complaint  -->
				<div class="modal fade border-primary" role="dialog" tabindex="-1"
					id="pop">
					<form class="text-monospace d-block" style="margin: default;" action="insertComplaint" method="post">
					<div class="modal-dialog modal-dialog-centered" role="document">
						<div class="modal-content">
							<div class="modal-header d-md-flex justify-content-md-center">
								<h4
									class="modal-title text-center d-md-flex justify-content-center align-items-center ml-auto justify-content-md-center align-items-md-center">Enter
									Your Complaint</h4>
								<button type="button" class="close" data-dismiss="modal"
									aria-label="Close">
									<span id="see" aria-hidden="true">×</span>
								</button>
							</div>
							<div class="modal-body">
							  
								<textarea class="form-control" placeholder="Complaint"
									id="complaint" required="" name="complaint"></textarea>
								<br>
							</div>
							<div
								class="modal-footer d-md-flex justify-content-md-center align-items-md-center">
								<button data-toggle="modal" data-target="#pop2"
									class="btn btn-primary d-md-flex justify-content-md-center align-items-md-center"
									type="submit">Submit</button>
							</div>
						</div>
					</div>
					</form>
				</div>




				<div class="col-sm-6 col-md-5 col-lg-4 item">
					<a href="loadMessPage">
						<div class="box">
							<i class="fas fa-hamburger icon"></i>
							<h3 class="name">Hostel Mess</h3>
						</div>
					</a>
				</div>
				<div class="col-sm-6 col-md-5 col-lg-4 item">
					<a href="loadPayFees">
						<div class="box">
							<i class="fas fa-rupee-sign icon"></i>
							<h3 class="name">Fee Payment</h3>
						</div>
					</a>
				</div>
			</div>
		</div>
	</div>



	
	<script src="<%=request.getContextPath()%>/UserIndexResources/assets/js/jquery.min.js"></script>
	<script src="<%=request.getContextPath()%>/UserIndexResources/assets/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>