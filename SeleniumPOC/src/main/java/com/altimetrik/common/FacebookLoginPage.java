package com.altimetrik.common;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.altimetrik.core.FacebookBase;

/**
 * This class enables to login in Facebook
 * @Author Gayatri Charchi
 * @Date: 15/12/2019
 */
public class FacebookLoginPage extends FacebookBase{

	@FindBy(id="email")
	WebElement userName;
	
	@FindBy(id="pass")
	WebElement passWord;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement loginBTN;
	
	@FindBy(name="firstname")
	WebElement firstName;
	
	@FindBy(name="lastname")
	WebElement lastName;
	
	@FindBy(name="reg_email__")
	WebElement emailId;
	
	@FindBy(xpath="//input[@autocomplete='new-password']")
	WebElement newPassword;
	
	@FindBy(xpath="//div[text()='Gender']/ancestor::div[@class='mtm _5wa2 _5dbb']//span//label[text()='Female']")
	WebElement selectGender;
	
	@FindBy(xpath="//button[@name='websubmit' and text()='Sign Up']")
	WebElement clickSignUpBtn;
	
	@FindBy(xpath="//i[contains(@class,'logo img')]")
	WebElement facebookLogo;
	
	@FindBy(xpath="//span[text()='Create an account']")
	WebElement createAccount;
	
	// now we have to initialize all the object repositary/elements. have to use PageFactory
	//using initElements used to intialize of Pagefactory
	//all these will be initialized with driver
	
	public FacebookLoginPage() {
		PageFactory.initElements(driver,this);
	}
	
	public String validateLoginPageTitle() {
		return driver.getTitle();
		}
	
	public boolean logoTest() {
		return facebookLogo.isDisplayed();
	}
	
	public FacebookHomePage faceBookLogin(String un,String pwd) throws InterruptedException {
		userName.sendKeys(un);
		passWord.sendKeys(pwd);
		
		loginBTN.click();
		
		Thread.sleep(20000);
		
		return new FacebookHomePage();
	}
	
	public void verifyText() {
		
		createAccount.getText();
		
	}
	
	
	
	
	
	
	
	
}
