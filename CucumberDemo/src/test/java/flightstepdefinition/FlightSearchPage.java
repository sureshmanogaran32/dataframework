package flightstepdefinition;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FlightSearchPage {
	WebDriver driver;

@Given("the user is on flight serch page \\(siteurl={string})")
public void the_user_is_on_flight_serch_page(String siteurl) {
	driver = new ChromeDriver();
	driver.get(siteurl);
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
}

@When("the user enters source and destination \\(sourcePlace= {string}, destPlace= {string})")
public void the_user_enters_source_and_destination(String sourcePlace, String destPlace) {
   driver.findElement(By.xpath("//input[contains(@class, 'v2VFa')] [@tabindex='01']")).sendKeys(sourcePlace);
   driver.findElement(By.xpath("//input[contains(@class, 'v2VFa')] [@tabindex='02']")).sendKeys(destPlace);

}

@When("selects the date of journey \\(date={string})")
public void selects_the_date_of_journey(String dateOfJourney) {
   driver.findElement(By.xpath("//input[contains(@class, 'v2VFa')] [@tabindex='03']")).sendKeys(dateOfJourney);
}
/*
@When("selects the traveller and cabinet class")
public void selects_the_traveller_and_cabinet_class() {
    
}
*/
@When("the user clicks search button")
public void the_user_clicks_search_button() {
    driver.findElement(By.xpath("//button[contains(@class, 'QqFHMw')] [@tabindex='5']")).click();
}

@Then("the user redirects to search result page")
public void the_user_redirects_to_search_result_page() {
    
}
}
