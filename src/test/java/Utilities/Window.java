package Utilities;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;

public class Window {
	
	  WebDriver driver;
	
	public Window(WebDriver driver) {
		this.driver = driver;
	  //PageFactory.initElements(driver, WindowHandles.class);
	}
	
	public void popupHandling() {
		
		//driver = BrowserFactory.startBrowser("chrome", "http://demo.guru99.com/", "C:/Users/NithishKumarR/Downloads/chromedriver_win32/chromedriver.exe");
		
		Set<String> windowhandles = driver.getWindowHandles();
		Iterator<String> itr = windowhandles.iterator();
		String mainWindow = itr.next();
		String newWindow = itr.next();
		driver.switchTo().window(newWindow).close();
		driver.switchTo().window(mainWindow);
		
		
	}

}
