package utility;

import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Utility {
    public WebDriver driver;

    //This method will click on element
    public void clickOnElement(By by) {
        driver.findElement(by).click();
    }

    //This method will send text on element
    public void sendTextToElement(By by, String text) {
        driver.findElement(by).sendKeys(text);
    }

    //This method will get text on element
    public String getTextFromElement(By by) {
        return driver.findElement(by).getText();
    }

    //Method for mouse hover on element

    public void mouseHoverToElement(By by){
        Actions  actions = new Actions(driver);
        actions.moveToElement(driver.findElement(by)).perform();
    }

    //This method will used to hover mouse on element and click
    public void mouseHoverToElementAndClick(By by){
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(by)).click().perform();
    }
    //Method for select drop down menu by visible text
    public void selectByVisibleTextFromDropDownMenu(By by, String text ){
        Select select = new Select(driver.findElement(by));
        select.selectByVisibleText(text);
    }
    //This method will used to select drop down menu by index
    public void selectByIndexFromDropDownMenu(By by, int index){
        Select select = new Select(driver.findElement(by));
        select.selectByIndex(index);
    }
    //This method will used to select drop down menu by value
    public void selectByValueFromDropDownMenu(By by, String value) {
        Select select = new Select(driver.findElement(by));
        select.selectByValue(value);
    }

}


