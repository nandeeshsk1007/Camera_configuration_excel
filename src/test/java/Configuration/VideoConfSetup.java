package Configuration;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import PageObjects.Components;
import Utilities.ConfigDetails;

public class VideoConfSetup extends BaseClass{
	@Test
	public void video() throws InterruptedException, EncryptedDocumentException, IOException {
		Components components = new Components(driver);
		ConfigDetails set = new ConfigDetails();
		components.videomain.click();
		Thread.sleep(2000);
		components.videosub.click();
		Thread.sleep(2000);

		//Stream type
		Select strmtype = new Select(components.streamtype);
		String streamtype = components.streamtype.getAttribute("value");
		if(streamtype!=set.conf("Sheet1",5, 1)) {
			strmtype.selectByVisibleText(set.conf("Sheet1",5, 1));
		}

		//Profile
		Select prfl = new Select(components.profile);
		String profile = components.profile.getAttribute("value");
		if(profile!=set.conf("Sheet1",6, 1)) {
			prfl.selectByVisibleText(set.conf("Sheet1",6, 1));
		}

		//Video encoding
		Select vdoencdng = new Select(components.videoencoding);
		String videoencoding = components.videoencoding.getAttribute("value");
		if(videoencoding!=set.conf("Sheet1",7, 1)) {
			vdoencdng.selectByVisibleText(set.conf("Sheet1",7, 1));
		}

		//Resolution
		Select reslutn = new Select(components.resolution);
		String resolution = components.resolution.getAttribute("value");
		if(resolution!=set.conf("Sheet1",8, 1)) {
			reslutn.selectByVisibleText(set.conf("Sheet1",8, 1));
		}

		//Frame Rate
		Select frmrt = new Select(components.framerate);
		String framerate = components.framerate.getAttribute("value");
		if(framerate!=set.conf("Sheet1",9, 1)) {
			frmrt.selectByVisibleText(set.conf("Sheet1",9, 1));
		}

		//Bit rate
		String bitrate=components.bitrate.getAttribute("value");
		if(bitrate!=set.conf("Sheet1",10, 1)) {
			Thread.sleep(2000);
			components.bitrate.clear();
			Thread.sleep(2000);
			components.bitrate.sendKeys(set.conf("Sheet1",10, 1));
		}

		//Rate control
		Select rtcntrl = new Select(components.ratecontrol);
		String ratecontrol = components.ratecontrol.getAttribute("value");
		if(ratecontrol!=set.conf("Sheet1",11, 1)) {
			rtcntrl.selectByVisibleText(set.conf("Sheet1",11, 1));
		}

		//I-Frame Interval
		String ifrmintrvl=components.Iframeinterval.getAttribute("value");
		if(ifrmintrvl!=set.conf("Sheet1",12, 1)) {
			Thread.sleep(2000);
			components.Iframeinterval.clear();
			Thread.sleep(2000);
			components.Iframeinterval.sendKeys(set.conf("Sheet1",12, 1));
		}

		//Watermark
		Select wtrmrk = new Select(components.Watermark);
		String Watermark = components.Watermark.getAttribute("value");
		if(Watermark!=set.conf("Sheet1",13, 1)) {
			wtrmrk.selectByVisibleText(set.conf("Sheet1",13, 1));
		}

		//Save
		components.savebutton.click();
		
		//Logout
		Thread.sleep(1000);
		components.logoutbutton.click();
		Alert al = driver.switchTo().alert();
		al.accept();
	}
}
