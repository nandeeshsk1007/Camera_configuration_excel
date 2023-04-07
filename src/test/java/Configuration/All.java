package Configuration;

import java.awt.AWTException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import PageObjects.Components;
import Utilities.ConfigDetails;

public class All extends BaseClass {
	@Test(priority = 1)
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
	}

	@Test(priority = 2)
	public void checkDeviceInfo() throws InterruptedException, EncryptedDocumentException, IOException {

		Components components = new Components(driver);
		ConfigDetails set = new ConfigDetails();
		components.systemconfbutton.click();
		String devicename = components.devicename.getAttribute("value");
		set.conf1("Sheet2",0, 0, devicename);
		String firmwareversion = components.firmwarever.getAttribute("value");
		set.conf1("Sheet2",1, 0, firmwareversion);
		String webverion = components.firmwarever.getAttribute("value");
		set.conf1("Sheet2",2, 0, webverion);
	}

	@Test(priority = 6)
	public void reboot() throws InterruptedException {

		Components components = new Components(driver);
		Thread.sleep(2000);
		components.systemconfbutton.click();
		Thread.sleep(2000);
		components.maintanancebutton.click();
		components.rebootbutton.click();
		Thread.sleep(2000);
		Alert acc = driver.switchTo().alert();
		acc.accept();
	}

	@Test(priority = 3)
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
	}
	@Test(priority = 4)
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
	}
	@Test(priority = 5)
	public void imageOSD() {
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
	}
}