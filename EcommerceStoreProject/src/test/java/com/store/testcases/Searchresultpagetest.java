package com.store.testcases;

import java.net.MalformedURLException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.store.base.baseclass;
import com.store.dataprovider.DataProviders;
import com.store.pageobjects.Addtocartpage;
import com.store.pageobjects.Homepage;
import com.store.pageobjects.Indexpage;
import com.store.pageobjects.Loginpage;
import com.store.pageobjects.Searchresultpage;
import com.store.utilities.Log;

public class Searchresultpagetest extends baseclass{
	Indexpage Indexpg;
	Loginpage Loginpg;
	Homepage Homepg;
	Searchresultpage Searchresultpg;
	Addtocartpage Addtocartpg;
	
	@Parameters({"browser"})
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setup(String brow) throws MalformedURLException {	
		initializebrowser(brow);		
		Indexpg=new Indexpage();	
		Searchresultpg=new Searchresultpage();
		
	}
	
	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void teardown(){
		getDriver().quit();
	}
	
	@Test(groups="Smoke",dataProvider="searchproduct",dataProviderClass=DataProviders.class)
	public void productsearchtest(String product) {
		Log.startTestCase("productsearchtest");
		Searchresultpg=Indexpg.searchproductbox(product);
		boolean result = Searchresultpg.productresultisdisplayed();
		Assert.assertTrue(result);
		Log.info("productsearchtest Success");
		Log.endTestCase("productsearchtest");
		
	}
}
