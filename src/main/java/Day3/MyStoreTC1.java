package Day3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class MyStoreTC1{

    WebDriver driver;
    String URL = "http://automationpractice.com";

    @BeforeMethod
    @Parameters({"browser"})
    public void openBrowser(String browser){

        if(browser.equalsIgnoreCase("chrome")){

            System.setProperty("webdriver.chrome.driver", "C:\\Users\\mdube\\Documents\\Selenium-Training\\Resources\\chromedriver.exe");
            //Create a new instance of the Chrome driver
            driver = new ChromeDriver();
        }else if (browser.equalsIgnoreCase("firefox")){

            System.setProperty("webdriver.gecko.driver", "C:\\Users\\mdube\\Documents\\Selenium-Training\\Resources\\geckodriver.exe");
            //Create a new instance of the Chrome driver
            driver = new FirefoxDriver();

        }
        driver.get(URL);

        //Maximize chrome browser
        driver.manage().window().maximize();

    }

    @Test(priority = 1)
    public void logoTest(){

        WebElement logo = driver.findElement(By.xpath("//img[@class='logo img-responsive']"));
        Assert.assertTrue(logo.isDisplayed(), "Logo is not displayed");
    }

    @Test(priority = 0)
    public void titleTest(){

        //Storing title name in the String variable
        String title = driver.getTitle();

        //Verify the title page
        Assert.assertEquals(title, "My Store", "Titles don't match");

    }

    @Test(priority = 2)
    public void urlTest(){
        //Storing URL in String variable
        String actualURL = driver.getCurrentUrl();

        //Verify that the urls match by printing a message
       Assert.assertEquals(actualURL, URL, "URL's don't match");

    }

    @AfterMethod
    public void closeBrowser(){

        driver.close();
    }



}
