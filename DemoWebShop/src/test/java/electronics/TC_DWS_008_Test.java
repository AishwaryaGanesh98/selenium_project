package electronics;

import java.io.IOException;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.tricentis.genericutility.BaseClass1;
import com.tricentis.genericutility.ListenerUtility;
@Listeners(ListenerUtility.class)
public class TC_DWS_008_Test extends BaseClass1{ 	
	@Test(groups = "smoke")
	public void clickOnElectronics() throws IOException
	{
		hp.getElectronicsLink().click();
		/*String expectedTitle = eUtils.getStringDataFromExcel("Electronics", 1, 0);
		Assert.assertEquals(expectedTitle, driver.getTitle(), "Electronics page is not displayed" );
		Reporter.log("Electronics page is displayed", true); //is not used while implementing extent reports instead we use next line */
		Assert.assertEquals("Electronics", driver.getTitle(), "Electronics page is not displayed" ); //failing script on purpose to take screenshot using extent reports
		test.log(Status.PASS, "Electronics page is displayed");
	}
}



