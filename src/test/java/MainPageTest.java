import browser.Browser;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import pages.AgeCalculator;
import pages.MainPage;

public class MainPageTest extends BaseTest{

    @Test
    public void test1() {
        startingMainPage()      // instead calling the methode we can just write that: PageFactory.initElements(driver, MainPage.class);
                .goToAgeCalculatorPage()
                .selectAge();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
