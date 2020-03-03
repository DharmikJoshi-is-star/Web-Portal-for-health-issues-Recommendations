<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Portal for health issuse</title>

<script src='https://kit.fontawesome.com/a076d05399.js'></script>

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<!-- 
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"> -->
<!--   <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script> -->
<!-- <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script> -->



<style type="text/css">
html {
	overflow: scroll;
	overflow-x: hidden;
}

  



.pink-textarea textarea.md-textarea:focus:not([readonly]) {
  border-bottom: 1px solid #f48fb1;
  box-shadow: 0 1px 0 0 #f48fb1;
}
.active-pink-textarea.md-form label.active {
  color: #f48fb1;
}
.active-pink-textarea.md-form textarea.md-textarea:focus:not([readonly])+label {
  color: #f48fb1;
}


.amber-textarea textarea.md-textarea:focus:not([readonly]) {
  border-bottom: 1px solid #ffa000;
  box-shadow: 0 1px 0 0 #ffa000;
}
.active-amber-textarea.md-form label.active {
  color: #ffa000;
}
.active-amber-textarea.md-form textarea.md-textarea:focus:not([readonly])+label {
  color: #ffa000;
}


.active-pink-textarea-2 textarea.md-textarea {
  border-bottom: 1px solid #f48fb1;
  box-shadow: 0 1px 0 0 #f48fb1;
}
.active-pink-textarea-2.md-form label.active {
  color: #f48fb1;
}
.active-pink-textarea-2.md-form label {
  color: #f48fb1;
}
.active-pink-textarea-2.md-form textarea.md-textarea:focus:not([readonly])+label {
  color: #f48fb1;
}


.active-amber-textarea-2 textarea.md-textarea {
  border-bottom: 1px solid #ffa000;
  box-shadow: 0 1px 0 0 #ffa000;
}
.active-amber-textarea-2.md-form label.active {
  color: #ffa000;
}
.active-amber-textarea-2.md-form label {
  color: #ffa000;
}
.active-amber-textarea-2.md-form textarea.md-textarea:focus:not([readonly])+label {
  color: #ffa000;
}
::-webkit-scrollbar {
	width: 0px; /* Remove scrollbar space */
	background: transparent; /* Optional: just make scrollbar invisible */
}
/* Optional: show position indicator in red */
::-webkit-scrollbar-thumb {
	background: #FF0000;
}

body {
	font-family: "Calibri", Times, serif;
}

.search-form {
	border-radius: 30px 0px 0px 30px;
	/*border-radius: Top-left, Top-right, Bottom-right, Bottom-left;*/
}

#more {
	display: none;
}
.button:hover::before {
	color: #fff;
}

.button:hover::after {
	color: #000;
}

.modal{
	margin-top: 50px;
}

.card {
	padding-top: 20px;
	margin: 10px 0 20px 0;
	background-color: rgba(214, 224, 226, 0.2);
	border-top-width: 0;
	border-bottom-width: 2px;
	-webkit-border-radius: 3px;
	-moz-border-radius: 3px;
	border-radius: 3px;
	-webkit-box-shadow: none;
	-moz-box-shadow: none;
	box-shadow: none;
	-webkit-box-sizing: border-box;
	-moz-box-sizing: border-box;
	box-sizing: border-box;
}

.card .card-heading {
	padding: 0 20px;
	margin: 0;
}

.card .card-heading.simple {
	font-size: 20px;
	font-weight: 300;
	color: #777;
	border-bottom: 1px solid #e5e5e5;
}

.card .card-heading.image img {
	display: inline-block;
	width: 46px;
	height: 46px;
	margin-right: 15px;
	vertical-align: top;
	border: 0;
	-webkit-border-radius: 50%;
	-moz-border-radius: 50%;
	border-radius: 50%;
}

.card .card-heading.image .card-heading-header {
	display: inline-block;
	vertical-align: top;
}

.card .card-heading.image .card-heading-header h3 {
	margin: 0;
	font-size: 14px;
	line-height: 16px;
	color: #262626;
}

.card .card-heading.image .card-heading-header span {
	font-size: 12px;
	color: #999999;
}

.card .card-body {
	padding: 0 20px;
	margin-top: 20px;
}

.card .card-media {
	padding: 0 20px;
	margin: 0 -14px;
}

.card .card-media img {
	max-width: 100%;
	max-height: 100%;
}

.card .card-actions {
	min-height: 30px;
	padding: 0 20px 20px 20px;
	margin: 20px 0 0 0;
}

.card .card-comments {
	padding: 20px;
	margin: 0;
	background-color: #f8f8f8;
}

.card .card-comments .comments-collapse-toggle {
	padding: 0;
	margin: 0 20px 12px 20px;
}

.card .card-comments .comments-collapse-toggle a, .card .card-comments .comments-collapse-toggle span
	{
	padding-right: 5px;
	overflow: hidden;
	font-size: 12px;
	color: #999;
	text-overflow: ellipsis;
	white-space: nowrap;
}

.card-comments .media-heading {
	font-size: 13px;
	font-weight: bold;
}

.card.people {
	position: relative;
	display: inline-block;
	width: 170px;
	height: 300px;
	padding-top: 0;
	margin-left: 20px;
	overflow: hidden;
	vertical-align: top;
}

.card.people:first-child {
	margin-left: 0;
}

.card.people .card-top {
	position: absolute;
	top: 0;
	left: 0;
	display: inline-block;
	width: 170px;
	height: 150px;
	background-color: #ffffff;
}

.card.people .card-top.green {
	background-color: #53a93f;
}

.card.people .card-top.blue {
	background-color: #427fed;
}

.card.people .card-info {
	position: absolute;
	top: 150px;
	display: inline-block;
	width: 100%;
	height: 101px;
	overflow: hidden;
	background: #ffffff;
	-webkit-box-sizing: border-box;
	-moz-box-sizing: border-box;
	box-sizing: border-box;
}

.card.people .card-info .title {
	display: block;
	margin: 8px 14px 0 14px;
	overflow: hidden;
	font-size: 16px;
	font-weight: bold;
	line-height: 18px;
	color: #404040;
}

.card.people .card-info .desc {
	display: block;
	margin: 8px 14px 0 14px;
	overflow: hidden;
	font-size: 12px;
	line-height: 16px;
	color: #737373;
	text-overflow: ellipsis;
}

.card.people .card-bottom {
	position: absolute;
	bottom: 0;
	left: 0;
	display: inline-block;
	width: 100%;
	padding: 10px 20px;
	line-height: 29px;
	text-align: center;
	-webkit-box-sizing: border-box;
	-moz-box-sizing: border-box;
	box-sizing: border-box;
}

.card.hovercard {
	position: relative;
	padding-top: 0;
	overflow: hidden;
	text-align: center;
	background-color: rgba(214, 224, 226, 0.2);
}

.card.hovercard .cardheader {
	background: url("back.png");
	background-size: cover;
	height: 135px;
}

.card.hovercard .avatar {
	position: relative;
	top: -50px;
	margin-bottom: -50px;
}

.card.hovercard .avatar img {
	width: 100px;
	height: 100px;
	max-width: 100px;
	max-height: 100px;
	-webkit-border-radius: 50%;
	-moz-border-radius: 50%;
	border-radius: 50%;
	border: 5px solid rgba(255, 255, 255, 0.5);
}

.card.hovercard .info {
	padding: 4px 8px 10px;
}

.card.hovercard .info .title {
	margin-bottom: 4px;
	font-size: 24px;
	line-height: 1;
	color: #262626;
	vertical-align: middle;
}

.card.hovercard .info .desc {
	overflow: hidden;
	font-size: 12px;
	line-height: 20px;
	color: #737373;
	text-overflow: ellipsis;
}

.card.hovercard .bottom {
	padding: 0 20px;
	margin-bottom: 17px;
}

.navbar{
	position: fixed;
	top: 0;
	left: 0;
	z-index: 9999;
	width: 100%;
	height: 53px;
	color: #fff;
	
}	



.recommend{
	position: fixed;
	right: 0;
}


</style>

</head>
<body>
	<!-- ###################################################################################################### -->

	<div class="container-fluid">
		<nav class="navbar navbar-inverse">
			<div class="container-fluid">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse"
						data-target="#myNavbar">
						<span class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="#">HashCoder</a>
				</div>

				<div class="collapse navbar-collapse container-fluid" id="myNavbar">
					<ul class="nav navbar-nav align-content-center">
						<li class="active nav nav-item"><a href="#"><span
								class="glyphicon glyphicon-home"> Home</a></li>
						<!--         <li class=" nav nav-item"><a href="#"><span class=" glyphicon glyphicon-edit"> Answer</a></li>
 -->
						<li class=" nav nav-item"><a data-toggle ="modal" data-target="#experiencemodal"><span
								class=" glyphicon glyphicon-book "> Experience&nbsp;&&nbsp;Tips</a></li>
						<!-- <li class=" nav nav-item"><a href="#"><span
								class=" glyphicon glyphicon-bullhorn"> Notification</a></li> -->
						<li class=" nav nav-item"><a 
							data-toggle="modal" data-target="#addquestionmodal"
							class="btn btn-toolbar btn-danger text text-light"><span
								class="button"> Add Question</span></a></li>
					</ul>

					<ul class="nav navbar-nav navbar-right">



<!-- Experience and tip modal -->

<!-- Modal -->
  <div class="modal fade" id="experiencemodal" role="dialog" style="color: #000;">
    <div class="modal-dialog modal-lg">
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Experience $ Tips</h4>
        </div>
        <div class="modal-body">
        
        
            <div class="row ">
            
                <div class="col-md-4">
                    <i class="fas fa-user" style="font-size: 80px;"></i>
                </div>
                <div class="col-sm-6">
                    <h2>Anonymous </h2>
                    <h4>Avg Rating :</h4>
                </div>
                <div class="col-sm-2">
                    <button type="button" class="btn btn-success" style="margin-top: 30px;">Follow <span
								class="	glyphicon glyphicon-plus"></span></button>
                </div>
            </div>

            <div class="row">
                <!-- <h3 style="align-content: center;">What is Anxiety</h3> -->
                <p class="card-text panel-body">
						Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus
						imperdiet, nulla et dictum interdum, nisi lorem egestas vitae scel<span
							id="dots">...</span><span id="more">erisque enim ligula
							venenatis dolor. Maecenas nisl est, ultrices nec congue eget,
							auctor vitae massa. Fusce luctus vestibulum augue ut aliquet. Nunc
							sagittis dictum nisi, sed ullamcorper ipsum dignissim ac. In at
							libero sed nunc venenatis imperdiet sed ornare turpis. Donec vitae
							dui eget tellus gravida venenatis. Integer fringilla congue eros
							non fermentum. Sed dapibus pulvinar nibh tempor porta.</span>
					</p>
					<div>
						<a onclick="myFunction()" id="myBtn"
							class="btn  float-right panel-footer"
							style="background-color: transparent;">Read more <span
							class="glyphicon glyphicon-forward"></a>

					</div>
            </div>
            <div class="box">
                <a onclick="check(5)" value="1" class="ion-android-star b1"></a>
                <a onclick="check(4)" value="2" class="ion-android-star b2"></a>
                <a onclick="check(3)" value="3" class="ion-android-star b3"></a>
                <a onclick="check(2)" value="4" class="ion-android-star b4"></a>
                <a onclick="check(1)" value="5" class="ion-android-star b5"></a>
			
                 <style>
                    @import "http://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css";
.box{
    position: relative;
    /* top: 50%;
    left: 50%; */
    /* transform: translate(-50%,-50%); */
    direction: rtl;
   
}
.box a{
    font-size: 40px;
    color: #313131;
    transition: 0.3s all;
}
.box a:hover{
    color: #f1c40f;
}
.b1:hover ~ a{
    color: #f1c40f;
}
.b2:hover ~ a{
    color: #f1c40f;
}
.b3:hover ~ a{
    color: #f1c40f;
}
.b4:hover ~ a{
    color: #f1c40f;
}
.b5:hover ~ a{
    color: #f1c40f;
}
                </style>
               

<script>
    function check(value){
        var no=value;
    //    if(no<0){
            alert(no);
    }
        
        
    
</script>
            </div>

		
            
            
        </div>
        
        
        <div class="modal-footer">
          <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
        </div>
      </div>
    </div>
  </div>
<!-- end-->
<!-- Add Question Modal -->
				<div id="addquestionmodal" class="modal fade" role="dialog">
					<div class="modal-dialog">

						<!-- Modal content-->
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal">&times;</button>
								<h4 class="modal-title" style="color: #000;">Add Questions</h4>
							</div>
							<div class="modal-body">
								
								<div class="form-group">
								  <label for="sel1">Category: </label>
								  <select class="form-control" id="category">
								    <option>Anxiety</option>
								    <option>Obesity</option>
								  </select>
								</div>
								  <!-- <button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">Category
								  <span class="caret"></span></button>
								  <ul class="dropdown-menu">
								    <li><a href="#">HTML</a></li>
								    <li><a href="#">CSS</a></li>
								    <li><a href="#">JavaScript</a></li>
								  </ul> -->
								
								  <br><br>
								  <form method="post" action="addQuery?user_id=${user.getId() }">
										<div class=" md-form mb-4 pink-textarea active-pink-textarea">
										  <input name="queryField" id="form18" class="md-textarea form-control" rows="3" ></input>
										  <label for="form18">Type your question here</label>
										</div>
										<button type="submit" class="btn btn-danger">Submit</button>
								</form>
							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-default"
									data-dismiss="modal">Close</button>
							</div>
						</div>

					</div>
				</div>

				<!-- Modal End -->







						<!-- Login and signup  modal button  -->
						<!--  <li class=" nav nav-item"><a data-toggle="modal" data-target="#signupmodal"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>

        <li class=" nav nav-item"><a data-toggle="modal" data-target="#loginmodal"><span class="glyphicon glyphicon-log-in"></span> Login</a></li> -->


						<li class=" nav nav-item"><a href="#"><span
								class="	glyphicon glyphicon-off"></span> Logout</a></li>

						<!-- <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal">Open Registration Form</button>
 -->

					</ul>



				</div>
			</div>
		</nav>
		<hr>
	</div>
	<!-- ###################################################################################################### -->

	<div class="row container-fluid">
		<div class="col-md-3 ">
			<br>
			<center style="padding-top: 8px;">
				<strong><h3>User Profile</h3></strong>
			</center>
			<hr>
			<div class="card hovercard ">
				<div class="cardheader "></div>
				<div class="avatar">
					 <i class="fas fa-user" style="font-size: 80px;"></i>
					<!-- <img alt="" src="img.png"> -->
				</div>
				<div class="info">
					<div class="title">
						<h3>
							<span class="userprofilecss">${user.getName()}</span>
						</h3>
					</div>
					<div class="desc">${type}</div>
					
				</div>


				<div class="">
					<!-- <ul>
						<li>Following</li>
						<li>Total Answer</li>
						<li>Total Question</li>
						<li>Profile</li>
					</ul>glyphicon glyphicon-user
 -->

					<!-- <a data-toggle="modal" data-target="#myModal">Do I have
				an anxiety disorder? <span class="badge">12</span>
			</a> -->


					<ul class="list-group">
						<li
							class="list-group-item d-flex justify-content-between align-items-center"><a
							data-toggle="modal" data-target="#followingmodal">Following <span
								class="glyphicon glyphicon-user "></span> <span
								class="align-content-end badge badge-primary badge-pill">${user.getFollowing().size() }</span></a>
						</li>

						<li
							class="list-group-item d-flex justify-content-between align-items-center"><a
							data-toggle="modal" data-target="#followermodal">Followers <span
								class="glyphicon glyphicon-globe "></span> <span
								class="align-content-end badge badge-primary badge-pill">${user.getFollowers().size()}</span></a>
						</li>

						<li
							class="list-group-item d-flex justify-content-between align-items-center"><a
							data-toggle="modal" data-target="#answermodal"> <span>Answers</span>
								<span class="	glyphicon glyphicon-edit "> </span> <span
								class="badge badge-primary badge-pill">${user.getAnswers().size() }</span></a></li>

						<li
							class="list-group-item d-flex justify-content-between align-items-center">
							<a data-toggle="modal" data-target="#questionmodal"><span>Question</span>
								<span class="glyphicon glyphicon-question-sign "></span> <span
								class="badge badge-primary badge-pill">${user.getQueries().size() }</span></a>
						</li>

						<li
							class="list-group-item d-flex justify-content-between align-items-center">
							<a data-toggle="modal" data-target="#postmodal"><span>Add Experience & Tips</span>
								<span class="	glyphicon glyphicon-pencil "></span> <span
								class="badge badge-primary badge-pill">${user.getPosts().size() }</span></a>
						</li>

					</ul>

				</div>

					
				<!-- followers Modal -->
				<div id="followermodal" class="modal fade" role="dialog">
					<div class="modal-dialog">
					
						<!-- Modal content-->
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal">&times;</button>
								<h4 class="modal-title">Followers</h4>
							</div>
							<div class="modal-body pre-scrollable">
								<div class="form-group">

								<c:forEach items="${user.getFollowers() }" var="follower">
										<!-- card -->
										<div class="card mb-3" style="max-width: 540px;">
											<div class="row ">
												<div class="col-sm-4">
													<!-- <img src="back.png" class="card-img" alt="..."> -->
													<div>
														<i class="fa fa-user-md" style="font-size: 40px;padding-bottom: 20px;"></i>
													</div>
	
												</div>
												<div class="col-sm-4 ">
	
													<h4 class="card-title" align="left"
														style="align-items: left; padding-left: 10px;">${follower.getName() }</h4>
	
	
												</div>
												<div class="col-sm-4 ">
	
	
													<a href="follow-user?user_id=${user.getId()}&otherUser_id=${follower.getId()}"  style="padding-left: 5px;"><span class="glyphicon glyphicon-globe "></span>
														Follow</a> &nbsp; <span class="glyphicon glyphicon-star"
														style="padding-top: 10px;">Rating<span class="badge">${follower.getRating()}</span></span>
												</div>
	
											</div>
										</div>
										<!-- card end -->
									
									</c:forEach>
								</div>

							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-danger"
									data-dismiss="modal">Close</button>
							</div>
						</div>

					</div>
				</div>

				<!-- Modal End -->

				<!-- followering Modal -->
				<div id="followingmodal" class="modal fade" role="dialog">
					<div class="modal-dialog">

						<!-- Modal content-->
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal">&times;</button>
								<h4 class="modal-title">Following</h4>
							</div>
							<div class="modal-body pre-scrollable">
								<div class="form-group">

								<c:forEach items="${user.getFollowing() }" var="following">
									<!-- card -->
									<div class="card mb-3" style="max-width: 540px;">
										<div class="row ">
											<div class="col-sm-4">
												<!-- <img src="back.png" class="card-img" alt="..."> -->
												<div>
													<i class="fa fa-user-md" style="font-size: 40px;padding-bottom: 20px;"></i>
												</div>

											</div>
											<div class="col-sm-4 ">

												<h4 class="card-title" align="left"
													style="align-items: left; padding-left: 10px;">${following.getName() }</h4>


											</div>
											<div class="col-sm-4 ">


											<span class="glyphicon glyphicon-star"
													style="padding-top: 10px;">Rating<span class="badge">${following.getRating() }</span></span>
											</div>

										</div>
									</div>
									<!-- card end -->
								</c:forEach>
								</div>

							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-danger"
									data-dismiss="modal">Close</button>
							</div>
						</div>

					</div>
				</div>

				<!-- Modal End -->



				<!-- question Modal -->
				<div id="questionmodal" class="modal fade" role="dialog">
					<div class="modal-dialog">

						<!-- Modal content-->
						<div class="modal-content pre-scrollable">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal">&times;</button>
								<h4 class="modal-title">Question</h4>
							</div>
							
							<c:forEach items="${user.getQueries() }" var="queryByUser">
							<div class="modal-body">
								<h3 class="panel-heading card-danger card-title">
					<strong>${queryByUser.getQuery() } </strong>
				</h3>
				
				
				
				<c:forEach items="${ queryByUser.getAnswers()}" var="ans">
				average rating : ${ans.getAvg_rating() } 
						<p class="card-text panel-body">
							 ${ ans.getAnswer()} <span
								id="dots0${ans.getId() }">...</span><span id="more0${ans.getId() }">
								 ${ ans.answer} </span>
		
						</p>
						<div>
							<a onclick="myFunction(dots0${ans.getId() },more0${ans.getId() },myBtn0${ans.getId() })" id="myBtn0${ans.getId() }"
								class="btn  float-right panel-footer"
								style="background-color: transparent;">Read more <span class="glyphicon glyphicon-forward"></span></a>
							
							<a data-toggle="modal"
								data-target="#answer">Next Answer
							</a>
		
						</div>
						
				</c:forEach>
				
							</div>
							
							</c:forEach>
							<div class="modal-footer">
								<button type="button" class="btn btn-default"
									data-dismiss="modal">Close</button>
							</div>
						</div>

					</div>
				</div>

				<!-- Modal End -->


				<!-- answers Modal -->
				<div id="answermodal" class="modal fade" role="dialog">
					<div class="modal-dialog">

						<!-- Modal content-->
						<div class="modal-content pre-scrollable">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal">&times;</button>
								<h4 class="modal-title">Answer By User</h4>
							</div>
							
							<c:forEach items="${user.getAnswers() }" var="ans">
							
							<div class="modal-body">
								<h3 class="panel-heading card-danger card-title">
								
						<%-- <strong>${queryDB.getQueryByUserId(ans.getUser_id()).getQuery() }</strong>  --%>
								
					</h3>
					<p class="card-text panel-body">
						${ ans.getAnswer()}<span
							id="dots1${ans.getId() }">...</span><span id="more1${ans.getId() }">${ ans.getAnswer()}</span>
					</p>
					<div>
						<a onclick="myFunction(dots1${ans.getId() },more1${ans.getId()},  myBtn1${ans.getId() })" id="myBtn1${ans.getId() }"
							class="btn  float-right panel-footer"
							style="background-color: transparent;">Read more <span class="glyphicon glyphicon-forward"></span></a>

					</div>
								</div>
								
								</c:forEach>
								
								<div class="modal-footer">
									<button type="button" class="btn btn-danger"
										data-dismiss="modal">Close</button>
								</div>
							</div>

						</div>
					</div>

				<!--  End -->
				<!-- post Modal -->
				<div id="postmodal" class="modal fade" role="dialog">
					<div class="modal-dialog">

						<!-- Modal content-->
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal">&times;</button>
								<h4 class="modal-title">Add Experience and Tips</h4>
							</div>
							<div class="modal-body">
								<form action="uploadPost?user_id=${user.getId()}" method="post">
								<div class="form-group">
								  <label for="sel1">Category: </label>
								  <select class="form-control" name="category" id="category">
								    <option>Anxiety</option>
								    <option>Obesity</option>
								  </select>
								</div>
								  <!-- <button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">Category
								  <span class="caret"></span></button>
								  <ul class="dropdown-menu">
								    <li><a href="#">HTML</a></li>
								    <li><a href="#">CSS</a></li>
								    <li><a href="#">JavaScript</a></li>
								  </ul> -->
								
								  <br><br>
								<div class=" md-form mb-4 pink-textarea active-pink-textarea">
								  <textarea id="form18" name="postData" class="md-textarea form-control" rows="3" ></textarea>
								  <label for="form18">Type Experience and tips</label>
								</div>
								<button type="submit" class="btn btn-danger">Submit</button>
								</form>
							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-default"
									data-dismiss="modal">Close</button>
							</div>
						</div>

					</div>
				</div>

				<!-- Modal End -->

				<div class="bottom">
					<h3>
						<span class="glyphicon glyphicon-star"> Rating ${user.getRating() }
					</h3>
				</div>
			</div>

		</div>


		<div class="col-md-6">
			<br>
			<center><strong><h2>Question and Answer</h2></strong></center>
			<hr>

<!-- 			<div class="input-group card-body">
				<input type="text" class="form-control search-form"
					placeholder="Search Question"> <span
					class="input-group-btn">
					<button type="submit" class="btn search-btn "
						data-target="#search-form" name="q">
						  <span	class="	glyphicon glyphicon-search"></span> Search
						</i>
					</button>
				</span>
			</div>
 -->
			<h3>
				 <span class="label label-primary">Latest</span> Questions
			</h3>
			
			<hr>

			

			<br>
			
			<div class=" panel panel-danger card-body pre-scrollable"
				style="height: 100%; width: 100%; overflow: scroll; overflow-x: hidden; overflow-y: scroll;">
				<c:forEach items="${queries}" var="query">

				<h3 class="panel-heading card-danger card-title">
					${query.getQuery()}  
				</h3>
				<c:set var="c" value="0"></c:set>
				
				<c:forEach items="${query.getAnswers() }" var="ans">
						<c:if test="${c == 0 }">
						
						<c:set var="c" value="1"></c:set>
							<p class="card-text panel-body">
								${ans.getAnswer()}<span
									id="dots2${ans.getId()}">...</span><span id="more2${ans.getId()}">${ans.getAnswer()}</span>
							</p>
							<div>
								<a onclick="myFunction(dots2${ans.getId()}, more2${ans.getId()}, myBtn2${ans.getId()})" id="myBtn2${ans.getId()}"
									class="btn  float-right panel-footer"
									style="background-color: transparent;">Read more <span
									class="glyphicon glyphicon-forward"></a> 
								<a data-toggle="modal"
									data-target="#myModal1" class="btn  float-left panel-footer"
									style="background-color: transparent;">Answer <span
									class="	glyphicon glyphicon-pencil"></a> 
								<a data-toggle="modal"
									data-target="#answer">Total Answer<span class="badge">${query.getAnswers().size() }</span>
								</a>
								&nbsp;&nbsp;&nbsp;
								Rate answer: 
								<a href="rate-answer?user_id=${user.getId()}&answer_id=${ans.getId()}&rating=1">1</a>
								<a href="rate-answer?user_id=${user.getId()}&answer_id=${ans.getId()}&rating=2">2</a>
								<a href="rate-answer?user_id=${user.getId()}&answer_id=${ans.getId()}&rating=3">3</a>
								<a href="rate-answer?user_id=${user.getId()}&answer_id=${ans.getId()}&rating=4">4</a>
								<a href="rate-answer?user_id=${user.getId()}&answer_id=${ans.getId()}&rating=5">5</a>
							</div>
						</c:if>
						</c:forEach>
				
				<!-- </a><br> <a data-toggle="modal" data-target="#myModal">Do I have
				an anxiety disorder? <span class="badge">12</span>
			</a> -->
			<!-- Modal -->
	<div id="myModal1" class="modal fade" role="dialog">
		<div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">Question</h4>
				</div>

				<div class="modal-body">
				
					<form action="addAnswer?user_id=${user.getId()}&question_id=${query.getId() }&type=${type}" method="post">
					
					<div class="form-group">
					
						<textarea name="answerField" rows="10" class="form-control" id="ans"></textarea>
						<!--           <input type="textarea" rows="5" col="5" class="form-control" id="ans">
 -->
					</div>

					<input type="submit" class="btn btn-danger" value="submit">
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				</div>
			</div>

		</div>
	</div>
	
	</c:forEach>

				
				<!-- ################################# -->

				<!-- Modal -->
				<div id="answer" class="modal fade" role="dialog">
					<div class="modal-dialog">

						<!-- Modal content-->
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal">&times;</button>
								<h4 class="modal-title"> Question </h4>
							</div>
							<div class="modal-body pre-scrollable">
								<div class="form-group">
									<!-- <textarea name="" rows="10" class="form-control" id="ans"></textarea>
					     <input type="textarea" rows="5" col="5" class="form-control" id="ans"> -->



						<c:forEach var="query" items="${queries }">
									<h3 class="panel-heading card-danger card-title">
										 <a href="#"
											class="float-right d-inline-flex share"><i
											class="fas fa-share-alt text-primary"></i></a>
									</h3>
																		
													<c:forEach items="${query.getAnswers() }" var="ans">
													
													<p class="card-text panel-body">
														${ans.getAnswer()}<span id="dots5${ans.getId()}">...</span>
														
														<span id="more5${ans.getId()}"> ${ans.getAnswer()}</span>
													</p>
													<div>
														<a onclick="myFunction(dots5${ans.getId()}, more5${ans.getId()}, myBtn5${ans.getId()})" id="myBtn5${ans.getId()}"
															class="btn  float-right panel-footer"
															style="background-color: transparent;">Read more <span class="glyphicon glyphicon-forward"></a>
				
														<!-- <a data-toggle="modal" data-target="#answer">Total Answer<span class="badge">12</span>
								</a> -->
				
													</div>
				
													</c:forEach>
									
									<c:forEach items="${query.getAnswers() }" var="ans">
									
									<h3 class="panel-heading card-danger card-title">
										Answer by ${ans.getId() }<a href="#" class="float-right d-inline-flex share"><i
											class="fas fa-share-alt text-primary"></i></a>
									</h3>
									<p class="card-text panel-body">
										${ans.getAnswer()}<span id="dots3${ans.getId()}">...</span><span id="more3${ans.getId()}">${ans.getAnswer()}</span>
									</p>
									<div>	
										<a onclick="myFunction(dots3${ans.getId()}, more3${ans.getId()}, myBtn3${ans.getId()})" id="myBtn3${ans.getId()}"
											class="btn  float-right panel-footer"
											style="background-color: transparent;">Read more <span class="glyphicon glyphicon-forward"></span></a>

										<!-- 					<a data-toggle="modal" data-target="#answer">Total Answer<span class="badge">12</span>
				</a> -->

									</div>

									</c:forEach>

									</c:forEach>
								</div>

								<!-- <button type="submit" class="btn btn-danger">Submit</button> -->
							</div>

						</div>

						<div class="modal-footer">
							<button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
						</div>

					</div>
				</div>
				<!-- end -->



			</div>

			<script>
				function myFunction(dots,moreText,btnText) {
					

					if (dots.style.display === "none") {
						dots.style.display = "inline";
						btnText.innerHTML = "Read more";
						moreText.style.display = "none";
					} else {
						dots.style.display = "none";
						btnText.innerHTML = "Read less";
						moreText.style.display = "inline";
					}
				}
			</script>



		</div>


		<!-- ###################################################################################################### -->

		<div class="col-md-3  pre-scrollable">
<br><br>
			<h4>Recommended Questions</h4>
			<hr>
			
			
			
			<a data-toggle="modal" data-target="#myModal">What are anxiety
				disorders? <span class="badge">105</span>
			</a><br> <a data-toggle="modal" data-target="#myModal">How do
				you cope with anxiety disorders and what are the types of anxiety
				disorders? <span class="badge">5</span>
			</a><br> <a data-toggle="modal" data-target="#myModal">Do I have
				an anxiety disorder? <span class="badge">12</span>
			</a>
			
			
		</div>
	</div>
	<hr>

	<!-- ########################## -->


	<!-- <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal">Open Registration Form</button>
 -->

	<!-- ################################# -->

	

	<!-- ###################################### -->



</body>
</html>