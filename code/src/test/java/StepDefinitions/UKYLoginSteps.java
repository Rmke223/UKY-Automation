package StepDefinitions;


import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class UKYLoginSteps {

	WebDriver driver = null;

	@Given("browser is open")
	public void browser_is_open() {
		System.out.println("this");
//		String projectPath = System.getProperty("user.dir");
//		System.setProperty("webdriver.chrome.driver", projectPath+"/src/test/resources/drivers/chromedriver");
//		driver = new ChromeDriver();
		SafariOptions options = new SafariOptions();
        driver = new SafariDriver(options);
       
		
	}

	@And("user is on uky page")
	public void user_is_on_uky_page() {
		driver.navigate().to("https://myuk.uky.edu");;
	}
	
	@And("^user clicks on the \"(.*)\" button$")
	public void user_clicks_on_button(String buttonID) {
		driver.findElement(By.id(buttonID)).click();
	}

	@And("^user enters username in \"(.*)\" field$")
	public void user_enters_username_in_field(String fieldID) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.findElement(By.id(fieldID)).sendKeys("rmke223@g.uky.edu");
	}

	@And("^user enters password in \"(.*)\" field$")
	public void user_enters_password_in_in_password_field(String fieldID) {
		driver.findElement(By.id(fieldID)).sendKeys("Marley123!");
	}
	
	@Then("^check that \"(.*)\" is present$")
	public boolean check_that_is_present(String elementID) {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		try {
	        driver.findElement(By.id(elementID));
	    } catch (NoSuchElementException e) {
	        return false;
	    }
	    return true;
	}
	@After
    public void cleanUp() {
        if(this.driver != null) {
        	driver.close();
        }
        
    }

	
}
