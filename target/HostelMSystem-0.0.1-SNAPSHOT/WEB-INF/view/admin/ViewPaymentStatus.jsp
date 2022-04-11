<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="f" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<meta
	content="width=device-width, initial-scale=1, maximum-scale=1, shrink-to-fit=no"
	name="viewport">
<title>HMS ADMIN</title>
<!-- General CSS Files -->
<link rel="stylesheet" href="<%=request.getContextPath()%>/adminResources/css/app.min.css">
<!-- Template CSS -->
<link rel="stylesheet" href="<%=request.getContextPath()%>/adminResources/css/datatables.min.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/adminResources/css/dataTables.bootstrap4.min.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/adminResources/css/style.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/adminResources/css/components.css">
<!-- Custom style CSS -->
<link rel="stylesheet" href="<%=request.getContextPath()%>/adminResources/css/custom.css">
<link rel='shortcut icon' type='image/x-icon'
	href='<%=request.getContextPath()%>/adminResources/image/favicon.ico' />

</head>
<body>
	<div class="loader"></div>
	<div id="app">
		<div class="main-wrapper main-wrapper-1">
			<div class="navbar-bg"></div>



			<jsp:include page="header.jsp"></jsp:include>



			<jsp:include page="menu.jsp"></jsp:include>

			<!-- Main Content -->
			<div class="main-content">
				<section class="section">
				<div class="section-body">
					<div class="row">
						<div class="col-12">
							<div class="card">
								<div class="card-header">
									<h3 style="font-family: cursive; color: blue;">payment status </h3>
									
								</div>
								<div class="card-body">
									<div class="table-responsive">

										<table class="table table-striped table-hover"
											id="tableExport" style="width: 100%;">
											<thead>
												<tr>
													<th>No</th>
													<th>Fisrtname</th>
													<th>Lastname</th>
													<th>Phone Number</th>
													<th>Email</th>
													<th>payment status</th>
													<th>allocated room no</th>
													<th>Block No</th>
													<th>Floor No</th>
													<th>Hostel Type</th>			
												</tr>
											</thead>
											<tbody>
												<f:forEach varStatus="j" items="${list}" var="i">
													<tr>
														<td>${j.count}</td>
														<td>${i.udvo.applicationFormVO.firstName }</td>	
														<td>${i.udvo.applicationFormVO.lastName }</td>
														<td>${i.udvo.applicationFormVO.mobileNo }</td>
														<td><a href="mailto:${i.udvo.applicationFormVO.email}">${i.udvo.applicationFormVO.email}</a></td>	
														<td>
															${i.paymentStatus}<br/><br/>
															<f:if test="${i.paymentStatus eq 'pending'}">
																<a href="sendPendingPaymentMail?email=${i.udvo.applicationFormVO.email}">
																	<button>Notify</button>
																</a>
															</f:if>
														</td>
														<td>${i.roomVO.roomNO}</td>	
														<td>${i.roomVO.blockNo}</td>
														<td>${i.roomVO.floorNo}</td>
														<td>${i.roomVO.hostelType}</td>
													</tr>
												</f:forEach>
											</tbody>
										</table>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				</section>





			</div>
			<section><jsp:include page="footer.jsp"></jsp:include></section>

		</div>
		<!-- General JS Scripts -->
		<script src="<%=request.getContextPath()%>/adminResources/js/app.min.js"></script>
		<!-- JS Libraies -->
		<!-- Page Specific JS File -->
		<script src="<%=request.getContextPath()%>/adminResources/js/datatables.min.js"></script>
		<script src="<%=request.getContextPath()%>/adminResources/js/dataTables.bootstrap4.min.js"></script>
		<script src="<%=request.getContextPath()%>/adminResources/js/dataTables.buttons.min.js"></script>
		<script src="<%=request.getContextPath()%>/adminResources/js/buttons.flash.min.js"></script>
		<script src="<%=request.getContextPath()%>/adminResources/js/jszip.min.js"></script>
		<script src="<%=request.getContextPath()%>/adminResources/js/pdfmake.min.js"></script>
		<script src="<%=request.getContextPath()%>/adminResources/js/vfs_fonts.js"></script>
		<script src="<%=request.getContextPath()%>/adminResources/js/buttons.print.min.js"></script>
		<script src="<%=request.getContextPath()%>/adminResources/js/datatables.js"></script>
		<!-- Template JS File -->
		<script src="<%=request.getContextPath()%>/adminResources/js/scripts.js"></script>
		<!-- Custom JS File -->
		<script src="<%=request.getContextPath()%>/adminResources/js/custom.js"></script>
</body>
</html>