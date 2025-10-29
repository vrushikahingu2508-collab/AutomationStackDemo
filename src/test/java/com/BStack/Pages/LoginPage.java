package com.BStack.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.BStack.Utility.CommonUtils;

public class LoginPage {

	WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	
	@FindBy(xpath = "//*[text()=\"Sign In\"]")private WebElement signInLink;
	@FindBy(id = "username")private WebElement userNameDropdown;
	//private By userNameDropdown = By.xpath("(//*[name()='svg'])[2]");
	@FindBy(xpath = "//*[text()=\"demouser\"]")private WebElement usernameValue;
	@FindBy(id = "password")private WebElement passwordDropdown;
	@FindBy(xpath = "//*[text()=\"testingisfun99\"]")private WebElement passwordvalueValid;
	@FindBy(xpath = "(//*[@spellcheck=\"false\"])[2]")private WebElement passwordValueInValid;
	@FindBy(xpath = "//*[@id=\"login-btn\"]")private WebElement loginBtn;
	
	@FindBy(xpath = "//*[@id=\"__next\"]/div[2]/div/form/div[2]/h3")private WebElement invalidMsg;
	
	
	public String login() {

			signInLink.click();
			CommonUtils.waitForWhile(2000);	
			userNameDropdown.click();
			//driver.findElement(userNameDropdown).click();;
			//driver.findElement(By.xpath("(//*[name()='svg'])[2]")).click();
			usernameValue.click();
			passwordDropdown.click();
			passwordvalueValid.click();
			CommonUtils.waitForWhile(2000);	
			loginBtn.click();
			CommonUtils.waitForWhile(2000);	
			
	
		return driver.getCurrentUrl();
	}
	
	public String loginWithEmptyInput() 
	{
			signInLink.click();
			loginBtn.click();
			CommonUtils.waitForWhile(2000);	

		return invalidMsg.getText();
	}
	
	
	
	
	
	
	
}
