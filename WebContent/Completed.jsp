<%@page import="java.io.*"%>
<%@page import="java.sql.*"%>
<html>
<head>
<title>Delete</title>
</head>
<body>
<%
 String add="",Title="",desc="";
int rno;
 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cndwastemanagement","root","");
 
rno=Integer.parseInt(request.getParameter("rno"));
 
PreparedStatement pstmt =con.prepareStatement("select * from cndrequest where rno=?");
pstmt.setInt(1, rno);
ResultSet rs=pstmt.executeQuery();
while(rs.next()){
	rno=rs.getInt(1);
	add=rs.getString(2);
	 Title=rs.getString(3);
	 desc=rs.getString(4);
	
	
}
 
 PreparedStatement ps=con.prepareStatement("insert into completed values(?,?,?,?)");
 ps.setInt(1,rno);
 ps.setString(2,add);
 ps.setString(3, Title);
 ps.setString(4, desc);
 int i=ps.executeUpdate();
 if(i>0){
	 
	 response.sendRedirect("AdminViewCnD.jsp");
	 System.out.println("Approved");
	 
 }
 

%>
</body>
</html>