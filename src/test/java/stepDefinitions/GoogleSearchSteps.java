package stepDefinitions;

import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class GoogleSearchSteps {
    private static WebDriver driver;
    private static WebElement weSearchBar;

    private static int explicitWaitInSecond=5000;
    @Given("Open chrome browser")
    public void open_chrome_browser() {
        WebDriverManager.getInstance(DriverManagerType.CHROME).setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("headless");
        driver=new ChromeDriver(options);
    }
    @When("Go google search")
    public void go_google_search() {
        driver.navigate().to("https://www.google.com");
        driver.manage().window().maximize();
    }
    @Then("Search for {string}")
    public void search_for(String searchText) {
        weSearchBar=driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input"));
        weSearchBar.sendKeys(searchText);
    }
    @Then("Hit enter")
    public void hit_enter() {
        weSearchBar.sendKeys(Keys.RETURN);
    }
    @Then("Validate the search result is more then {string}")
    public void validate_the_search_result_is_more_then(String expectedResultCount) {
        WebDriverWait wait = new WebDriverWait(driver,explicitWaitInSecond/1000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='yuRUbf']//a//h3")));
        List<WebElement> weSearchElements=driver.findElements(By.xpath("//div[@class='yuRUbf']//a//h3"));

        Assert.assertTrue(weSearchElements.size()>Integer.parseInt(expectedResultCount));
    }
    @And("Close browser")
    public void close_browser() {
        driver.close();
    }
}
