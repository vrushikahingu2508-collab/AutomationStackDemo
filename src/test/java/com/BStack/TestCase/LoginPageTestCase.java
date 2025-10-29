package com.BStack.TestCase;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.BStack.Utility.BaseClass;

public class LoginPageTestCase extends BaseClass{
  @Test (priority = 2)
  public void testLoginWithValidData() 
  {
	 String actUrl =  lp.login();
	 System.out.println("actUrl:"+actUrl);
	 Assert.assertTrue(actUrl.contains("signin=true"),"Test Fail: Something went wrong!!!");
	 System.out.println("Test Pas: Login Successfully!!!");
  }
  
  @Test (priority = 1)
  public void testLoginWithEmptyInput() 
  {
	 String actMsg =  lp.loginWithEmptyInput();
	 System.out.println("actUrl:"+actMsg);
	 Assert.assertTrue(actMsg.contains("Invalid Username"),"Test Fail: Something went wrong!!!");
	 System.out.println("Test Pas: Login Successfully!!!");
  }
  
}
