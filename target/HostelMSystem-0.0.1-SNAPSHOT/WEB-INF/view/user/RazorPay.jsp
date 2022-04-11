<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="com.hms.model.PaymentStatusVO"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
<title>Hostel Management System</title>
<style>
body {
	background: linear-gradient(-45deg, #ee7752, #e73c7e, #23a6d5, #23d5ab);
	background-size: 600% 1000%;
	animation: gradient 7.5s cubic-bezier(0.6, 0.74, 0.98, 0.335) infinite;
}

@
keyframes gradient { 0% {
	background-position: 0% 50%;
}

50%
{
background-position






:



 



100%
50%;
}
100%
{
background-position






:



 



0%
50%;
}
}
.whiteback {
	background-color: white;
	padding: 50px;
	border-radius: 30px;
	opacity: 0.8;
}
</style>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/applicationFormResources/assets/bootstrap/css/bootstrap.min.css">
</head>
<body>

	<div style="width: 40%; margin: auto;">
		<div class="container whiteback" style="margin: 0; margin-top: 52px;">
			<div class="row">
				<div
					class="col d-md-flex justify-content-md-center align-items-md-center">
					<div>
						<div
							class="col d-md-flex d-xl-flex justify-content-md-center align-items-md-center justify-content-xl-center align-items-xl-start">
							<div>
								<h1>
									Confirmation<br>
								</h1>
							</div>
							<div></div>
						</div>
						<div
							class="col d-xl-flex justify-content-xl-center align-items-xl-start">
							<div></div>
						</div>
					</div>
				</div>
			</div>
			<hr>
			<div class="row" style="margin-top: 52px;">
				<div class="col">


                    <p id="name" style="font-size: 18px;">
					<strong>Name :&nbsp;</strong><%=((PaymentStatusVO) session.getAttribute("paymentVO")).getUdvo().getApplicationFormVO()
					.getFirstName()%>&nbsp;&nbsp;<%=((PaymentStatusVO) session.getAttribute("paymentVO")).getUdvo().getApplicationFormVO()
					.getLastName()%></p>
					
					<p id="latepaymentcharges-2" style="font-size: 18px;">
						<strong>Email :&nbsp;</strong><%=((PaymentStatusVO) session.getAttribute("paymentVO")).getUdvo().getApplicationFormVO().getEmail()%>
					</p>
					<p id="studentid" style="font-size: 18px;">
					 <strong>Application ID :&nbsp;</strong><%=((PaymentStatusVO) session.getAttribute("paymentVO")).getUdvo().getApplicationFormVO()
					.getApplicationNo()%>
					</p>
					
					<p id="paymentdate" style="font-size: 18px;">
						<strong>Student Type :&nbsp;</strong><%=((String)(session.getAttribute("studentType"))) %>
					</p>
					
					<p id="Year" style="font-size: 18px;">
						<strong>Academic Year :&nbsp;</strong><%=((String)(session.getAttribute("AcademicYear"))) %>
					</p>
					<p id="totalfees" style="font-size: 18px;">
						<strong>Total Fees&nbsp; :&nbsp;</strong>4000
					</p>

					
				</div>
			</div>
			<hr>
			<hr>
			<div class="row">
				<form action="generatePaymentReceipt" method="post">
					<script src="https://checkout.razorpay.com/v1/checkout.js"
						data-key="rzp_test_hexd4kuiRIDvQX" data-amount="400000"
						data-buttontext="Make Payment"
						data-buttoncolor="green" data-name="Hostel"
						data-description="pay hostel fees"
						data-image="https://example.com/your_logo.jpg"
						data-prefill.name="<%=((PaymentStatusVO) session.getAttribute("paymentVO")).getUdvo().getApplicationFormVO()
					.getFirstName()%>"
						data-prefill.email=<%=session.getAttribute("emailId")%>
						data-theme.color="#F37254"></script>
					<input type="hidden" custom="Hidden Element" name="hidden">
				</form>
				<div
					class="col d-md-flex justify-content-md-start align-items-md-center">
					<button class="btn btn-danger" type="button">Cancel</button>
				</div>
			</div>
		</div>
	</div>
	<script src="assets/js/jquery.min.js"></script>
	<script src="assets/bootstrap/js/bootstrap.min.js"></script>
	<%-- <form action="generatePaymentReceipt" method="post">



		<script src="https://checkout.razorpay.com/v1/checkout.js"
			data-key="rzp_test_hexd4kuiRIDvQX" data-amount="40000"
			data-currency="INR" data-buttontext="Make Payment" data-name="Hostel"
			data-description="pay hostel fees"
			data-image="https://example.com/your_logo.jpg"
			data-prefill.name="<%=session.getAttribute("fullName") %>"
			data-prefill.email=<%=session.getAttribute("emailId")%>
			data-theme.color="#F37254"></script>
		<input type="hidden" custom="Hidden Element" name="hidden">
	</form> --%>
</body>
</html>