import browser.Browser;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import java.io.File;
import java.io.IOException;

public class TestListener extends TestListenerAdapter {
    //WebDriver driver = Browser.getDriver();

    public void onTestFailure(ITestResult tr){
        WebDriver driver = Browser.getDriver(); // it has to be inside in order to work
        System.out.println("******"+tr.getName());
        final String path = "src/main/java/screenshotFiles";
        File screenShot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        File destFile = new File(path+tr.getName()+".png");

        try {
            FileUtils.copyFile(screenShot, destFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}