import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(value = TestListener.class) // this is the listener for the screenShot.

public class MainPageTest extends BaseTest {

    @Test
    public void test1() {
        startingMainPage()      // instead calling the methode we can just write that: PageFactory.initElements(driver, MainPage.class);
                .goToAgeCalculatorPage()
                .selectAge()
                .checkAgeResult("araa");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
