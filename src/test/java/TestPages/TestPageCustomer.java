package TestPages;

import java.io.IOException;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Base.BaseClass;
import PageFactory.PFCustomer;
import Utilities.DataProviders;

@Listeners(Listener.TelecomListener.class) 

public class TestPageCustomer extends BaseClass {
	
	
	@Test(dataProvider = "getLoginData",dataProviderClass=DataProviders.class)
	
	public void ValidCustomer(String fname, String lname, String email, String address, String phno) throws Exception {
		
		PFCustomer ac = new PFCustomer(BaseClass.driver);	
		
		ac.ValidCustomer(fname, lname, email, address, phno);

	}
	
//	@Test(dataProvider = "getLoginData",dataProviderClass=DataProviders.class)
//	
//	public void Reset(String fname, String lname, String email, String address, String phno) throws Exception {
//		
//		PFCustomer ac = new PFCustomer(BaseClass.driver);	
//		
//		ac.ResetButton(fname, lname, email, address, phno);
//	
//	} 

	@Test

   public void InvalidCustomer() throws Exception {
	
	PFCustomer ac = new PFCustomer(BaseClass.driver);	
	
	ac.InvalidCustomer();

} 


	@Test(dataProvider = "getLoginData",dataProviderClass=DataProviders.class)

	public void AssignTariffPlan(String fname, String lname, String email, String address, String phno) throws Exception {
	
	PFCustomer ac = new PFCustomer(BaseClass.driver);	
	
	ac.AssignTariffPlan(fname, lname, email, address, phno);
}
	
	

}
