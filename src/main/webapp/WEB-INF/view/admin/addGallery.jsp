<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="f" uri="http://java.sun.com/jstl/core_rt"%>
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

<script>
function fileValidation()
{
    var fileInput = document.getElementById('file');
    var filePath = fileInput.value;
    var allowedExtensions = /(\.jpg|\.jpeg|\.png)$/i;
    if(!allowedExtensions.exec(filePath))
    {
        alert('Please upload file having extensions .jpeg/.jpg/.png only.');
        fileInput.value = '';
        return false;
    }
    else
    {
        //Image preview
         if (fileInput.files.length > 0) 
        { 
                for (const i = 0; i <= fileInput.files.length - 1; i++)
                { 

                    const fsize = fileInput.files.item(i).size; 
                    const file = Math.round((fsize / 1024)); 
                    // The size of the file. 
                    if (file > 5120) { 
                        alert( 
                          "File too Big, please select a file less than 5mb");
                        return false;
                    }
                   
                } 
         } 

        
        if (fileInput.files && fileInput.files[0]) 
        {
            var reader = new FileReader();
            reader.onload = function(e) {
                document.getElementById('imagePreview').innerHTML = '<img src="'+e.target.result+'"/>';
            };
            reader.readAsDataURL(fileInput.files[0]);
        }   
               
        return true;
    }
   
}

</script>

</head>

<body>
	<div class="loader"></div>
	<div id="app">
		<div class="main-wrapper main-wrapper-1">
			<div class="navbar-bg"></div>



			<jsp:include page="header.jsp"></jsp:include>



			<jsp:include page="menu.jsp"></jsp:include>



			<!-- Main Content -->
			<s:form action="insertGallery" modelAttribute="galleryvo"
				method="post" enctype="multipart/form-data">
				<div class="main-content">
					<section class="section">
						<div class="section-body">
							<div class="row">
								<div class="col-12 col-md-12 col-lg-12" >
									<div class="card">
										<form class="needs-validation" novalidate="">
											<div class="card-header">
												<h4 style="font-family:cursive;font-size: 30px;color: blue;;margin-left:43%">Add Photo</h4>
											</div>
											<div class="card-body ">
												<div class="form-group ">

													<label>Type of Gallery</label>
													<s:select path="galleryType" class="form-control">
														<s:option value="Room Photos" class="form-control">Room Photos</s:option>
														<s:option value="Hostel Photos" class="form-control">Hostel Photos</s:option>
														<s:option value="Mess Photos" class="form-control">Mess Photos</s:option>
													</s:select>

												</div>

												<div class="form-group mb-0">
													<label>Add Photo</label> <input type="file" name="pics"
														id="file" onchange="return fileValidation()"
														class="form-control" required="" />
													<!-- <div class="invalid-feedback">What's your name?</div> -->
												</div>

                                          	</div>
											<div class="card-footer text-center">
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
		<section>	<jsp:include page="footer.jsp"></jsp:include></section>
	
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