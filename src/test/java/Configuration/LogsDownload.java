package Configuration;

import java.awt.AWTException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.Alert;
import org.testng.annotations.Test;
import PageObjects.Components;
import Utilities.ConfigDetails;

public class LogsDownload extends BaseClass{
	@Test
	public void downloadingLogs() throws EncryptedDocumentException, IOException, InterruptedException, AWTException {

		Components components = new Components(driver);
		ConfigDetails set = new ConfigDetails();
		//To click on system tab and navigate log search screen	
		components.system();

		//To select start date
		components.clickonstartdatefield.click();		
		String datefrom = set.conf("Sheet1",3,1);
		Thread.sleep(1000);
		if(components.monthandyear.getText().equals(datefrom)) {
			System.out.println("You are downloading "+datefrom+" logs");
		}

		else{
			String value = " ";
			while(value!=datefrom) {
				Thread.sleep(1000);
				if(value.equals(datefrom)) {
					break;
				}
				else {
					components.clickoncalendarbackbutton.click();
					String value1 = components.monthandyear.getText();
					value=value1;
				}
			}
			System.out.println("You are downloading logs from "+datefrom);
		}

		components.clickondayone.click();
		Thread.sleep(1000);
		components.donebutton.click();

		//To export logs
		Thread.sleep(2000);
		components.clickonlogexport.click();
		components.clickonok.click();
		
		//Logout
		Thread.sleep(1000);
		components.logoutbutton.click();
		Alert al = driver.switchTo().alert();
		al.accept();
	}
}
