package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;


public class A_CreateAccountsteps {
    WebDriver driver;

    @Given("User open website and goto create new account page")
    public void create_account()
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://magento.softwaretestingboard.com/");
        WebElement linkElement = driver.findElement(By.cssSelector("a[href='https://magento.softwaretestingboard.com/customer/account/create/']"));
        linkElement.click();
    }
    @When("User insert all correct data in fields")
    public void insert_data()
    {
      driver.findElement(By.id("firstname")).sendKeys("NadaFor");
      driver.findElement(By.id("lastname")).sendKeys("Testing");
      driver.findElement(By.id("email_address")).sendKeys("nadTest@mail.com");
      driver.findElement(By.id("password")).sendKeys("nAda@246810");
      driver.findElement(By.id("password-confirmation")).sendKeys("nAda@246810");
          WebElement CreateAccount = driver.findElement(By.cssSelector("[title='Create an Account']"));
          CreateAccount.click();
    }

    @Then("New account created successfully")
    public void result()
    {
     WebElement myaccount = driver.findElement(By.cssSelector("a[href='https://magento.softwaretestingboard.com/sales/order/history/']"));
     Assert.assertTrue(myaccount.isDisplayed());
    }
}
