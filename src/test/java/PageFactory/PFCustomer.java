package PageFactory;

import java.io.IOException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Utilities.ExtentReportsSample;


public class PFCustomer {
	
	WebDriver driver;
	static String FetchCustomerID;
	private int alertTimeOut;
	static String path= ".//TestData//customerinfo.xlsx";
	ExtentTest extentTest;

	public void setAlertTimeOut(int alertTimeOut) {
		this.alertTimeOut = alertTimeOut;
	}
	
	public PFCustomer(WebDriver driver) {
		this.driver = driver;
		//this.extentTest = extentTest;
		PageFactory.initElements(driver, this);
		
	}
	
	
	@FindBy(xpath = "//*[@id=\"one\"]/div/div[1]/div[1]/h3/a")
	WebElement add_customer; 
	
	@FindBy(xpath = "//*[@id=\"main\"]/div/form/div/div[1]/label")   
	WebElement done; 
	
	@FindBy(xpath = "//*[@id=\"main\"]/div/form/div/div[2]/label") 
	WebElement pending; 
	
	@FindBy(id = "fname") 
	WebElement fname; 
	
	@FindBy(id = "lname") 
	WebElement lname;
	
	@FindBy(id = "email") 
	WebElement email;
	
	@FindBy(xpath = "//*[@id=\"message\"]") 
	WebElement address;
	
	@FindBy(id = "telephoneno")
	WebElement phonenum;
	
	@FindBy(xpath = "//*[@id=\"main\"]/div/form/div/div[9]/ul/li[1]/input")
	WebElement submit;
	
	@FindBy(xpath = "//*[@id=\"main\"]/div/form/div/div[9]/ul/li[2]/input")
	WebElement reset;
	
	@FindBy(xpath = "//*[@id=\"main\"]/div/div/table/tbody/tr[1]/td[2]/h3")
	WebElement fetchcustid;
	
	@FindBy(xpath = "//*[@id=\"main\"]/div/div/ul/li/a")
	WebElement home;
	
	@FindBy(xpath = "//*[@id=\"navbar-brand-centered\"]/ul/li[8]/a")
    WebElement TelecomProject;
	
	@FindBy(xpath = "//*[@id=\"one\"]/div/div[1]/div[2]/h3/a")
	WebElement tplancust;
	
	@FindBy(id = "customer_id")  
	WebElement custid;
	
	@FindBy(xpath = "//*[@id=\"main\"]/div/form/div/div[6]/input")
	WebElement submit2;
	
	@FindBy(css =  "#main > div > form > div.\\35 u.\\31 2u\\$\\(small\\) > input")
	WebElement selectplan;
	
	@FindBy(xpath = "//*[@id='main']/div/form/div[1]/table/tbody/tr/td[1]/label")
	WebElement pln;
	
	@FindBy(css =  "#main > div > ul > li > a")
	WebElement homee;
	
	
	public void CustomerDetails(String fname,String lname,String email,String address,String phno) throws Exception {

		this.fname.sendKeys(fname);   
		this.lname.sendKeys(lname);
		this.email.sendKeys(email);
		this.email.sendKeys(Keys.TAB,address);
		this.phonenum.sendKeys(phno);
		
	}
	
	  public void getcustid() {
			FetchCustomerID=fetchcustid.getText();
			
		}
	
	public void ValidCustomer(String fname,String lname,String email,String address,String phno) throws Exception {
	
		add_customer.click();
		done.click();
		CustomerDetails(fname, lname, email, address, phno);
		ExtentReportsSample.takeScreenShotWithExtentReport(driver, Status.PASS);
		submit.click();
		ExtentReportsSample.takeScreenShotWithExtentReport(driver, Status.PASS);
		getcustid();
//		home.click();
//		add_customer.click();
//		pending.click();
//		CustomerDetails(fname, lname, email, address, phno);
//		submit.click();
//		getcustid();
//		home.click();
//		//add_customer.click();
	
	}
	
	
	
//	public void ResetButton(String fname,String lname,String email,String address,String phno) throws Exception {
//		
//		add_customer.click();
//		CustomerDetails(fname, lname, email, address, phno);
//		reset.click();
//	
//	}
	
	
	  public String InvalidCustomer() throws IOException {
		  
		  add_customer.click();
	 
		  reset.click();
		  submit.click();
		  
		  
			Utilities.CommonUtils.waitForAlert(driver, alertTimeOut);
			String alertText = driver.switchTo().alert().getText();
			Assert.assertEquals(CustomerConstants.addCustomerAlert, alertText);
			return alertText;
		  
		  
	  }
	  
		
		public void AssignTariffPlan(String fname,String lname,String email,String address,String phno) throws Exception {
			
			
			ValidCustomer(fname, lname, email, address, phno);
			home.click();
			tplancust.click();
			
			custid.sendKeys(FetchCustomerID);
			submit2.click();
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,500)");
			
			js.executeScript("arguments[0].click();", pln);
			
			selectplan.click();
			
			
		}

}
