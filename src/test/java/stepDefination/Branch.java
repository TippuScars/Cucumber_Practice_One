package stepDefination;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pageObjects.BranchPage;

public class Branch {
	WebDriver driver;
	BranchPage branchpage;
	Properties config;

	@Given("I want to launch my application with {string} url")
	public void i_want_to_launch_my_application_with_url(String url) throws FileNotFoundException, IOException {
		config = new Properties();

		config.load(new FileInputStream("./src/test/resources/propertyFiles/PrimasBank.properties"));

		if (config.getProperty("Browser").equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		} else if (config.getProperty("Browser").equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
		} else if (config.getProperty("Browser").equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
			driver.manage().window().maximize();
		} else {
			System.out.println("Enter valid Browser");
		}
		branchpage = new BranchPage(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(url);

	}

	@When("I enter valid {string} and {string}")
	public void i_enter_valid_and(String username, String password) {

		branchpage.username(username);
		branchpage.password(password);
	}

	@And("I click on login button")
	public void i_click_on_login_button() {
		branchpage.loginbtn();

	}

	@And("user click on branchbth")
	public void user_click_on_branchbth() {
		branchpage.clickbranch();
	}

	@And("user created the branch with valid data")
	public void user_created_the_branch_with_valid_data(DataTable dataTable) throws InterruptedException {

		// Convert DataTable to a List of Maps
		List<Map<String, String>> products = dataTable.asMaps(String.class, String.class);

		// Access data from the DataTable
		for (Map<String, String> product : products) {

			String barnchName = product.get("branchname");
			String adds1 = product.get("address1");
			String adds2 = product.get("address2");
			String adds3 = product.get("address3");
			String areaData = product.get("area");
			String zipdata = product.get("zipcode");
			String countryData = product.get("country");
			String statedata = product.get("state");
			String cityData = product.get("city");

			Thread.sleep(2000);
			branchpage.clickNewbranch();
			Thread.sleep(2000);
			branchpage.branchName(barnchName);
			branchpage.address1(adds1);
			branchpage.address2(adds2);
			branchpage.address3(adds3);
			branchpage.area(areaData);
			branchpage.zipcode(zipdata);
			branchpage.country(countryData);
			Thread.sleep(2000);
			branchpage.state(statedata);
			Thread.sleep(2000);
			branchpage.city(cityData);
			Thread.sleep(2000);
			branchpage.submit();
			Thread.sleep(4000);
			driver.switchTo().alert().accept();

		}

	}

	@And("close the browser")
	public void close_the_browser() throws InterruptedException {
		Thread.sleep(2000);
		driver.close();
	}

}
