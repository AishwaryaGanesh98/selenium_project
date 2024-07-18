package books;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.tricentis.genericutility.BaseClass1;
import com.tricentis.genericutility.ListenerUtility;
@Listeners(ListenerUtility.class)
public class TC_DWS_006_Test extends BaseClass1{ 	
		@Test(groups = "smoke")
		public void clickOnBooks() throws IOException
		{
			hp.getBooksLink().click();
			//String expectedTitle = eUtils.getStringDataFromExcel("Books", 1, 0);
			//Assert.assertEquals(expectedTitle, driver.getTitle(), "Books page is not displayed" );
			//Reporter.log("Books page is displayed", true); is not used while implementing extent reports instead we use next line
			Assert.assertEquals("Books", driver.getTitle(), "Books page is not displayed" ); //failing script on purpose to take screenshot using extent reports
			test.log(Status.PASS, "Books page is displayed");
		}
		
	}

