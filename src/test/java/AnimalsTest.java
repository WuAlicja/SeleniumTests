import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AnimalsTest {
    //symuluje przegladarke
    private WebDriver webDriver;

    @BeforeMethod
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", "/Users/alicja/Downloads/chromedriver");
        webDriver = new ChromeDriver();
    }

    @AfterMethod
    public void afterTest() {
        webDriver.close();
        webDriver.quit();
    }

    @Test
    public void animalsTest() {

        webDriver.navigate().to("https://jpetstore.cfapps.io/catalog");

        String url12 = webDriver.findElement(By
                .cssSelector("section:nth-child(1) div:nth-child(2) div:nth-child(1) div:nth-child(1) > a:nth-child(13)")).getAttribute("href");

        webDriver.navigate().to(url12);
        Assert.assertTrue(webDriver.getPageSource().contains("Birds"));

    }


}
