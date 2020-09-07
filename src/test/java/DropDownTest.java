import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

    public class DropDownTest {
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
        public void dropDownTest() {

            webDriver.navigate().to("http://the-internet.herokuapp.com/dropdown");

            Select dropdown= new Select(webDriver.findElement(By.id("dropdown")));
            Assert.assertTrue(dropdown.getFirstSelectedOption().getText().contentEquals("Please select an option"));

            dropdown.selectByIndex(1);
            Assert.assertTrue(dropdown.getFirstSelectedOption().getText().contentEquals("Option 1"));

            dropdown.selectByIndex(2);
            Assert.assertTrue(dropdown.getFirstSelectedOption().getText().contentEquals("Option 2"));


        }


    }

