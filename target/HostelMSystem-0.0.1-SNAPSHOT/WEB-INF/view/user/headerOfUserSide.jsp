
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %> 
 <nav class="navbar navbar-light navbar-expand-md sticky-top shadow navigation-clean-button"
        style="background-color: rgb(20, 133, 238); height: 65px;">
        <div class="container-fluid">

            <div id="main">
                <button class="openbtn" onclick="openNav()">&#9776; Hostel</button>
            </div>
           <div id="main">
                <a href="/logout"><button class="btn btn-light" type="button">Sign Out <i class="fa fa-sign-out"></i> </button></a>
            </div>
           
        
        </div>
    </nav>

    <div id="mySidebar" class="sidebar">
        <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
        <a href="index"><i class="fa fa-dashboard"></i>Dashboard</a>
        
        <a <c:if test="${addmissionStatus eq true}">href="loadApplicationForm"</c:if>
		   <c:if test="${addmissionStatus eq false}">href="" onclick="admissionOFF()"</c:if>
		><i class="fa fa-user"></i> Apply As Freshers</a>
        
        <a 
           <c:if test="${addmissionStatus eq true}">href="loadRegularForm"</c:if>
		   <c:if test="${addmissionStatus eq false}">href="" onclick="admissionOFF()"</c:if>
        ><i class="fa fa-user"></i>   Apply As Regular</a>
        
        <a 
           <c:if test="${addmissionStatus eq true}">href="loadApplicationNumberVerify"</c:if>
		   <c:if test="${addmissionStatus eq false}">href="" onclick="admissionOFF()"</c:if>
        ><i class="fa fa-file-pdf-o"></i>   Upload Document Of Fresher</a>
        
        
        <a href=""  data-toggle="modal" data-target="#pop"><i class="fab fa-telegram-plane"></i>Complaint</a>
        
        <a href="loadMessPage"><i class="fa fa-spoon"></i> Mess</a>
        
        <a 
           <c:if test="${addmissionStatus eq true}">href="loadPayFees"</c:if>
		   <c:if test="${addmissionStatus eq false}">href="" onclick="admissionOFF()"</c:if>
        ><i class="fa fa-money"></i>   Fee Payment</a>
        
        <a href="loadEditProfile"><i class="fa fa-edit"></i>   Profile</a>
        
        
        <a href="/logout">  Sign Out</a>
    </div>
    
     <!--Pop up for comlaint  -->
				<div class="modal fade border-primary" role="dialog" tabindex="-1"
					id="pop">
					<form class="text-monospace d-block" style="margin: default;" action="insertComplaint" method="post">
					<div class="modal-dialog modal-dialog-centered" role="document">
						<div class="modal-content">
							<div class="modal-header d-md-flex justify-content-md-center">
								<h4
									class="modal-title text-center d-md-flex justify-content-center align-items-center ml-auto justify-content-md-center align-items-md-center">Enter
									Your Complaint</h4>
								<button type="button" class="close" data-dismiss="modal"
									aria-label="Close">
									<span id="see" aria-hidden="true">×</span>
								</button>
							</div>
							<div class="modal-body">
							  
								<textarea class="form-control" placeholder="Complaint"
									id="complaint" required="" name="complaint"></textarea>
								<br>
							</div>
							<div
								class="modal-footer d-md-flex justify-content-md-center align-items-md-center">
								<button data-toggle="modal" data-target="#pop2"
									class="btn btn-primary d-md-flex justify-content-md-center align-items-md-center"
									type="submit">Submit</button>
							</div>
						</div>
					</div>
					</form>
				</div>
				

				