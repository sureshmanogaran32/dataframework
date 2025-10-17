package stepdefinition;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.*;

public class Register {

	WebDriver driver;
	@Given("the user enters the URL")
	public void the_user_enters_the_url() {
	driver = new ChromeDriver();
	        driver.manage().window().maximize();
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	        driver.get("https://automationexercise.com/login");
	}
	@When("the user enters name and email \\(name={string}, email={string})")
	public void the_user_enters_name_and_email(String name, String email) {
	     driver.findElement(By.name("name")).sendKeys(name);
	        driver.findElement(By.xpath("//button[text()='Signup']/preceding::input[@name='email'][1]")).sendKeys(email);
	}
	@When("submits the signup button")
	public void submits_the_signup_button() {
	    driver.findElement(By.xpath("//button[text()='Signup']")).click();
	}
	@Then("the user is redirected to the signup registration page")
	public void the_user_is_redirected_to_the_signup_registration_page() {
	    boolean isDisplayed = driver.findElement(By.xpath("//*[contains(text(), 'Enter Account')]")).isDisplayed();
	        if (!isDisplayed) {
	            throw new AssertionError("Signup page not displayed."); }
	}
	@When("the user enters password, firstname, lastname, and address \\(pswd={string},fname={string},lname={string},address={string})")
	public void the_user_enters_password_firstname_lastname_and_address(String pswd, String fname, 
			String lname,
			String address) {
	driver.findElement(By.id("password")).sendKeys(pswd);
	        driver.findElement(By.id("first_name")).sendKeys(fname);
	        driver.findElement(By.id("last_name")).sendKeys(lname);
	        driver.findElement(By.id("address1")).sendKeys(address);   
	}
	@When("enters country, state, city, zipcode, and mobile number")
	public void enters_country_state_city_zipcode_and_mobile_number() {
	     WebElement countryDropdown = driver.findElement(By.id("country"));
	        new Select(countryDropdown).selectByVisibleText("India");

	        driver.findElement(By.name("state")).sendKeys("Tamil Nadu");
	        driver.findElement(By.id("city")).sendKeys("Coimbatore");
	        driver.findElement(By.id("zipcode")).sendKeys("641004");
	        driver.findElement(By.id("mobile_number")).sendKeys("1234567890");
	}
	@When("the user clicks the create account button")
	public void the_user_clicks_the_create_account_button() {
	    driver.findElement(By.xpath("//button[contains(text(), 'Create Account')]")).click();
	}
	@Then("user should redirect to successful page")
	public void sucessfullPage() {
		boolean b = driver.findElement(By.xpath("//*[text()='Account Created!']")).isDisplayed();
		Assert.assertEquals(b,true);
	}



}
