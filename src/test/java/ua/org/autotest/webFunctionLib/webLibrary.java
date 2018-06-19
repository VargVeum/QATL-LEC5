package ua.org.autotest.webFunctionLib;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class webLibrary {
    private static WebDriver driver;
    private Actions check = new Actions(driver);

    public void mouseHover(WebElement hover)
    {
        check.moveToElement(hover).perform();
    }

    public void webDriverWait(int waitTime)
    {
        try {
            driver.wait(waitTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
