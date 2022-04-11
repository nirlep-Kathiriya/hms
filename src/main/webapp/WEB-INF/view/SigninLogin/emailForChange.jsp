<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Hostel Management System</title>
<script>
 function varify()
{
    var email=document.getElementById("email");
	var htp=new XMLHttpRequest();
	
	  htp.onreadystatechange=function()
	  {
		  if(htp.readyState==4)
		  {
			  var jsn=JSON.parse(htp.responseText);
              
              if(jsn.ans.localeCompare("No")==0)
              {
            	 document.getElementById("err").innerHTML='Email is not registered';
              }	  
              else
              {
                   window.location.replace("sendOTPForForgotPassVarify?email="+email.value+"");
              }
	      }
      }
	  htp.open("post","checkEmailAlreadyRegistered?email="+email.value+" ",true);
	  htp.send();
} 
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

</head>
<body>
<input type="email" id="email"><span id="err"></span><br>
<input type="submit" onclick="varify()">
</body>
</html>