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

public class Electronics extends Utility {
    String baseUrl = "https://demo.nopcommerce.com/electronics";
    @Before
    public void openbrowser(){
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
    public void mouseHoverOnElectronics(){
        mouseHoverToElement(By.linkText("Electronics"));
        clickOnElement(By.linkText("Camera & photo"));
        String expectedText = "Camera & photo";
        String actualText = getTextFromElement(By.xpath("//h1[contains(text(),'Camera & photo')]"));
        Assert.assertEquals(expectedText,actualText);

    }
    @Test
    public void verifySortByPositionIsLawToHigh(){
        mouseHoverToElement(By.linkText("Electronics"));
        clickOnElement(By.linkText("Camera & photo"));
        selectByVisibleTextFromDropDownMenu(By.xpath("//select[@id='products-orderby']"),"Price: Low to High");
    }
    @After
    public void closebrowser(){
        driver.quit();
    }
}
