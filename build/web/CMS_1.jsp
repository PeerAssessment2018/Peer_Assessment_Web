<%-- 
    Document   : CMS_1
    Created on : 30 Jun, 2018, 11:27:24 AM
    Author     : Indranil
--%>
<%@page import="java.sql.*" %>
<%@page import="helper_pack.*" %>
<% Class.forName("com.mysql.jdbc.Driver"); %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Assessment Init.</title>
        <link rel="stylesheet" href="boot.css">
        <link rel="stylesheet" href="newcss.css">
        <script lang="javascript" src="support.js" ></script>
    </head>
    <body style="background-color: #a5adba">
        <div class="back_image">
            <div class="box" align="center">
                <div class="headder" align="center">
                    <h2 class="headder_color">Self-Assessment</h2>
                </div>
                <div align="center"  >
                    <form name="cms1_form" method="POST">
                        <br>
                        <div class="input-width">
                            <h6>Select Course:</h6>
                            <select class="form-control input-width" name="dropdown">
                                <option class="form-control">Course 1</option>
                                <option class="form-control">Course 2</option>
                                <option class="form-control">Course 3</option>
                            </select>
                        </div>
                        <br>
                        <div class="input-width">
                            <textarea autocomplete="off" placeholder="Set Prompt" class="form-control" name="set_prompt" rows="4" cols="20" ></textarea>
                        </div>
                        <br>
                        <br>
                        <div class="input-width div_outline">
                            <h5 class="form-control">Assignment Details :</h5>
                            <br>
                            Each Learner Must be graded by : <input  type="text" name="set_assignment" placeholder="" size="2" />
                            <br>
                            <br>
                           Learner Must grade: <input  type="text" name="must_grade" placeholder="" size="2" />
                           <br>
                            <br>
                            Last Date of Submission <input type="date" name="bday">
                        </div>
                        <br>
                        <input class=" form-control buttonstyle_smaller" type="button" value="Next" name="butt1" onclick="butt_click()"/>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
