package main.java.net.antra.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;


public class TestConnection {
    public static void main(String[] args) {
        //驱动程序名
        final String driver = "com.mysql.jdbc.Driver";
        //URL指向要访问的数据库名doudou
        final String URL = "jdbc:mysql://192.168.4.235:3306/course_student_teacher";
        //用户名（我是用的端丽软账户root）
        final String name = "root";
        //密码
        final String password = "123";
        //创建//数据库表达式
        Statement stmt = null;
        //创建结果集
        ResultSet rs = null;
        //创建数据库连接
        Connection conn = null;

        try{
            // 加载驱动程序
            Class.forName(driver);
            //连接数据库
            conn = DriverManager.getConnection(URL, name, password);
            //查看是否连接成功
            if(!conn.isClosed()){
                System.out.println("Succeeded connecting to the Database!");
            }

            //获取表达式
            stmt =conn.createStatement();
            //执行SQL
            rs = stmt.executeQuery("SELECT * FROM Course");
            //输出数据
            System.out.println("seq_id：" + "\t\t" + "course_name");
            while(rs.next()){
                System.out.println(rs.getInt("seq_id") + "\t\t" + rs.getString("course_name"));

            }
        } catch(Exception e){
            e.printStackTrace();
        } finally {
            try {
                if(rs != null) {
                    rs.close();
                }
                if(stmt != null) {
                    stmt.close();
                }
                if(conn != null) {
                    conn.close();
                }
            } catch(Exception ex) {
                ex.printStackTrace();
            }
        }

    }

}