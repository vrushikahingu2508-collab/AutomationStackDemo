package com.BStack.TestCase;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.BStack.Utility.BaseClass;
import com.BStack.Utility.CommonUtils;

public class LoginPageTestCase extends BaseClass{
	
	
  @Test (priority = 1)
  public void testLoginWithValidData() 
  {
	 String actUrl =  lp.login();
	 System.out.println("actUrl:"+actUrl);
	 Assert.assertTrue(actUrl.contains("signin=true"),"Test Fail: Something went wrong!!!");
	 System.out.println("Test Pas: Login Successfully!!!");
	 CommonUtils.waitForWhile(2000);
	 lp.logout();
	 
  }
  
  @Test (priority = 2)
  public void testLoginWithEmptyInput() 
  {
	 String actMsg =  lp.loginWithEmptyInput();
	 System.out.println("actUrl:"+actMsg);
	 Assert.assertTrue(actMsg.contains("Invalid Username"),"Test Fail: Something went wrong!!!");
	 System.out.println("Test Pass: Login validate with empty value is successfully!!!");
  }
  
  @Test (priority = 3)
  public void testLoginWithInvalidInput() 
  {
	 String actMsg =  lp.loginWithInvalidInput();
	 System.out.println("actUrl:"+actMsg);
	 Assert.assertTrue(actMsg.contains("Invalid Username"),"Test Fail: Something went wrong!!!");
	 System.out.println("Test Pass: Login validate with invalid value is successfully!!!");
  }
  
}
