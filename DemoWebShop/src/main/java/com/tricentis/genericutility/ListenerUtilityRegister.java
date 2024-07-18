package com.tricentis.genericutility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;

public class ListenerUtilityRegister extends BaseClass4 implements ITestListener{
	@Override
	public void onTestFailure(ITestResult result) {
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
