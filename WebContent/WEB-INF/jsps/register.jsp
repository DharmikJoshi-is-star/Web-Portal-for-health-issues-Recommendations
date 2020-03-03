<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Portal for health issue</title>

<style>

@import url('https://fonts.googleapis.com/css?family=Poppins:200,300,400,500,600,700&display=swap');
*
{
    margin: 0;
    padding: 0;
    box-sizing: border-box;
    outline: none;
    font-family: 'Poppins',sans-serif;
}
body
{
    display: flex;
    justify-content: center;
    align-items: center;
    min-height: 100vh;
    background: #ff6347;

}

.container
{
    position: relative;
    width: 500px;
    padding: 40px;
    background: #fff;
}
.container h2
{
    color: #ff6347;
    margin-bottom: 45px;
    font-size: 35px;
    
    /* color: #3498DB ; */

}
.input-field,
.input-field-1,
.input-field-2,
.input-field-3,
.input-field-4,
.input-field-5,
.input-field-6,
.input-field-7
{
    position: relative;
    height: 80px;
    width: 100%;
}
.input-field input[type="text"],
.input-field-1 input[type="password"],
.input-field-2 input[type="password"],
.input-field-3 input[type="text"],
.input-field-4 input[type="text"],
.input-field-5 input[type="text"],
.input-field-6 input[type="text"],
.input-field-7 input[type="text"]

{
    /* c */
position: absolute;
background: transparent;
border: none;
box-shadow: none;
font-size: 16px;
color: #000000;
width: 100%;
}
.input-field label,
.input-field-1 label,
.input-field-2 label,
.input-field-3 label,
.input-field-4 label,
.input-field-5 label,
.input-field-6 label,
.input-field-7 label

{
    /* c */
    position: absolute;
    top: 0;
    left: 0;
    color: #555;
    pointer-events: none;
    display: block;
    transition: 0.5s;
}
.input-field input[type="text"]:focus + label,
.input-field input[type="text"]:valid +label,
.input-field-3 input[type="text"]:focus + label,
.input-field-3 input[type="text"]:valid +label,
.input-field-4 input[type="text"]:focus + label,
.input-field-4 input[type="text"]:valid +label,
.input-field-5 input[type="text"]:focus + label,
.input-field-5 input[type="text"]:valid +label,
.input-field-6 input[type="text"]:focus + label,
.input-field-6 input[type="text"]:valid +label,
.input-field-7 input[type="text"]:focus + label,
.input-field-7 input[type="text"]:valid +label


{
    transform: translateY(-35px);
    font-size: 14px;
    color: #fff;
    background: #ff6347;
    padding: 2px 6px;

    
    /* transition:0.5s ; */
}
.input-field-1 input[type="password"]:focus + label,
.input-field-1 input[type="password"]:valid +label,
.input-field-2 input[type="password"]:focus + label,
.input-field-2 input[type="password"]:valid +label
{
    transform: translateY(-35px);
    font-size: 14px;
    color: #fff;
    background: #ff6347;
    padding: 2px 6px;
    
    /* transition:0.5s ; */
}
.input-field span,
.input-field-1 span,
.input-field-2 span,
.input-field-3 span,
.input-field-4 span,
.input-field-5 span,
.input-field-6 span,
.input-field-7 span

{
    /* c */
    position: absolute;
    bottom:0;
    right: 0;
    display: block;
    color: #555;
    width:100%;
    height:2px;
}
.input-field span:before,
.input-field-1 span:before,
.input-field-2 span:before,
.input-field-3 span:before,
.input-field-4 span:before,
.input-field-5 span:before,
.input-field-6 span:before,
.input-field-7 span:before
{
    /* c */
content: '';
position: absolute;
top: -40px; 
/* The top command is negative to get the blue span line just below the input text field */
left: 0;
width: 100%;
height: 100%;
background: #00b0ff;
transform: scaleX(0);
transform-origin: right;
transition: transform 0.5s ease-in-out;
}
.input-field input[type="text"]:focus ~ span:before,
.input-field input[type="text"]:valid ~ span:before,
.input-field-1 input[type="password"]:focus ~ span:before,
.input-field-1 input[type="password"]:valid ~ span:before,
.input-field-2 input[type="password"]:focus ~ span:before,
.input-field-2 input[type="password"]:valid ~ span:before,
.input-field-3 input[type="text"]:focus ~ span:before,
.input-field-3 input[type="text"]:valid ~ span:before,
.input-field-4 input[type="text"]:focus ~ span:before,
.input-field-4 input[type="text"]:valid ~ span:before,
.input-field-5 input[type="text"]:focus ~ span:before,
.input-field-5 input[type="text"]:valid ~ span:before,
.input-field-6 input[type="text"]:focus ~ span:before,
.input-field-6 input[type="text"]:valid ~ span:before,
.input-field-7 input[type="text"]:focus ~ span:before,
.input-field-7 input[type="text"]:valid ~ span:before


{
    transform: scaleX(1);
transform-origin: left;
transition: transform 0.5s ease-in-out;
}
.btn
{
    margin-top: 20px;
    border: none;
    box-shadow: none;
    padding: 10px 25px;
    background: #333;
    color: #fff;
    font-size: 16px;
    cursor: pointer;
}
.btn:hover
{
    background: #ff6347;
    /* transition: 0.5s; */
}

</style>

</head>
 <body>
       
       <div class="container">
           <h2 id="heading">Sign Up</h2>
           <sf:form method="post" action="register-process" modelAttribute="user">
               
               <div class="input-field">
                   <sf:input type="text" name="username" required="" path="name"/>
                   <label>Please Enter Your Username</label>
                   <span></span>
                </div> 
                <div class="input-field-1">
                   <sf:input type="password" name="password" required="" path="password"/>
                   <label>Please Enter Your Password</label>
                   <span></span>
                </div>

                <!-- <div class="input-field-2">
                    <input type="password" name="confirmpassword" required="">
                    <label>Please Confirm  Your Password</label>
                    <span></span>
                 </div>
                  -->
                 <div class="input-field-3">
                    <sf:input type="text" name="Email" required="" path="email"/>
                    <label>Please Enter Your Email</label>
                    <span></span>
                 </div>

                 <div class="input-field-4">
                    <sf:input type="text" name="Contact" required="" path="contact"/>
                    <label>Please Enter Your Contact</label>
                    <span></span>
                 </div>
                 <div class="input-field-5">
                    <sf:input type="text" name="Age" required="" path="age"/>
                    <label>Please Enter Your Age</label>
                    <span></span>
                 </div>
                 <div class="input-field-6">
                    <sf:input type="text" name="gender" required="" path="gender"/>
                    <label>Please Enter Your Gender</label>
                    <span></span>
                 </div>
                 <div class="input-field-7">
                    <sf:input type="text" name="Address" required=""  path="address"/>
                    <label>Please Enter Your Address</label>
                    <span></span>
                 </div>

               <input type="submit" name="login_btn" value="Sign up" class="btn">

           </sf:form>

       </div>
</body>
</html>