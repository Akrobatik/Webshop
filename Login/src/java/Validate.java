import java.sql.*;

public class Validate
 {
     public static boolean checkUser(String userName,String userPassword) 
     {
      boolean st =false;
      try{

	 //loading drivers for mysql
         Class.forName("com.mysql.jdbc.Driver");

 	 //creating connection with the database 
         Connection con=DriverManager.getConnection 
                        ("jdbc:mysql:/ /160.153.18.103","webShopAdmin","bertil1234");
         PreparedStatement ps =con.prepareStatement
                             ("select * from register where email=? and pass=?");
         ps.setString(1, userName);
         ps.setString(2, userPassword);
         ResultSet rs =ps.executeQuery();
         st = rs.next();
        
      }catch(Exception e)
      {
          e.printStackTrace();
      }
         return st;                 
  }   
}