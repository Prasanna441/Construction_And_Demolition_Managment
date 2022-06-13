package Admin;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AdminCreateAccount
 */
public class AdminCreateAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminCreateAccount() {
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
		String name,email,password;
		int id = 0;
		name=request.getParameter("name");
		email=request.getParameter("email");
		password=request.getParameter("password");
		
		try{
			Connection con=ConnectDB.connect();
			PreparedStatement ps=con.prepareStatement("insert into admin values(?,?,?)");
			ps.setInt(1,id);
			ps.setString(2, name);
			ps.setString(3,email);
			ps.setString(4,password);
			int i=ps.executeUpdate();
			
			if(i>0){
				System.out.println("Admin Account create Succesfully");
			}else{
				System.out.println("wrong input");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
