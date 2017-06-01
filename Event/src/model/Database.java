package model;
import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Database {
public int Insert(String name,String tel,String em,String add,String desi,String comp )
{ int sno=0; 
try{
	
	DateTimeFormatter dft=DateTimeFormatter.ofPattern("yyyy/MM/dd");
    LocalDate localDate=LocalDate.now();
    String date=dft.format(localDate);
	String un=name;
    //String co=code;
	String te=tel;
	String ema=em;
	String ad=add;
	String des=desi;
	String com=comp;
	Class.forName("com.mysql.jdbc.Driver");  
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql","root","thapliyal");  
	String query = "insert into event(NAME,TELEPHONE,EMAIL,ADDRESS,DESIGNATION,DATE,COMPANY)"+ "values (?,?,?,?,?,?,?)";
    PreparedStatement preparedStmt = con.prepareStatement(query);
    preparedStmt.setString (1, un);
    preparedStmt.setString (2, te);
    preparedStmt.setString (3, ema);
    preparedStmt.setString (4, ad);
    preparedStmt.setString (5, des);
    preparedStmt.setString (6, date);
    preparedStmt.setString (7, com);
    preparedStmt.execute();
    Statement stmt = con.createStatement();
    ResultSet rs = stmt.executeQuery("select * from event" ); 
    while (rs.next())
        {sno = rs.getInt("REG.NO");
        
        con.close();
        }
    	
	  
	}
catch(Exception e)

{  
	System.out.println(e);
}  

return (sno);

}
/*public static void main(String arg[])
{
	Database d=new Database();
	int s=d.Insert("HIM", "999999", "him@gmai.com", "RZD ", "CEO", "GOOGLE");
}*/
}


