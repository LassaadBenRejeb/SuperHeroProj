package superhero.page;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import superhero.utility.Hook;

public class DiversityPage {
	static WebDriver driver = Hook.driver;



	@FindAll(@FindBy(xpath = "//iframe"))
	public static List<WebElement> listFrame;

	@FindBy(xpath = "//iframe")
	public static WebElement frame;

	@FindBy(xpath = ".//div[@class=\"header\"]//button")
	public static WebElement headerbtn;

	@FindBy(xpath = ".//button[@data-cy=\"settings\"]")
	public static WebElement btnSetting;

	@FindBy(xpath = ".//span[contains(text(),\"Remove account\")]")
	public static WebElement btnRemoveAccount;







	public DiversityPage(WebDriver driver) {
		//DiversityPage.driver = driver;
		driver=Hook.driver;
		PageFactory.initElements(driver, this);
	}


	public void the_page_is_opened(String page) {


		Assert.assertTrue("!!! KO, the page:- "+page+"-  is not opened", Hook.driver.getCurrentUrl().contains(page));

	}

	public void i_click_on_the_button_of(String btn) throws InterruptedException {
		Thread.sleep(1000);
		WebElement el = Hook.driver.findElement(By.xpath("//*[@title=\""+btn+"\"]"));
		el.click();



	}

	public void i_enter_in(String value, String filter) throws InterruptedException {
		Thread.sleep(3000);
		if(frame.findElements(By.xpath(".//*[@placeholder=\""+filter+"\"]")).size()>0){
			Hook.driver.switchTo().frame(1);

		}



		List<WebElement> listEl = Hook.driver.findElements(By.xpath(".//*[@placeholder=\""+filter+"\"]"));

		Actions actions = new Actions(Hook.driver);
		actions.moveToElement(listEl.get(0));
		actions.perform();

		if(filter.equals("Add reply"))
		{
			listEl.get(1).sendKeys(value);
		}

		else {
			listEl.get(0).sendKeys(value);
		}
		Hook.driver.switchTo().defaultContent();

	}

	public void i_click_on_button_of_first_video(String btn) throws InterruptedException {


		List<WebElement> lbtn = Hook.driver.findElements(By.xpath("//button[contains(@class,\""+btn+"\")]"));

		if(btn.equals("button-plain play play-button"))
		{
			Actions actions = new Actions(Hook.driver);
			actions.moveToElement(lbtn.get(0)).click().build().perform();
			Thread.sleep(1000);
		}

		else {
			lbtn.get(0).click();
		}
	}

	public void i_disallow_cookies_from_rd_party_providers(Integer int1) {

		Hook.driver.manage().deleteAllCookies();
		Hook.driver.navigate().refresh();

	}


	public void i_select_the_checkbox(String opt) throws InterruptedException {
//driver=Hook.driver;

		Thread.sleep(5000);
		//System.out.println("listFrame.size()=>"+listFrame.size());
		if (listFrame.size() == 1) {
			Hook.driver.switchTo().frame(0);;

		}



		WebElement el = Hook.driver.findElement(By.xpath(".//label[@class=\"checkbox-container\"]//*[contains(text(),\""+opt+"\")]"));
		el.click();

		Hook.driver.switchTo().defaultContent();

	}

	public void i_click_on_button(String btn) {

		if (listFrame.size() == 1) {
			Hook.driver.switchTo().frame(0);;

		}

		WebElement el = Hook.driver.findElement(By.xpath("//button[contains(text(),\""+btn+"\")]"));
		el.click();
		Hook.driver.switchTo().defaultContent();
	}

	public void i_navigate_to(String url) {
		Hook.driver.navigate().to(url);

	}


	public void iRemoveTheAccount() throws InterruptedException {
		Hook.driver.navigate().refresh();
		Thread.sleep(2000);

		if (listFrame.size() == 1) {
			Hook.driver.switchTo().frame(0);;

		}




		headerbtn.click();
		Thread.sleep(500);

		btnSetting.click();
		Thread.sleep(500);
		btnRemoveAccount.click();
		i_click_on_button("Confirm");



	}




}
