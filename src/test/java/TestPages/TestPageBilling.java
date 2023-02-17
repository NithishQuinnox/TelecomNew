package TestPages;

import java.io.FileInputStream;
import java.util.Properties;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Base.BaseClass;
import PageFactory.PFBilling;
import Utilities.DataProviders;

@Listeners(Listener.TelecomListener.class) 


public class TestPageBilling extends BaseClass {

	
   @Test(dataProvider = "getLoginData",dataProviderClass=DataProviders.class)
	
	public void Bill(String fname,String lname,String email,String address,String phno) throws Exception {
		
		
		PFBilling ac = new PFBilling(BaseClass.driver);	
		ac.Billing(fname, lname, email, address, phno);
	}
   
	@Test
 	public void NoBill() throws Exception {
		
		 Properties property;
	     property=new Properties();
	     property.load(new FileInputStream(".//resources//Config.properties"));
		String alertTime = property.getProperty("alerttimeout");
 		PFBilling ac = new PFBilling(BaseClass.driver);	
 		ac.NoBilling(Integer.parseInt(alertTime));
 	}

}
