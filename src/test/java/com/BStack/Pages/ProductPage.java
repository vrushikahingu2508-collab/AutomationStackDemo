package com.BStack.Pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.BStack.Utility.CommonUtils;

public class ProductPage {
	
	WebDriver driver;
	
	public ProductPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath = "//*[@id='__next']/div/div/main/div[2]/div/small/span")private WebElement totalProduct;
	
	@FindBy(xpath = "//*[@id='__next']/div/div/main/div[2]/div/div/select")private WebElement orderByDD;
	@FindBy(xpath = "//*[@id='__next']/div/div/main/div[2]/div/div[3]/div")private WebElement price;
	
	@FindBy(xpath = "//*[@id='__next']/div/div/main/div/div/label")private List<WebElement> listOfVendors;
	@FindBy(xpath = "//*[@id=\"__next\"]/div/div/main/div[2]/div[1]/small/span") private WebElement itemFound;
	

	
	
	public String totalProduct() 
	{
		return totalProduct.getText();
	}
	
	public String orderByProduct(boolean highest)
	{
		Select select = new Select(orderByDD);
		if(highest) 
		{
			select.selectByValue("highestprice");
		}else
		{
			select.selectByVisibleText("Lowest to highest");
		}
		CommonUtils.waitForWhile(2000);

	return price.getText();
	}
	
	public void vendorsList() 
	{
		for(WebElement e : listOfVendors)
		{
			CommonUtils.waitForWhile(2000);
			System.out.println("Vendors: "+e.getText());
		
		}
	}
	
	public void asPerVendor(String vendor) 
	{
		for(WebElement e : listOfVendors)
		{
			if(vendor.equals(e.getText())) {
				e.click();
				CommonUtils.waitForWhile(2000);
			}
		}
	}


}
