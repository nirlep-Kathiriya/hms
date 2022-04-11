<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>otp</title>
    <link rel="stylesheet" href="resetPasswordResources/assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="resetPasswordResources/assets/css/style.css">
<title>Hostel Management System</title>
</head>

<body style="background-image: url(&quot;resetPasswordResources/assets/img/b.jpg&quot;);">
    <div class="registration-form" style="background-size: contain;background-repeat: no-repeat;">
        <form class="text-monospace d-block" style="margin: default;" action="varifyOTPandUpdatePassword" method="post">
           <input class="form-control item" type="text" id="otp" placeholder="Enter OTP" name="OTPForForgotPassword" required="" minlength="6" maxlength="6"><span  style="color: red">${errorOfOTP}</span><br>
           <input class="form-control item" type="password" id="password"  name="password1" placeholder="Enter New Password" required="">
            <input class="form-control item" type="password" id="password-1"  name="password2" placeholder="Confirm Password" required=""><span style="color: red">${errorOfPass}</span><br>
            <input type="hidden" name="token" value="${sessionScope.Token}"><br>
				<%session.removeAttribute("error"); %>    
                <div class="form-group">
                    <button class="btn btn-primary btn-block create-account" type="submit" style="background-color: rgb(33,93,130);">Reset Password</button>
                </div>
                
        </form>
        <div class="social-media" style="background-color: rgb(34,93,133);"></div> <!--blue rounded footer-->
    </div>
    <script src="resetPasswordResources/assets/js/jquery.min.js"></script>
    <script src="resetPasswordResources/assets/bootstrap/js/bootstrap.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.15/jquery.mask.min.js"></script>
    <script src="resetPasswordResources/assets/js/script.js"></script>
</body>

<%-- <body>
<form action="varifyOTPandUpdatePassword" method="post">

NewPassword :<input type="password" name="password1"><br>
Retype Password :<input type="password" name="password2"><span style="color: red">${errorOfPass}</span><br>
Enter OTP :<input type="text" name="OTPForForgotPassword"> <span  style="color: red">${errorOfOTP}</span><br>
<input type="hidden" name="token" value="${sessionScope.Token}"><br>
<%session.removeAttribute("error"); %>
<input type="submit">
</form>
</body> --%>
</html>