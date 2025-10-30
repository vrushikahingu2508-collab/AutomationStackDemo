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
	
	@FindBy(xpath = "//*[@id=\"signin\"]")private WebElement logout;
	
	@FindBy(xpath = "//*[@id=\"username\"]")private WebElement userclick;
	
	@FindBy(xpath = "//*[@id=\"username\"]/div[1]/div[1]")private WebElement invalidUserInput;
	@FindBy(xpath = "//*[@id=\"react-select-4-option-1\"]")private WebElement invalidUserCreate;	
	
	@FindBy(xpath = "//*[@id=\"react-select-5-input\"]")private WebElement invalidPasswordInput;
	@FindBy(xpath = "//*[@id=\"react-select-5-option-1\"]")private WebElement invalidPasswordCraete;
	
	
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
	
	public void logout() {
		logout.click();
		
	}
	

	public String loginWithInvalidInput() 
	{
			driver.navigate().refresh();
		
			userclick.click();
			invalidUserInput.sendKeys("AbcUser");
			invalidUserCreate.click();
			invalidPasswordInput.sendKeys("abc123");
			invalidPasswordCraete.click();
			loginBtn.click();
			
			CommonUtils.waitForWhile(2000);	

		return invalidMsg.getText();
	}
	
	
	
	
	
}
