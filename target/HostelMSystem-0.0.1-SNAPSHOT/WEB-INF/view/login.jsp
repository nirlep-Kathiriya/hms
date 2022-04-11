<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="f" uri="http://java.sun.com/jstl/core_rt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
<title>sign_in (2)</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/forgetPasswordResources/assets/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/forgetPasswordResources/assets/fonts/font-awesome.min.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/forgetPasswordResources/assets/fonts/simple-line-icons.min.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/forgetPasswordResources/assets/css/style.css">

<link rel="stylesheet"
	href="homePageResources/assets/css/Footer-Dark.css">

<link rel="stylesheet"
	href="homePageResources/assets/css/Footer-Basic.css">
	
<link rel="stylesheet" href="homePageResources/assets/css/mynav.css">


<script>
	function varifyforget() {
		var email = document.getElementById("email");
		console.log(email.value);
		var htp = new XMLHttpRequest();

		htp.onreadystatechange = function() {
			if (htp.readyState == 4) {
				var jsn = JSON.parse(htp.responseText);

				if (jsn.ans.localeCompare("No") == 0) {
					document.getElementById("err").innerHTML = 'Email is not registered';
				} else {
					window.location.replace("sendOTPForForgotPassVarify?email="
							+ email.value + "");
				}
			}
		}
		htp.open("post", "checkEmailAlreadyRegistered?email=" + email.value
				+ " ", true);
		htp.send();
	}

	function varify() {
		var username = document.getElementById("username-2");
		var password = document.getElementById("password");
		var htp = new XMLHttpRequest();

		htp.onreadystatechange = function() {
			if (htp.readyState == 4) {
				var jsn = JSON.parse(htp.responseText);

				if (jsn.ans.localeCompare("No") == 0) {
					document.getElementById("errOfLogin").innerHTML = 'WRONG Username Or Password';
				} else {
					if (jsn.ans.localeCompare("Yes") == 0) {
						sessionStorage.setItem("username1", username.value);
						sessionStorage.setItem("password1", password.value);
						window.location.replace("savedata?username="
								+ username.value + "&password="
								+ password.value + " ");

					} else if (jsn.ans.localeCompare("admin") == 0)
						window.location.replace("loadAdmin");

				}
			}
		}
		htp.open("post", "verifyLoginDetail?username=" + username.value
				+ "&password=" + password.value + " ", true);
		htp.send();
	}
</script>
</head>


<body
	style="background-image: url(&quot;forgetPasswordResources/assets/img/b.jpg&quot;);">



	<nav
		class="navbar navbar-light navbar-expand-md sticky-top shadow navigation-clean-button"
		style="background-color: rgb(20,133,238);height: 65px;">
	<div class="container-fluid">
		<a class="navbar-brand" href="#"
			style="color: rgba(255, 255, 255, 0.9);">HosteL</a>
			
		<button data-toggle="collapse" class="navbar-toggler"
			data-target="#navcol-1" style="color: rgb(0, 0, 0);">
			<span class="sr-only" style="background-color: #1485ee;">Toggle
				navigation</span><span class="navbar-toggler-icon"
				style="background-color: #1485ee;"></span>
		</button>
		<div class="collapse navbar-collapse" id="navcol-1"
			style="background-color: #1485ee;">
			<ul class="nav navbar-nav mr-auto" style="background-color: #1485ee;">
				<li class="nav-item" role="presentation"><a class="nav-link"
					href="#about" style="color: rgb(255, 255, 255);"><strong>About
							Us</strong></a></li>
			</ul>
			<span class="navbar-text actions" style="background-color: #1485ee;">
				<a class="btn btn-light border-light action-button" role="button"
				id="bor" href="loadSignUpPage"
				style="color: rgb(20,133,238); background-color:white;"><strong>&nbsp;Sign
						Up</strong></a>
			</span> <span class="navbar-text actions" style="background-color: #1485ee;">
			</span><span class="navbar-text actions" style="background-color: #1485ee;">
			</span><span class="navbar-text actions" style="background-color: #1485ee;">
			</span>
		</div>
	</div>
	</nav>

	<div class="registration-form"
		style="background-size: contain; background-repeat: no-repeat;">
		
		<form class="text-monospace d-block" style="margin: default;"
			action="j_spring_security_check" method="post" autocomplete="on">
			<div class="form-icon"
				style="background-color: rgb(20, 133, 238); padding-top: 30px">
				<span><i class="icon-user icon"></i></span>
			</div>
			<div class="form-group">
				<input class="form-control item" type="text" id="username-2"
					placeholder="Email Id" minlength="3" autocomplete="on" required="" name="username">
			</div>
			<div class="form-group">
				<input class="form-control item" type="password" id="password"
					placeholder="Password" required="" name="password">
			</div>
			<f:if test="${error eq true}">
				<span style="color: red">Invalid Username or Password</span>	
			</f:if>	
			<span style="color: red" id="errOfLogin"></span>
			<div class="form-group">
				<button class="btn btn-primary btn-block create-account"
					type="submit" style="background-color: rgb(20, 133, 238);">Sign
					In</button>
			</div>
		</form>
		<div class="modal fade border-primary" role="dialog" tabindex="-1"
			id="pop">
			<div class="modal-dialog modal-dialog-centered" role="document">
				<div class="modal-content">
					<div class="modal-header d-md-flex justify-content-md-center">
						<h4
							class="modal-title text-center d-md-flex justify-content-center align-items-center ml-auto justify-content-md-center align-items-md-center">Account
							Recovery</h4>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span id="see" aria-hidden="true">×</span>
						</button>
					</div>
					<div class="modal-body">
						<input class="form-control" type="email"
							placeholder="Enter your Email" id="email" inputmode="email"
							required=""><span style="color: red" id="err"></span><br>
					</div>
					<div
						class="modal-footer d-md-flex justify-content-md-center align-items-md-center">
						<button data-toggle="modal" data-target="#pop2"
							class="btn btn-primary d-md-flex justify-content-md-center align-items-md-center"
							type="button" onclick="varifyforget()">Submit</button>
					</div>
				</div>
			</div>
		</div>
		<div class="social-media" style="background-color: rgb(20, 133, 238);">
			<div style="margin: auto;">
				<a data-toggle="modal" data-target="#pop" href=""
					class="d-lg-flex justify-content-lg-start"
					style="color: rgb(255, 255, 255); font-size: 20px; margin-left: 40%; margin-bottom: 5%">Forgot
					password?</a>
			</div>
			<h5 style="color: rgb(255, 255, 255);">
				Don't have an account?&nbsp;<a href="loadSignUpPage"
					style="color: rgb(92, 181, 211);">Sign up</a>
			</h5>
		</div>
	</div>

	<jsp:include page="footerOfMain.jsp"></jsp:include>
	<script
		src="<%=request.getContextPath()%>/forgetPasswordResources/assets/js/jquery.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/forgetPasswordResources/assets/bootstrap/js/bootstrap.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.15/jquery.mask.min.js"></script>
</body>






</html>