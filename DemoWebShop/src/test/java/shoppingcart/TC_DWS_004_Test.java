package shoppingcart;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.tricentis.genericutility.BaseClass1;
import com.tricentis.genericutility.ListenerUtility;
@Listeners(ListenerUtility.class)
public class TC_DWS_004_Test extends BaseClass1 {
	@Test(groups = "system")
	public void addProduct()
	{
		hp.getAddToCartButtons().get(1).click(); //get(index) is used to get the element based on index, index starts from 0 so get(1) clicks on second element in add to cart out of 6
		//Assert.assertEquals(true, hp.getConfirmMessage().isDisplayed(), "Failed to add product" ); //if condition is passed for true true value failed message - failed to add will not be printed
		Assert.assertEquals(false, hp.getConfirmMessage().isDisplayed(), "Failed to add product" ); //failing script on purpose
		eWait.until(ExpectedConditions.invisibilityOf(hp.getConfirmMessage()));  //we will get exception here because when the previous line fails it will not come to this line
		test.log(Status.PASS, "Product is added successfully");
	}

}
