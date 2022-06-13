package User;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.Connection;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Response;

import Admin.ConnectDB;
import Admin.credential;


/**
 * Servlet implementation class UserCreateAccount
 */
public class UserCreateAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserCreateAccount() {
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
		String name=request.getParameter("name");
		String phoneNo=request.getParameter("phoneNo");
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		String prof=request.getParameter("profession");
		String addr=request.getParameter("add");
		int Uid = 0;
		
		try{
			Connection con=ConnectDB.connect();
			PreparedStatement ps=con.prepareStatement("insert into user values(?,?,?,?,?,?,?)");
			ps.setInt(1, Uid);
			ps.setString(2, name);
			ps.setString(3, phoneNo);
			ps.setString(4, email);
			ps.setString(5, password);
			ps.setString(6, prof);
			ps.setString(7, addr);
			int i=ps.executeUpdate();
			if(i>0){
				System.out.println("Account created");
				credential.setEmail(email);
				response.sendRedirect("UserHome.html");
				
			}else{
				System.out.println("wrong input");
				response.sendRedirect("UserCreateAccount.html");
			}
		}catch(Exception e){
				e.printStackTrace();
			}
		
	}

}
