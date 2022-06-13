package User;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import Admin.ConnectDB;
import Admin.credential;

/**
 * Servlet implementation class CnDrequest
 */
public class CnDrequest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CnDrequest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		String add=request.getParameter("add");
		String title=request.getParameter("title");
		String desc=request.getParameter("desc");
		String email=credential.getEmail();
		String status="pending";
		String Completed="pending";
		
		int rno = 0;
		try{
			Connection con=ConnectDB.connect();
			PreparedStatement ps=con.prepareStatement("insert into cndrequest values(?,?,?,?,?,?,?)");
			ps.setInt(1, rno);
			ps.setString(2, add);
			ps.setString(3, title);
			ps.setString(4, desc);
			ps.setString(5, email);
			ps.setString(6, status);
			ps.setString(7, Completed);
			int rs=ps.executeUpdate();
			if(rs>0){
				System.out.println("request Added Successfully");
				response.sendRedirect("UserHome.html");
			}else{
				System.out.println("wrong input");
				response.sendRedirect("CnDrequest.html");
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
