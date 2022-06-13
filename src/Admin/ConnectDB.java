package Admin;



import java.sql.Connection;
import java.sql.DriverManager;
public class ConnectDB {
	
public static Connection connect(){
	Connection con=null;
	try{
		//1.load the Driver
		Class.forName("com.mysql.jdbc.Driver");
		
		//2.Establish connection
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cndwastemanagement","root","");
		System.out.println("connection establish");
		
	}catch(Exception e){
		e.printStackTrace();
	}
	return con;
}
}