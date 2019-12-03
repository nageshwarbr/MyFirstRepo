<%@page import="java.io.*,java.net.*"%>
<%@page import="com.manthan.resume.bean.ResumeBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%List<ResumeBean> ls=(ArrayList)request.getAttribute("ls"); %>
     <%String msg=(String)request.getAttribute("msg");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<a href="./Upload" style="margin-left:90%">Upload Resume</a>

	<!-- <div align="center">
		<h2>Search Resume</h2>
	</div>
	<br>
	<form>
		<input type="text" name="keyword" placeholder="Search" style="margin-left:42%">
		<input type="submit" value="Search">
	</form> -->
	<fieldset>
<legend>Search Resume</legend>
<form action="./searchResume" method="get">
		Enter your keyword <input type="text" name="keyword" required><br />
		<br /> <input type="submit" value="Search">
	</form>
	</fieldset>
	<%if(msg!=null && !msg.isEmpty()){ %>
	<%=msg %>
	<%} %>
	 <%if(ls!=null){ %>
	<table>
	 <tr>
    <th>FileName</th>
     <th>Name</th>
    <th>Email_ID</th>
    <th>Download link</th>
  </tr>
  <%for(ResumeBean rs:ls){%>
  <tr>
	<td><%=rs.getFileName() %></td>&nbsp;
	<td><%=rs.getName() %></td>&nbsp;
	<td><%=rs.getEmail() %></td>&nbsp;
	<a href="./Upload" style="margin-left:90%">Upload Resume</a></br>
	<%!
public static String getMimeType(String fileUrl)
    throws java.io.IOException, MalformedURLException 
  {
    String type = null;
    URL u = new URL(fileUrl);
    URLConnection uc = null;
    uc = u.openConnection();
    type = uc.getContentType();
    return type;
  }

%>
 <%
	
    String file="D:/files/"+rs.getName();
    File f = new File (file);
    String filename=f.getName();
    String type=getMimeType("file:"+file);

    response.setContentType (type);
    response.setHeader ("Content-Disposition", "attachment;     filename=\""+filename+"\"");

    String name = f.getName().substring(f.getName().lastIndexOf("/") + 1,f.getName().length());
    InputStream in = new FileInputStream(f);
        ServletOutputStream outs = response.getOutputStream();

        int bit = 256;
        int i = 0;
            try {
                    while ((bit) >= 0) {
                        bit = in.read();
                        outs.write(bit);
                    }
                        } catch (IOException ioe) {
                        ioe.printStackTrace(System.out);
                    }
                        outs.flush();
                    outs.close();
                    in.close(); 

        %>
	
	</tr>
	<%}%>
		<%}%>
		</table>
</body>
</html>