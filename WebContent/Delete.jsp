<%@page import="java.io.*"%>
<%@page import="java.sql.*"%>
<html>
<head>
<title>Delete</title>
</head>
<body>
<%
 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cndwastemanagement","root","");
 int vid=Integer.parseInt(request.getParameter("vid"));
 PreparedStatement pstmt=con.prepareStatement("delete from vehicle where vid=?");
 pstmt.setInt(1,vid);
 int i=pstmt.executeUpdate();
 if(i>0){
	 response.sendRedirect("DeleteVehicle.jsp");
	 
 }
 

%>
</body>
</html>