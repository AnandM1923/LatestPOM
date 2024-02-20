package listeners;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import ExtentReportspkg.ExtReports;
import basepackage.BaseClassForInit;

public class Itestlisterners extends BaseClassForInit implements ITestListener{
	ExtReports ExtReports=new ExtReports();
	ExtentReports erp = ExtReports.extentreports();
	 ExtentTest test;
	
	public void onTestStart(ITestResult result) {
		test=erp.createTest(result.getMethod().getMethodName());
	
	}

	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, "test Case passed");
	}

	public void onTestFailure(ITestResult result) {
		test.log(Status.FAIL, "test case failed");
		try {
            // Retrieve the WebDriver instance using TestBaseClass method
            WebDriver driver = getDriver();
            test.fail(result.getThrowable());
            String ScreenShotpth = takeScreenShot(result.getMethod().getMethodName(), driver);
            test.addScreenCaptureFromPath(ScreenShotpth, result.getMethod().getMethodName());
        } catch (Exception e1) {
            e1.printStackTrace();
        }
	}

	public void onTestSkipped(ITestResult result) {
	
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	
	}

	public void onTestFailedWithTimeout(ITestResult result) {
	
	}

	public void onStart(ITestContext context) {
		
	}

	public void onFinish(ITestContext context) {
		erp.flush();
	}

}
