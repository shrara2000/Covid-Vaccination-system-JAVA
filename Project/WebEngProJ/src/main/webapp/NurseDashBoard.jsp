<%--
Document : NurseDashBoard
Created on : Jan 5, 2022, 9:58:43 AM
Author : USER
--%>



<%@page import="Beans.PrintCitezen"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="styles.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Nurse-DashBoard</title>
</head>
<body>
<jsp:useBean id="Nurse" type="Models.Nurse" scope="session" />
<jsp:useBean id="List" type="List<Models.Citizen>" scope="session"/>
<div><img src="icon.jpg" alt="" width="80 px" height="80 px"></div>
<H1 style="display: inline;"></H1>
<div class="form-center">
<%out.print(PrintCitezen.Print(List)) ; %>
</div>
</body>

</html>