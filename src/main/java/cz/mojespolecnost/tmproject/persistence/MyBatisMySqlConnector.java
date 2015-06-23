package cz.mojespolecnost.tmproject.persistence;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;



/**
 * Responsible for connection to MySQL database according to 
 * the data provided in the configuration file.
 * 
 * Config file right know mixes database connection settings with used Mapper.
 * 
 *
 */
public class MyBatisMySqlConnector 
{

    private final SqlSessionFactory sqlSessionFactory;

    //TODO Get info where to connect
    //TODO Provide some way to get selected data in User
    /**
     * Configures connector according to given xml file.
     * @param xmlConfigFile
     * @throws IOException 
     */
    public MyBatisMySqlConnector(String xmlConfigFile) throws IOException{
        InputStream is= Resources.getResourceAsStream(xmlConfigFile);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
    }
    
    
    public UserDO getUserByID(int userID){
        UserDO out;
        SqlSession session = sqlSessionFactory.openSession();
        try {
            UserMapper mapper = session.getMapper(UserMapper.class);
            out = mapper.selectUser(userID);
            return out == null ? UserNull.getUserNull() : out;
        } finally { //NOTE does not throw any exceptions, am I right?
            session.close();
        }         
    }
    
    public List <UserDO> getAllUsers(){
        SqlSession session = sqlSessionFactory.openSession();       
        try {
            UserMapper mapper = session.getMapper(UserMapper.class);
            return mapper.getAllUsers();
        } finally {
            session.close();
        }
    }      
    
    public int getNumberOfUsers(){
        SqlSession session = sqlSessionFactory.openSession();       
        try {
            UserMapper mapper = session.getMapper(UserMapper.class);
            return mapper.getAllUsers().size();
        } finally {
            session.close();
        }
    }         
    
//    public void insertUser(User insertedUser){
//        insertUser(new UserDO(insertedUser));
//    }
    
    public UserDO insertUser(UserDO insertedUser){
        SqlSession session = sqlSessionFactory.openSession();       
        try {
            UserMapper mapper = session.getMapper(UserMapper.class);
            mapper.insertUser(insertedUser);
            session.commit();
            return insertedUser;
        } finally {
            session.close();
        }        
    }
    
    public void deleteUser(int userID){
        SqlSession session = sqlSessionFactory.openSession();       
        try {
            UserMapper mapper = session.getMapper(UserMapper.class);
            mapper.deleteUser(userID);
            session.commit();
        } finally {
            session.close();
        }        
    }
    
//    public void updateUser(User updatedUser){
//        updateUser(new UserDO(updatedUser));
//    }
    
    public void updateUser(UserDO updatedUser){
        SqlSession session = sqlSessionFactory.openSession();       
        try {
            UserMapper mapper = session.getMapper(UserMapper.class);
            mapper.updateUser(updatedUser);
            session.commit();
        } finally {
            session.close();
        }        
    }    
    

    
//    private static void oldMain( String[] args )
//    {
//        String url = "jdbc:mysql://localhost:3306/";
//        String dbName = "topmonks";
//        String driver = "com.mysql.jdbc.Driver";
//        String userName = "topmonks";
//        String password = "topmonksPass";        
//        try {
//            Class.forName(driver).newInstance();
//            Connection conn = DriverManager.getConnection(url+dbName, userName, password);
//                                   
//            Statement st = conn.createStatement();
//            ResultSet res = st.executeQuery("SELECT User.name, User.address, UserGroup.permissions FROM User LEFT JOIN UserGroup ON User.userGroupID=UserGroup.userGroupID");
//            while (res.next()){
//                System.out.println(String.format("%s   %s    %s", res.getString("name"), 
//                        res.getString("address"), res.getString("permissions")));
//            }
//            
//            conn.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        
//    }
    
}
