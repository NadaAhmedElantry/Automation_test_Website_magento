package steps;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.hc.core5.util.Asserts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.BeforeClass;

//@BeforeClass
public class login {

    WebDriver driver;

        @Given("User open website")
                public void opensite()
        {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("https://magento.softwaretestingboard.com/");
            WebElement Loginlink = driver.findElement(By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[2]/a"));
            Loginlink.click();
        }

        @When("insert data to login fields")
                public void login()
        {
            driver.findElement(By.id("email")).sendKeys("nad@mail.com");
            driver.findElement(By.id("pass")).sendKeys("nAda@246810");
            WebElement clickloginbutton = driver.findElement(By.id("send2"));
            clickloginbutton.click();
        }

        @Then("logged in successfully")
            public void result()
             {
                WebElement checkresult = driver.findElement(By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[1]/span"));
                 Assert.assertTrue(checkresult.isDisplayed());
             }
    }
