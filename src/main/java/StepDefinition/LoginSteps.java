package StepDefinition;
import cucumber.api.PendingException;
import cucumber.api.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class LoginSteps {

    WebDriver driver;

    @Given("User is on Facebook login page$")
    public void user_application_home_page(){


        System.setProperty("webdriver.chrome.driver", "Resources" + File.separator + "chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.facebook.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
    }

    @When("^Application page tittle is Facebook$")
    public void application_page_tittle_is_Facebook() {

        String actualTittle = driver.getTitle();
        Assert.assertEquals(actualTittle, "Facebook – log in or sign up", "Titles do not match");
    }

    @Then("^User enters UserName and Password$")
    public void user_enters_UserName_and_Password() {

        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("0765133419");
        driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("dialect");

    }

    @Then("^User clicks on Login button$")
    public void user_clicks_on_Login_button() throws Throwable {

        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/form[1]/div[2]/button[1]"))).click();
    }

    @Then("^User should access their account$")
    public void user_should_access_their_account() {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        String actualTile = driver.getTitle();
        String expectedTitle = "Facebook – log in or sign up";
        Assert.assertEquals(actualTile, expectedTitle, "Titles do not match");
        driver.close();
    }


}
