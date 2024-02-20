package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import actions.AllActions;
import basepackage.BaseClassForInit;

public class AddRemoveElements extends BaseClassForInit {
	
	public AddRemoveElements() {
		PageFactory.initElements(getDriver(), this);
	}

	@FindBy(xpath="//a[@href='/add_remove_elements/']")
	WebElement AddRemoveElementsLink;
	
	@FindBy(xpath="//div[@id='content']/h3")
	WebElement AddRemoveElementsText;
	
	public String ClickOnAddRemoveElementsLink() throws Exception {
		
		boolean  Clicked=AllActions.ClickOntLink(getDriver(), AddRemoveElementsLink);
		Thread.sleep(1000);
		String text=AllActions.getText(getDriver(), AddRemoveElementsText);
		return text;
		
	}
	
	
}
