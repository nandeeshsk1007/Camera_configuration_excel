package Configuration;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;
import PageObjects.Components;
import Utilities.ConfigDetails;

public class Devicedetails extends BaseClass {
	@Test
	public void checkDeviceInfo() throws InterruptedException, EncryptedDocumentException, IOException {

		Components components = new Components(driver);
		ConfigDetails set = new ConfigDetails();
		components.systemtab.click();
		components.systemconfbutton.click();
		String devicename = components.devicename.getAttribute("value");
		set.conf1("Sheet2",0, 0, devicename);
		String firmwareversion = components.firmwarever.getAttribute("value");
		set.conf1("Sheet2",1, 0, firmwareversion);
		String webverion = components.firmwarever.getAttribute("value");
		set.conf1("Sheet2",2, 0, webverion);
		
		//Logout
		Thread.sleep(1000);
		components.logoutbutton.click();
	}
}
