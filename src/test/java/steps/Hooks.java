package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import page.base.Base;

public class Hooks {

     WebDriver driver;

    @Before(value = "not @excludeSetup")

    public void setUp() {

        Base.launchbrowser();
        driver=Base.driver;
        WebElement Loginlink = driver.findElement(By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[2]/a"));
        Loginlink.click();
        driver.findElement(By.id("email")).sendKeys("nad@mail.com");
        driver.findElement(By.id("pass")).sendKeys("nAda@246810");
        WebElement clickloginbutton = driver.findElement(By.id("send2"));
        clickloginbutton.click();
        WebElement checkresult = driver.findElement(By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[1]/span"));
        Assert.assertTrue(checkresult.isDisplayed());

    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
    public WebDriver getDriver() {
        return driver;
    }

}

