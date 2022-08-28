package pages;

import browser.Browser;
import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {

    WebDriver driver;

    @FindBy(css = "a[href='/age-calculator.html']") private WebElement AgeCalculatorLink;
    //@FindBy() private WebElement

    public AgeCalculator goToAgeCalculatorPage(){

        AgeCalculatorLink.click();
        return PageFactory.initElements(Browser.driver, AgeCalculator.class);
    }

}
