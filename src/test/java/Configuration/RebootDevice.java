package Configuration;

import org.openqa.selenium.Alert;
import org.testng.annotations.Test;
import PageObjects.Components;

public class RebootDevice extends BaseClass {
	@Test
	public void reboot() throws InterruptedException {

		Components components = new Components(driver);
		Thread.sleep(2000);
		components.systemtab.click();
		components.systemconfbutton.click();
		Thread.sleep(2000);
		components.maintanancebutton.click();
		components.rebootbutton.click();
		Thread.sleep(2000);
		Alert acc = driver.switchTo().alert();
		acc.accept();
	}
}
