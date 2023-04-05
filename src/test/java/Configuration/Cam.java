package Configuration;

import java.awt.AWTException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import PageObjects.Components;
import Utilities.ConfigDetails;

public class Cam extends BaseClass {
	@Test
	public void startConfiguring() throws EncryptedDocumentException, IOException, InterruptedException, AWTException
	{
		Components components = new Components(driver);
		ConfigDetails set = new ConfigDetails();
		driver.get(set.conf(0, 1));

		//Login to Application
		components.login(set.conf(1, 1), set.conf(2, 1));
		Thread.sleep(2000);

		//Close modify password tips popup
		components.exitFromTipsPopup();
		Thread.sleep(2000);

		//To click on configuration button
		components.configuration();
		Thread.sleep(5000);

		//To click on system tab and navigate log search screen	
		components.system();

		//To select start date
		components.clickonstartdatefield.click();		
		String datefrom = set.conf(3,1);
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
				System.out.println("You are downloading logs from "+datefrom);
			}
		}
		
		components.clickondayone.click();
		Thread.sleep(1000);
		components.donebutton.click();
		
		//To export logs
		Thread.sleep(2000);
		components.clickonlogexport.click();
		components.clickonok.click();
	}
}