<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

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
					<div class="row" style="margin-top: 5%">
						<div class="col-12 col-md-12 col-lg-12">
							<div class="card" >
								<form class="needs-validation" novalidate=""
									action="insertBroadcastMessage" method="post"
									modelAttribute="broadcastMessageVO">
									<div class="card-header">
										<h4 style="font-family:cursive;font-size: 30px;color: blue;margin-left:45%">Broadcast Message</h4>
									</div>
									<div class="card-body">
										<div class="form-group">
                                            <textarea name="message" class="form-control" required="true"></textarea><br>
										    <input class="btn btn-primary" type="submit"  value="send">
            							</div>

									</div>

								</form>
							</div>
						</div>
					</div>
				</div>
				</section>
		</div>
		<section>
					<jsp:include page="footer.jsp"></jsp:include>
		
		</section>
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