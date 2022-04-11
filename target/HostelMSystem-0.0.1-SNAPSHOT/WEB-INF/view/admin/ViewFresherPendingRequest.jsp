<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta
	content="width=device-width, initial-scale=1, maximum-scale=1, shrink-to-fit=no"
	name="viewport">
<title>HMS ADMIN</title>
<!-- General CSS Files -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/adminResources/css/app.min.css">
<!-- Template CSS -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/adminResources/css/datatables.min.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/adminResources/css/dataTables.bootstrap4.min.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/adminResources/css/style.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/adminResources/css/components.css">
<!-- Custom style CSS -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/adminResources/css/custom.css">
<link rel='shortcut icon' type='image/x-icon'
	href='<%=request.getContextPath()%>/adminResources/image/favicon.ico' />
<script type="text/javascript">
function admissionON() {
	alert("Admission process still continue");
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



			<!-- Main Content -->
			<div class="main-content">
				<section class="section">
					<div class="section-body">
						<div class="row">
							<div class="col-12">
								<div class="card">
									<div class="card-header">
										<h3 style="font-family: cursive; color: blue;">Fresher's
											Pending Requests</h3>
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										<h5>Remaining seat Of Boys Hostel :</h5>
										<div
											style="border: 2px solid gray; margin-left: 1%; width: 50px">${remainBoyBed}</div>
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										<h5>Remaining seat Of Girls Hostel :</h5>
										<div
											style="border: 2px solid gray; margin-left: 1%; width: 50px">${remainGirlBed}</div>
									</div>
									<div class="card-body">
										<div class="table-responsive">

											<table class="table table-striped table-hover"
												id="tableExport" style="width: 100%;">
												<thead>
													<tr>
														<th>No</th>
														<th>Fisrtname</th>
														<th>Middlename</th>
														<th>Lastname</th>
														<th>Gender</th>
														<th>Phone Number</th>
														<th>Email</th>
														<th>State</th>
														<th>City</th>
														<th>View Documents</th>
														<th>Action</th>

													</tr>
												</thead>
												<tbody>
													<f:forEach items="${fresherlist}" var="i" varStatus="j">
														<tr>
															<td>${j.count}</td>
															<td>${i.applicationFormVO.firstName}</td>
															<td>${i.applicationFormVO.middleName}</td>
															<td>${i.applicationFormVO.lastName}</td>
															<td>${i.applicationFormVO.gender}</td>
															<td>${i.applicationFormVO.mobileNo}</td>
															<td>${i.applicationFormVO.email}</td>
															<td>${i.applicationFormVO.state}</td>
															<td>${i.applicationFormVO.city}</td>
															<td><a
																href="loadFresherDocument?documentListId=${i.id}">View
																	Document</a></td>
															<td><a
																<f:if test="${StatusOfAddmission eq false}">href="acceptFresherRequest?documentListId=${i.id}"</f:if>
																<f:if test="${StatusOfAddmission eq true}">href="" onclick="admissionON()"</f:if>>Accept
																	Request</a><br> <a
																<f:if test="${StatusOfAddmission eq false}">href="rejectFresherRequest?documentListId=${i.id}"</f:if>
																<f:if test="${StatusOfAddmission eq true}">href="" onclick="admissionON()"</f:if>>
																	Reject Request</a></td>
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
		<script
			src="<%=request.getContextPath()%>/adminResources/js/app.min.js"></script>
		<!-- JS Libraies -->
		<!-- Page Specific JS File -->
		<script
			src="<%=request.getContextPath()%>/adminResources/js/datatables.min.js"></script>
		<script
			src="<%=request.getContextPath()%>/adminResources/js/dataTables.bootstrap4.min.js"></script>
		<script
			src="<%=request.getContextPath()%>/adminResources/js/dataTables.buttons.min.js"></script>
		<script
			src="<%=request.getContextPath()%>/adminResources/js/buttons.flash.min.js"></script>
		<script
			src="<%=request.getContextPath()%>/adminResources/js/jszip.min.js"></script>
		<script
			src="<%=request.getContextPath()%>/adminResources/js/pdfmake.min.js"></script>
		<script
			src="<%=request.getContextPath()%>/adminResources/js/vfs_fonts.js"></script>
		<script
			src="<%=request.getContextPath()%>/adminResources/js/buttons.print.min.js"></script>
		<script
			src="<%=request.getContextPath()%>/adminResources/js/datatables.js"></script>
		<!-- Template JS File -->
		<script
			src="<%=request.getContextPath()%>/adminResources/js/scripts.js"></script>
		<!-- Custom JS File -->
		<script
			src="<%=request.getContextPath()%>/adminResources/js/custom.js"></script>
</body>

</html>