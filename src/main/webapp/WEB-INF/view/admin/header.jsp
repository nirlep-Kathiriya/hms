<%@page import="com.hms.utils.Basemethods"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<nav class="navbar navbar-expand-lg main-navbar sticky">
	<div class="form-inline mr-auto">
		<ul class="navbar-nav mr-3">
			<li><a href="#" data-toggle="sidebar"
				class="nav-link nav-link-lg
									collapse-btn"> <i
					data-feather="align-justify"></i></a></li>
			<li><a href="#" class="nav-link nav-link-lg fullscreen-btn">
					<i data-feather="maximize"></i>
			</a></li>
			
		</ul>
	</div>
	<ul class="navbar-nav navbar-right">
		<li class="dropdown dropdown-list-toggle"><a href="#"
			data-toggle="dropdown" class="nav-link nav-link-lg message-toggle"><i
				data-feather="mail"></i> <!-- <span class="badge headerBadge1"> 6
			</span> --> </a>
			<div class="dropdown-menu dropdown-list dropdown-menu-right pullDown">
				<div class="dropdown-header">
					Complaints
				</div>
				<div class="dropdown-list-content dropdown-list-message">
				    <c:forEach items="${listOfComplaint}" var="loc">
					<a href="#" class="dropdown-item"> <span
						class="dropdown-item-avatar
											text-white"> <img
							alt="image" src="<%=request.getContextPath()%>/adminResources/image/user-1.png"
							class="rounded-circle">
					</span> <span class="dropdown-item-desc"> <span
							class="message-user">${loc.name}</span> <span
							class="time messege-text">${loc.complaint }</span> <span
							class="time">${loc.t}</span>
					</span>
					</a> 
					</c:forEach>
					
				</div>
				<div class="dropdown-footer text-center">
					<a href="viewComplaint">View All<i class="fas fa-chevron-right"></i></a>
				</div>
			</div></li>

		<li class="dropdown"><a href="#" data-toggle="dropdown"
			class="nav-link dropdown-toggle nav-link-lg nav-link-user"> <img
				alt="image" src="<%=request.getContextPath()%>/adminResources/image/user.png"
				class="user-img-radious-style"> <span
				class="d-sm-none d-lg-inline-block"></span></a>
			<div class="dropdown-menu dropdown-menu-right pullDown">
				<div class="dropdown-title"><%=Basemethods.getUser()%></div>
				<a href="loadAdminEditProfile" class="dropdown-item has-icon"> <i
					class="farfa-user"></i> Profile
				</a> 
				<div class="dropdown-divider"></div>
				<a href="/logout" class="dropdown-item has-icon text-danger">
					<i class="fas fa-sign-out-alt"></i> Logout
				</a>
			</div></li>
	</ul>
</nav>
