package Day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class SecondSeleniumScript {

    public static void main(String[] args) {

        WebDriver driver;

        System.setProperty("webdriver.chrome.driver", "Resources" + File.separator + "chromedriver.exe");

        driver = new ChromeDriver();

        //Get application url
        String URL = "http://automationpractice.com";
        driver.get(URL);

        //Maximize Chrome window
        driver.manage().window().maximize();

        //Enter username and password to login_ "Click and sendkeys command"
        driver.findElement(By.xpath("//a[@class='login']")).click();
        driver.findElement(By.id("email")).sendKeys("mpumelelo.mbuyazidube@gmail.com");
        driver.findElement(By.id("passwd")).sendKeys("Lostboi123");

        //Click on the login button
        driver.findElement(By.xpath("//button[@id='SubmitLogin']")).click();

        //Sets the amount of time to wait for a page-load
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);

        //Store login actual and expected name in string variable
        String ActualLoginName = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/header[1]/div[2]/div[1]/div[1]/nav[1]/div[1]/a[1]/span[1]")).getText();
        String ExpectedLoginName = "Mpumelelo mbuyazi";

        //Verify that you have logged in with the correct user
        if(ActualLoginName.equals(ExpectedLoginName)) {

            System.out.println("Pass: correct user");
        }else {

            System.out.println("Fail: incorrect user");

            System.out.println("Actual user" + ActualLoginName);
            System.out.println("Expected user" + ExpectedLoginName);
        }

        //Click on dresses on the menu bar
        driver.findElement(By.xpath("//body[@id='my-account']/div[@id='page']/div[@class='header-container']/header[@id='header']/div/div[@class='container']/div[@class='row']/div[@id='block_top_menu']/ul[@class='sf-menu clearfix menu-content sf-js-enabled sf-arrows']/li[2]/a[1]")).click();

        //Click on casual dresses
        driver.findElement(By.xpath("//div[@class='block_content']//ul[@class='tree dynamized']//a[contains(text(),'Casual Dresses')]")).click();

        //Select the size of the dress
        driver.findElement(By.id("layered_id_attribute_group_1")).click();

        //Selects "In stock" on the "Drop down operation "
        Select select = new Select(driver.findElement(By.id("selectProductSort")));
        select.selectByVisibleText("In stock");

        //Hover over the dress before adding to cart "Webelement command"
        WebElement ele = driver. findElement(By.xpath("//a[@class='product_img_link']//img[@class='replace-2x img-responsive']"));
        Actions action = new Actions(driver);
        action.moveToElement(ele).perform();

        //Add item to the chart
        driver.findElement(By.xpath("//span[contains(text(),'Add to cart')]")).click();

        //Add implicit wait for element interaction or else script will fail
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

        //Click on proceed to checkout button
        driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/header[1]/div[3]/div[1]/div[1]/div[4]/div[1]/div[2]/div[4]/a[1]/span[1]")).click();

        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        String ActualItemsAdded = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/header[1]/div[3]/div[1]/div[1]/div[3]/div[1]/a[1]")).getText();
        String ExpectedItemsAdded = "1";

        //Verify that one item has been added
        if(ActualItemsAdded.contains(ExpectedItemsAdded)) {

            System.out.println("Pass: 1 item is added");

        }else {

            System.out.println("fail: More than one items or no items were added");

            System.out.println("Actual, "+ActualItemsAdded);
            System.out.println("Expected, "+ExpectedItemsAdded);

        }

        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        //Click on proceed to checkout button
        driver.findElement(By.xpath("//a[@class='button btn btn-default standard-checkout button-medium']//span[contains(text(),'Proceed to checkout')]")).click();

        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        //Click on proceed to checkout button
        driver.findElement(By.xpath("//button[@name='processAddress']//span[contains(text(),'Proceed to checkout')]")).click();

        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        //verify that the T&C’s checkbox is not selected
        boolean TCcheckbox = driver.findElement(By.id("cgv")).isSelected();
        if(TCcheckbox == false) {

            System.out.println("Pass: checkbox is not selected");
        }else {

            System.out.println("Fail: checkbox is selected");
        }

        //Click on proceed to checkout button
        driver.findElement(By.xpath("//button[@name='processCarrier']//span[contains(text(),'Proceed to checkout')]")).click();

        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        boolean WarningMessage = driver.findElement(By.xpath("//div[@class='fancybox-outer']")).isDisplayed();

        if(WarningMessage == true) {

            System.out.println("Pass: Warning message is displayed ");
        }else {

            System.out.println("Fail: Warning message is no displayed");
        }

        //Close the warning message
        driver.findElement(By.xpath("//a[@class='fancybox-item fancybox-close']")).click();

        //Click on the T&C's checkbox
        driver.findElement(By.id("cgv")).click();

        //Click on proceed to checkout button
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        driver.findElement(By.xpath("//button[@name='processCarrier']//span[contains(text(),'Proceed to checkout')]")).click();

        //Click pay by bank wire button
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        driver.findElement(By.className("bankwire")).click();

        //Click on I confirm my order button
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        driver.findElement(By.xpath("//span[contains(text(),'I confirm my order')]")).click();

        //verify that it was completed by displaying message
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        String OrderConfirmation = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/p[1]/strong[1]")).getText();

        //Display message
        System.out.println(OrderConfirmation);

        driver.close();

    }
}
