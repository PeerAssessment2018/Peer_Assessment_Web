<%-- 
    Document   : CMS_3.jsp
    Created on : 2 Jul, 2018, 12:23:39 PM
    Author     : Indranil
--%>
<%@page import="java.sql.*" %>
<%@page import="helper_pack.*" %>
<% Class.forName("com.mysql.jdbc.Driver"); %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Set Details for Sample answer </title>
        <link rel="stylesheet" href="boot.css">
        <link rel="stylesheet" href="newcss.css">
        <script lang="javascript" src="support.js" ></script>
    </head>
    <body style="background-color: #a5adba">
        <div class="back_image">
            <div class="box" align="center">
                <div class="headder" align="center">
                    <h2 class="headder_color">Set Details for Sample answer</h2>
                </div>
                <br>
                <div align="center"  >
                    <form name="cms2_form" method="POST">
                        <div class="input-width text_color">
                            How many answers would you like to set ? <input type="number" name="no_asn" min="1" max="10">
                            <br>
                            <br>
                            Set Sample Answer :
                            <select>
                                <option>Sample 1</option>
                                <option>Sample 2</option>
                                <option>Sample 3</option>
                            </select>
                            <br>
                            <br>
                                <h5 class="headder headder_color">Answer Details</h5>
                                <br>
                                <textarea autocomplete="off" placeholder="Set an Answer to the prompt" class="form-control" name="prompt" rows="4" cols="20" ></textarea>
                                <br>
                                <br>
                                Set answers for the Criterion :  
                            <select name="select_answers">
                                <option>Answer 1</option>
                                <option>Answer 2</option>
                                <option>Answer 3</option>
                            </select>
                                <br>
                                <br>
                                <div class="input-width_2">
                                    <h5 class="form-control" >Options</h5>
                                    <input type="radio" name="options_radio" value="" />Option 1<br>
                                    <input type="radio" name="options_radio" value="" />Option 2<br>
                                    <input type="radio" name="options_radio" value="" />Option 3<br>
                                    <input type="radio" name="options_radio" value="" />Option 4<br>
                                </div>
                        </div>
                        <br>
                            <br>
                        <input class=" form-control buttonstyle_smaller" type="button" value="Submit !" name="butt1" onclick="butt_click()"/>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
