<%@page import="java.io.*"%>
<%@page import="java.sql.*"%>
<html>
<head>
<title>Approve</title>
</head>
<body>
<%
int rno=Integer.parseInt(request.getParameter("rno"));
try{
	
 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cndwastemanagement","root","");
 
 
PreparedStatement pstmt =con.prepareStatement("update cndrequest set status=? where rno=?");
pstmt.setString(1,"Approved");
pstmt.setInt(2, rno);
int rs=pstmt.executeUpdate();
if(rs>0){
	System.out.println("Account updated ");
	response.sendRedirect("AdminViewCnD.jsp");
	
}else{
	System.out.println("error");
	response.sendRedirect("AdminHome.html");
}
}catch(Exception e){
	e.printStackTrace();
}
 

%>
</body>
</html>