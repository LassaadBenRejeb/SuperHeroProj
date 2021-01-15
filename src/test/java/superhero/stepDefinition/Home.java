package superhero.stepDefinition;

import cucumber.api.java.en.And;
import org.openqa.selenium.WebDriver;



import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import superhero.page.HomePage;
import superhero.utility.Hook;

import java.awt.*;

public class Home {




	static WebDriver driver = Hook.getDriver();

	@Given("the home page is opened")
	public void the_home_page_is_opened() {

		HomePage homePage = new HomePage(driver);
		homePage.the_home_page_is_opened();

	}
	
	@When("I click on {string} in the left menu")
	public void i_click_on_in_the_left_menu(String opt) {

		HomePage homePage = new HomePage(driver);
		homePage.i_click_on_in_the_left_menu(opt);
	    
	}
	
	
	@Then("the video finded is {string}")
	public void the_video_finded_is(String vid) throws InterruptedException {
		HomePage homePage = new HomePage(driver);
		homePage.the_video_finded_is(vid);
		}
	
	@When("I click on button of comment")
	public void i_click_on_button_of_comment() {
		
		HomePage homePage = new HomePage(driver);
		homePage.i_click_on_button_of_comment();

	}
	
	@Then("the comment is added")
	public void the_comment_is_added() throws InterruptedException {

		HomePage homePage = new HomePage(driver);
		homePage.the_comment_is_added();


	}
	
	@When("I add a reply to a comment")
	public void i_add_a_reply_to_a_comment() throws InterruptedException {
	
		HomePage homePage = new HomePage(driver);
		homePage.i_add_a_reply_to_a_comment();

	}

	@Then("the replay is added")
	public void the_replay_is_added() {
	
		HomePage homePage = new HomePage(driver);
		homePage.the_replay_is_added();

	}
	
	@Then("all post finded are from youtube")
	public void all_post_finded_are_from_youtube() {
		HomePage homePage = new HomePage(driver);
		homePage.all_post_finded_are_from_youtube();

	}
	


	@Given("the extension chrome is {string}")
	public void the_extension_chrome_is(String ins) throws InterruptedException, AWTException {
		HomePage homePage = new HomePage(driver);
		homePage.the_extension_chrome_is(ins);
	   
	}

	@And("I click on Allow YouTube button")
	public void iClickOnAllowYouTubeButton() throws InterruptedException {
		HomePage homePage = new HomePage(driver);
		homePage.iClickOnAllowYouTubeButton();
	}

	@When("I click on play button of first video")
	public void iClickOnPlayButtonOfFirstVideo() throws InterruptedException {
		HomePage homePage = new HomePage(driver);
		homePage.iClickOnPlayButtonOfFirstVideo();
	}

	@And("I click on play button youtube of first video")
	public void iClickOnPlayButtonYoutubeOfFirstVideo() throws InterruptedException {
		HomePage homePage = new HomePage(driver);
		homePage.iClickOnPlayButtonYoutubeOfFirstVideo();
	}


	@Then("the video is played")
	public void theVideoIsPlayed() throws InterruptedException {
		HomePage homePage = new HomePage(driver);
		homePage.the_video_is_played();
	}
}
