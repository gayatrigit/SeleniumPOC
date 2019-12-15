package com.altimetrik.common;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.altimetrik.core.FacebookBase;

/**
 * This class allows to post custom message and Logout
 * @Author Gayatri Charchi
 * @Date: 15/12/2019
 */
public class FacebookHomePage extends FacebookBase{
	
	@FindBy(xpath="//div[@aria-label='Create a post']")
	WebElement post;
	
	//@FindBy(xpath="//div[contains(text(),'Write something here')]")
	@FindBy(xpath="//div[contains(@class,'_1mwp navigationFocus _395 _1mwq _4c_p _5bu_ _34nd _21mu _5yk1')]")
	//@FindBy(xpath="//div[@class='_5yk2']//div[@class='_5rp7']//div[@class='_5rpb']//div[@class='notranslate _5rpu']//div//div//div[@class='_1mf _1mj']")
	WebElement postType;
	
	
	@FindBy(xpath="//span[text()='Post']/ancestor::button")
	WebElement clickPost;
	
	
	@FindBy(xpath="//span[text()='Facebook']")
	WebElement faceboookLink;
	
	@FindBy(xpath="//a[@title='Profile']")
	WebElement profileLink;
	
	@FindBy(xpath="//div[text()='Account Settings']")
	WebElement accountSettings;
	
	@FindBy(xpath="//li[contains(@class,'navSubmenu')]/a[contains(@data-gt,'menu_logout')]")
	WebElement logoutLink;
	
	public FacebookHomePage() {
		PageFactory.initElements(driver,this);
	}
	
	/*public String verifyHomePageTitle() {
		return driver.getTitle();
	}*/
	public boolean verifyUsername() {
		return faceboookLink.isDisplayed();
	}
	
	
	public void logoutAndClose() throws InterruptedException {
	/*	Actions action=new Actions(driver);
		action.moveToElement(accountSettings).build().perform();*/
		Thread.sleep(3000);
		accountSettings.click();
		Thread.sleep(3000);
		logoutLink.click();
		//driver.quit();
	}
	
	public void writePost() throws InterruptedException {
		Thread.sleep(3000);
		post.click();
		Thread.sleep(3000);
		Actions actions = new Actions(driver);
		actions.moveToElement(postType);
		actions.click();
		actions.sendKeys("Sample new2 Post Message");
		actions.build().perform();
		clickPost.click();
	}
	
}
