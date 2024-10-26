package com.store.testcases;

import java.net.MalformedURLException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.store.base.baseclass;
import com.store.dataprovider.DataProviders;
import com.store.pageobjects.Addresspage;
import com.store.pageobjects.Addtocartpage;
import com.store.pageobjects.Indexpage;
import com.store.pageobjects.Loginpage;
import com.store.pageobjects.Orderconfirmationpage;
import com.store.pageobjects.Orderpage;
import com.store.pageobjects.Ordersummarypage;
import com.store.pageobjects.Paymentpage;
import com.store.pageobjects.Searchresultpage;
import com.store.pageobjects.Shippingpage;
import com.store.utilities.Log;

public class EndtoEndtest  extends baseclass{
	Indexpage Indexpg;
	Searchresultpage Searchresultpg;
	Addtocartpage Addtocartpg;
	Orderpage Orderpg;
	Loginpage Loginpg;
	Addresspage Addresspg;
	Shippingpage Shippingpg;
	Paymentpage Paymentpg;
	Ordersummarypage Ordersummarypg;
	Orderconfirmationpage Orderconfirmationpg;
	
	@Parameters({"browser"})
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setup(String brow) throws MalformedURLException {	
		initializebrowser(brow);
		Indexpg = new Indexpage();
		Searchresultpg = new Searchresultpage();
		Addtocartpg = new Addtocartpage();
		Orderpg = new Orderpage();
		Loginpg = new Loginpage();
		Addresspg = new Addresspage();
		Shippingpg= new Shippingpage();
		Paymentpg= new Paymentpage();
		Ordersummarypg= new Ordersummarypage();
		Orderconfirmationpg=new Orderconfirmationpage();
	}

	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void teardown() {
		getDriver().quit();
	}

	@Test(groups = "Regression",dataProvider="endtoenddata",dataProviderClass=DataProviders.class)
	public void addtocarttestE2E(String product, String qty, String size,String uname, String pwd) throws Throwable {
		Log.startTestCase("addtocarttestE2E");
		Searchresultpg = Indexpg.searchproductbox(product);
		Addtocartpg = Searchresultpg.clickonproductresult();
		Addtocartpg.selectsize(size);
		Addtocartpg.enterquantity(qty);
		Addtocartpg.clickoncolour();
		Addtocartpg.clickonaddtocart();
		Addtocartpg.JSClickproceedtocheckout();
		Loginpg = Orderpg.clickonproceedtocheckout();
		//Addresspg  = Loginpg.Loginfromshoppingcart(prop.getProperty("username"), prop.getProperty("password"));
		Addresspg  = Loginpg.Loginfromshoppingcart(uname, pwd);
		Shippingpg = Addresspg.clickoncheckout();
		Shippingpg.checktheterms();
		Paymentpg=Shippingpg.clickonproceedtocheckout();
		Ordersummarypg=Paymentpg.clickOnPaymentMethod();
		Orderconfirmationpg =Ordersummarypg.clickOnconfirmOrderBtn();		
		String actualConfirmMessage = Orderconfirmationpg.validateConfirmMessage();
		String expectedConfirmMessage="Your order on My Shop is complete.";
		System.out.println(actualConfirmMessage);
		Assert.assertEquals(actualConfirmMessage, expectedConfirmMessage);
		Log.info("addtocarttestE2E success");
		Log.endTestCase("addtocarttestE2E");
	}
}
