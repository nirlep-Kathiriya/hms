<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="f" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta
	content="width=device-width, initial-scale=1, maximum-scale=1, shrink-to-fit=no"
	name="viewport">
<title>HMS ADMIN</title>
<!-- General CSS Files -->
<link rel="stylesheet" href="<%=request.getContextPath()%>/adminResources/css/app.min.css"">
<!-- Template CSS -->
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

			
			<div class="main-content">
				<section class="section">
					<div class="section-body">
						<div class="row">
							<div class="col-12">
								<div class="card">
									<div class="card-header">
										<h4 style="font-family:cursive;font-size: 30px;color: blue;;margin-left:43%">Documents</h4>
									</div>
									<div class="card-body">
										<div class="table-responsive">
										
											<table class="table table-striped table-hover"
												id="tableExport" style="width: 100%;">
												<thead>
													<tr>
														<th>No</th>
														<th>Document Type</th>
														<th>Document</th>
													</tr>
												</thead>
												<tbody>
												<f:forEach items="${fresherDocumentList}" var="i">
													<tr>
														
														<td>1</td>
														<td>Profile Photo</td>
														<td>
															<a href="${i.profilePhoto}" target="_blank">
																<img alt="Not Found" src="${i.profilePhoto}" style="height: 150px;width: 150px">
														    </a>
														</td>
													</tr>
													<tr>	
														<td>2</td>
														<td>${i.identitiyProofType}</td>
														<td>
															<a href="${i.identitiyProof}" target="_blank">
																<img alt="Not Found" src="${i.identitiyProof}" style="height: 150px;width: 150px">
														    </a>
														</td>
													</tr>
													<tr>	
														<td>3</td>
														<td>Graduation Transcript</td>
														<td>
															<a href="${i.graduationTranscript}" target="_blank">
																<img alt="Not Found" src="${i.graduationTranscript}" style="height: 150px;width: 150px">
														    </a>
														</td>
													</tr>
													<tr>	
														<td>4</td>
														<td>Graduation Marksheet</td>
														<td>
															<a href="${i.graduationMarksheet}" target="_blank">
																<img alt="Not Found" src="${i.graduationMarksheet}" style="height: 150px;width: 150px">
														    </a>
														</td>
													</tr>
													<tr>
														<td>5</td>
														<td>Address Proof</td>
														<td>
															<a href="${i.addressProof}" target="_blank">
																<img alt="Not Found" src="${i.addressProof}" style="height: 150px;width: 150px">
														    </a>
														</td>
													</tr>
													<tr>	
														<td>6</td>
														<td>Addmission Slip</td>
														<td>
															<a href="${i.addmissionSlip}" target="_blank">
																<img alt="Not Found" src="${i.addmissionSlip}" style="height: 150px;width: 150px">
														    </a>
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
		<section><jsp:include page="footer.jsp"></jsp:include></section>	
		</div>
		<!-- General JS Scripts -->
		<script src="<%=request.getContextPath()%>/adminResources/js/app.min.js"></script>
		<!-- JS Libraies -->
		<script src="<%=request.getContextPath()%>/adminResources/js/apexcharts.min.js"></script>
		<!-- Page Specific JS File -->
		<script src="<%=request.getContextPath()%>/adminResources/js/index.js"></script>
		<!-- Template JS File -->
		<script src="<%=request.getContextPath()%>/adminResources/js/scripts.js"></script>
		<!-- Custom JS File -->
		<script src="<%=request.getContextPath()%>/adminResources/js/custom.js"></script>
</body>

</html>