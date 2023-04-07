package Configuration;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.Alert;
import org.testng.annotations.Test;
import PageObjects.Components;
import Utilities.ConfigDetails;

public class Network extends BaseClass{
	@Test
	public void network() throws EncryptedDocumentException, IOException, InterruptedException {
		Components components = new Components(driver);
		ConfigDetails set = new ConfigDetails();
		components.networkbutton.click();
		components.basicsetupbutton.click();

		//IPv4 Subnet Mask
		String subnetmask=components.subnetmask.getAttribute("value");
		set.conf1("Sheet3",0, 0, subnetmask);

		//IPv4 Default Gateway
		String defaultgateway=components.defaultgateway.getAttribute("value");
		set.conf1("Sheet3",1, 0, defaultgateway);

		//IPv4 predefined server
		String preffereddnsserver=components.preffereddnsserver.getAttribute("value");
		set.conf1("Sheet3",2, 0, preffereddnsserver);

		//Save
		components.savebutton1.click();
		Thread.sleep(2000);
		Alert acc = driver.switchTo().alert();
		acc.accept();
		
		//Logout
		Thread.sleep(1000);
		components.logoutbutton.click();
		Alert al = driver.switchTo().alert();
		al.accept();
	}
	
}
