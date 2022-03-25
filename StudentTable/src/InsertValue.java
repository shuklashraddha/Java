import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.*;

public class InsertValue {
public static void main(String args[])throws Exception{
	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","SYSTEM","Oracle1");

PreparedStatement ps=con.prepareStatement("insert into studentdb.Student values(?,?,?,?)");
BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

do{
	//System.out.println("enter id:");
	//int id=Integer.parseInt(br.readLine());
	//System.out.println("enter name:");
	//String name=br.readLine();
	//System.out.println("enter salary:");
	//float salary=Float.parseFloat(br.readLine());
	
	ps.setInt(1,4);
	ps.setString(2,"Mahadev");
	ps.setDate(3, new Date(622790105000L));
	ps.setDate(4, new Date(622790105000L));
	
	int i=ps.executeUpdate();
	System.out.println(i+" records affected");
	
	//System.out.println("Do you want to continue: y/n");
	String s=br.readLine();
    if(s.startsWith("n"))
	{
	break;
	}
}
while(true);
con.close();

}
}