<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
<title>HMS ADMIN</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/editProfileResources/assets/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/editProfileResources/assets/fonts/font-awesome.min.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/editProfileResources/assets/css/Features-Boxed.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/editProfileResources/assets/css/Footer-Dark.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/editProfileResources/assets/css/My_nav.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/editProfileResources/assets/css/mynav-1.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/editProfileResources/assets/css/Navigation-Clean.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/editProfileResources/assets/css/Profile-Edit-Form-1.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/editProfileResources/assets/css/Profile-Edit-Form.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/editProfileResources/assets/css/styles.css">

<script type="text/javascript">
	function enableField() {

		var fn = document.getElementById("fn");
		var ln = document.getElementById("ln");
		 var phone = document.getElementById("phone"); 
		var email = document.getElementById("email");
		var password = document.getElementById("password");
		var button = document.getElementById("button");
		var submit = document.getElementById("submit");

		fn.disabled = false;
		ln.disabled = false;
		phone.disabled = false;
		email.disabled = false;
		password.disabled = false;
		button.style.display = "none";
		submit.style.display = "";

	}
</script>
</head>
<body>

	
	
	<div class="container profile profile-view"
		style="margin: auto; padding: auto; padding-bottom: 53px;">


		 <s:form action="updateAdminProfile" modelAttribute="signinVO" method="post">
		 <s:hidden path="id"/>
		 <s:hidden path="loginVO.loginId"/>
			<div class="form-row ">
				 <%-- <div class="col-md-4 relative">
					<div class="avatar" style="margin-bottom: 25px; margin-top: 45px;">
						<div class="avatar-bg center"
							style="background-image: url(&quot;0&quot;);">
							<img src="<%=request.getContextPath()%>/editProfileResources/assets/img/icon.png"
								style="width: 100%; background-color: #ffffff;">
						</div>
					</div>
					<input class="d-xl-flex form-control" type="file"
						name="avatar-file" style="padding: 0px;">
				</div>  --%>
				<div class="col-md-12" style="margin-top: 10%">
					<h1>Profile</h1>
					<hr>
					<div class="form-row">
						<div class="col-sm-12 col-md-6">
							<div class="form-group">
								<label>Firstname </label>
								<s:input class="form-control" path="firstName" id="fn" minlength="3"
									required="" disabled="true"></s:input>
							</div>
						</div>
						<div class="col-sm-12 col-md-6">
							<div class="form-group">
								<label>Lastname </label>
								<s:input class="form-control" path="lastName" id="ln" minlength="3"
									required="" disabled="true"></s:input>
							</div>
						</div>
					</div>
					<div class="form-group">
						<label>Email </label>
						<s:input class="form-control" path="loginVO.username" id="email"
							required="" minlength="10" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$" disabled="true"></s:input>
					</div>
					<div class="form-group">
						<label>Phone </label>
						<s:input class="form-control" path="phone" id="phone" minlength="10" maxlength="10"
							required="" disabled="true"></s:input>
					</div>
					<div class="form-row">
						<div class="col-sm-12 col-md-6">
							<div class="form-group">
								<label>Password </label>
								<s:input class="form-control" path="loginVO.password"
									id="password" required="" disabled="true"></s:input>
							</div>
						</div>
						<div class="col-sm-12 col-md-6">
							<div class="form-group">
								<label>Confirm Password</label><input class="form-control"
									type="password" id="password1" autocomplete="off" required="">
							</div>
						</div>
					</div>
					<hr>
					<div class="form-row">
						<div class="col-md-12 content-right">
							<input type="submit" style="display: none;" value="SAVE"
								id="submit"> <input type="button" id="button"
								value="Edit" onclick="enableField()">
						</div>
					</div>
				</div>
			</div>
		</s:form> 
	</div>



	
	<script src="<%=request.getContextPath()%>/editProfileResources/assets/js/jquery.min.js"></script>
	<script src="<%=request.getContextPath()%>/editProfileResources/assets/bootstrap/js/bootstrap.min.js"></script>
	<script src="<%=request.getContextPath()%>/editProfileResources/assets/js/Profile-Edit-Form.js"></script>
	<script src="https://cdn.rawgit.com/PascaleBeier/bootstrap-validate/v2.2.0/dist/bootstrap-validate.js" ></script>
	<script>
        bootstrapValidate('#fn','min:3:Enter at least 3 characters.')
        bootstrapValidate('#fn','alpha:Enter only alphabets.')
        bootstrapValidate('#ln','min:3:Enter at least 3 characters.')
        bootstrapValidate('#ln','alpha:Enter only alphabets.')
        bootstrapValidate('#email','email:Enter a valid email address.')
        bootstrapValidate('#phone','numeric:Enter numbers only.')
        bootstrapValidate('#password1','matches:#password:Enter the same password as above.')
    </script>
	
</body>
</html>