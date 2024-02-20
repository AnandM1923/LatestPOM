package basepackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeTest;

public class BaseClassForInit {
	
public static ThreadLocal<RemoteWebDriver> driver=new ThreadLocal<RemoteWebDriver>();
	
	public static WebDriver getDriver() {
		return driver.get();
	}
	//public WebDriver driver;
	
	@BeforeTest
	public String readPropertyFile() throws IOException {
		Properties prop=new Properties();
		FileInputStream fis=new FileInputStream("C:\\Users\\margo\\ElcipseWorkspace3\\POMProject\\Properties\\urlandbrowser.properties");
		prop.load(fis);
		String BrowserName=prop.getProperty("browser");
		return BrowserName;
		
	}
	

	public void InitilisationOfDriver() throws IOException {
		
		String BrwsName=readPropertyFile();
		
		if(BrwsName.equalsIgnoreCase("chrome")) {
			driver.set(new ChromeDriver());
			//driver=new ChromeDriver();
			getDriver().get("https://the-internet.herokuapp.com/");
			
		}else if(BrwsName.equalsIgnoreCase("firfox")) {
			driver.set(new FirefoxDriver());
			//driver=new FirefoxDriver();
			getDriver().get("https://the-internet.herokuapp.com/");
			
		}else if(BrwsName.equalsIgnoreCase("ie")){
			driver.set(new InternetExplorerDriver());
			//driver=new InternetExplorerDriver();
			getDriver().get("https://the-internet.herokuapp.com/");
		}else {
			System.out.println("please provide valid input for browser");
		}
		
		getDriver().manage().window().maximize();
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	
	public String takeScreenShot(String testCaseName, WebDriver driver) throws Exception {
        TakesScreenshot ts = (TakesScreenshot) driver;
        if (ts != null) {
            File source = ts.getScreenshotAs(OutputType.FILE);
            File file = new File(
                    System.getProperty("user.dir") + "//reports//" + testCaseName + ".png");
            FileUtils.copyFile(source, file);
            return System.getProperty("user.dir") + "//reports//" + testCaseName + ".png";
        } else {
            System.out.println("TakesScreenshot is null. WebDriver state: " + getDriver());
            throw new Exception("TakesScreenshot is null");
        }
    }
	

}
