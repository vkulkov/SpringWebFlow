<%@ page contentType="text/html;charset=UTF-8" %>
<html xmlns:jsp="http://java.sun.com/JSP/Page">
    <jsp:output omit-xml-declaration="yes"/>
    <head>
        <title>Spizza</title>
    </head>
    <body>
        <h2>Thank you for your order!</h2>
        <![CDATA[
        <a href='${flowExecutionUrl}&_eventId=finished'>Finish</a>
        ]]>
    </body>
</html>
