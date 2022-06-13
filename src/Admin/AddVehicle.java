package Admin;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class AddVehicle
 */
public class AddVehicle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddVehicle() {
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
		int vehicleNO=Integer.parseInt(request.getParameter("vehicleNo"));
		String Dname=request.getParameter("Dname");
		String driverNO=request.getParameter("driverNO");
		Double latitude=Double.parseDouble(request.getParameter("latitude"));
		Double longitude=Double.parseDouble(request.getParameter("longitude"));
		int vid=0;
		
		try{
			Connection con=ConnectDB.connect();
			PreparedStatement ps=con.prepareStatement("insert into vehicle values(?,?,?,?,?,?)");
			ps.setInt(1,vid);
			ps.setInt(2, vehicleNO);
			ps.setString(3, Dname);
			ps.setString(4, driverNO);
			ps.setDouble(5, latitude);
			ps.setDouble(6, longitude);
			int i=ps.executeUpdate();
			if(i>0){
				System.out.println("Vehicle Details added ");
				response.sendRedirect("AdminHome.html");
			}else{
				System.out.println("worng input");
				response.sendRedirect("AddVehicle.html");
			}
			
		}catch(Exception e){
			e.printStackTrace();
			response.sendRedirect("AddVehicle.html");
		}
	}

}
