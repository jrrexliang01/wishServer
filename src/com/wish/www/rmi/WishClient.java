package com.wish.www.rmi;
  
import java.rmi.Naming;

public class WishClient {  
    /** 
     * @param args 
     */  
    public static void main(String[] args) {
    	
        try{  
            //调用远程对象，注意RMI路径与接口必须与服务器配置一致  
        	WishServer calc = (WishServer) Naming.lookup("rmi://121.40.197.29:6600/WsihService");  
        	int fib = calc.test();
        	System.out.println(fib);
        }catch(Exception ex){  
            ex.printStackTrace();  
        }  
    }  
}  
