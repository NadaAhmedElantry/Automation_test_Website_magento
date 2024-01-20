package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import page.base.Base;

public class D_CheckoutandPayment {
    private final WebDriver driver;

    public D_CheckoutandPayment() {
        this.driver= Base.driver;
    }

    @Given("Go to cart")
    public void gotocart()
    {
        driver.get("https://magento.softwaretestingboard.com/");
        WebElement cart = driver.findElement(By.cssSelector("a[href='https://magento.softwaretestingboard.com/checkout/cart/']"));
        cart.click();
    }
    @When("Proceed with payment")
    public void Gotopayment()
    {
        WebElement proccedtopayment = driver.findElement(By.id("top-cart-btn-checkout"));
        proccedtopayment.click();
    }
    @And("Fill data in two steps")
    public void Insertdata()
    {
        driver.findElement(By.cssSelector("[name='company']")).sendKeys("Company");
        driver.findElement(By.cssSelector("[name='street[0]']")).sendKeys("Address");
        driver.findElement(By.cssSelector("[name='city']")).sendKeys("Cairo");
        WebElement dropdownElement = driver.findElement(By.xpath("//*[@id=\"shipping-new-address-form\"]/div[5]/div"));
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByVisibleText("Option 4");
        driver.findElement(By.cssSelector("[name='postcode']")).sendKeys("24680");
        WebElement dropdownElement2 = driver.findElement(By.cssSelector("[name='country_id']"));
        Select dropdown2 = new Select(dropdownElement2);
        dropdown2.selectByVisibleText("Option 2");
        driver.findElement(By.cssSelector("[name='telephone']")).sendKeys("01111111111");
        WebElement next = driver.findElement(By.xpath("//*[@id=\"shipping-method-buttons-container\"]/div/button/span"));
        next.click();
        WebElement placeorder = driver.findElement(By.xpath("//*[@id=\"checkout-payment-method-load\"]/div/div/div[2]/div[2]/div[4]/div/button"));
        placeorder.click();


    }
    @Then("Assert")
    public void Assert()
    {
      WebElement orderplaced = driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[1]/h1/span"));
        Assert.assertTrue(orderplaced.isDisplayed());
        Assert.assertEquals(orderplaced.getText(),"Thank you for your purchase!");

    }
}
