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
        Connection con = null; //��ʾ���ݿ�����Ӷ���  
        PreparedStatement pstmt = null; //��ʾ���ݿ���²���  
          
        String sql = "insert into wish.t_wish_error values("+code+","+message+","+data+","+new Date()+")";  
          
        try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println(sql);  
			con = DriverManager.getConnection(DBURL,DBUSER,DBPASS); //2���������ݿ�  
			pstmt = con.prepareStatement(sql); //ʹ��Ԥ����ķ�ʽ��������  
//			pstmt.setString(1, name); //��һ�����ŵ�����  
//			pstmt.setInt(2, age); //�ڶ������ŵ�����  
//			pstmt.setDate(3, new java.sql.Date(date.getTime()));  
			pstmt.executeUpdate(); //ִ��SQL ��䣬�������ݿ�  
			pstmt.close();  
			con.close(); // 4���ر����ݿ�  
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //1��ʹ��CLASS �������������  
          
    }

}
