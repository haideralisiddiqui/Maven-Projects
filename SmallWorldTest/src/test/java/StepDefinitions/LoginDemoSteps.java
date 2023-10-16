package StepDefinitions;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.*;

public class LoginDemoSteps {
	WebDriver driver = null;
	
	
	@Given("Browser is open")
	public void browser_is_open() {
		System.out.println("Inside Step - Browser is Open");
		String projectPath= System.getProperty("user.dir");
		System.out.println("Project path is:" +projectPath);
		System.setProperty("webdriver.chrome.driver",
				projectPath+"/src/test/resources/Drivers/chromedriver.exe");
		
		driver=new ChromeDriver();
	}

	@And("user is on login page")
	public void user_is_on_login_page() {
	   driver.navigate().to("https://www.saucedemo.com/");
	}

	@When("^user enters (.*) and (.*)$")
	public void user_enters_username_and_password(String username, String password) throws InterruptedException {
	    driver.findElement(By.id("user-name")).sendKeys(username);
	    driver.findElement(By.id("password")).sendKeys(password);
	    
	    Thread.sleep(2000);
	    
	}

	@And("user clicks Login CTA")
	public void user_clicks_login_cta() throws InterruptedException {
		driver.findElement(By.id("login-button")).click();
		Thread.sleep(2000);
		
	}

	@Then("user is navigated to homepage")
	public void user_is_navigated_to_homepage() throws InterruptedException {
		driver.findElement(By.id("react-burger-menu-btn")).click();
		Thread.sleep(2000);
	    driver.getPageSource().contains("Logout");
	    driver.close();
	    driver.quit();
	}
}