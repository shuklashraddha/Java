import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
public class CreateTable {

	public static void main(String[] args) {
		try{
		
			//step1 load the driver class  
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//step2 create  the connection object 
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","SYSTEM","Oracle1");
			System.out.println("Connect Sucessfully");
			//step3 create the statement object    
			Statement stmt=con.createStatement();
			stmt.executeUpdate("create table studentdb.Student(Student_No Number(3),Student_Name varchar(30),Student_DOB Date,Student_DOJ Date)");
			System.out.println(" Table created Sucessfully");
			con.close();
		}
		catch(Exception e) {System.out.println(e);}
			

	}

}