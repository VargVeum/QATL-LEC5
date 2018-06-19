package ua.org.autotest;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.interactions.Actions;



public class workWithPrestashop {

    private static WebDriver driver;
    private Actions actions = new Actions(driver);

    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "/WindowsDrivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://prestashop-automation.qatestlab.com.ua/");
    }

    @Test
    public void checkShop() {
        WebElement loginButton = driver.findElement(By.id("_desktop_logo"));
        WebElement showAll = driver.findElement(By.id("category-3"));

        loginButton.click();
        actions.pause(1000);
        String curURL = driver.getCurrentUrl();
        Assert.assertEquals("http://prestashop-automation.qatestlab.com.ua/ru/", curURL);

        showAll.click();
        selectRandomMenu();

        actions.pause(1000);
    }



    @AfterClass
    public static void tearDown() {
        driver.quit();
    }

    private void selectRandomMenu() {

        WebElement TOPS = driver.findElement(By.xpath("/html/body/main/section/div/div[2]/section/section/div[3]/div/div[1]/article[1]/div/div[1]/h1/a"));
        WebElement T_SHIRTS = driver.findElement(By.xpath("/html/body/main/section/div/div[2]/section/section/div[3]/div/div[1]/article[2]/div/div[1]/h1/a"));
        WebElement BLOUSES = driver.findElement(By.xpath("/html/body/main/section/div/div[2]/section/section/div[3]/div/div[1]/article[3]/div/div[1]/h1/a"));
        WebElement DRESSES = driver.findElement(By.xpath("/html/body/main/section/div/div[2]/section/section/div[3]/div/div[1]/article[4]/div/div[1]/h1/a"));
        WebElement CASUAL_DRESSES = driver.findElement(By.xpath("/html/body/main/section/div/div[2]/section/section/div[3]/div/div[1]/article[5]/div/div[1]/h1/a"));
        WebElement EVENING_DRESSES = driver.findElement(By.xpath("/html/body/main/section/div/div[2]/section/section/div[3]/div/div[1]/article[6]/div/div[1]/h1/a"));
        WebElement SUMMER_DRESSES = driver.findElement(By.xpath("/html/body/main/section/div/div[2]/section/section/div[3]/div/div[1]/article[7]/div/div[1]/h1/a"));

        Random random = new Random();
        int num = random.nextInt(8);
        switch (num) {
            case 1:  TOPS.click();
                break;
            case 2:  T_SHIRTS.click();
                break;
            case 3:  BLOUSES.click();
                break;
            case 4:  DRESSES.click();
                break;
            case 5:  CASUAL_DRESSES.click();
                break;
            case 6:  EVENING_DRESSES.click();
                break;
            case 7:  SUMMER_DRESSES.click();
                break;
        }
    }


}
