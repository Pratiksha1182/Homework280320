package nopcommerce;


import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import utility.Utility;

import java.util.concurrent.TimeUnit;

public class Login extends Utility {
    private String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void openBrowser() {

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
    public void userShouldNagigateToLoginPageSuccessfully() throws InterruptedException {
        clickOnElement(By.xpath("//a[@class='ico-login']"));
        Thread.sleep(3000);
        String expectedText = "Welcome, Please Sign In!";
        String actualText = getTextFromElement(By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"));
        Assert.assertEquals(expectedText,actualText);
        System.out.println("Expected message on the screen:" + expectedText);
        System.out.println("Actual message on the screen:" + actualText);
    }

    @Test
    public void userShoulLoginSuccessfully() throws InterruptedException {
        clickOnElement(By.xpath("//a[@class='ico-login']"));
        Thread.sleep(3000);
        sendTextToElement(By.xpath("//input[@id='Email']"),"pratikshapatel1182@gmail.com");
        sendTextToElement(By.id("Password"),"2810om");
        clickOnElement(By.xpath("//input[@class='button-1 login-button']"));
        String expectedText = "Welcome to our store";
        String actualText = getTextFromElement(By.xpath("//h2[contains(text(),'Welcome to our store')]"));
        Assert.assertEquals(expectedText,actualText);
        System.out.println("Expected message on the screen:" + expectedText);
        System.out.println("Actual message on the screen:" + actualText);

    }
    @Test
    public void userShouldnotLoginSuccessfully() throws InterruptedException{
        clickOnElement(By.xpath("//a[@class='ico-login']"));
        Thread.sleep(3000);
        sendTextToElement(By.xpath("//input[@id='Email']"),"xyz@yahoo.com");
        sendTextToElement(By.id("Password"),"1234");
        clickOnElement(By.xpath("//input[@class='button-1 login-button']"));
        String expectedText = "Login was unsuccessful. Please correct the errors and try again.\n" +
                "No customer account found";
        String actualText = getTextFromElement(By.xpath("//div[@class='message-error validation-summary-errors']"));
        Assert.assertEquals(expectedText,actualText);
        System.out.println("Expected message on the screen:" + expectedText);
        System.out.println("Expected message on the screen:" + actualText);

    }
    @After
public void closebrowser(){
        driver.quit();
    }
    }






