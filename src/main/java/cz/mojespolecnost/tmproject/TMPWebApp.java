package cz.mojespolecnost.tmproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;



/**
 * Hello world!
 *
 */
public class TMPWebApp 
{
    public static void main( String[] args )
    {
        String url = "jdbc:mysql://localhost:3306/";
        String dbName = "topmonks";
        String driver = "com.mysql.jdbc.Driver";
        String userName = "topmonks";
        String password = "topmonksPass";        
        try {
            Class.forName(driver).newInstance();
            Connection conn = DriverManager.getConnection(url+dbName, userName, password);
                                   
            Statement st = conn.createStatement();
            ResultSet res = st.executeQuery("SELECT User.name, User.address, UserGroup.permissions FROM User LEFT JOIN UserGroup ON User.userGroupID=UserGroup.userGroupID");
            while (res.next()){
                System.out.println(String.format("%s   %s    %s", res.getString("name"), 
                        res.getString("address"), res.getString("permissions")));
            }
            
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
}
