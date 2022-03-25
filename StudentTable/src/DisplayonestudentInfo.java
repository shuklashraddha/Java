import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class DisplayonestudentInfo{
	public static void main(String args[]) {
		try{
			//step1 load the driver class  
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//step2 create  the connection object 
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","SYSTEM","Oracle1");
			System.out.println("Connect Sucessfully");
			//step3 create the statement object    
			Statement stmt=con.createStatement();
			//step4 execute query  
			ResultSet rs=stmt.executeQuery("select * from studentdb.Student where Student_No=4");
			while(rs.next())
			System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getDate(3)+"  "+rs.getDate(4));

			
			con.close();
			}
		catch(Exception e) {System.out.println(e);}
			
			
		}
	}

