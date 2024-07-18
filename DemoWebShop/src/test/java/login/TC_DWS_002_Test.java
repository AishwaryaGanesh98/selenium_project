package login;

import java.io.IOException;
import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.tricentis.genericutility.BaseClass2;
import com.tricentis.genericutility.ExcelUtility;
import com.tricentis.genericutility.ListenerUtilityLogin;
import com.tricentis.objectrepository.HomePage;
import com.tricentis.objectrepository.LoginPage;
import com.tricentis.objectrepository.WelcomePage;
@Listeners(ListenerUtilityLogin.class)
public class TC_DWS_002_Test extends BaseClass2{
	@Test(groups = "system")
	public void login(Method method) throws IOException
	{
		hp=new HomePage(driver);
		test=extReport.createTest(method.getName()); //instead of hardcoding we are getting method names dynamically
		screenTest = test; //if we just use test without making it static we are getting null exception so we have created screenTest, made it static and assigned test value to it
		wp = new WelcomePage(driver);
		wp.getLoginLink().click();
		lp = new LoginPage(driver);
		lp.getEmailTF().sendKeys(fUtils.getDataFromProperty("email"));
		lp.getPasswordTF().sendKeys(fUtils.getDataFromProperty("password"));
		lp.getLoginButton().click();
		eUtils = new ExcelUtility();
		String expectedTitle = eUtils.getStringDataFromExcel("Home", 1, 0);
		Assert.assertEquals("login", driver.getTitle(), "User has failed to login");
		test.log(Status.PASS, "User has logged in successfully");
	}
}
