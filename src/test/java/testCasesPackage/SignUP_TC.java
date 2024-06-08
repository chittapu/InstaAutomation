package testCasesPackage;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Utilities.ExcelUtility;
import basePackage.Base;

public class SignUP_TC extends Base{
	Select sel;
	@Test(dataProvider = "getData")
	public void signUP(String mobNum,String fullNAme,String userNAme,String password,String DOBday,String DOBmonth,String DOByear) throws InterruptedException {
		sup.getsignUP_Btn().click();
		sup.getmobNum().sendKeys(mobNum);
		sup.getfullName().sendKeys(fullNAme);
		sup.getuserName().sendKeys(userNAme);
		sup.getpassword().sendKeys(password);
		Thread.sleep(2000);
		sup.getsubmit().click();
		sel=new Select(sup.getDOBmonth());
		sel.selectByValue(DOBmonth);
		sel=new Select(sup.getDOBday());
		sel.selectByValue(DOBday);
		sel=new Select(sup.getDOByear());
		sel.selectByValue(DOByear);
		sup.getnextBtn().click();
		
	}
	

}
