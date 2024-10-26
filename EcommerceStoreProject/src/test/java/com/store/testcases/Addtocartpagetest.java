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
import com.store.pageobjects.Indexpage;
import com.store.pageobjects.Searchresultpage;
import com.store.utilities.Log;

public class Addtocartpagetest extends baseclass{
	Indexpage Indexpg;
	Searchresultpage Searchresultpg;
	Addtocartpage Addtocartpg;
	
	@Parameters({"browser"})
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setup(String brow) throws MalformedURLException {	
		initializebrowser(brow);		
		Indexpg=new Indexpage();
		Searchresultpg=new Searchresultpage();
		Addtocartpg=new Addtocartpage();
	}	
	
	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void teardown(){
		getDriver().quit();
	}	
	
	@Test(groups = {"Regression","Sanity"},dataProvider="getproduct",dataProviderClass=DataProviders.class)
	public void addtocarttest(String product, String qty, String size) throws Throwable {
		Log.startTestCase("addtocarttest");
		Searchresultpg=Indexpg.searchproductbox(product);
		Addtocartpg=Searchresultpg.clickonproductresult();
		Addtocartpg.selectsize(size);
		Addtocartpg.enterquantity(qty);
		Addtocartpg.clickoncolour();
		Addtocartpg.clickonaddtocart();
		boolean result=Addtocartpg.validateAddtoCart();
		Assert.assertTrue(result);
		Log.info("addtocarttest success");
		Log.endTestCase("addtocarttest");
	}
	
}
