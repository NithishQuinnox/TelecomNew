package PageFactory;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;

public class PFBilling extends PFCustomer {
	
	WebDriver driver;
	ExtentTest extenttest;
	
	public PFBilling(WebDriver driver) {
		super(driver);
		this.driver=driver;
//    	this.extenttest=extenttest;
//    	PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath = "//*[@id=\"navbar-brand-centered\"]/ul/li[8]/a")
    WebElement TelecomProject;
	
	@FindBy(linkText = "Pay Billing")
	WebElement paybill;
	
	@FindBy(id = "customer_id")
	WebElement cid;

	@FindBy(css = "#main > div > form > div > div:nth-child(6) > input")
	WebElement cid_submit;
	
	@FindBy(how = How.XPATH, using = "//tbody/tr[6]/td[2]")
	WebElement totalBill;
	
	@FindBy(how = How.XPATH, using= "/html[1]/body[1]/section[1]/div[1]/header[1]/h1[1]")
	WebElement bill_Heading;
	
		
	public void Billing(String fname,String lname,String email,String address,String phno) throws Exception {
		
		
		ValidCustomer(fname, lname, email, address, phno);
		home.click();
		paybill.click();
		cid.sendKeys(FetchCustomerID);
		cid_submit.click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		String heading = bill_Heading.getText();
		Assert.assertEquals(PayBillConstants.payBill_Heading, heading);
		
		Utilities.CommonUtils.waitForElementToBeCLickabe(totalBill, driver);
	

}
	
	public void NoBilling(int alertTimeOut) {
		
		paybill.click();
		cid_submit.click();
		
		Utilities.CommonUtils.waitForAlert(driver, alertTimeOut);
		String alertText = driver.switchTo().alert().getText();
		System.out.println(alertText);
		
		
		 driver.switchTo().alert().accept();
		 //this.TelecomProject();
	
		
	}
}
