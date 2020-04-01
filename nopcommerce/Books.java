package nopcommerce;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import utility.Utility;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Books extends Utility {
    String baseUrl = "https://demo.nopcommerce.com/books";
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
    public void sortBooksByAtoZ(){
        clickOnElement(By.xpath("//option[contains(text(),'Name: A to Z')]"));
        ArrayList<String> getList = new ArrayList<>();
        List<WebElement> elementList = driver.findElements(By.tagName("h2"));
        for (WebElement Links : elementList){
            getList.add(Links.getText());
        }
        System.out.println("Obtained Product List :" + getList);
        ArrayList<String> sortedList = new ArrayList<>();
        sortedList.addAll(getList);
        Collections.sort(sortedList);
        Assert.assertEquals(getList, sortedList);
    }
    @Test
    public void addProductToTheWishList(){
        clickOnElement(By.xpath("//option[contains(text(),'Name: A to Z')]"));
        clickOnElement(By.xpath("//div[@class='item-grid']//div[1]//div[1]//div[2]//div[3]//div[2]//input[3]"));
        String expectedResult = "The product has been added to your wishlist";
        String actualResult = getTextFromElement(By.xpath("//p[@class='content']"));
        Assert.assertEquals(expectedResult, actualResult);
    }
    @After
    public void closebrowser(){
        driver.quit();
    }
}

