<%-- 
    Document   : register_2.jsp
    Created on : 27 Jun, 2018, 5:07:21 PM
    Author     : Indranil
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% Class.forName("com.mysql.cj.jdbc.Driver"); %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register</title>
        <link rel="stylesheet" href="boot.css">
        <link rel="stylesheet" href="newcss.css">
    </head>
    <body style="background-color: #a5adba">
        <div class="back_image" >
        <div class="box" align="center">
        <div class="headder" align="center">
            <h2 class="headder_color">Register</h2>
        </div>
        <div align="center" >
            
            <form autocomplete="off" name="registration_form" action="register_back.jsp" method="POST" align="center">
                <br>
                <h5 class="text_color">Fill up the following to Register :</h5>
                <br>
                <div class="input-width"><input class="form-control" type="text" placeholder="User Name" name="username" size="10" /></div>
                <br>
                <div class="input-width"><input class="form-control" type="password" placeholder="Password" name="password"  size="10" /></div>
                <br>
                <div class="input-width"><input class="form-control" type="text" placeholder="First Name" name="first" size="10" /></div>
                <br>
                <div class="input-width"><input class="form-control" type="text" placeholder="Last Name" name="last" size="10" /></div>
                <br>
                <div class="input-width"><input class="form-control" type="text" placeholder="Email" name="email"  size="10" /></div>
                <br>
                <div>
                <input class="form-control buttonstyle" type="submit" value="Register" name="register" /></div>
                <!--<table>
                    <thead>
                    <th colspan="2" align="center">Fill up the following to Register :</th>
                    </thead>
                    <tbody>
                        <tr>
        		<td>UserName :</td>
        		<td><input class="form-control" type="text" name="username" value="" size="20" /></td>
        	</tr>
                <tr>
        		<td>First Name :</td>
        		<td><input type="text" name="first" value="" size="20" /></td>
        	</tr>
                <tr>
        		<td>Last Name :</td>
        		<td><input type="text" name="last" value="" size="20" /></td>
        	</tr>
        	<tr>
        		<td>Password :</td>
        		<td><input type="password" name="password" value="" size="20" /></td>
        	</tr>
                <tr>
        		<td>Email :</td>
        		<td><input type="text" name="email" value="" size="20" /></td>
        	</tr>
        	<tr>
        		<td></td>
        		<td><input type="submit" value="Submit" name="submit_button"  /><input align="right" type="reset" value="Reset" name="reset_button" /></td>
        	</tr>
                    </tbody>
                </table> -->
            </form>
        </div>
    </body>
</html>
