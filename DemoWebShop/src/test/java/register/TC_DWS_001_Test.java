package register;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Random;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.tricentis.genericutility.BaseClass4;
import com.tricentis.genericutility.ListenerUtilityRegister;
import com.tricentis.objectrepository.RegisterPage;
import com.tricentis.objectrepository.WelcomePage;
@Listeners(ListenerUtilityRegister.class)
public class TC_DWS_001_Test extends BaseClass4{
	@Test(groups = "system")
	public void register(Method method) throws IOException 
	{
		Random rn = new Random();
		test=extReport.createTest(method.getName()); //instead of hardcoding we are getting method names dynamically
		screenTest = test;
		wp = new WelcomePage(driver);
		wp.getRegisterLink().click();
		rp = new RegisterPage(driver);
		rp.getMaleGenderRB().click();
		rp.getFirstNameTF().sendKeys(fUtils.getDataFromProperty("firstName"));
		rp.getLastNameTF().sendKeys(fUtils.getDataFromProperty("lastName"));
		rp.getEmailTF().sendKeys("aish"+rn.nextInt(0,1000)+"@gmail.com");
		rp.getPasswordTF().sendKeys(fUtils.getDataFromProperty("rPassword"));
		rp.getConfirmPasswordTF().sendKeys(fUtils.getDataFromProperty("cPassword"));
		rp.getRegisterButton().click();
		Assert.assertEquals(false, rp.getConfirmMessage().isDisplayed(), "Failed to register" ); //failing on purpose
		eWait.until(ExpectedConditions.visibilityOf(rp.getConfirmMessage()));
		test.log(Status.PASS, "User has registered successfully");
		
	}
}
