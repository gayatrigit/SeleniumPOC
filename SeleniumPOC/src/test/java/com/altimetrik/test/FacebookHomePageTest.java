package com.altimetrik.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.altimetrik.common.FacebookHomePage;
import com.altimetrik.common.FacebookLoginPage;
import com.altimetrik.core.FacebookBase;
import com.altimetrik.util.FacebookUtil;


public class FacebookHomePageTest extends FacebookBase {
	FacebookLoginPage loginpage;
	FacebookHomePage homepage;
	FacebookUtil testutil;
	
	public FacebookHomePageTest() {
		super();
	}
	
	
	@BeforeTest
	public void setUp() throws InterruptedException {
		initialization();
		testutil=new FacebookUtil();
		loginpage=new FacebookLoginPage();
		homepage=loginpage.faceBookLogin(prop.getProperty("username"),prop.getProperty("password"));
	}

	/*@Test(enabled=true)
	public void verifyHomePageTitleTest() {
		String homePageTitle=homepage.verifyHomePageTitle();
		//Assert.assertEquals(homePageTitle,"(3) Facebook","home page title is not correct");
	}*/
	
	@Test()
	public void logoutAndClose() throws InterruptedException {
		homepage.writePost();
		homepage.logoutAndClose();
	}
	

	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
