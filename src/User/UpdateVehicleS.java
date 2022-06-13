package User;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.ParseConversionEvent;


import Admin.ConnectDB;

/**
 * Servlet implementation class UpdateVehicleS
 */
public class UpdateVehicleS extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateVehicleS() {
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
		int Vno=Integer.parseInt(request.getParameter("Vno"));
		String Dname=request.getParameter("Dname");
		String mobNo=request.getParameter("mobNo");
		
		try{
			Connection con=ConnectDB.connect();
			PreparedStatement ps=con.prepareStatement("Update vehicle set driverName=?,driverPhoneNo=? where vehicleNo=?");
			ps.setString(1,Dname);
			ps.setString(2, mobNo);
			ps.setInt(3,Vno);
			int i=ps.executeUpdate();
			if(i>0){
				System.out.println("updated");
			}else{
				System.out.println("wrong input");
			}
			}catch(Exception e){
				e.printStackTrace();
		}
	}

}
