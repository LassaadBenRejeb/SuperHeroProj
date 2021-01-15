package superhero.stepDefinition;

import java.awt.AWTException;

import org.openqa.selenium.WebDriver;



import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import superhero.page.ProfilePage;
import superhero.utility.Hook;

public class Profile {
	
	static WebDriver driver = Hook.driver;


	
	@When("I upload the photo {string}")
	public void i_upload_the_photo(String photo) throws AWTException, InterruptedException {
		
		ProfilePage profilePage = new ProfilePage(driver);
		profilePage.i_upload_the_photo(photo);

	}
	
	@Then("the photo is uploaded")
	public void the_photo_is_uploaded() throws InterruptedException {

		ProfilePage profilePage = new ProfilePage(driver);
		profilePage.the_photo_is_uploaded();

	}
	
	@Then("the value of profile description is {string}")
	public void the_value_of_profile_description_is(String value) throws InterruptedException {

		ProfilePage profilePage = new ProfilePage(driver);
		profilePage.the_value_of_profile_description_is(value);
	}

}
