package computers;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.tricentis.genericutility.BaseClass1;
import com.tricentis.genericutility.ListenerUtility;
@Listeners(ListenerUtility.class)
public class TC_DWS_007_Test extends BaseClass1{ 	
	@Test(groups = "smoke")
	public void clickOnComputers() throws IOException
	{
		hp.getComputersLink().click();
		/*String expectedTitle = eUtils.getStringDataFromExcel("Computers", 1, 0);
		Assert.assertEquals(expectedTitle, driver.getTitle(), "Computers page is not displayed" );
		Reporter.log("Computers page is displayed", true); //is not used while implementing extent reports instead we use next line */
		Assert.assertEquals("Computers", driver.getTitle(), "Computers page is not displayed" ); //failing script on purpose to take screenshot using extent reports
		test.log(Status.PASS, "Computers page is displayed");
	}
}



