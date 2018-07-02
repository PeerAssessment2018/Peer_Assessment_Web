<%-- 
    Document   : CMS_2.jsp
    Created on : 2 Jul, 2018, 11:32:39 AM
    Author     : Indranil
--%>
<%@page import="java.sql.*" %>
<%@page import="helper_pack.*" %>
<% Class.forName("com.mysql.jdbc.Driver"); %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Initialize Ruberics </title>
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
                    <form name="cms2_form" method="POST">
                        <br>
                        <div class="input-width text_color">
                            Enter the number of Criteria for Evaluation : <input type="number" name="no_cri" min="1" max="10">
                            <br>
                            <br>
                           
                            Select Criteria :
                            <select>
                                <option>Criteria 1</option>
                                <option>Criteria 2</option>
                                <option>Criteria 3</option>
                            </select>
                        <br>
                        <br>
                        <div class="input-width_2">
                            <h6 class="form-control headder headder_color">Criteria Details</h6>
                            <br>
                            <input class="form-control"  type="text" name="set_cri_name" placeholder="Set Criteria name" size="10" />
                            <br>
                            <textarea autocomplete="off" placeholder="Criteria Prompt" class="form-control" name="set_prompt" rows="2" cols="20" ></textarea>
                            <br>
                            <div style="padding: 5px ; align-content: center ; border: solid ; border-color: #899daf ; border-width:thin; ">
                                <h6>Feedback</h6>
                                <input type="radio" name="feed_radio" value="feedback" />None<input type="radio" name="feed_radio" value="feedback" />Optional 
                                    <input type="radio" name="feed_radio" value="feedback" />Required 
                                  
                               
                                  
                            </div>
                        </div>
                        </div>
                        <br>
                        <br>
                        <div class="input-width text_color">
                            Enter the number of Criteria for Evaluation : <input type="number" name="no_cri" min="1" max="10">
                            <br>
                            <br>
                           
                            Select Option :
                            <select>
                                <option>Option 1</option>
                                <option>Option 2</option>
                                <option>Option 3</option>
                            </select>
                            <div class="input-width_2">
                            <h6 class="form-control headder headder_color">Option Details</h6>
                            <br>
                            <input class="form-control"  type="text" name="set_opt_name" placeholder="Set Option name" size="10" />
                            <br>
                            <textarea autocomplete="off" placeholder="Description" class="form-control" name="set_prompt" rows="2" cols="20" ></textarea>
                            <br>
                            Number of Points : <input type="number" name="points" min="1" max="10" size="2">
                            </div>
                            <br>
                            <br>
                            Please note that after filling details of each option press "Done" button and once pressed no changes would be allowed for the option.
                            <br>
                            So please carefully fill in the details !
                            <br>
                            <br>
                            <input class=" form-control buttonstyle_smaller" type="button" value="Done" name="butt1" onclick="butt_click()"/>
                    </form>
                </div>
            </div>
       </div>
    </body>
</html>
