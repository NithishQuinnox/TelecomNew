package Base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.aventstack.extentreports.ExtentTest;

import Listener.TelecomListener;
import PageFactory.PFCustomer;
import Utilities.BrowserFactory;
import Utilities.Window;

public class BaseClass {
	
	public static WebDriver driver;
	public static ExtentTest extentTest;
	
	@BeforeMethod
	public WebDriver launch() throws IOException {
		
		ChromeOptions options = new ChromeOptions();
        options.addExtensions(new File(".//resources//AdGuard//AdGuard.crx"));
        System.setProperty("webdriver.chrome.driver", ".//resources//Driver//chromedriver.exe");
        driver = new ChromeDriver(options);
   
        Properties property;
        property=new Properties();
        property.load(new FileInputStream(".//resources//config.properties"));
   
        driver.get(property.getProperty("url"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();
        TelecomListener.setDriver(driver);
        
    	Window wh = PageFactory.initElements(driver, Window.class);
	    wh.popupHandling();
	   // PFCustomer ac = PageFactory.initElements(driver, PFCustomer.class);
	    
	    return driver;
	}
	
	@AfterMethod
	public void Quit() {
		
		driver.quit();
		
	}	

}
