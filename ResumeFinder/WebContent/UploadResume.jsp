<%@page import="com.manthan.resume.bean.ResumeBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%String msg=(String)request.getAttribute("msg");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%if(msg!=null && !msg.isEmpty()){ %>
	<%=msg %>
	<%} %>
<a href="./Search" style="margin-left:90%">Upload Resume</a>
File: <br />
<form action="upload" method="post"
                        enctype="multipart/form-data">
<input type="file" name="this_file" size="50" />
<br />
<input type="submit" value="Upload" />
</form>
</body>
</html>