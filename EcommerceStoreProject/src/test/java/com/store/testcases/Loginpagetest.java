package com.store.testcases;

import java.net.MalformedURLException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.store.base.baseclass;
import com.store.dataprovider.DataProviders;
import com.store.pageobjects.Homepage;
import com.store.pageobjects.Indexpage;
import com.store.pageobjects.Loginpage;
import com.store.utilities.ExtentManager;
import com.store.utilities.Log;

public class Loginpagetest extends baseclass {
	Indexpage Indexpg;
	Loginpage Loginpg;
	Homepage Homepg;
	

	@Parameters({ "browser" })
	@BeforeMethod(groups = { "Smoke", "Sanity", "Regression" })
	public void setup(String brow) throws MalformedURLException {
		initializebrowser(brow);
		Loginpg = new Loginpage();
		Indexpg = new Indexpage();
		Homepg = new Homepage();
		
	}

	@AfterMethod(groups = { "Smoke", "Sanity", "Regression" })
	public void teardown() {
		getDriver().quit();
	}

	@Test(groups = { "Smoke", "Sanity" }, dataProvider = "credentials", dataProviderClass = DataProviders.class)
	public void Logintest(String uname, String pwd) throws Throwable {		
		
		Log.startTestCase("Logintest");		
		Loginpg = Indexpg.clickonsignin();
		Log.info("Enter username & Password :"+"UserName ="+uname+", Password ="+ pwd);		
		ExtentManager.test.info("UserName ="+uname+", Password ="+ pwd);
		// Homepg=Loginpg.Login(prop.getProperty("username"),prop.getProperty("password"));
		Homepg = Loginpg.Login(uname, pwd);
		Thread.sleep(5000);	
		String actualurl = Homepg.getcurrenturlhomepage();
		String expectedurl = "http://www.automationpractice.pl/index.php?controller=my-account";
		Assert.assertEquals(actualurl, expectedurl);
		Log.info("Login Success");
		Log.endTestCase("Logintest");
	}

	/*
	 * @Test(groups = { "Smoke", "Sanity" }, dataProvider = "invalidcredentials",
	 * dataProviderClass = DataProviders.class) public void InvalidLogintest(String
	 * uname, String pwd, String msg) throws Throwable {
	 * 
	 * Log.startTestCase("Logintest"); Loginpg = Indexpg.clickonsignin(); //
	 * Homepg=Loginpg.Login(prop.getProperty("username"),prop.getProperty("password"
	 * )); Log.info("Enter username & Password :"+"UserName ="+uname+", Password ="+
	 * pwd); ExtentManager.test.info("UserName ="+uname+", Password ="+ pwd); Homepg
	 * = Loginpg.Login(uname, pwd); Thread.sleep(5000); String actualmsg =
	 * Loginpg.Validateinvalidcredentialmsg(); String expectedmsg = msg;
	 * Assert.assertEquals(actualmsg, expectedmsg); Log.info("Login Success");
	 * Log.endTestCase("Logintest"); }
	 */

}
