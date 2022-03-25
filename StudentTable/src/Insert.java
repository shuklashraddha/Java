import java.util.*;
import java.sql.*;
import java.text.*;
class Insert  
{
     public static void main(String[] args) throws Exception
     {
          
          Scanner sc = new Scanner(System.in);
          System.out.println("Enter the Student No - ");
          int no = sc.nextInt();
          System.out.println("Enter theStudent Name - ");
          String name = sc.next();
          System.out.println("Enter the date of birth - ");
          String dob = sc.next();
          System.out.println("Enter the date of joining -");
          String doj = sc.next();
          
          //for date of birth
          SimpleDateFormat sdf1 = new SimpleDateFormat("dd-mm-yy");
          java.util.Date udob = sdf1.parse(dob);
          java.sql.Date sqdob = new java.sql.Date(udob.getTime());
          //for date of joining(yyyy-mm-dd)
          java.sql.Date sqdoj = java.sql.Date.valueOf(doj);
          //create JDBC connection object
          Class.forName("oracle.jdbc.driver.OracleDriver");
          Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","SYSTEM","Oracle1");
          PreparedStatement ps = con.prepareStatement("insert into studentdb.student values (?,?,?,?)");
         
          ps.setInt(1, no);
          ps.setString(2, name);
          ps.setDate(3, sqdob);
          ps.setDate(4, sqdoj);
          //execute the query
          int res = ps.executeUpdate();
          if (res == 0)
          {
               System.out.println("Record is not inserted");
          }
          else
               System.out.println("Record is inserted");
          //close jdbc 
          ps.close();
          con.close();
     }
}
