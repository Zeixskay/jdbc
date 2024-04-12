package utils;

import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;

public class DBUtils {
private static String DRIVER;
private static String URL;
private static String USER;
private static String PASSWORD;


private static Connection conn;
private static PreparedStatement ps;
private static ResultSet rs;

static {
    Properties properties =new Properties();
    try {
        properties.load(new FileInputStream("src/db.properties"));
        DRIVER=properties.getProperty("driver");
        URL=properties.getProperty("url");
        USER=properties.getProperty("user");
        PASSWORD=properties.getProperty("password");

        Class.forName(DRIVER);
    } catch (Exception e) {
        throw new RuntimeException(e);
    }
}

public static boolean getConn() throws SQLException {
       conn  = DriverManager.getConnection(URL, USER, PASSWORD);
       return true;
}
public static void closeResource() throws SQLException {
    if(conn!=null){
        conn.close();
    }
    if(ps!=null){
        ps.close();
    }
    if(rs!=null){
        rs.close();
    }
 }

public static ResultSet selectSQL(String sql,Object[] objs) throws SQLException {
    ResultSet rs=null;
    if(getConn()){
        ps=conn.prepareStatement(sql);
        if(objs!=null){
            for (int i = 0; i < objs.length; i++) {
                ps.setObject((i + 1), objs[i]);
            }
        }
        rs= ps.executeQuery();
    }
    return rs;
}

public static Integer cudSQL(String sql,Object[] objs) throws SQLException {
    int i=0;
    if(getConn()){
        ps=conn.prepareStatement(sql);
        if(objs!=null){
            for (int j = 0; j < objs.length; j++) {
                ps.setObject((j + 1), objs[j]);
            }
        }
         i=ps.executeUpdate();
    }
    return i;
}

}
