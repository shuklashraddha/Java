import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
public class Delete {

	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","SYSTEM","Oracle1");
			System.out.println("connect sucessfully");
			PreparedStatement stmt=con.prepareStatement("delete from studentdb.student where Student_No=?");
			stmt.setInt(1,1);
			int i=stmt.executeUpdate();
			System.out.println(i+" records deleted");
			con.close();
		}
		catch(Exception e)
		{System.out.println(e);}
		

	}

}

