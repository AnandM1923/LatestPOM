package actions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import basepackage.BaseClassForInit;

public class AllActions extends BaseClassForInit {
	
	
	public static void scrollByVisibilityOfElement(WebDriver driver,WebElement ele) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", ele);
	}
	
public static boolean ClickOntLink(WebDriver ldriver,WebElement element) {
		
		boolean flag=false;
		try {
			element.click();;
			flag=true;
		}catch (Exception e) {
			flag=false;
		}finally {
			if(flag) {
				System.out.println("The element is clicked: " +element);
			}else {
				System.out.println("The element is not clicked: " +element);
			}
		}
		return flag;
		
	}
	
	
	public static boolean abtestTextValidiation(WebDriver ldriver,WebElement element) {
		
		boolean flag=false;
		try {
			element.isDisplayed();
			flag=true;
		}catch (Exception e) {
			flag=false;
		}finally {
			if(flag) {
				System.out.println("The element is displayed: " +element);
			}else {
				System.out.println("The element is not displayed: " +element);
			}
		}
		return flag;
		
	}

	public static String getText(WebDriver ldriver,WebElement element) {
		boolean flag=false;
		String text = null;
		try {
			text=element.getText();
			flag=true;
		}catch (Exception e) {
			flag=false;
		}finally {
			if (flag) {
				System.out.println("Title of the page is: \""+text+"\"");
			}
			
		}
		return text;
		
		
	}
}
