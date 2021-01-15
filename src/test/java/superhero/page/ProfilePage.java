package superhero.page;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import superhero.utility.Hook;

public class ProfilePage {
	static WebDriver driver = Hook.driver;

	@FindBy(xpath = "//div[@class=\"cover-photo\"]")
	public static WebElement coverPhoto;
	
	@FindBy(xpath = "//div[@class=\"profile__description\"]")
	public static WebElement profileDescription;
	
	

	public ProfilePage(WebDriver driver) {
		driver=Hook.driver;
		PageFactory.initElements(driver, this);
	}

	public void i_upload_the_photo(String photo) throws AWTException, InterruptedException {


Thread.sleep(2000);
		String path = "src\\test\\resources\\fichier\\" + photo;




		File classpathRoot = new File(System.getProperty("user.dir"));
		File picturesDir = new File(classpathRoot, "\\src\\test\\resources\\fichier");
		File picture = new File(picturesDir, photo);
		String picturePath = picture.getAbsolutePath();
		System.out.println("picturePath==>"+picturePath);

		StringSelection ss = new StringSelection(picturePath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

		Thread.sleep(1000);
		Robot robot = new Robot();
		robot.delay(250);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.delay(50);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(1000);

	}
	
	public void the_photo_is_uploaded() throws InterruptedException {

		Thread.sleep(4000);
		
		Assert.assertTrue("!!! KO, there no photo uploaded", coverPhoto.getAttribute("style").contains("images"));

	}
	
	public void the_value_of_profile_description_is(String value) throws InterruptedException {
	   Thread.sleep(3000);
		Assert.assertEquals("!!! KO, The value of bio is not "+value+" !!!", value,
				profileDescription.getText());
		
		
	}

}
