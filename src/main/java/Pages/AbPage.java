package Pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import actions.AllActions;
import basepackage.BaseClassForInit;


public class AbPage extends BaseClassForInit {
	

	
	
	public AbPage() {		
		PageFactory.initElements(getDriver(), this);
		
	}
	
	@FindBy(xpath="//div[@class='example']/h3")
	WebElement AbtestTesxt;
	
	@FindBy(xpath="//a[@href='/abtest']")
	WebElement Abtestclick;
	
	@FindBy(xpath="//div[@style='text-align: center;']")
	WebElement poweredBy;
	
	
	public boolean AbtestTesxtvalidation() throws Exception {
		AllActions.ClickOntLink(getDriver(),Abtestclick);
		Thread.sleep(2000);
		boolean isDispalyedflag=AllActions.abtestTextValidiation(getDriver(),AbtestTesxt);
		return isDispalyedflag;
		
	}
	
	public String AbtestTestpoweredByText() throws Exception {
		AllActions.ClickOntLink(getDriver(),Abtestclick);
		Thread.sleep(1000);
		String poweredByText=AllActions.getText(getDriver(),poweredBy);
		return poweredByText;
		
	}
	
	
	
}
