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
import com.store.pageobjects.Loginpage;
import com.store.pageobjects.Orderpage;
import com.store.pageobjects.Searchresultpage;
import com.store.utilities.Log;

public class Orderpagetest extends baseclass{
	Indexpage Indexpg;
	Searchresultpage Searchresultpg;
	Addtocartpage Addtocartpg;
	Orderpage Orderpg;
	Loginpage Loginpg;

	@Parameters({"browser"})
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setup(String brow) throws MalformedURLException {	
		initializebrowser(brow);
		Indexpg = new Indexpage();
		Searchresultpg = new Searchresultpage();
		Addtocartpg = new Addtocartpage();
		Orderpg = new Orderpage();
		Loginpg = new Loginpage();
	}

	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void teardown() {
		getDriver().quit();
	}

	@Test(groups="Regression",dataProvider="getproduct",dataProviderClass=DataProviders.class)
	public void verifytotalpriceaddtocarttest(String product, String qty, String size) throws Throwable {
		Log.startTestCase("verifytotalpriceaddtocarttest");
		Searchresultpg = Indexpg.searchproductbox(product);
		Addtocartpg = Searchresultpg.clickonproductresult();
		Addtocartpg.selectsize(size);
		Addtocartpg.enterquantity(qty);
		Addtocartpg.clickoncolour();
		Addtocartpg.clickonaddtocart();
		Addtocartpg.JSClickproceedtocheckout();
		Double unitprice = Orderpg.getunitprice();
		System.out.println(unitprice);
		Double actualtotalprice = Orderpg.gettotalprice();
		System.out.println(actualtotalprice);
		double expectedtotalprice = (unitprice * 2) + 7;
		Assert.assertEquals(actualtotalprice, expectedtotalprice);
		Log.info("verifytotalpriceaddtocarttest success");
		Log.endTestCase("verifytotalpriceaddtocarttest");
	}

	@Test(groups="Regression",dataProvider="getproduct",dataProviderClass=DataProviders.class)
	public void addtocarttest(String product, String qty, String size) throws Throwable {
		Log.startTestCase("addtocarttest");
		Searchresultpg = Indexpg.searchproductbox(product);
		Addtocartpg = Searchresultpg.clickonproductresult();
		Addtocartpg.selectsize(size);
		Addtocartpg.enterquantity(qty);
		Addtocartpg.clickoncolour();
		Addtocartpg.clickonaddtocart();
		Addtocartpg.JSClickproceedtocheckout();
		Double unitprice = Orderpg.getunitprice();
		System.out.println(unitprice);
		Double actualtotalprice = Orderpg.gettotalprice();
		System.out.println(actualtotalprice);
		Loginpg = Orderpg.clickonproceedtocheckout();
		boolean result = Orderpg.validateAuthentication();
		Assert.assertTrue(result);
		Log.info("addtocarttest success");
		Log.endTestCase("addtocarttest");

	}
}
