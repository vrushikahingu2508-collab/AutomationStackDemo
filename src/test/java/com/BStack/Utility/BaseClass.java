package com.BStack.Utility;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.BStack.Pages.CartPage;
import com.BStack.Pages.LoginPage;
import com.BStack.Pages.ProductPage;

public class BaseClass {
	
	public WebDriver driver;
	public LoginPage lp;
	public ProductPage pp;
	public CartPage cp;
	
	
	String url = "https://bstackdemo.com/";
	
	
	@BeforeTest
	public void setUp()
	{
		
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get(url);
		
		lp = new LoginPage(driver);
		pp = new ProductPage(driver);
		cp = new CartPage(driver);
	}
	
	@AfterTest
	public void close()
	{
		driver.close();
	}
	

}
