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

public class Homepagetest extends baseclass{
	
	Indexpage Indexpg;
	Loginpage Loginpg;
	Homepage Homepg;
	
	@Parameters({"browser"})
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setup(String brow) throws MalformedURLException {	
		initializebrowser(brow);
		Loginpg=new Loginpage();
		Indexpg=new Indexpage();
		Homepg=new Homepage();
	}
	
	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void teardown(){
		getDriver().quit();
	}
	
	@Test(groups="Smoke",dataProvider = "credentials", dataProviderClass = DataProviders.class)
	public void verifymyaccount(String uname, String pwd) throws Throwable {
		Log.startTestCase("verifymyaccount");
		Loginpg =Indexpg.clickonsignin();		
		Log.info("Enter username & Password :"+"UserName ="+uname+", Password ="+ pwd);		
		ExtentManager.test.info("UserName ="+uname+", Password ="+ pwd);
		// Homepg=Loginpg.Login(prop.getProperty("username"),prop.getProperty("password"));
		Homepg = Loginpg.Login(uname, pwd);
		boolean result= Homepg.myaccountisdisplayed();
		Assert.assertTrue(result);
		Log.info("verifymyaccount Success");
		Log.endTestCase("verifymyaccount");
	}
	
	@Test(groups="Smoke",dataProvider = "credentials", dataProviderClass = DataProviders.class)
	public void verifyaddmyfirstaddress(String uname, String pwd) throws Throwable {
		Log.startTestCase("verifyaddmyfirstaddress");
		Loginpg =Indexpg.clickonsignin();		
		Log.info("Enter username & Password :"+"UserName ="+uname+", Password ="+ pwd);		
		ExtentManager.test.info("UserName ="+uname+", Password ="+ pwd);
		// Homepg=Loginpg.Login(prop.getProperty("username"),prop.getProperty("password"));
		Homepg = Loginpg.Login(uname, pwd);
		boolean result= Homepg.addmyfirstaddressisdisplayed();
		Assert.assertTrue(result);	
		Log.info("verifyaddmyfirstaddress Success");
		Log.endTestCase("verifyaddmyfirstaddress");
	}
	
	@Test(groups="Smoke",dataProvider = "credentials", dataProviderClass = DataProviders.class)
	public void verifyorderhistory(String uname, String pwd) throws Throwable {
		Log.startTestCase("verifyorderhistory");
		Loginpg =Indexpg.clickonsignin();
		Log.info("Enter username & Password :"+"UserName ="+uname+", Password ="+ pwd);		
		ExtentManager.test.info("UserName ="+uname+", Password ="+ pwd);
		// Homepg=Loginpg.Login(prop.getProperty("username"),prop.getProperty("password"));
		Homepg = Loginpg.Login(uname, pwd);
		boolean result= Homepg.orderhistoryisdisplayed();
		Assert.assertTrue(result);
		Log.info("verifyorderhistory Success");
		Log.endTestCase("verifyorderhistory");
	}
}
