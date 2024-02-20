package ExtentReportspkg;

import java.io.FileInputStream;
import java.util.Date;
import java.text.SimpleDateFormat;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtReports {
	
	public ExtentReports extentreports() {
		String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
		String fis=System.getProperty("user.dir") +"\\ReportsExt\\index"+ timeStamp ;
		//String fis= "C:\\Users\\margo\\ElcipseWorkspace3\\POMProject\\ReportsExt";
		ExtentSparkReporter exp=new ExtentSparkReporter(fis);
		exp.config().setDocumentTitle("AnandTestAutomation");
		exp.config().setReportName("Margol");
		ExtentReports ext=new ExtentReports();
		ext.attachReporter(exp);
		ext.setSystemInfo("a", "b");
		ext.setSystemInfo("v", "5");
		return ext;
		
	}

}
