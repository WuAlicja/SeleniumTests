import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class HoversTest {
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
    public void hoversTest() {

        webDriver.navigate().to("http://the-internet.herokuapp.com/hovers");
        WebElement webElement = webDriver.findElement(By.cssSelector(" div.row:nth-child(2) div.large-12.columns:nth-child(2)" +
                " div.example:nth-child(2) div.figure:nth-child(3) > img:nth-child(1)"));
        Actions actions = new Actions(webDriver);
        actions.moveToElement(webElement).perform();
        WebElement webElement1 = webDriver.findElement(By.cssSelector("div.row:nth-child(2) div.large-12.columns:nth-child(2) div.example:nth-child(2) div.figure:nth-child(3) div.figcaption:nth-child(2) > h5:nth-child(1)"));
        Assert.assertTrue(webElement1.getText().contains("user1"));

        List<WebElement> webElement3 = webDriver.findElements(By.tagName("h5"));
        Assert.assertFalse(webElement3.get(1).getText().contains("user2"));
        Assert.assertFalse(webElement3.get(2).getText().contains("user3"));

        actions.moveToElement(webDriver.findElement(By.cssSelector("div.row:nth-child(2) " +
                "div.large-12.columns:nth-child(2) div.example:nth-child(2) div.figure:nth-child(4) > img:nth-child(1)"))).perform();
        Assert.assertTrue(webElement3.get(1).getText().contains("user2"));
        Assert.assertFalse(webElement3.get(0).getText().contains("user1"));
        Assert.assertFalse(webElement3.get(2).getText().contains("user3"));

        actions.moveToElement(webDriver.findElement(By.cssSelector("div.row:nth-child(2) " +
                "div.large-12.columns:nth-child(2) div.example:nth-child(2) div.figure:nth-child(5) > img:nth-child(1)"))).perform();
        Assert.assertTrue(webElement3.get(2).getText().contains("user3"));
        Assert.assertFalse(webElement3.get(0).getText().contains("user1"));
        Assert.assertFalse(webElement3.get(1).getText().contains("user2"));
    }


}


