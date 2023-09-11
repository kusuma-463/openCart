package com.openCart.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.openCart.PageObject.AccountRegistrationPage;
import com.openCart.PageObject.HomePage;

public class TC_001_AccountRegistrationTest extends BaseClass{
	@Test(groups= {"Master","Regression"})
	public void test_account_Registration() throws InterruptedException{
		
		logger.info("******Starting  TC_001_AccountRegistrationTest*****");
		try {
		HomePage hp=new HomePage(driver);
		logger.info("******Clicked on MyAccount link*******");
		hp.clickMyAccount();
		
		logger.info("******Clicked on Register link*******");
		hp.clickRegister();
		
		AccountRegistrationPage regpage=new AccountRegistrationPage(driver);
		
		regpage.setFirstName(randomeString().toUpperCase());
		
		regpage.setLastName(randomeString().toUpperCase());
		
		regpage.setEmail(randomeString()+"@gmail.com");// randomly generated the email
		
		regpage.setTelephone(randomeNumber());
		
		String password=randomAlphaNumeric();
		regpage.setPassword(password);
		regpage.setConfirmPassword(password);
		
		regpage.setPrivacyPolicy();
		
		logger.info("******Clicked on continue*******");
		regpage.clickContinue();
		
		String confmsg=regpage.getConfirmationMsg();
		
		logger.info("******validating expected message*******");
		Assert.assertEquals(confmsg, "Your Account Has Been Created!","Not getting expected message");
		}
		catch(Exception e) {
			logger.error("*****Test Failed*******");
			Assert.fail();
		}
		logger.info("*******Finished Account Registartion Test*******");
	}
	

}
