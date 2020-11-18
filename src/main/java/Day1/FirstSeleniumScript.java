package Day1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class FirstSeleniumScript {

    public static void main(String[] args) {

        WebDriver driver;

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\mdube\\Documents\\Selenium-Training\\Resources\\chromedriver.exe");

        //Create a new instance of the Chrome driver
        driver = new ChromeDriver();

        String URL = "http://automationpractice.com";
        driver.get(URL);

        //Maximize chrome browser
        driver.manage().window().maximize();

        //Storing title name in the String variable
        String title = driver.getTitle();

        //Printing Title in console
        System.out.println("Title of the page is: " + title);

        //Storing URL in String variable
        String actualURL = driver.getCurrentUrl();

        //Verify that the urls match by printing a message
        if(actualURL.contains(URL)){

            System.out.println("Pass");

        }else {

            System.out.println("Fail");

            //Print the actual and expected URL for record purposes
            System.out.println("Actual URL is: " + actualURL);
            System.out.println("Expected URL is: " + URL);
        }

        driver.close();

    }
}
