package nopcommerce;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.Point;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import utility.Utility;

import java.util.concurrent.TimeUnit;

public class Computers extends Utility {
    String baseUrl = "https://demo.nopcommerce.com/computers";

    @Before
    public void openbrowser() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NONE);
        driver = new ChromeDriver(options);
        driver.manage().window().setPosition(new Point(-2000, 0));//display 2
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(baseUrl);
    }

    @Test
    public void verifyUserNavigatesToDesktopPage() {
        clickOnElement(By.xpath("//li[@class='inactive']//a[contains(text(),'Desktops')]"));
        clickOnElement(By.xpath("//div[@class='item-grid']//div[1]//div[1]//div[1]//a[1]//img[1]"));
        clickOnElement(By.xpath("//input[@id='product_attribute_3_7']"));
        clickOnElement(By.id("add-to-cart-button-1"));
        String expectedResult = "The product has been added to your shopping cart";
        String actualResult = getTextFromElement(By.xpath("//p[@class='content']"));
        Assert.assertEquals(expectedResult, actualResult);
    }

    @After
    public void closingBrowser() {
        driver.close();
    }
}
