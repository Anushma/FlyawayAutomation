package com.simplilearn.FlyAwayAppAutomation;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.simplilearn.FlyAwayAppAutomation.login.LoginPage;
import com.simplilearn.FlyAwayAppAutomation.login.RegisterPage;

public class RegisterTest extends BaseTest {
	
	  private RegisterPage registerPage;
	    
	    
	    @BeforeTest
	    @Override
	    public void setUp() {
	        super.setUp();
	        registerPage = new RegisterPage(driver);
	    }
	    
	
	   @Test(priority = 1 )
	    public void signUp() {
		    registerPage.signUp();
	        boolean signUp = registerPage.performSignUp("ima@gmail.com", "124r435yt", "Aby", "Stratford", "London");
	        Assert.assertTrue(signUp);
	    }
	   
	   
	   @Test(priority = 2)
	   public void searchFlights() {
		   registerPage.clickHome();
		   boolean isPresent = registerPage.searchFlights(1, 4, true);
		   Assert.assertTrue(isPresent);
		   
	   }
	   
	   
	   @Test(priority = 3)
	   public void searchNoflights() {
	     registerPage.clickHome();
		   boolean isNotPresent = registerPage.searchFlights(1, 7, false);
		   Assert.assertFalse(isNotPresent);
		   
	   }
	   
	    
	    @AfterTest
	    @Override
	    public void tearDown() {
	        super.tearDown();
	    }
}
