package Configuration;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import PageObjects.Components;
import Utilities.ConfigDetails;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static WebDriver driver;
	@BeforeClass
	public void before() throws InterruptedException, EncryptedDocumentException, IOException {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		Components components = new Components(driver);
		ConfigDetails set = new ConfigDetails();
		driver.get(set.conf("Sheet1",0, 1));

		//Login to Application
		components.login(set.conf("Sheet1",1, 1), set.conf("Sheet1",2, 1));
		Thread.sleep(2000);

		//Close modify password tips popup
		components.exitFromTipsPopup();
		Thread.sleep(5000);

		//To click on configuration button
		components.configuration();
		Thread.sleep(5000);
	}

	
	@AfterClass
	public void after() {
//		driver.quit();
	}

}
