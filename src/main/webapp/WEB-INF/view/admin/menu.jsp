
<div class="main-sidebar sidebar-style-2">
	<aside id="sidebar-wrapper">
		<div class="sidebar-brand">
			<a href="index"> <img alt="image"
				src="<%=request.getContextPath()%>/adminResources/image/logo.png" class="header-logo" /> <span
				class="logo-name">HMS ADMIN</span>
			</a>
		</div>
		<ul class="sidebar-menu">
			<li class="menu-header">Main</li>
			<li class="dropdown active"><a href="index"
				class="nav-link"><i data-feather="home"></i><span>Dashboard</span></a>
			</li>	
			<!-- <li class="dropdown"><a href="#"
				class="menu-toggle nav-link has-dropdown"><i
					data-feather="compass"></i><span>Manage City</span></a>
				<ul class="dropdown-menu">
					<li><a class="nav-link" href="loadInsertCity">Add  City</a></li>
					<li><a class="nav-link" href="viewCity">View City</a></li>
				</ul></li>	 -->
			<li class="dropdown"><a href="#"
				class="menu-toggle nav-link has-dropdown"><i
					data-feather="home"></i><span>Manage Room Data</span></a>
				<ul class="dropdown-menu">
					<li><a class="nav-link" href="loadAddRoom">Add Rooms</a></li>
					<li><a class="nav-link" href="viewRoom">View Rooms</a></li>
				</ul></li>
			<li class="dropdown"><a href="loadAdmissionControl"
				class="nav-link"><i data-feather="sliders"></i><span>Control Admission Round</span></a>
			</li>	
			<li class="dropdown"><a href="#"
				class="menu-toggle nav-link has-dropdown"><i
					data-feather="image"></i><span>Gallery</span></a>
				<ul class="dropdown-menu">
					<li><a class="nav-link" href="loadAddGallery">Add Photos
							</a></li>
					<li><a href="viewGallery">View photos</a></li>
				</ul>
			</li>
			<li class="dropdown"><a href="#"
				class="menu-toggle nav-link has-dropdown"><i
					data-feather="send"></i><span>Broadcast Message</span></a>
				<ul class="dropdown-menu">
					<li><a class="nav-link" href="loadBroadCastMessage">Send Message</a></li>
					<!-- <li><a href="viewBroadcastMessage">View Broadcast Messages</a></li> -->
				</ul>
			</li>
	     </ul>
	</aside>
</div>
