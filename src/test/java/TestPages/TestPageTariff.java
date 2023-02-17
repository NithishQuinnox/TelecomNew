package TestPages;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Base.BaseClass;
import PageFactory.PFTariff;
import Utilities.DataProviders;

@Listeners(Listener.TelecomListener.class) 

public class TestPageTariff extends BaseClass {
	
	
	
    @Test(dataProvider = "getLoginData1",dataProviderClass=DataProviders.class)
	
	public void SubmitTariffPlanDetails(String rental, String localmins, String intermins ,String sms, String local, String international, String smspack) throws Exception {
		
		
		PFTariff ac = new PFTariff(BaseClass.driver);	
		ac.submittariffplandetails(rental, localmins, intermins ,sms, local, international, smspack);
	
	}
    
    @Test	
  	public void BlankTariffPlan() throws Exception {
  		
  		
  		PFTariff ac = new PFTariff(BaseClass.driver);	
  		ac.BlankTariff();
  	}
	

}
