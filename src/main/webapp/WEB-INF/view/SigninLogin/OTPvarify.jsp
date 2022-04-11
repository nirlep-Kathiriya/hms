<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<html>
<head>
<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>Hostel Management System</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/resetPasswordResources/assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/resetPasswordResources/assets/css/style.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/messResources/assets/css/myheader.css">	
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/homePageResources/assets/css/Footer-Basic.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/homePageResources/assets/css/Footer-Dark.css">
    
<script>
function varify()
{
    var token=document.getElementById("token");
    var OTP=document.getElementById("OTP");
    /* var flagForDirectOTPPage=document.getElementById("flagForDirectOTPPage").value; */
    
	var htp=new XMLHttpRequest();

    
	  htp.onreadystatechange=function()
	  {
		  if(htp.readyState==4)
		  {
			  var jsn=JSON.parse(htp.responseText);
              if(jsn.ans.localeCompare("No")==0)
              { 
            	 
            	 document.getElementById("err").innerHTML='WRONG OTP';
              }	  
              else
              {
            	  /* if(flagForDirectOTPPage.localeCompare("SignUp")==0) */
                   window.location.replace("loadLogInPage");
            	 /*  if(flagForDirectOTPPage.localeCompare("regularStudent")==0)
                   window.location.replace("loadUserPage"); */
  

            	  
              }
	      }
      }
	  htp.open("post","VarifyOTPForSignin?token="+token.value+"&OTP="+OTP.value+" ",true);
	  htp.send();
}
</script>
</head>
<%-- <body>
<input type="hidden" id="flagForDirectOTPPage" value="${sessionScope.flagForDirectOTPPage}">
<input type="hidden" id="token" value="${sessionScope.Token}">
Enter OTP :- <input type="text" id="OTP">

<c:if test="${sessionScope.flagForDirectOTPPage eq 'SignUp'}">
<a href="sendOTPForSignInVarify">Resend OTP</a><span id="err"></span><br>
</c:if>
<c:if test="${sessionScope.flagForDirectOTPPage eq 'regularStudent'}">
<a href="sendOTPForRegularVarify">Resend OTP</a><span id="err"></span><br>
</c:if>
<input type="submit" value="Varify" onclick="varify()" >
</body> --%>

<body
	style="background-image: url(&quot;resetPasswordResources/assets/img/b.jpg&quot;);">
	<div class="registration-form"
		style="background-size: contain; background-repeat: no-repeat;">
		<form class="text-monospace d-block" style="margin: default;">
		
			<%-- <input type="hidden" id="flagForDirectOTPPage"
				value="${sessionScope.flagForDirectOTPPage}">  --%>
				
			<input type="hidden" id="token" value="${sessionScope.Token}">
			
			 <input class="form-control item" type="text" id="OTP"
				placeholder="Enter OTP" name="OTPForForgotPassword" required=""
				minlength="6" maxlength="6"> <span style="color: red">${errorOfOTP}</span>
            
				<a href="sendOTPForSignInVarify">Resend OTP</a>
				<span id="err" style="color:red"></span>
				

			<div class="form-group">
				<button class="btn btn-primary btn-block create-account"
					type="button" style="background-color: rgb(33, 93, 130);" onclick="varify()">Submit</button>
			</div>
		</form>
		<div class="social-media" style="background-color: rgb(34, 93, 133);"></div>
		<!--blue rounded footer-->
	</div>


	<script src="resetPasswordResources/assets/js/jquery.min.js"></script>
	<script
		src="resetPasswordResources/assets/bootstrap/js/bootstrap.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.15/jquery.mask.min.js"></script>
	<script src="resetPasswordResources/assets/js/script.js"></script>
</body>
</html>