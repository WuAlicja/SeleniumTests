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

public class ExpliciteWaitTest {
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
    public void explicitWaitTest() {

        webDriver.navigate().to("http://the-internet.herokuapp.com/dynamic_controls");
        WebElement webElement = webDriver.findElement(By.cssSelector("div.row:nth-child(2) div.large-12.columns:nth-child(2) div.example:nth-child(3) form:nth-child(5) div:nth-child(1) > input:nth-child(1)"));
        Assert.assertFalse(webElement.isSelected());

        WebElement webElement1 = webDriver.findElement(By.cssSelector("div.row:nth-child(2) div.large-12.columns:nth-child(2) div.example:nth-child(3) form:nth-child(5) > button:nth-child(2)"));


        Actions actions = new Actions(webDriver);
        actions.moveToElement(webElement1).perform();
        actions.click(webElement1).perform();
        WebDriverWait webDriverWait = new WebDriverWait(webDriver, 15);
        webDriverWait.until(ExpectedConditions.invisibilityOf(webElement));
        WebElement webElement2 = webDriver.findElement(By.id("message"));
        Assert.assertTrue(webElement2.getText().contains("It's gone"));
    }

}