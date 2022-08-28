package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static org.testng.AssertJUnit.assertTrue;

public class AgeCalculator {

    WebDriver driver;

    @FindBy(id = "today_Year_ID") private WebElement yearBirth;
    @FindBy(xpath = ("//*[@id=\"today_Month_ID\"]/option[7]"))
    private WebElement monthBirth; // Choose Jul.
    @FindBy(xpath = "//*[@id=\"today_Day_ID\"]/option[17]")
    private WebElement dayBirth; // Choosing the 17th.

    @FindBy(id = "ageat_Year_ID") private WebElement yearWanted;
    @FindBy(xpath = ("//*[@id=\"ageat_Month_ID\"]/option[7]"))
    private WebElement monthWanted; // Choose Jul.
    @FindBy(xpath = "//*[@id=\"ageat_Day_ID\"]/option[17]")
    private WebElement dayWanted; // Choosing the 17th.

    @FindBy(xpath = "//*[@id=\"content\"]/div[3]/table/tbody/tr[3]/td[2]/input")
    private WebElement submitButton;

    @FindBy(css = "p[class='verybigtext']") private WebElement textToCheck;

    public AgeCalculator selectAge(){

        yearBirth.sendKeys(Keys.chord(Keys.CONTROL,"a"));
        yearBirth.sendKeys(Keys.DELETE);
        yearBirth.sendKeys("1986");
        monthBirth.click();
        dayBirth.click();

        yearWanted.sendKeys(Keys.chord(Keys.CONTROL,"a"));
        yearWanted.sendKeys(Keys.DELETE);
        yearWanted.sendKeys("2021");
        monthWanted.click();
        dayWanted.click();

        submitButton.click();

//      ****Normally we use Select for dropbox but here it does not work.*****
//        Select month = new Select(driver.findElement(By.id("today_Month_ID")));
//        month.selectByIndex(6);
//        Select day = new Select(driver.findElement(By.cssSelector("Select[id='today_Day_ID']")));
//        day.selectByVisibleText("17");
        return this;
    }

    public AgeCalculator checkAgeResult(String text){

        String actualString = textToCheck.getText();
        //System.out.println(actualString); // this is to print the text to see if it works.
        assertTrue(actualString.contains(text));

        return this;
    }



}
