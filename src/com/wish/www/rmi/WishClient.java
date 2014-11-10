package com.wish.www.rmi;
  
import java.rmi.Naming;

public class WishClient {  
    /** 
     * @param args 
     */  
    public static void main(String[] args) {
    	
        try{  
            //����Զ�̶���ע��RMI·����ӿڱ��������������һ��  
        	WishServer calc = (WishServer) Naming.lookup("rmi://121.40.197.29:6600/WsihService");  
        	int fib = calc.test();
        	System.out.println(fib);
        }catch(Exception ex){  
            ex.printStackTrace();  
        }  
    }  
}  
