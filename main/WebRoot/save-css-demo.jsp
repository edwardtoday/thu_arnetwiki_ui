 <html>
	<head>
	<link rel="stylesheet" type="text/css" href="index.css">
	<script type="text/javascript" src="jquery.js"></script>
	<script type="text/javascript" src="interface.js"></script>
	<script type="text/javascript" src="main.js"></script>
	<script type="text/javascript" src="getXmlHttp.js"></script>
	<style>
		#show {
		background:#ffff66;
		font-size:12px;
		height:20px;
		width:100px;
		left:450px;
		position:absolute;
		text-align:center;
		filter:alpha(opacity=0);
		color: grey;
		font-weight: bold;
		}
	</style>
	</head>	
	<body>
	    <!-- outerframe ---------------------------------------------------------------------------->
		<div id='outerframe'>
			<!-- mainframe ------------------------------------------------------------------------->
			<div id='mainframe'>
				<!-- mainlogo ---------------------------------------------------------------------->
				<div id="mainlogo">
					<a href="index.jsp"><img width="135" height="135" alt="logo" src="logo2.png"/></a>
				</div>
				
				<!-- topbar ------------------------------------------------------------------------>
				 <div id="topbar">
				    <div id="show" style="">
						    layout saved!
						</div>
					<p>
<%--						<input type=button id="bt" onClick="loadLayout();" value="LoadLayout">--%>
<%--						<input type=button id="bt" onClick="saveLayout();" value="SaveLayout">--%>
						<a href="" id='login'>Login</a>&nbsp/
						<a href="" id='signup'>Sign up</a>
					</p>
				</div>
				
				<!-- navegation new add! ----------------------------------------------------------->
				<div id="navegation"><ul lang="en" xml:lang="en">
					<li class="selected"><a href="">Term</a></li>
					<li><a href="">People</a></li>
					<li><a href="">Role</a></li>
				</ul></div>
				
				<!-- wiki-content : class='groupWrapper' ------------------------------->
				 <div id='wiki-content'class="groupWrapper">
					
					 <div id='wiki-id' style="display:none">
						the-wiki-id
					 </div>
					 <div id='wiki-type' style="display:none">
						 <!-- wiki-type:invisible -->
					 </div>
					 
					<!-- keyword ---------------------------------------------------------------->
					<div id="keyword" class="groupItem" style="width:200px;">
						<div class="itemHeader">Keyword</div>
						<div class="itemContent">
							content
						</div>
					</div>
					
					<!-- definition ---------------------------------------------------------------->
					<div id="definition" class="groupItem">
						<div class="itemHeader">Definition<a href="#" class="closeEl">[-]</a></div>
						<div class="itemContent">
							content
						</div>
					</div>
					<!-- conferences -------------------------------------------------------------->
					<div id="conferences" class="groupItem">
						<div class="itemHeader">Conferences<a href="#" class="closeEl">[-]</a></div>
						<div class="itemContent">
							content
						</div>
					</div>
					<!-- papers ------------------------------------------------------------------->
					<div id="papers" class="groupItem">
						<div class="itemHeader">Papers<a href="#" class="closeEl">[-]</a></div>
						<div class="itemContent">
							content
						</div>
					</div>
					<!-- people ------------------------------------------------------------------->
					<div id="people" class="groupItem">
						<div class="itemHeader">People<a href="#" class="closeEl">[-]</a></div>
						<div class="itemContent">
							content
						</div>
					</div>
					<!-- institutions ------------------------------------------------------------->
					<div id="institutions" class="groupItem">
						<div class="itemHeader">Institutions<a href="#" class="closeEl">[-]</a></div>
						<div class="itemContent">
							content
						</div>
					</div>
					<!-- dataset ------------------------------------------------------------------>
					<div id="dataset" class="groupItem">
						<div class="itemHeader">Dataset<a href="#" class="closeEl">[-]</a></div>
						<div class="itemContent">
							content
						</div>
					</div>
				 </div>
			 </div>
		 </div>
		 
		 <!-- bottom manu ------------------------------------------------------------------------->
		 <div id="bottom">
			<ul lang="en" xml:lang="en">
			(c) ArnetWiki &nbsp &nbsp
			<li><a accesskey="t" title="" href="">About</a></li>
			<li><a accesskey="t" title="" href="">Contact</a></li>
			<li><a accesskey="t" title="" href="">Help</a></li>
			</ul>
		</div>
	 </body>
 </html>