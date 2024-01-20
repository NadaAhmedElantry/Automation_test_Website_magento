package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import page.base.Base;

import java.time.Duration;

public class C_AddtoCard {

    private WebDriver driver;

    public C_AddtoCard()
    {
        this.driver= Base.driver;
    }

    @Given("From two products select second one")
    public void selectproduct()
    {
        driver.get("https://magento.softwaretestingboard.com/catalog/product_compare/");
        WebElement Assertontitle = driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[1]/h1/span"));
        Assert.assertTrue(Assertontitle.isDisplayed());
    }

    @When("add second one to the cart")
    public void addtocart() throws InterruptedException {
        WebElement Addtocart = driver.findElement(By.xpath("//*[@id=\"product-comparison\"]/tbody[1]/tr/td[2]/div[3]/div[1]/form/button/span"));
        Addtocart.click();
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"option-label-size-143-item-170\"]")));;
        WebElement selectsize = driver.findElement(By.xpath("//*[@id=\"option-label-size-143-item-170\"]"));
        selectsize.click();
        WebElement selectcolor = driver.findElement(By.xpath("//*[@id=\"option-label-color-93-item-49\"]"));
        selectcolor.click();
        WebElement Finaladdtocart = driver.findElement(By.xpath("//*[@id=\"product-addtocart-button\"]"));
        Finaladdtocart.click();
    }
    @Then("Product added to cart successfully")
    public void result()
    {
      WebElement Addedtocart = driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[1]/div[2]/div/div/div"));
     Assert.assertTrue(Addedtocart.isDisplayed());
    }
}
