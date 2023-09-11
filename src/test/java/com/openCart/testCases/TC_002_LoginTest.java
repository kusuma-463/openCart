package com.openCart.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.openCart.PageObject.HomePage;
import com.openCart.PageObject.LoginPage;
import com.openCart.PageObject.MyAccountPage;

public class TC_002_LoginTest extends BaseClass{
	
	@Test(groups= {"Master","Sanity"})
	public void test_login() {
		try {
		logger.info("*****Starting TC_002_LoginTest*****");
		
		HomePage hp = new HomePage(driver);
		
		logger.info("******Clicked on MyAccount*****");
		hp.clickMyAccount();
		
		logger.info("******Clicked on Login*****");
	    hp.clickLogin();
	    
	    
	    LoginPage lp = new LoginPage(driver);
	    logger.info("******Entering email and password*****");
	    lp.setEmail(rb.getString("email"));
	    lp.setPwd(rb.getString("password"));
	    
	    logger.info("******Clicked on login button*****");
	    lp.ClickLogin();
	    
	    MyAccountPage maccpg = new MyAccountPage(driver);
	    logger.info("******Validating MyAccount Page*****");
	    boolean targetPage = maccpg.isMyAccountPageExists();
	    Assert.assertEquals(targetPage, true,"Invalid Login Details");
		}
		catch(Exception e) {
			Assert.fail();
		}
		logger.info("******Finished TC_002_LoginTest*****");
	}
	

}
