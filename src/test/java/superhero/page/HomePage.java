package superhero.page;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import superhero.utility.Hook;

public class HomePage {

	static WebDriver driver = Hook.driver;



	@FindBy(xpath = "//div[@class=\"tip-title\"]")
	public static WebElement video_finded;

	@FindBy(xpath = "//div[@class=\"tip__comments tip__comments--hascomments\"]")
	public static WebElement btn_comment;

	@FindBy(xpath = "//div[@class=\"tip-comment-list\"]/div[@class=\"tree\"][1]/div[@class=\"tip-comment clickable\"][1]/div[@class=\"note\"]")
	public static WebElement text_comment;

	@FindBy(xpath = "//div[@class=\"tip-comment-list\"]/div[@class=\"tree\"][1]/div[@class=\"tip-comment clickable\"][2]/div[@class=\"note\"]")
	public static WebElement text_reply;

	@FindBy(xpath = "//div[@class=\"tip-comment-list\"]/div[@class=\"tree\"][1]/form[1]//textarea[@placeholder=\"Add reply\"]")
	public static WebElement input_replay;

	@FindAll(@FindBy(id = "//div[@class=\"source\"]"))
	public static List<WebElement> list_sources_results;

	@FindBy(xpath = "//img[@alt=\"Chrome\"]")
	public static WebElement chromeExtension;


	@FindAll(@FindBy(xpath = "//iframe"))
	public static List<WebElement> listFrame;

	@FindAll(@FindBy(xpath = "//div[text()=\"Ajouter à Chrome\" or text()=\"Add to Chrome\"]"))
	public static List<WebElement> listBtnAddToChrome;

	@FindBy(xpath = "//*[@title=\"Reply\"]")
	public static WebElement btnSubmitReplay;

	@FindBy(xpath = "//button[contains(text(),\"Allow YouTube\")]")
	public static WebElement btnAllow;

	@FindAll(@FindBy(xpath = "//button[@class=\"ytp-large-play-button ytp-button\" or @class=\"button-plain play play-button\"]"))
	public static List<WebElement> listBtnPlay;

	@FindBy(xpath = ".//button[@class=\"ytp-large-play-button ytp-button\" and @aria-label=\"Lire\"]")
	public static WebElement btnPlayYoutube;

	@FindAll(@FindBy(xpath = ".//button[@class=\"ytp-large-play-button ytp-button\" and @aria-label=\"Lire\"]"))
	public static List<WebElement> listbtnPlayYoutube;






	Set<String> allwindows;

	public HomePage(WebDriver driver) {
		//HomePage.driver = driver;
		driver=Hook.driver;
		PageFactory.initElements(driver, this);
	}

	public void the_home_page_is_opened() {


		Hook.driver.navigate().to("https://superhero.com/");



		Assert.assertTrue("!!! KO, the home page of superHero is not opened",
				Hook.driver.getCurrentUrl().contains("superhero.com"));

	}

	public void i_click_on_in_the_left_menu(String opt) {

		WebElement el = Hook.driver.findElement(By.xpath("//div[@class=\"navigation\"]/a[text()=\"" + opt + "\"]"));
		el.click();

	}

	public void the_video_finded_is(String vid) throws InterruptedException {

		Thread.sleep(2000);
		Assert.assertEquals("!!! KO, the video finded is not "+vid+" !!!!", vid,
				video_finded.getText());
	}

	public void i_click_on_button_of_comment() {

		btn_comment.click();

	}

	public void the_comment_is_added() throws InterruptedException {
		Thread.sleep(1000);
		Assert.assertEquals("!!! KO, the comment is not added", "comment test",
				text_comment.getText());

	}

	public void i_add_a_reply_to_a_comment() throws InterruptedException {
		input_replay.sendKeys("reply test");
		Thread.sleep(5000);

		btnSubmitReplay.click();

	}

	public void the_replay_is_added() {

		Assert.assertEquals("!!! KO, the reply is not added", "reply test",
				text_reply.getText());

	}

	public void all_post_finded_are_from_youtube() {

		boolean sourceDifferentYoutube = false;
		int size = list_sources_results.size();
		for (int i = 0; i < size; i++) {
			if (!(list_sources_results.get(i).getText().contains(" www.youtube.com "))) {
				sourceDifferentYoutube = true;
				Assert.assertTrue("!!!! KO, ,There source of video :"+i+ "- is not youtube", sourceDifferentYoutube);
			}
		}



	}


	public void the_extension_chrome_is(String ins) throws InterruptedException, AWTException {

		String parentWindow;
		if(ins.equals("installed"))
		{
			if (listFrame.size() == 1) {
				Hook.driver.switchTo().frame(0);;

			}
			chromeExtension.click();



			parentWindow = Hook.driver.getWindowHandle();
			allwindows = Hook.driver.getWindowHandles();
			for (String childWindow : allwindows) {
				if (!childWindow.equals(parentWindow)) {
					Hook.driver.switchTo().window(childWindow);
				}
			}

			Thread.sleep(2000);

			listBtnAddToChrome.get(0).click();

			Thread.sleep(2000);



			Robot robot = new Robot();
			robot.delay(3000);
			robot.keyPress(KeyEvent.VK_LEFT);
			Thread.sleep(2000);
			robot.keyPress(KeyEvent.VK_ENTER);

			Thread.sleep(2000);

			Hook.driver.close();

			Hook.driver.switchTo().window(parentWindow);

		}
	}


	public void iClickOnAllowYouTubeButton() throws InterruptedException {

		btnAllow.click();
		Thread.sleep(1000);
	}

	public void iClickOnPlayButtonOfFirstVideo() throws InterruptedException {
		Actions actions = new Actions(Hook.driver);
		actions.moveToElement(listBtnPlay.get(0)).click().build().perform();
		Thread.sleep(1000);
	}


	public void iClickOnPlayButtonYoutubeOfFirstVideo() throws InterruptedException {
		Thread.sleep(2000);


		Hook.driver.switchTo().frame(Hook.driver.findElement(By.xpath("//iframe[contains(@src,\"youtube\")]")));


		btnPlayYoutube.click();
		Thread.sleep(1000);

	}

	public void the_video_is_played() throws InterruptedException {


		Thread.sleep(2000);
		Assert.assertFalse("!!! KO, the video is not played",btnPlayYoutube.isDisplayed());

		driver.switchTo().defaultContent();

	}


}