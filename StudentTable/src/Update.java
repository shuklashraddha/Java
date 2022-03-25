import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
public class Update {

	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","SYSTEM","Oracle1");
			System.out.println("Connect Sucessfully");
			PreparedStatement stmt=con.prepareStatement("update studentdb.Student set Student_Name= ? where Student_No=?");
			stmt.setString(1,"Mohan");//1 specifies the first parameter in the query i.e. name  
			stmt.setInt(2,1);
			int i=stmt.executeUpdate();
			System.out.println(i+" records updated");
			con.close();
		}
		catch(Exception e)
		{System.out.println(e);}
			
	}

}

