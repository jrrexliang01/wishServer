package com.wish.www.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;


public interface WishServer extends Remote {  
	
  public int test() throws RemoteException;  
  
  public String createProduct(String tShopCommodity,String tProductVariation,String wishKey) throws RemoteException;  
}   