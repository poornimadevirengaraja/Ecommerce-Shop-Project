package com.store.testcases;

import java.net.MalformedURLException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.store.base.baseclass;
import com.store.pageobjects.Indexpage;
import com.store.utilities.Log;

public class Indexpagetest extends baseclass{
	Indexpage Indexpg;
	
	@Parameters({"browser"})
	@BeforeMethod(groups = { "Smoke", "Sanity", "Regression" })
	public void setup(String brow) throws MalformedURLException {	
		initializebrowser(brow);
		Indexpg=new Indexpage();		
	}
	
	@AfterMethod(groups = { "Smoke", "Sanity", "Regression" })
	public void teardown(){
		getDriver().quit();
	}
	
	@Test(groups="Smoke")
	public void verifystoretitle() {
		Log.startTestCase("verifystoretitle");
		Log.info("Get the store title");
		String getstoretitle = Indexpg.getstoretitle();
		Log.info("Asserting Actual and expected store title");
		System.out.println(getstoretitle);
		Assert.assertEquals(getstoretitle,"My Shops");
		Log.info("verifystoretitle success");
		Log.endTestCase("verifystoretitle");
	}
	
	@Test(groups="Smoke")
	public void verifylogo() throws InterruptedException {
		Log.startTestCase("verifylogo");
		boolean logoisdisplayed = Indexpg.logoisdisplayed();
		Log.info("Asserting if logo is displayed or not");
		Assert.assertTrue(logoisdisplayed);
		Log.info("verifylogo success");
		Log.endTestCase("verifylogo");
	}
}
