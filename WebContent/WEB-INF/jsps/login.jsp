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
.input-field-1 
{
    position: relative;
    height: 80px;
    width: 100%;
}
.input-field input[type="text"],
.input-field-1 input[type="password"]
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
.input-field-1 label
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
.input-field input[type="text"]:valid +label


{
    transform: translateY(-35px);
    font-size: 14px;
    color: #fff;
    background: #ff6347;
    padding: 2px 6px;

    
    /* transition:0.5s ; */
}
.input-field-1 input[type="password"]:focus + label,
.input-field-1 input[type="password"]:valid +label
{
    transform: translateY(-35px);
    font-size: 14px;
    color: #fff;
    background: #ff6347;
    padding: 2px 6px;
    
    /* transition:0.5s ; */
}
.input-field span,
.input-field-1 span
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
.input-field-1 span:before
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
.input-field-1 input[type="password"]:valid ~ span:before
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

footer li{
    display: inline;
    list-style-type: none;
    
    padding: 0 0.3rem;

}
footer li a{
    
    color: gray;
    font-family: sans-serif;
    font-size: 14px;
}

</style>

</head>
<body>
       
       <div class="container">
           <h2 id="heading">Login Form</h2>
           <sf:form method="post" action="login-process" modelAttribute="login">
                
               <div class="input-field">
                   <sf:input type="text" name="email" required="" path="email"></sf:input> 
                   <label>Please Enter Your Email</label>
                   <span></span>
                </div> 
                <div class="input-field-1">
                   <sf:input type="password" name="password" required="" path="password"></sf:input> 
                   <label>Please Enter Your Password</label>
                   <span></span>
                </div>
                
               
               <input type="submit" name="login_btn" value="Login" class="btn">
               <br><br>
               <a href="register" class="sign">Sign-up</a>
    

           </sf:form>
           <footer>
            <ul>
                <li><a href="#">About</a></li>
                <li><a href="#">Languages</a></li>
                <li><a href="#">Careers</a></li>
                <li><a href="#">Business</a></li>
                <li><a href="#">Privacy</a></li>
                <li><a href="#">Terms</a></li>
                <li><a href="#">Contact</a></li>
                
                <li><a href="#">&copy; Hash-Coders Inc. 2020</a></li>
            </ul>
        </footer>

       </div>
</body>       
</html>