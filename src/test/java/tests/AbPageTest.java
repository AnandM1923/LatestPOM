package tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.AbPage;
import basepackage.BaseClassForInit;
import basepckg.BaseClass;

public class AbPageTest extends BaseClassForInit{
	
	AbPage abtest =new AbPage();
	
	
	@BeforeMethod
	public void StartBrowser() throws IOException {
		InitilisationOfDriver();
	}
	
	@Test
	public void test01() throws Exception {
		AbPage abtest =new AbPage();
		boolean textdiplayed=abtest.AbtestTesxtvalidation();
		Assert.assertEquals(textdiplayed, true);
		System.out.println("The text is diplayed");
		
		
	}
	
	@Test
	public void test02() throws Exception {
		AbPage abtest =new AbPage();
		String textdiplayed=abtest.AbtestTestpoweredByText();
		Assert.assertEquals(textdiplayed, "Powered by");
		System.out.println("The text is diplayed");
	
	}
	@AfterMethod
	public void CloseApplication() {
		getDriver().close();
	}

}
