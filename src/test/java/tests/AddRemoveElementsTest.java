package tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.AbPage;
import Pages.AddRemoveElements;
import basepackage.BaseClassForInit;

public class AddRemoveElementsTest extends BaseClassForInit {
	AddRemoveElements addRemoveElements=new AddRemoveElements();
	
	@BeforeMethod
	public void StartBrowser() throws IOException {
		InitilisationOfDriver();
	}
	
	@Test
	public void test01() throws Exception {
		AddRemoveElements addRemoveElements=new AddRemoveElements();
		String textdiplayed=addRemoveElements.ClickOnAddRemoveElementsLink();
		Assert.assertEquals(textdiplayed, "Add/Remove Elements");
		System.out.println("The text is diplayed");
		
		
	}
	
	
	
	@AfterMethod
	public void CloseApplication() {
		getDriver().close();
	}

}
