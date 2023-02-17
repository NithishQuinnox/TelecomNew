package PageFactory;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;


public class PFTariff {
	
	
	ExtentTest extenttest;
	WebDriver driver;
	
	public PFTariff(WebDriver driver) {
		this.driver=driver;
		//this.extenttest = extenttest;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//*[@id=\"navbar-brand-centered\"]/ul/li[8]/a")
    WebElement TelecomProject;
	

	@FindBy(linkText =  "Add Tariff Plan")    
	WebElement tplan;
	
	@FindBy(id = "rental1")
	WebElement rental;
	
	@FindBy(id = "local_minutes")
	WebElement localmins;
	
	@FindBy(id = "inter_minutes")
	WebElement intermins;
	
	@FindBy(id = "sms_pack")
	WebElement smspack;
	
	@FindBy(id = "minutes_charges")
	WebElement localcharges;
	
	@FindBy(id = "inter_charges")
	WebElement intercharges;
	
	@FindBy(id = "sms_charges")
	WebElement smscharges;
	
	@FindBy(xpath = "//*[@id=\"main\"]/div/form/div/div[36]/ul/li[1]/input")
	WebElement submit1;
	
	@FindBy(xpath = "//*[@id=\"main\"]/div/ul/li/a")
	WebElement home1;
	
	@FindBy(xpath = "//*[@id=\"main\"]/div/form/div/div[36]/ul/li[2]/input")
	WebElement reset1;
	
	@FindBy(how=How.XPATH,using="/html[1]/body[1]/section[1]/div[1]/header[1]/h1[1]")
	WebElement titleTariff;
	
	@FindBy(how=How.XPATH,using="//*[@id=\"main\"]/div/h2")
	WebElement cogratulationsMessage;

	
	public void TariffPlanDetails(String rental, String localmins, String intermins ,String sms, String local, String international, String smspack) throws IOException {
		
		
		this.rental.sendKeys(rental);
		this.localmins.sendKeys(localmins);
		this.intermins.sendKeys(intermins);
		this.smspack.sendKeys(sms);
		localcharges.sendKeys(local);
		intercharges.sendKeys(international);
		smscharges.sendKeys(smspack);
	
	}
	
	public void submittariffplandetails(String rental, String localmins, String intermins ,String sms, String local, String international, String smspack) throws IOException {
		
		tplan.click();
		TariffPlanDetails(rental, localmins, intermins, sms, local, international, smspack);
		submit1.click();
		
		String title = titleTariff.getText();
		Assert.assertEquals(TariffConstants.addTariffHeading, title);
		
		Utilities.CommonUtils.waitForElementToBeCLickabe(cogratulationsMessage, driver);
		
		String message = cogratulationsMessage.getText();
		Assert.assertEquals(message, TariffConstants.addTariffOn_sub_Msg);
	}
	
public void ResetTariffPlanDetails(String rental, String localmins, String intermins ,String sms, String local, String international, String smspack) throws IOException {
		
		tplan.click();
		TariffPlanDetails(rental, localmins, intermins, sms, local, international, smspack);
		reset1.click();
	}
	
	
	
	public void BlankTariff() {
		
		
		tplan.click();
		submit1.click();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		  wait.until(ExpectedConditions.alertIsPresent());
		  String alertText=driver.switchTo().alert().getText();
		  System.out.println(alertText);
		 driver.switchTo().alert().accept();
		
	  }
		
	}

