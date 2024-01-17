package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.AssertJUnit;

public class C_AddtoCard {
    WebDriver driver;

    @Given("From two products select second one")
    public void selectproduct()
    {
        WebElement comparelink = driver.findElement(By.cssSelector("a[href='https://magento.softwaretestingboard.com/catalog/product_compare/']"));
        comparelink.click();
        WebElement Assertontitle = driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[1]/h1/span"));
        Assert.assertTrue(Assertontitle.isDisplayed());
    }

    @When("add second one to the cart")
    public void addtocart() throws InterruptedException {
        WebElement Addtocart = driver.findElement(By.xpath("//*[@id=\"product-comparison\"]/tbody[1]/tr/td[2]/div[3]/div[1]/form/button/span"));
        Addtocart.click();
        wait(500);
        WebElement selectsize = driver.findElement(By.xpath("//*[@id=\"option-label-size-143-item-169\"]"));
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