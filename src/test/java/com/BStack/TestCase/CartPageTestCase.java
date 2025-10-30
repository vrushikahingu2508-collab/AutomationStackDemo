package com.BStack.TestCase;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.BStack.Utility.BaseClass;

public class CartPageTestCase extends BaseClass{
  
	
@Test  (priority = 1)
  public void testAddToCart() 
  {
	  lp.login();
	  cp.addToCart();
	  cp.increaseQty(3);
	  cp.decreaseQty(1);
	  String actUrl  = cp.checkOut();
	  Assert.assertTrue(actUrl.contains("checkout"),"Test Fail: Not able to checkout!!!");
	  System.out.println("Test Pass: Chechout Done !!!");
  }
	@Test(priority = 2)	
	public void testOrderSummary() {	
		
		cp.orderSummery();
	}
	
	@Test(priority = 3)	
	public void testShippingAddress() {	
		
		String actUrl = cp.shippingAddress("Juli", "Sharma", "Station plot", "Gujarat", "360221");
		//System.out.println("act"+actUrl);
		Assert.assertTrue(actUrl.contains("confirmation"),"Test Fail: Something went wrong -- Shipping Address");
		System.out.println("Test Pass: Order Confirm!!");
	}
	
	@Test(priority = 4)	
	public void testOrderConfirmation() {	
		
		String actUrl = cp.orderConfirmation();
		Assert.assertTrue(actUrl.contains("bstackdemo"),"Test Fail: Something went wrong -- Confirmation");
		System.out.println("Test Pass: Order Placed!!");
	}
}
