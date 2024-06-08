package basePackage;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import Utilities.ExcelUtility;
import pagesPackage.SignUp_page;

public class Base {
	public static WebDriver driver;
	public static SignUp_page sup;
	public static ExcelUtility excel;

	@Parameters({ "url", "browser" })
	@BeforeClass
	public void setUp(String url, String browser) {
		
		if (browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\src\\test\\java\\chromedriver-win64\\chromedriver.exe");
			driver=new ChromeDriver();
		}
		else if (browser.equals("edge")) {
			System.setProperty("webdriver.edge.driver",
					System.getProperty("user.dir") + "\\src\\test\\java\\EdgeDriver\\msedgedriver.exe");
			driver=new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		sup=new SignUp_page(driver);
		
		excel=new ExcelUtility();
		
		
		
	}
	@DataProvider
	public static  String[][] getData() throws InvalidFormatException, IOException{
		String filePata="C:\\Users\\C DILEEP KUMAR REDDY\\eclipse-workspace\\CrackATJenkinsWay\\src\\test\\java\\Utilities\\InstagramData.xlsx";
		String sheetName="signup";
		int rowCount=ExcelUtility.getRowNum(filePata, sheetName);
		int cellCount =ExcelUtility.getCellNum(filePata, sheetName, rowCount);
		String[][] data=new String[rowCount][cellCount];

		for(int i=1;i<rowCount;i++) {
			for(int j=0;j<cellCount;j++) {
				data[i-1][j]=ExcelUtility.getCellValue(filePata, sheetName, i, j);
			}
		}
		return data;
	}
	@AfterClass
	public void tearDown() {
		//driver.close();
	}

}
