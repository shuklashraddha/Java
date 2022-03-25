import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DisplayTable {

	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","SYSTEM","Oracle1");
			System.out.println("Connect Sucessfully");
			PreparedStatement stmt=con.prepareStatement("select * from studentdb.Student");
			ResultSet rs=stmt.executeQuery();
			while(rs.next()){
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getDate(3)+" "+rs.getDate(4));
				}
			con.close();
		}
		catch(Exception e)
		{System.out.println(e);}
		

	}

}
