<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="com.hms.model.PaymentStatusVO"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<title>Payment Receipt</title>
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/PaymentReceiptResources/assets/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/PaymentReceiptResources/assets/css/styles.css">

<!-- <meta name="viewport" content="width=device-width, initial-scale=1" /> -->
<script
	src="<%=request.getContextPath()%>/pdfResources/html2pdf.bundle.min.js"></script>

<script>
	function generatePDF() {
		// Choose the element that our invoice is rendered in.
		const
		element = document.getElementById("invoice");
		// Choose the element and save the PDF for our user.
		html2pdf().from(element).save();
	}
</script>
</head>

<body>
	<button class="btn btn primary" type="button" onclick="generatePDF()" style="float:right">Download as PDF</button>
	<%-- <div id="invoice">
application Id : <%=session.getAttribute("appId") %><br><br>
email Id : <%=session.getAttribute("emailId") %><br><br>
full name : <%=session.getAttribute("fullName") %><br><br>
type : <%=session.getAttribute("studentType") %><br><br>
year : <%=session.getAttribute("AcademicYear") %><br><br>
</div> --%>
	<div class="container" style="margin-top: 52px;" id="invoice">
		<div class="row">
			<div
				class="col-2 d-xl-flex justify-content-xl-center align-items-xl-center">
				<img
					src="<%=request.getContextPath()%>/PaymentReceiptResources/assets/img/icon.jpg"
					style="width: 136px; margin-left:2% ">
			</div>
			<div class="col">
				<div>
					<div
						class="col d-xl-flex justify-content-xl-center align-items-xl-start">
						<div>
							<h1>
								University of North Texas<br>
							</h1>
						</div>
						<div></div>
					</div>
					<div
						class="col d-xl-flex justify-content-xl-center align-items-xl-start">
						<div>
							<p class="text-center">
								1155 Union Cir, <br>Denton, <br>Texas
							</p>
						</div>
					</div>
				</div>
			</div>
			<div
				class="col-2 d-xl-flex justify-content-xl-center align-items-xl-center">
				<img class="float-right"
					src="<%=request.getContextPath()%>/PaymentReceiptResources/assets/img/icon.jpg"
					style="width: 136px; margin-right:2%">
			</div>
		</div>
		<hr>
		<div class="row" style="margin-top: 52px;">
			<div class="col">
				

				<p id="name" style="font-size: 18px;">
					<strong>Name :&nbsp;</strong><%=((PaymentStatusVO) session.getAttribute("paymentVO")).getUdvo().getApplicationFormVO()
					.getFirstName()%>&nbsp;&nbsp;<%=((PaymentStatusVO) session.getAttribute("paymentVO")).getUdvo().getApplicationFormVO()
					.getLastName()%></p>

				<p id="applicationid" style="font-size: 18px;">
					<strong>Application ID :&nbsp;</strong><%=((PaymentStatusVO) session.getAttribute("paymentVO")).getUdvo().getApplicationFormVO()
					.getApplicationNo()%></p>

				<p id="email" style="font-size: 18px;">
					<strong>Email Id :&nbsp;</strong><%=((PaymentStatusVO) session.getAttribute("paymentVO")).getUdvo().getApplicationFormVO().getEmail()%>
				</p>

				<p id="paymentdate" style="font-size: 18px;">
					<strong>Payment Date :&nbsp;</strong><%=java.time.LocalDate.now()%>
				</p>



				<!-- <p id="paymentid" style="font-size: 18px;"><strong>Payment ID :&nbsp;</strong></p> -->

				<p id="totalfees" style="font-size: 18px;">
					<strong>Total Fees&nbsp; :&nbsp;</strong>4000
				</p>

				<!-- <p id="latepaymentcharges" style="font-size: 18px;"><strong>Late Payment Charges :&nbsp;</strong></p> -->

				<p id="paidamount" style="font-size: 18px;">
					<strong>Paid Amount :&nbsp;</strong>4000
				</p>

				<p id="blocknumber" style="font-size: 18px;">
					<strong>Block Number :&nbsp;</strong><%=((PaymentStatusVO) session.getAttribute("paymentVO")).getRoomVO().getBlockNo()%>
				</p>

				<p id="roomnumber" style="font-size: 18px;">
					<strong>Room Number :&nbsp;</strong><%=((PaymentStatusVO) session.getAttribute("paymentVO")).getRoomVO().getRoomNO()%>
				</p>
			</div>
		</div>
		<hr>
		<div class="row">
			<div
				class="col d-xl-flex justify-content-xl-center align-items-xl-center">
				<h1 style="font-size: 25px;">Thanks For Payment</h1>
			</div>
		</div>
		<hr>
	</div>
	<script src="assets/js/jquery.min.js"></script>
	<script src="assets/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>