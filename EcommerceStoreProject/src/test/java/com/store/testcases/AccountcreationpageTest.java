package com.store.testcases;

import java.net.MalformedURLException;
import java.util.HashMap;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.store.base.baseclass;
import com.store.dataprovider.DataProviders;
import com.store.pageobjects.Accountcreationpage;
import com.store.pageobjects.Homepage;
import com.store.pageobjects.Indexpage;
import com.store.pageobjects.Loginpage;
import com.store.utilities.Log;

public class AccountcreationpageTest extends baseclass{
	Indexpage Indexpg;
	Loginpage Loginpg;
	Homepage Homepg;
	Accountcreationpage accountcreationpg;
	
	@Parameters({"browser"})
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setup(String brow) throws MalformedURLException {	
		initializebrowser(brow);
		Loginpg=new Loginpage();
		Indexpg=new Indexpage();
		Homepg=new Homepage();
		accountcreationpg=new Accountcreationpage();
	}
	
	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void teardown(){
		getDriver().quit();
		
	}
	
	@Test(groups = {"Sanity"},dataProvider="email",dataProviderClass=DataProviders.class)
	public void verifyaccountcreationpage(String email) {
		Log.startTestCase("verifyaccountcreationpage");
		Loginpg =Indexpg.clickonsignin();
		//accountcreationpg=Loginpg.createnewaccount("shanthini1@gmail.com");
		accountcreationpg=Loginpg.createnewaccount(email);
		boolean result = accountcreationpg.myaccountisdisplayed();
		Assert.assertTrue(result);
		Log.info("verifyaccountcreationpage Success");
		Log.endTestCase("verifyaccountcreationpage");
	}

	@Test(groups = {"Sanity"},dataProvider = "newacountdetailsdata",dataProviderClass = DataProviders.class)
	public void createAccountTest(HashMap<String,String> hashMapValue) throws Throwable {
		Log.startTestCase("createAccountTest");
		Indexpg= new Indexpage();
		Loginpg=Indexpg.clickonsignin();
		accountcreationpg=Loginpg.createnewaccount(hashMapValue.get("Email"));
		accountcreationpg.createAccount(
				hashMapValue.get("Gender"),
				hashMapValue.get("FirstName"),
				hashMapValue.get("LastName"),
				hashMapValue.get("SetPassword"),
				hashMapValue.get("Day"),
				hashMapValue.get("Month"),
				hashMapValue.get("Year")
				/*hashMapValue.get("Company"),
				hashMapValue.get("Address"),
				hashMapValue.get("City"),
				hashMapValue.get("State"),
				hashMapValue.get("Zipcode"),
				hashMapValue.get("Country"),
				hashMapValue.get("MobilePhone")*/
				);
		
		Homepg=accountcreationpg.validateRegistration();
		boolean result = Homepg.accountcreatedmsgisdisplayed();
		Assert.assertTrue(result);
		Log.info("createAccountTest Success");
		Log.endTestCase("createAccountTest");
	}

}
