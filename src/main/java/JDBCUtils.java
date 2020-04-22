package java;
import java.sql.*;

/**
 * JDBC的工具类
 * 工具类中的构造方法都是私有的
 * 因为工具类中的构造方法方法都是静态的，所以不需要new对象，直接调用
 */
public class JDBCUtils {
    private JDBCUtils(){}
        static{//静态代码块，在类加载的时候只需要执行一次
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }



   //获取数据库连接对象   return 连接对象
    public static Connection getConncetion() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/propertymanagementsystem?serverTimezone=UTC","root","0121");

    }
    //关闭资源
    public static void close(Connection c,Statement s,ResultSet r){
        try {
            if (r!=null){
                    r.close();
                }
            if (s!=null){
                    s.close();
            }
            if (c!=null){
                    c.close();
                }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public static void close(Connection c,Statement s){
        try {
            if (s!=null){
                s.close();
            }
            if (c!=null){
                c.close();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

}
