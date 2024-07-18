package logout;

import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.tricentis.genericutility.BaseClass3;
import com.tricentis.genericutility.ListenerUtilityLogout;
import com.tricentis.objectrepository.HomePage;
@Listeners(ListenerUtilityLogout.class)
public class TC_DWS_003_Test extends BaseClass3{
	@Test(groups = "system")
	public void logout(Method method)
	{
		hp=new HomePage(driver);
		hp.getLogoutLink().click();
		Assert.assertEquals(true, false, "User has failed to log out"); //failing script on purpose
		test.log(Status.PASS, "User has logged out successfully");	}
}
