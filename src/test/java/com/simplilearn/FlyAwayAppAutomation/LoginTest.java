package com.simplilearn.FlyAwayAppAutomation;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.simplilearn.FlyAwayAppAutomation.login.LoginPage;

import org.testng.Assert;

public class LoginTest extends BaseTest {
    
    private LoginPage loginPage;
    
    
    @BeforeTest
    @Override
    public void setUp() {
        super.setUp();
        loginPage = new LoginPage(driver);
    }
    
    @Test(priority = 1)
    public void testLogin() {
        boolean login = loginPage.login("anushma@gmail.com", "Anushma1234");
        Assert.assertTrue(login);
    }
    
    @Test(priority = 2)
    public void testInvalidLogin() {
        boolean login = loginPage.invalid("anushma@gmail.com", "anushma");
        Assert.assertTrue(login);
    }
    
   
    @Test (priority = 3)
    public void initiateBooking() {
       loginPage.login("anushma@gmail.com", "Anushma1234");
       loginPage.clickHome();
       boolean isBookingConfirmed = loginPage.clickBookFlight();
       Assert.assertTrue(isBookingConfirmed);
       boolean isBookingCompleted = loginPage.completeBooking();
       Assert.assertTrue(isBookingCompleted);
	   
    }
    
    @Test(priority = 4)
    public void seeBookings() {
    	boolean isBookingListVisible = loginPage.getBookings();
    	Assert.assertTrue(isBookingListVisible);
    }
    
    @Test(priority = 5)
    public void editProfile() {
    	boolean isProfileEdited = loginPage.editProfile("45 Margery");
    	Assert.assertTrue(isProfileEdited);
    	
    }
    
    @AfterTest
    @Override
    public void tearDown() {
        super.tearDown();
    }
}

