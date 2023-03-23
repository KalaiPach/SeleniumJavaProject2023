package day09;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Framework {
	public static WebDriver driver;
	public static ExtentReports report;
	public static ExtentTest test;

	public static void browser(String browserValue) {
	
		try {
			switch(browserValue) {
			case "Chrome":
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--remote-allow-origins=*");
				driver = new ChromeDriver(options);
				test.log(LogStatus.INFO, "launched Chrome Browser");
				passScreenShot(browserValue);
				break;
			case "Firefox":
				driver = new FirefoxDriver();
				test.log(LogStatus.INFO, "Launched Firefox");
				passScreenShot(browserValue);
				break;
			case "IE":
				driver = new InternetExplorerDriver(); 
				test.log(LogStatus.INFO, "IE Launched");
				passScreenShot(browserValue);
				break;
			case "Edge":
				driver = new EdgeDriver();
				test.log(LogStatus.INFO, "Launched Edge");
				passScreenShot(browserValue);
				break;
			}
		} catch (Exception e) {
			e.printStackTrace(); 
			test.log(LogStatus.ERROR, e.getMessage());
			failScreenShot(browserValue);
			}

	}
	
	public static void application(String url) {
		try {
			driver.get(url);
			test.log(LogStatus.INFO, "Launch Url");
			passScreenShot("application");
		} catch (Exception e) {
			e.printStackTrace(); 
			test.log(LogStatus.ERROR, e.getMessage());
			passScreenShot("application");
		}
		}
	public static void typeIn(String fieldName) {
		try {
			driver.findElement(By.xpath(readXpath(fieldName))).sendKeys(readDataValue(fieldName));
			test.log(LogStatus.INFO, "Entered value in " +fieldName+" as " +readDataValue(fieldName));
			passScreenShot(fieldName);
		} catch (Exception e) {
			e.printStackTrace(); 
			test.log(LogStatus.ERROR, e.getMessage());
			failScreenShot(fieldName);
		}
		
	}
	public static void clickIn(String fieldName) {
		try {
			driver.findElement(By.xpath(readXpath(fieldName))).click();
			test.log(LogStatus.INFO, "User clicked " +fieldName);
			passScreenShot("Value clicked");
		} catch (Exception e) {
			e.printStackTrace(); 
			test.log(LogStatus.ERROR, e.getMessage());
			failScreenShot("Value clicked");
		}
		
	}
	public static void clearAll(String fieldName) {
		try {
			driver.findElement(By.xpath(readXpath(fieldName))).clear();
			test.log(LogStatus.INFO, "User deleted " +fieldName);
			passScreenShot("Value cleared");
		} catch (Exception e) {
			e.printStackTrace(); 
			test.log(LogStatus.ERROR, e.getMessage());
			failScreenShot("Value cleared");
		}
			}
	
	public static void selectDropDownbyValue(String fieldName) {
		try {
			Select dropdown = new Select(driver.findElement(By.xpath(readXpath(fieldName))));
			dropdown.selectByValue(readDataValue(fieldName));
			test.log(LogStatus.INFO, "User selected dropdown in " +fieldName+" as " +readDataValue(fieldName));
			passScreenShot("dropdown selected");
		} catch (Exception e) {
			e.printStackTrace(); 
			test.log(LogStatus.ERROR, e.getMessage());
			failScreenShot("dropdown selected");
		}
			}
	
	public static void selectDropDownbyText(String fieldName) {
		try {
			Select mySkill = new Select(driver.findElement(By.xpath(readXpath(fieldName))));
			mySkill.selectByVisibleText(readDataValue(fieldName));
			test.log(LogStatus.INFO, "User selected dropdown in " +fieldName+" as " +readDataValue(fieldName));
			passScreenShot("dropdown selected");
		} catch (Exception e) {
			e.printStackTrace(); 
			test.log(LogStatus.ERROR, e.getMessage());
			failScreenShot("dropdown selected");
		}
					}

	public static void selectDropDownByIndex(String fieldName) {
		try {
			Select myCountry = new Select(driver.findElement(By.xpath(readXpath(fieldName))));
			myCountry.selectByIndex(Integer.parseInt(readDataValue(fieldName)));
			test.log(LogStatus.INFO, "User selected dropdown  " +fieldName+" as " +readDataValue(fieldName));
			passScreenShot("dropdown selected");
		} catch (Exception e) {
			e.printStackTrace(); 
			test.log(LogStatus.ERROR, e.getMessage());
			failScreenShot("dropdown selected");
		}
		}
	
	public static void alertOk() {
		try {
			driver.switchTo().alert().accept();
			test.log(LogStatus.INFO, "Ok for alert selected");
			passScreenShot("Alert Ok");
		} catch (Exception e) {
			e.printStackTrace(); 
			test.log(LogStatus.ERROR, e.getMessage());
			failScreenShot("Alert Ok");
		}
		}
	public static void alertCancel() {
		try {
			driver.switchTo().alert().dismiss();
			test.log(LogStatus.INFO, "Alert dismissed");
			passScreenShot("Alert Canceled");
		} catch (Exception e) {
			e.printStackTrace(); 
			test.log(LogStatus.ERROR, e.getMessage());
			failScreenShot("Alert Canceled");
		}
		}
	public static void alertTypeIn(String dataValue, String fieldName) {
		try {
			driver.switchTo().alert().sendKeys(dataValue);
			test.log(LogStatus.INFO, "Entered value in " +fieldName+" as " +dataValue);
			passScreenShot("Alert input");
		} catch (Exception e) {
			e.printStackTrace(); 
			test.log(LogStatus.ERROR, e.getMessage());
			failScreenShot("Alert input");
		}
		}
	public static void swithFrame(String frameIdName, String fieldName) {
		try {
			driver.switchTo().frame(frameIdName);
			test.log(LogStatus.INFO, "user switched to frame "+fieldName);
			passScreenShot("Switch frame");
		} catch (Exception e) {
			e.printStackTrace(); 
			test.log(LogStatus.ERROR, e.getMessage());
			failScreenShot("Switch frame");
		}
	}
	public static void switchBackFromframe() {
		try {
			driver.switchTo().defaultContent();
			test.log(LogStatus.INFO, "user switched back to main");
			passScreenShot("Switchback frame");
		} catch (Exception e) {
			e.printStackTrace(); 
			test.log(LogStatus.ERROR, e.getMessage());
			failScreenShot("Switchback frame");
		}
			}
	public static void swichToWindow(String windowId, String windowName) {
		try {
			driver.switchTo().window(windowId);
			test.log(LogStatus.INFO, "user switched to window "+windowName);
			passScreenShot("Switcto window");
		} catch (Exception e) {
			e.printStackTrace(); 
			test.log(LogStatus.ERROR, e.getMessage());
			failScreenShot("Switcto window");
		}
			}
	public static String getCurrentWindowId() {
		try {
			return driver.getWindowHandle();
			} catch (Exception e) {
			e.printStackTrace(); 
			test.log(LogStatus.ERROR, e.getMessage());
			passScreenShot("Get window");
			return(null);
		}
	}
	public static Set<String> getAllWindowIds() {
		try {
			return driver.getWindowHandles();
		} catch (Exception e) {
			e.printStackTrace(); 
			test.log(LogStatus.ERROR, e.getMessage());
			passScreenShot("Get window");
			return(null);
		}
	}
	
	public static void windowMax() {
		try {
			driver.manage().window().maximize();
			test.log(LogStatus.INFO, "Maximise Window");
			passScreenShot("Maximise window");
		} catch (Exception e) {
			e.printStackTrace(); 
			test.log(LogStatus.ERROR, e.getMessage());
			failScreenShot("Maximise window");
		}
	}
	public static void windowMini() {
		try {
			driver.manage().window().minimize();
			test.log(LogStatus.INFO, "Minimise Window");
			passScreenShot("Minimise window");
		} catch (Exception e) {
			e.printStackTrace(); 
			test.log(LogStatus.ERROR, e.getMessage());
			failScreenShot("Minimise window");
		}
	}
	
	public static void windowFullScreen() {
		try {
			driver.manage().window().fullscreen();
			test.log(LogStatus.INFO, "Full Window");
			passScreenShot("Full window");
		} catch (Exception e) {
			e.printStackTrace(); 
			test.log(LogStatus.ERROR, e.getMessage());
			failScreenShot("Full window");
		}
	}
	public static void browserClose() {
		try {
			driver.close();
			test.log(LogStatus.INFO, "Close browser");
			passScreenShot("Close browser");
		} catch (Exception e) {
			e.printStackTrace(); 
			test.log(LogStatus.ERROR, e.getMessage());
			failScreenShot("Close browser");
		}
	}
	public static void browserQuit() {
		try {
			driver.quit();
			test.log(LogStatus.INFO, "Browser quit");
			passScreenShot("Quit browser");
		} catch (Exception e) {
			e.printStackTrace(); test.log(LogStatus.ERROR, e.getMessage());
			failScreenShot("Quit browser");
		}
	}
	public static void actionDoubleClick(String fieldName) {
		try {
			Actions action = new Actions(driver);
			WebElement element = driver.findElement(By.xpath(readXpath(fieldName)));
			action.doubleClick(element).build().perform();
			test.log(LogStatus.INFO, "user doubleclicked "+fieldName);
			passScreenShot("Doubleclick");
		} catch (Exception e) {
			e.printStackTrace(); 
			test.log(LogStatus.ERROR, e.getMessage());
			failScreenShot("Doubleclick");
		}
	}
	public static void actionClick(String fieldName) {
		try {
			Actions action = new Actions(driver);
			WebElement element = driver.findElement(By.xpath(readXpath(fieldName)));
			action.click(element).build().perform();
			test.log(LogStatus.INFO, "User clicked "+fieldName);
			passScreenShot("Click");
		} catch (Exception e) {
			e.printStackTrace(); 
			test.log(LogStatus.ERROR, e.getMessage());
			failScreenShot("Click");
		}
	}
	public static void actionRightclick(String fieldName) {
		try {
			Actions action = new Actions(driver);
			WebElement element = driver.findElement(By.xpath(readXpath(fieldName)));
			action.contextClick(element).build().perform();
			test.log(LogStatus.INFO, "User rightclicked "+fieldName);
			passScreenShot("RightClick");
		} catch (Exception e) {
			e.printStackTrace(); 
			test.log(LogStatus.ERROR, e.getMessage());
			failScreenShot("RightClick");
		}
	}
	public static void actionMouseHover(String fieldName) {
		try {
			Actions action = new Actions(driver);
			WebElement element = driver.findElement(By.xpath(readXpath(fieldName)));
			action.moveToElement(element).build().perform();
			test.log(LogStatus.INFO, "User hoverovered the "+fieldName);
			passScreenShot("HoverOver");
		} catch (Exception e) {
			e.printStackTrace(); 
			test.log(LogStatus.ERROR, e.getMessage());
			failScreenShot("HoverOver");
		}
	}
	public static void actionDragAndDrop(String srcXapthvalue, String desXpathValue, String fieldName) {
		try {
			Actions action = new Actions(driver);
			WebElement srcElement = driver.findElement(By.xpath(srcXapthvalue));
			WebElement desElement = driver.findElement(By.xpath(desXpathValue));
			action.dragAndDrop(srcElement, desElement).build().perform();
			passScreenShot("DragandDrop");
			test.log(LogStatus.INFO, "User dragged and dropped "+fieldName);
		} catch (Exception e) {
			e.printStackTrace(); 
			test.log(LogStatus.ERROR, e.getMessage());
			failScreenShot("DragandDrop");
		}
	}
	
	public static void passScreenShot(String fileName)  {
		try {
			File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			File des = new File(".\\src\\test\\resources\\screenshot\\pass\\"+fileName+".png");
			FileUtils.copyFile(src, des);
			test.log(LogStatus.PASS, test.addScreenCapture(des.getAbsolutePath()));
			} 
			catch (Exception e) {
			e.printStackTrace(); 
			test.log(LogStatus.ERROR, e.getMessage());
		}
		}
		public static void failScreenShot(String fileName) {
			try {
				File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				File des = new File(".\\src\\test\\resources\\screenshot\\fail\\"+fileName+".png");
				FileUtils.copyFile(src, des);
				test.log(LogStatus.FAIL, test.addScreenCapture(des.getAbsolutePath()));
			} catch (IOException e) {
				e.printStackTrace(); 
				test.log(LogStatus.ERROR, e.getMessage());
			}
		
		
	}

	public static void reportStart(String fileName)
	{
		report = new ExtentReports(".\\src\\test\\resources\\report"+fileName+".html");
		
	}
	public static void reportEnd() {
		report.flush();
	}
	public static void testCaseStart(String testCaseId, String testDescription)
	{
		test = report.startTest(testCaseId,testDescription);
	}
	public static void testCaseEnd()
	{
		report.endTest(test);
	}
	
	public static String readXpath(String fieldName)
	{
		try {
		File src = new File(".\\src\\test\\resources\\TestDataSheet.xlsx");
		FileInputStream ip = new FileInputStream(src);
		XSSFWorkbook wb = new XSSFWorkbook(ip);
		XSSFSheet sh = wb.getSheetAt(0);
		DataFormatter format = new DataFormatter();
							
		for(int i=1; i<=sh.getLastRowNum();i++)
		{
			if(format.formatCellValue(sh.getRow(i).getCell(0)).equals("Skill"))
			{
				return(format.formatCellValue(sh.getRow(i).getCell(1)));
			}
			}
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return null;

	}

public static String readDataValue(String dataValue)
{
try {
File src = new File(".\\src\\test\\resources\\TestDataSheet.xlsx");
FileInputStream ip = new FileInputStream(src);
XSSFWorkbook wb = new XSSFWorkbook(ip);
XSSFSheet sh = wb.getSheetAt(0);
DataFormatter format = new DataFormatter();
					
for(int i=1; i<=sh.getLastRowNum();i++)
{
	
	if(format.formatCellValue(sh.getRow(i).getCell(0)).equals("Skill"))
	{
		return(format.formatCellValue(sh.getRow(i).getCell(2)));
	}
	}

} catch (Exception e) {
// TODO Auto-generated catch block
e.printStackTrace();
}
return null;

	
}
}


