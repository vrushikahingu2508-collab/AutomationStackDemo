package com.BStack.TestCase;

import org.testng.annotations.Test;

import com.BStack.Utility.BaseClass;

public class ProductPageTestCase extends BaseClass{
  @Test(priority = 1)
  public void testTotalProduct() 
  {
	  lp.login();
	  System.out.println("Total: " +pp.totalProduct());
  }
  
  @Test(priority = 2)
  public void testOrderByProduct() 
  {
	  System.out.println("Highest Price : "+pp.orderByProduct(true));
	  System.out.println("Lowest Price: "+pp.orderByProduct(false));
  }
  
  @Test(priority = 3)
  public void testListOfVendors()
  {
	  
	  pp.vendorsList();
  }
  
  @Test(priority = 4)
  public void testAsPerVendors()
  {
	  pp.asPerVendor("Apple");
  }
  
}
