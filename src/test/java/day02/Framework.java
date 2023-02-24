package day02;

import java.io.File;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Framework {
	public static WebDriver driver;

	public static void browser(String browserValue) {
	
		switch(browserValue) {
		case "Chrome":
			driver = new ChromeDriver(); 
			break;
		case "Firefox":
			driver = new FirefoxDriver(); 
			break;
		case "IE":
			driver = new InternetExplorerDriver(); 
			break;
		case "Edge":
			driver = new EdgeDriver(); 
			break;
		}

	}
	
	public static void application(String url) {
		driver.get(url);
		}
	public static void typeIn(String xpathValue, String dataValue) {
		driver.findElement(By.xpath(xpathValue)).sendKeys(dataValue);
		
	}
	public static void clickIn(String xpathValue) {
		driver.findElement(By.xpath(xpathValue)).click();
		
	}
	public static void clearAll(String xpathValue) {
		driver.findElement(By.xpath(xpathValue)).clear();
			}
	
	public static void selectDropDownbyValue(String xpathValue, String dataValue) {
		Select dropdown = new Select(driver.findElement(By.xpath(xpathValue)));
		dropdown.selectByValue(dataValue);
			}
	
	public static void selectDropDownbyText(String xpathValue, String dataValue) {
		Select mySkill = new Select(driver.findElement(By.xpath(xpathValue)));
		mySkill.selectByVisibleText(dataValue);
					}

	public static void selectDropDownByIndex(String xpathValue, int dataValue) {
		Select myCountry = new Select(driver.findElement(By.xpath(xpathValue)));
		myCountry.selectByIndex(dataValue);
		}
	
	public static void alertOk() {
		driver.switchTo().alert().accept();
		}
	public static void alertCancel() {
		driver.switchTo().alert().dismiss();
		}
	public static void alertTypeIn(String dataValue) {
		driver.switchTo().alert().sendKeys(dataValue);
		}
	public static void swithFrame(String frameIdName) {
		driver.switchTo().frame(frameIdName);
	}
	public static void switchBackFromframe() {
		driver.switchTo().defaultContent();
			}
	public static void swichToWindow(String windowId) {
		driver.switchTo().window(windowId);
			}
	public static String getCurrentWindowId() {
		return driver.getWindowHandle();
	}
	public static Set<String> getAllWindowIds() {
		return driver.getWindowHandles();
	}
	
	public static void windowMax() {
		driver.manage().window().maximize();
	}
	public static void windowMini() {
		driver.manage().window().minimize();
	}
	
	public static void windowFullScreen() {
		driver.manage().window().fullscreen();
	}
	public static void browserClose() {
		driver.close();
	}
	public static void browserQuit() {
		driver.quit();
	}
	public static void actionDoubleClick(String xpathValue) {
		Actions action = new Actions(driver);
		WebElement element = driver.findElement(By.xpath(xpathValue));
		action.doubleClick(element).build().perform();
	}
	public static void actionClick(String xpathValue) {
		Actions action = new Actions(driver);
		WebElement element = driver.findElement(By.xpath(xpathValue));
		action.doubleClick(element).build().perform();
	}
	public static void actionRightclick(String xapthValue) {
		Actions action = new Actions(driver);
		WebElement element = driver.findElement(By.xpath(xapthValue));
		action.contextClick(element).build().perform();
	}
	public static void actionMouseHover(String xpathValue) {
		Actions action = new Actions(driver);
		WebElement element = driver.findElement(By.xpath(xpathValue));
		action.moveToElement(element).build().perform();
	}
	public static void actionDragAndDrop(String srcXapthvalue, String desXpathValue) {
		Actions action = new Actions(driver);
		WebElement srcElement = driver.findElement(By.xpath(srcXapthvalue));
		WebElement desElement = driver.findElement(By.xpath(desXpathValue));
		action.dragAndDrop(srcElement, desElement).build().perform();
	}
	
	public static void ScreenShot(String fileName) throws Exception {
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File des = new File(".\\src\\test\\resources\\screenshot\\"+fileName+".png");
		FileUtils.copyFile(src, des);
		
		
	}
}


