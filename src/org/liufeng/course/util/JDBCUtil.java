package org.liufeng.course.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Date;

public class JDBCUtil {
	  /** 
     * @param args 
     */  
  
    public void insertWishError(String code,String message,String data){
    	PropertiesUtil propertiesUtil = new PropertiesUtil();
    	String DBURL = propertiesUtil.getProperties("DBURL");
    	String DBUSER = propertiesUtil.getProperties("DBUSER");
    	String DBPASS = propertiesUtil.getProperties("DBPASS");
        // TODO Auto-generated method stub  
        Connection con = null; //表示数据库的连接对象  
        PreparedStatement pstmt = null; //表示数据库更新操作  
          
        String sql = "insert into wish.t_wish_error values("+code+","+message+","+data+","+new Date()+")";  
          
        try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println(sql);  
			con = DriverManager.getConnection(DBURL,DBUSER,DBPASS); //2、连接数据库  
			pstmt = con.prepareStatement(sql); //使用预处理的方式创建对象  
//			pstmt.setString(1, name); //第一个？号的内容  
//			pstmt.setInt(2, age); //第二个？号的内容  
//			pstmt.setDate(3, new java.sql.Date(date.getTime()));  
			pstmt.executeUpdate(); //执行SQL 语句，更新数据库  
			pstmt.close();  
			con.close(); // 4、关闭数据库  
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //1、使用CLASS 类加载驱动程序  
          
    }

}
