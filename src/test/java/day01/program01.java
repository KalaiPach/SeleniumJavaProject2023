package day01;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class program01 {

	public static void main(String[] args) {
		
		ExtentReports report = new ExtentReports(".\\src\\test\\resources\\report\\feb14.html");
		ExtentTest test = report.startTest("TestCase01","Verify user is able to log in with valid user and password");
		test.log(LogStatus.INFO, "Open ChromeBrowser");
		test.log(LogStatus.INFO, "Open Application URL");
		test.log(LogStatus.INFO, "Enter the user name in text box");
		test.log(LogStatus.INFO, "Enter the password in text box");
		test.log(LogStatus.INFO, "Check log-in");
		report.endTest(test);
		report.flush();	

		
		
	}

}
