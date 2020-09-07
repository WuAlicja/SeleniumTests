import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HelloWorldTest {
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
    public void helloWorldTest() {

        webDriver.navigate().to("http://the-internet.herokuapp.com/dynamic_loading/1");
        Assert.assertFalse(webDriver.findElement(By.id("content")).getText().contains("Hello World"));
        Actions actions = new Actions(webDriver);
        WebElement webElement = webDriver.findElement(By.tagName("button"));
        actions.moveToElement(webElement).perform();
        actions.click(webElement).perform();
        WebDriverWait webDriverWait = new WebDriverWait(webDriver, 15);
        webDriverWait.until(ExpectedConditions.invisibilityOf(webElement));
        WebElement webElement1 = webDriver.findElement(By.id("finish")).findElement(By.tagName("h4"));
        Assert.assertTrue(webElement1.getText().contains("Hello World!"));
    }

}
