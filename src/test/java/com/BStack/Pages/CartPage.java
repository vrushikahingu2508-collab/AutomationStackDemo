package com.BStack.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.BStack.Utility.CommonUtils;

public class CartPage {
	
	public WebDriver driver;
	
	
	public CartPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	
	@FindBy(xpath = "//*[@id=\"2\"]/div[4]")private WebElement addToCartBtn;
	@FindBy(xpath = "//*[@id=\"__next\"]/div/div/div[2]/div[2]/div[3]/div[2]/p")private  WebElement totalPrice;
	@FindBy(xpath = "//*[@id=\"__next\"]/div/div/div[2]/div[2]/div[3]/div")private WebElement subTotalText;
	
	@FindBy(xpath = "//*[@id=\"__next\"]/div/div/div[2]/div[2]/div[2]/div/div[4]/div/button[2]")private WebElement qtyInc;
	@FindBy(xpath = "//*[@id=\"__next\"]/div/div/div[2]/div[2]/div[2]/div/div[4]/div/button[1]")private WebElement qtyDec;
	
	@FindBy(xpath = "//*[@id=\"__next\"]/div/div/div[2]/div[2]/div[2]/div/div[3]")private WebElement proDetails;
	@FindBy(xpath = "//*[@id=\"__next\"]/div/div/div[2]/div[2]/div[3]/div[3]")private WebElement checkOutBtn;
	
	@FindBy(id = "firstNameInput")private WebElement firstName;
	@FindBy(id = "lastNameInput")private WebElement lastName;	
	@FindBy(id = "addressLine1Input")private WebElement address;
	@FindBy(id = "provinceInput")private WebElement state;
	@FindBy(id = "postCodeInput")private WebElement postCode;
	@FindBy(id = "checkout-shipping-continue")private WebElement subBtn;
	
	@FindBy(xpath = "//*[@id=\"checkout-app\"]/div/div/aside/article/header/h3")private WebElement orderSummary;
	@FindBy(xpath = "//*[@id=\"checkout-app\"]/div/div/aside/article/section[1]")private WebElement itemsDetails;
	@FindBy(xpath = "//*[@id=\"checkout-app\"]/div/div/aside/article/section[2]")private WebElement amtTobePay;
	
	@FindBy(id = "confirmation-message")private WebElement confirmMsg;
	@FindBy(xpath = "//*[@id=\"checkout-app\"]/div/div/div/ol/li/div/div/div[2]")private WebElement orderNo;
	@FindBy(linkText = "Download order receipt")private WebElement downloadRecipt;
	@FindBy(xpath = "//*[@id=\"checkout-app\"]/div/div/div/div/a/button")private WebElement continueShopping;
	
	
	
	
	public void addToCart() 
	{
		CommonUtils.waitForWhile(3000);
		
		addToCartBtn.click();
		System.out.println("Product Details : "+ proDetails.getText());
		System.out.println(subTotalText.getText() + " : " + totalPrice.getText());
		
	}
	
	public void increaseQty(int qty) 
	{
		System.out.println("Qyantity Increase by "+qty);
		for(int i = 2;i <=qty;i++ )
			
		{
			qtyInc.click();
			CommonUtils.waitForWhile(3000);
			System.out.println(subTotalText.getText() + " : " + totalPrice.getText());
		}
		
	//	System.out.println(subTotalText.getText() + " : " + totalPrice.getText());
	}
	
	public void decreaseQty(int qty)
	{
		System.out.println("Qyantity decrease by "+qty);
		for(int i = 1;i <=qty;i++ )
		{
			qtyDec.click();
			CommonUtils.waitForWhile(3000);
			System.out.println(subTotalText.getText() + " : " + totalPrice.getText());
		}
		
	}
	
	public String checkOut() {
		
		checkOutBtn.click();
		CommonUtils.waitForWhile(2000);
		return driver.getCurrentUrl();
	}
	
	
	public void orderSummery() {
		
		System.out.println(orderSummary.getText());
		System.out.println(itemsDetails.getText());
		System.out.println(amtTobePay.getText());
		CommonUtils.waitForWhile(2000);
	}
	
	public String shippingAddress(String fname,String lname,String add,String province,String code) {
		
		firstName.sendKeys(fname);
		lastName.sendKeys(lname);
		address.sendKeys(add);
		state.sendKeys(province);
		postCode.sendKeys(code);
		subBtn.click();
		CommonUtils.waitForWhile(2000);
		
		return driver.getCurrentUrl();
	}
	
	public String orderConfirmation() {
		System.out.println(confirmMsg.getText());
		System.out.println(orderNo.getText());
		CommonUtils.waitForWhile(2000);
		downloadRecipt.click();
		continueShopping.click();
		CommonUtils.waitForWhile(2000);
		
		return driver.getCurrentUrl();
	}
	

	
	

}
