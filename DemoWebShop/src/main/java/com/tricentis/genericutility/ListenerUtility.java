package com.tricentis.genericutility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.Status;

public class ListenerUtility extends BaseClass1 implements ITestListener{
	@Override
	public void onTestFailure(ITestResult result) {
		//taking screenshot using OutputType.file and listeners	
		/*String methodName = result.getName();
		Reporter.log("Test Script has failed", true);
		TakesScreenshot ts = (TakesScreenshot) driver;
        File tempFile = ts.getScreenshotAs(OutputType.FILE);
        File permFile = new File("./screenshots/"+timestamp+methodName+".png");
        	try {
				FileUtils.copyFile(tempFile, permFile);
			} catch (IOException e) {
				e.printStackTrace();
			}
        
		
		//taking screenshot using OutputType.Base64 and extentreports
		String methodName = result.getName();
		screenTest.log(Status.FAIL, methodName+"has failed");
		TakesScreenshot ts = (TakesScreenshot) driver;
		String photo = ts.getScreenshotAs(OutputType.BASE64);
		screenTest.addScreenCaptureFromBase64String(photo); */
		
		//everything together can be written as:
		String methodName = result.getName();
		screenTest.log(Status.FAIL, methodName+" has failed");
		TakesScreenshot ts = (TakesScreenshot) driver;
		screenTest.addScreenCaptureFromBase64String(ts.getScreenshotAs(OutputType.BASE64));
		File tempFile = ts.getScreenshotAs(OutputType.FILE);
        File permFile = new File("./screenshots/"+timestamp+methodName+".png");
        	try {
				FileUtils.copyFile(tempFile, permFile);
			} catch (IOException e) {
				e.printStackTrace();
			}
		
	}
}
