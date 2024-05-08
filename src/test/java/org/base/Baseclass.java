


	
    package org.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.bouncycastle.oer.Switch;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class  Baseclass {
	public static WebDriver driver;
	public JavascriptExecutor js;

	public void getDriver(String browserType) {

		switch (browserType) {
		case "Chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
          
			break;

		case "Edge":
		  WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;

		default:
			System.out.println("In-valid_Browser_Type");
			break;
		}
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));

	}

	public void getUrl(String url) {
		driver.get(url);
	}

	public void winMax() {
		driver.manage().window().maximize();
	}

	public void textSendByJava(WebElement element, String keysToSend) {
		element.sendKeys(keysToSend);
	}

	public void textSendByJs(WebElement elementRef, String textValue) {
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('value','" + textValue + "')", elementRef);

	}

	public void screenShot(String screenShotName) throws IOException {

		TakesScreenshot ts = (TakesScreenshot) driver;
		File srcFile = ts.getScreenshotAs(OutputType.FILE);
		File destFile = new File("C:\\Users\\Welcome\\Desktop\\JavaEnt\\Framework\\New folder\\ScreenShoted\\"
				+ screenShotName + ".jpeg");
		FileUtils.copyFile(srcFile, destFile);

	}
	

	public void scrollByJs(WebElement elementRef, String scroll) {

		switch (scroll) {
		case "Down":
			js.executeScript("arguments[0].scrollIntoView(true)", elementRef);
			break;

		case "Up":
			js.executeScript("arguments[0].scrollIntoView(false)", elementRef);
			break;

		default:
			System.out.println("In-Valid Comment");
			break;
		}

	}

	public String getTextByJava(WebElement elementRef) {
		String text = elementRef.getText();
		return text;
	}

	public String getAttributeByJava(WebElement elementRef) {
		String attribute = elementRef.getAttribute("value");
		return attribute;
	}

	public Object getAttributeByJs(WebElement elementRef) {
		Object executeScript = js.executeScript("return arguments[0].getAttribute('value')", elementRef);
		return executeScript;
	}

	public void actions(WebElement targetElemnt, String whichAction) {

		Actions act = new Actions(driver);

		switch (whichAction) {
		case "Hover":
			act.moveToElement(targetElemnt).build().perform();
			break;

		case "Double":
			act.doubleClick(targetElemnt).build().perform();
			break;

		case "Right":
			act.contextClick(targetElemnt).build().perform();
			break;

		default:
			System.out.println("In-valid_Comment");
			break;
		}

	}

	public String readExcel(int rownum, int cellnum) throws IOException {

		// To Locate the File
		File file = new File("D:\\\\excel\\\\login.xlsx");

		// To get File as Input Datas to filed
		FileInputStream stream = new FileInputStream(file); // throws FileNotFoundException

		// To Define Workbook type
		Workbook book = new XSSFWorkbook(stream);// throws IOException

		// To get sheet from Workbook
		Sheet sheet = book.getSheet("Sheet1");

		Row row = sheet.getRow(rownum);

		Cell cell = row.getCell(cellnum);

		CellType cellType = cell.getCellType();

		String value = null;

		switch (cellType) {
		case STRING:
			value = cell.getStringCellValue();

			break;

		case NUMERIC:
			if (DateUtil.isCellDateFormatted(cell)) {

				Date dateCellValue = cell.getDateCellValue();
				SimpleDateFormat simple = new SimpleDateFormat("dd/MM/yyyy");
				value = simple.format(dateCellValue);

			} else {

				double numericCellValue = cell.getNumericCellValue();
				BigDecimal valueOf = BigDecimal.valueOf(numericCellValue);
				value = valueOf.toString();

			}
			break;

		default:
			System.out.println("In-Valid - Cell-Type");
			break;
		}
		return value;

	}

	public String windowshandling(int index) {

		// To Find Parent Id
		String parentWindowsId = driver.getWindowHandle();
		// To find All windows ID
		Set<String> allWindowsId = driver.getWindowHandles();
		// To add all the values from Set to List
		List<String> li = new LinkedList<String>();
		li.addAll(allWindowsId);
		// To get Required WindowsId
		String windowsId = li.get(index);

		return windowsId;
	}

	public void windowshandling1(int index) {
		// To Find Parent Id
		String parentWindowsId = driver.getWindowHandle();
		// To find All windows ID
		Set<String> allWindowsId = driver.getWindowHandles();
		// To add all the values from Set to List
		List<String> li = new LinkedList<String>();
		li.addAll(allWindowsId);
		// To get Required WindowsId
		String windowsId = li.get(index);
		// To switch to windows
		driver.switchTo().window(windowsId);
	}
	public void selectByValue(WebElement element, String value) {

		Select s = new Select(element);
		s.selectByValue(value);
	}
	public void selectByIndex(WebElement element, int index) {

		Select s = new Select(element);
		s.selectByIndex(index);
	}
	String accept;
	String reject;
	public void alerts(String value) {
		
		Alert a = driver.switchTo().alert();
		if (value.equals(accept)) {
			a.accept();
			
		} else {
			a.dismiss();

		}
		
	}
	public void quit() {
		driver.quit();
	}
}





