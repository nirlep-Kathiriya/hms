<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html lang="en">

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
										<h4 style="font-family:cursive;font-size: 30px;color: blue;;margin-left:43%">View Room</h4>
									</div>
									<div class="card-body">
										<div class="table-responsive">
											<span style="color:red;font-size:15px">${CannotDelete}</span>
											<table class="table table-striped table-hover"
												id="tableExport" style="width: 100%;">
												<thead>
													<tr>
														<th>No</th>
														<th>Hostel type</th>
														<th>Block no</th>
														<th>Floor no</th>
														<th>Room no</th>
														<th>Number of Bed</th>
														<th>Remaining no of seats</th>
														<th>action</th>
													</tr>
												</thead>
												<tbody>
												<f:forEach varStatus="j"  items="${roomlist}" var="i">
													<tr>
														<td>${j.count}</td>
														<td>${i.hostelType}</td>
														<td>${i.blockNo}</td>
														<td>${i.floorNo}</td>
														<td>${i.roomNO}</td>
														<td>${i.numOfBed}</td>
														<td>${i.remainBed}</td>
														
														<td>
															<a href="editRoom?id=${i.id}">Edit</a><br>
															<a href="deleteRoom?id=${i.id}">Delete</a>
														</td>
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
				<section>	<jsp:include page="footer.jsp"></jsp:include></section>
		
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