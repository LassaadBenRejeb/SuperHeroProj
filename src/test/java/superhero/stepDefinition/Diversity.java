package superhero.stepDefinition;

import cucumber.api.java.en.And;
import org.openqa.selenium.WebDriver;



import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import superhero.page.DiversityPage;
import superhero.utility.Hook;

public class Diversity {

	static WebDriver driver = Hook.driver;

	@Then("the page {string} is opened")
	public void the_page_is_opened(String page) {

		DiversityPage diversityPage = new DiversityPage(driver);
		diversityPage.the_page_is_opened(page);

	}

	@When("I click on the button of {string}")
	public void i_click_on_the_button_of(String btn) throws InterruptedException {
		
		DiversityPage diversityPage = new DiversityPage(driver);
		diversityPage.i_click_on_the_button_of(btn);

	}
	
	@When("I enter {string} in {string}")
	public void i_enter_in(String value, String filter) throws InterruptedException {
		
		DiversityPage diversityPage = new DiversityPage(driver);
		diversityPage.i_enter_in(value,filter);

	}



	@When("I click on {string} button of first video")
	public void i_click_on_button_of_first_video(String btn) throws InterruptedException {

		DiversityPage diversityPage = new DiversityPage(driver);
		diversityPage.i_click_on_button_of_first_video(btn);

	}


	@When("I disallow cookies from {int}rd party providers")
	public void i_disallow_cookies_from_rd_party_providers(Integer int1) {

		DiversityPage diversityPage = new DiversityPage(driver);
		diversityPage.i_disallow_cookies_from_rd_party_providers(int1);

	}
	
	
	
	
	@Given("I select the checkbox {string}")
	public void i_select_the_checkbox(String opt) throws InterruptedException {
		DiversityPage diversityPage = new DiversityPage(driver);
		diversityPage.i_select_the_checkbox(opt);
	}

	@Given("I click on {string} button")
	public void i_click_on_button(String btn) {
		DiversityPage diversityPage = new DiversityPage(driver);
		diversityPage.i_click_on_button(btn);
	}

	

	
	






	@When("I navigate to {string}")
	public void i_navigate_to(String url) {
		DiversityPage diversityPage = new DiversityPage(driver);
		diversityPage.i_navigate_to(url);

	}

	@When("I remove the account")
	public void iRemoveTheAccount() throws InterruptedException {
		DiversityPage diversityPage = new DiversityPage(driver);
		diversityPage.iRemoveTheAccount();
	}

	@And("I refresh the page")
	public void iRefreshThePage() {
		Hook.driver.navigate().refresh();
	}
}
