package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Components {

	//To Login
	@FindBy (xpath="//input[@placeholder=\"User Name\"]")
	private WebElement Username;
	@FindBy (xpath="//input[@placeholder=\"Password\"]")
	private WebElement Password;
	@FindBy (xpath="//button[@id=\"btnLogin\"]")
	private WebElement loginbutton;

	//To exit from modify password screen
	@FindBy (xpath="//input[@value='60 Minutes later modified']")
	private WebElement exitbutton;

	//TO click on configuration button
	@FindBy (xpath = "//a[.='Configuration']")
	public WebElement configbutton;

	//To click on system tab and search screen	
	@FindBy (xpath = "//a[.=' System ']")
	public WebElement systemtab;
	@FindBy (xpath = "(//a[.='Log Search'])[1]")
	private WebElement logsearchbutton;
	
	//To click on system configuration button
	@FindBy (xpath="//a[.='System Configuration']")
	public WebElement systemconfbutton;
	
	//To select start date
	@FindBy (xpath="//input[@class='time J-begin-time hasDatepicker']")
	public WebElement clickonstartdatefield;
	@FindBy (xpath="//span[@class='ui-icon ui-icon-circle-triangle-w']")
	public WebElement clickoncalendarbackbutton;
	@FindBy (xpath="//div[@class='ui-datepicker-title']")
	public WebElement monthandyear;
	@FindBy (xpath="//a[.='1']")
	public WebElement clickondayone;
	@FindBy (xpath="//button[.='Done']")
	public WebElement donebutton;
	
	//To export logs
	@FindBy (xpath="//a[.='Log export']")
	public WebElement clickonlogexport;
	@FindBy (xpath="//span[.='OK']")
	public WebElement clickonok;
	
	//Device name, Firmware version and WEB version
	@FindBy (xpath="//input[@id='devName']")
	public WebElement devicename;
	@FindBy (xpath="//input[@lssetter='devinfo.firmwareVersion.']")
	public WebElement firmwarever;
	@FindBy (xpath="//*[@id=\"devInfo\"]/div/div[3]/input")
	public WebElement webversion;
	
	//To reboot camera
	@FindBy (xpath="//a[.='Maintenance']")
	public WebElement maintanancebutton;
	@FindBy (xpath="//button[.='Reboot']")
	public WebElement rebootbutton;
	
	//Video
	@FindBy (xpath="//a[.=' Video ']")
	public WebElement videomain;
	@FindBy (xpath="(//a[.='Video'])[2]")
	public WebElement videosub;
	@FindBy (xpath="//*[@id=\"selStreamType\"]")
	public WebElement streamtype;
	@FindBy (xpath="//*[@id=\"blkVideoEnc\"]/div[2]/select")
	public WebElement profile;
	@FindBy (xpath = "//*[@id=\"encodeType\"]")
	public WebElement videoencoding;
	@FindBy (xpath = "//*[@id=\"selEncType\"]")
	public WebElement resolution;
	@FindBy (xpath = "//*[@id=\"frameRate\"]")
	public WebElement framerate;
	@FindBy (xpath = "//*[@id=\"bitRate\"]")
	public WebElement bitrate;
	@FindBy (xpath = "//*[@id=\"bitrateType\"]")
	public WebElement ratecontrol;
	@FindBy (xpath = "//*[@id=\"iFrameRate\"]")
	public WebElement Iframeinterval;
	@FindBy (xpath = "//*[@id=\"waterMark\"]")
	public WebElement Watermark;
	@FindBy (xpath = "//*[@id=\"btnSaveVideo\"]")
	public WebElement savebutton;
	
	//Network
	@FindBy (xpath = "//a[.=' Network ']")
	public WebElement networkbutton;
	@FindBy (xpath = "//a[.='Basic Setup']")
	public WebElement basicsetupbutton;
	@FindBy (xpath = "//*[@id=\"subNetMask\"]")
	public WebElement subnetmask;
	@FindBy (xpath = "//*[@id=\"gateway\"]")
	public WebElement defaultgateway;
	@FindBy (xpath = "//*[@id=\"dns1Ip\"]")
	public WebElement preffereddnsserver;
	@FindBy (xpath = "//*[@id=\"cfgTcpIp\"]/div[18]/ul/input")
	public WebElement savebutton1;
	
	//Image
	@FindBy (xpath = "//a[.=' Image ']")
	public WebElement imagebutton;
	@FindBy (xpath = "//a[.='OSD']")
	public WebElement OSDbutton;
	
	@FindBy (xpath = "//*[@id=\"optionsBlock\"]/div/div[1]/div[2]/div[1]/span/input")
	public WebElement timebox;
	@FindBy (xpath = "//*[@id=\"chkOSDTxtShow\"]")
	public WebElement textbox;
	@FindBy (xpath = "//*[@id=\"chkOSDWeekShow\"]")
	public WebElement weekbox;
	@FindBy (xpath = "//*[@id=\"optionsBlock\"]/div/div[3]/input")
	public WebElement savebutton2;
	
	//Logout
	@FindBy (xpath = "//a[.='Logout']")
	public WebElement logoutbutton;
	
	
	public Components(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}


	//Login
	public void login(String username, String password) throws InterruptedException {
		Thread.sleep(1000);
		Username.sendKeys(username);
		Thread.sleep(1000);
		Password.sendKeys(password);
		Thread.sleep(1000);
		loginbutton.click();
	}

	//To exit from modify password screen
	public void exitFromTipsPopup() throws InterruptedException {
		Thread.sleep(1000);
		exitbutton.click();
	}

	//To click on configuration
	public void configuration() throws InterruptedException {
		Thread.sleep(5000);
		configbutton.click();
		Thread.sleep(1000);
	}

	//To click on system tab and navigate log search screen	
	public void system() throws InterruptedException {
		Thread.sleep(1000);
		systemtab.click();
		Thread.sleep(1000);
		logsearchbutton.click();
		Thread.sleep(1000);
	}
}
