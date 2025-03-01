package com.simplilearn.FlyAwayAppAutomation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	

	    
	    protected WebDriver driver;
	    protected static final String BASE_URL = "http://localhost:8081/FlyAway";
	    
	    @BeforeTest
	    public void setUp() {
	        WebDriverManager.chromedriver().setup();
	        driver = new ChromeDriver();
	        driver.get(BASE_URL);
	    }
	    
	    @AfterTest
	    public void tearDown() {
	        if (driver != null) {
	            driver.quit();
	        }
	    }
	}

	
