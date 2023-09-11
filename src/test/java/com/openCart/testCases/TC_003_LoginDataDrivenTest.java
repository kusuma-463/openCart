package com.openCart.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.openCart.PageObject.HomePage;
import com.openCart.PageObject.LoginPage;
import com.openCart.PageObject.MyAccountPage;
import com.openCart.utilities.DataProviders;

public class TC_003_LoginDataDrivenTest extends BaseClass{
	
	@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class)
	public void test_LoginDDT(String email,String password,String expected) {
		
		logger.info("*****Starting TC_003_LoginDataDrivenTest*****");
		try {
        HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
	    hp.clickLogin();
	    
	    LoginPage lp = new LoginPage(driver);
	    lp.setEmail(email);
	    lp.setPwd(password);
	    lp.ClickLogin();
	    
	    MyAccountPage maccpg = new MyAccountPage(driver);
	    boolean targetPage = maccpg.isMyAccountPageExists();
	    
	    if(expected.equals("Valid")) {
	    	if(targetPage==true) {
	    		maccpg.ClickLogOut();
	    		Assert.assertTrue(true);
	    	}else {
	    		Assert.assertTrue(false);
	    	}
	    }
	    
	    if(expected.equals("Invalid")) {
	    	if(targetPage==true) {
	    		maccpg.ClickLogOut();
	    		Assert.assertTrue(false);
	    	}else {
	    		Assert.assertTrue(true);
	    	}
	    }
	    
		}catch(Exception e) {
			Assert.fail();
		}
	    logger.info("*****Finished TC_003_LoginDataDrivenTest*****");
	}
}
