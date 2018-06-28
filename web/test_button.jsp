<%-- 
    Document   : test_button
    Created on : 27 Jun, 2018, 9:34:25 PM
    Author     : Indranil
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <% 
        if(request.getParameter("buttonName") != null) {
               session.setAttribute("status", "guest");
               
        }
    %>

    <FORM NAME="form1" METHOD="POST">
        <INPUT TYPE="HIDDEN" NAME="buttonName">
        <INPUT TYPE="BUTTON" VALUE="Button 1" ONCLICK="button1()">
    </FORM>

    <SCRIPT LANGUAGE="JavaScript">
        function button1()
        {
            document.form1.buttonName.value = "yes";
            form1.submit();
            alert("Hello1!");
        } 
    </SCRIPT>
    </body>
</html>
