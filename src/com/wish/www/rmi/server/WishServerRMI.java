package com.wish.www.rmi.server;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class WishServerRMI {

	public static void main(String[] args) {
		 try {  
	            LocateRegistry.createRegistry(6600);    
	            WishServerIMP wishServerIMP = new WishServerIMP();  
	              
	            // ×¢²áµ½ registry ÖÐ  
	            Naming.rebind("rmi://127.0.0.1:6600/WsihService", wishServerIMP);  
	            System.out.println("wish server ready");  
	              
	        } catch (RemoteException re) {  
	            System.out.println("Exception in FibonacciImpl.main: " + re);  
	        } catch (MalformedURLException e) {  
	            System.out.println("MalformedURLException " + e);  
	        }  
	}
}
