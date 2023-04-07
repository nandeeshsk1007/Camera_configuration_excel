package Configuration;

import org.openqa.selenium.Alert;
import org.testng.annotations.Test;

import PageObjects.Components;

public class Image extends BaseClass{
	@Test
	public void imageOSD() throws InterruptedException {
		Components components = new Components(driver);
		components.imagebutton.click();
		components.OSDbutton.click();
		
		if(components.timebox.isSelected()) {
			components.timebox.click();
		}
		if(components.textbox.isSelected()) {
			components.textbox.click();
		}
		if(components.weekbox.isSelected()) {
			components.weekbox.click();
		}
		components.savebutton2.click();
		
		//Logout
		Thread.sleep(1000);
		components.logoutbutton.click();
		Alert al = driver.switchTo().alert();
		al.accept();
	}
}
