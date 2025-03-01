package com.simplilearn.FlyAwayAppAutomation.login;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class LoginPage {
    
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
    private By bookFlight;
    private By homeUrl;
    private By confirmBooking;
    private By getBookings;
    private By updateButton;
  
 
    
    // Constructors
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        initialiseLoginWebelement();
    }

    // Methods
    public void initialiseLoginWebelement() {
        login = By.xpath("html/body/a[2]");
        email = By.name("email_id");
        password = By.name("pwd");
        submit = By.xpath("/html/body/form/table/tbody/tr[3]/td/button");
        logout = By.xpath("/html/body/a[5]");
        bookFlight = By.xpath("/html/body/table/tbody/tr[2]/td[6]/a");
        homeUrl = By.xpath("/html/body/a[1]");
    }
    
    public void initialiseSignUpPageElements() {
        signUp = By.xpath("/html/body/form/table/tbody/tr[3]/td/a");
        confirmPassword = By.name("pwd2");
        address = By.name("address");
        name = By.name("name");
        city = By.name("city");
        signUpButton = By.xpath("/html/body/form/table/tbody/tr[7]/td/button");
    }
    
    public void initiliseBookingElements() {
    	confirmBooking = By.xpath("/html/body/a[6]");
    	
    }
    
    public void initialiseGetElements() {
    	getBookings = By.xpath("/html/body/a[6]");
    }
    
    public void initilaiseEditProfElements() {
    	   address = By.name("address");
    	updateButton = By.xpath("/html/body/form/table/tbody/tr[6]/td/button");
    }
    
  
    
    public boolean login(String loginEmail, String loginPassword) {
        driver.findElement(login).click();
        driver.findElement(email).sendKeys(loginEmail);
        driver.findElement(password).sendKeys(loginPassword);
        driver.findElement(submit).click();
        String loginSuccessUrl = "http://localhost:8081/FlyAway/dashboard";
        boolean isLoginTrue = new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.urlToBe(loginSuccessUrl));
        return isLoginTrue;
    }
    
    public boolean invalid(String loginEmail, String loginPassword) {
    	driver.findElement(logout).click();
        driver.findElement(login).click();
        driver.findElement(email).sendKeys(loginEmail);
        driver.findElement(password).sendKeys(loginPassword);
        driver.findElement(submit).click();
        String loginFailUrl = "http://localhost:8081/FlyAway/loginaction";
        boolean isLoginFalse = new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.urlToBe(loginFailUrl));
        return isLoginFalse;
    }
    
    public void signUp() {
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
    
    public boolean clickBookFlight() {
    	driver.findElement(bookFlight).click();
    	String bookingConfirmationUrl = "http://localhost:8081/FlyAway/bookflight?id=3";
    	driver.getCurrentUrl();
    	boolean isBookingSuccess = new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.urlToBe(bookingConfirmationUrl));
        return isBookingSuccess;
    	
        
    }
    
    public void clickHome() {
    	driver.findElement(homeUrl).click();
    }
    
    public boolean completeBooking() {
    	boolean isTrue = false;
    	initiliseBookingElements();
    	driver.findElement(confirmBooking).click();
    	JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement element = (WebElement) js.executeScript(
            "return Array.from(document.getElementsByTagName('*')).find(el => el.textContent.includes('has been booked for 4500.00.'));");
        if (element!= null) {
        	System.out.println("Login first to book a flight");
        	isTrue= true;
        			
        }
        return isTrue;
    	
    }
    
    public boolean getBookings() {
    	initialiseGetElements();
    	driver.findElement(getBookings).click();
    	String expectedUrl = "http://localhost:8081/FlyAway/memberbookings";
    	boolean isListDisplayed = driver.findElement(By.xpath("/html/body/table/tbody/tr[1]/td[1]/b")).isDisplayed();
    	return isListDisplayed;
    	
    }
    
    public boolean editProfile(String newAddress) {
    	boolean isEdited = false;
    	initilaiseEditProfElements();
    	driver.findElement(By.xpath("/html/body/a[3]")).click();
    	String currentUrl = driver.getCurrentUrl();
    	address = By.name("address");
    	confirmPassword = By.name("pwd2");
    	editFields(newAddress);
    	JavascriptExecutor js = (JavascriptExecutor) driver;
    	WebElement element = (WebElement) js.executeScript(
                "return Array.from(document.getElementsByTagName('*')).find(el => el.textContent.includes('Incomplete passwords submitted.'));");
            if (element!= null) {
            	System.out.println("Confirm the password first");
            	driver.findElement(confirmPassword).sendKeys("Anushma1234");
        		editFields(newAddress);
            	isEdited= true;
            			
            }
            return isEdited;
    }
    
    public void editFields(String editAddress) {
    	driver.findElement(address).clear();
    	driver.findElement(address).sendKeys(editAddress);
    	driver.findElement(updateButton).click();
    }
}


	
