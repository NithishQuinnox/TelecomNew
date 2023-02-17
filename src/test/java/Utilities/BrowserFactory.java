package Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;

import Listener.TelecomListener;


public class BrowserFactory {
    
    public static WebDriver driver;
    public static WebDriver startBrowser() throws IOException {
    	
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
	    
	    return driver;
    }
        
	public static void closeBrowser() {

		driver.quit();
	}
	
}

