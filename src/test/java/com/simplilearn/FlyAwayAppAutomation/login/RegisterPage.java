package com.simplilearn.FlyAwayAppAutomation.login;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterPage {

	 // Attributes
    private WebDriver driver;
    
    private By email;
    private By password;
    private By login;
    private By submit;
    private By signUp;
    private By confirmPassword;
    private By address;
    private By name;
    private By city;
    private By signUpButton;
    private By logout;
    
    // Constructors
    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        initialiseSignUpPageElements();
    }

 
    public void initialiseSignUpPageElements() {
    	login = By.xpath("/html/body/a[2]");
        signUp = By.xpath("/html/body/form/table/tbody/tr[3]/td/a");
        password = By.name("pwd");
        email = By.name("email_id");
        confirmPassword = By.name("pwd2");
        address = By.name("address");
        name = By.name("name");
        city = By.name("city");
        signUpButton = By.xpath("/html/body/form/table/tbody/tr[7]/td/button");
    }
    
  
    public void signUp() {
    	driver.findElement(login).click();
        driver.findElement(signUp).click();
        initialiseSignUpPageElements();
    }
    
    public boolean performSignUp(String userEmail, String userPassword, String userName, String userAddress, String userCity) {
        driver.findElement(email).sendKeys(userEmail);
        driver.findElement(password).sendKeys(userPassword);
        driver.findElement(name).sendKeys(userName);
        driver.findElement(confirmPassword).sendKeys(userPassword);
        driver.findElement(address).sendKeys(userAddress);
        driver.findElement(city).sendKeys(userCity);
        driver.findElement(signUpButton).click();
        String signUpSuccessUrl = "http://localhost:8081/FlyAway/registerconfirm";
        boolean isSignUpSuccess = new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.urlToBe(signUpSuccessUrl));
        return isSignUpSuccess;
    }
    
    public void clickHome() {
    	driver.findElement(By.xpath("/html/body/a[1]")).click();
    	
    }
    
    public boolean searchFlights(int source, int destination, boolean shoulbeVisible) {
    boolean isFlightsPresent = false;
    	WebElement SourcedropDown = driver.findElement(By.name("source"));
    	SourcedropDown.click();
    	Select select = new Select(SourcedropDown);
    	select.selectByValue(String.valueOf(source));
    	
    	WebElement destDropDown = driver.findElement(By.name("destination"));
    	destDropDown.click();
    	Select newSelect = new Select(destDropDown);
    	newSelect.selectByValue(String.valueOf(destination));
    	driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td[3]/button")).click();
    	if(shoulbeVisible) {
    	WebElement element = driver.findElement(By.xpath("/html/body/table/tbody/tr[2]/td[6]/a"));
    	if (element!=null) {
    		isFlightsPresent = true;
    	}
           
    	}
    	return isFlightsPresent;
    }
			

}
