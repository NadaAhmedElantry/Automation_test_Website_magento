package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import page.base.Base;

public class B_NavigationSteps {

    private  WebDriver driver;


    public B_NavigationSteps() {
           this.driver=Base.driver;
        }

    @Given("User write in search bar hot seller")
    public void searchforhotseller()
    {
        driver.get("https://magento.softwaretestingboard.com/");
        WebElement search = driver.findElement(By.id("search"));
        search.sendKeys("Hot Sellers");
        search.sendKeys(Keys.ENTER);

    }

    @When("hot seller items appears")
    public void Search()
    {
        WebElement Hot = driver.findElement(By.cssSelector("a[href='https://magento.softwaretestingboard.com/catalogsearch/result/?q=hot']"));
        Assert.assertTrue(Hot.isDisplayed());
    }

    @Then("select products to compare")
    public void selectproducts()
    {
        WebElement Addtocompare1 = driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div[1]/div[3]/div[2]/ol/li[1]/div/div/div[4]/div/div[2]/a[2]"));
        Addtocompare1.click();
        WebElement Addtocompare2 = driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div[1]/div[3]/div[2]/ol/li[2]/div/div/div[4]/div/div[2]/a[2]"));
        Addtocompare2.click();
        WebElement comparelink = driver.findElement(By.cssSelector("a[href='https://magento.softwaretestingboard.com/catalog/product_compare/']"));
        Assert.assertTrue(comparelink.isDisplayed());
    }
}
