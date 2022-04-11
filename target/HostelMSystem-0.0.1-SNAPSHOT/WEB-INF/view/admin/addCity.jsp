<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
	<%@taglib prefix="f" uri="http://java.sun.com/jstl/core_rt" %>
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
			<s:form action="insertCity" modelAttribute="cityvo" method="post">
			<div class="main-content">
				<section class="section">
					<div class="section-body">
						<div class="row">
							<div class="col-12 col-md-12 col-lg-12">
								<div class="card">
									<form class="needs-validation" novalidate="">
										<div class="card-header">
											<h4 style="font-family:cursive;font-size: 30px;color: blue;margin-left:43%">Add City</h4>
										</div>
										<div class="card-body">
											<div class="form-group">
						
												<label>select state</label> 
												<s:select path="statevo.id" class="form-control">
													<f:forEach items="${statelist}" var="sl">
														<s:option value="${sl.id}" class="form-control">${sl.stateName}</s:option>
													</f:forEach>
												</s:select>
									
											</div>
											
											<div class="form-group">
												<s:hidden path="id"/>
												<label>City Name</label> <s:input path="cityName"
													class="form-control" required=""/>
												<div class="invalid-feedback">What's your name?</div>
											</div>
											
											<div class="form-group mb-0">
												<label>City Discription</label>
												<s:textarea class="form-control" required="" path="cityDescription"></s:textarea>
												<div class="invalid-feedback">What do you wanna say?</div>
											</div>
										
										</div>
										<div class="card-footer text-right">
											<button class="btn btn-primary" type="submit">Submit</button>
										</div>
									</form>
								</div>
							</div>
						</div>
					</div>
				</section>
				</s:form>
		</div>
		<section><jsp:include page="footer.jsp"></jsp:include></section>
		
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