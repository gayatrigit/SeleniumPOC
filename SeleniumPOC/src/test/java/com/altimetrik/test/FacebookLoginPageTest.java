package com.altimetrik.test;

import org.testng.Assert;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.altimetrik.common.FacebookHomePage;
import com.altimetrik.common.FacebookLoginPage;
import com.altimetrik.core.FacebookBase;

public class FacebookLoginPageTest extends FacebookBase {
	static FacebookLoginPage loginpage;
	static FacebookHomePage homepage;
	
	public FacebookLoginPageTest() {
		
		super();
	}
	
	@BeforeMethod
	public static void setUp() {
		initialization();
		loginpage=new FacebookLoginPage();
		
	}
	
	@Test(priority=1)
	public void validateLoginPageTitle() {
		String title  = loginpage.validateLoginPageTitle();
		System.out.println(title);
		Assert.assertEquals(title,"Facebook – log in or sign up");
		
	}
	
	@Test(priority=2)
	public void loginTest() throws InterruptedException {
		String title  = loginpage.validateLoginPageTitle();
		System.out.println(title);
		Assert.assertEquals(title,"(3) Facebook");
		boolean flag = loginpage.logoTest();
		Assert.assertTrue(flag);
		homepage=loginpage.faceBookLogin(prop.getProperty("username"),prop.getProperty("password"));
	}
	
	/*
	@AfterMethod
	public static void tearDown() {
		driver.quit();
	}
	*/
}
