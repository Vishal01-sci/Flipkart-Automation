package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

import java.beans.Transient;
import java.time.Duration;
import java.util.logging.Level;
//import io.github.bonigarcia.wdm.WebDriverManager;
import demo.wrappers.Wrappers;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;


// import io.github.bonigarcia.wdm.WebDriverManager;
import demo.wrappers.Wrappers;

public class TestCases {
    public static ChromeDriver driver;
    
    //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
    /*
     * TODO: Write your tests here with testng @Test annotation. 
     * Follow `testCase01` `testCase02`... format or what is provided in instructions
     */

    //Search for Washing Machine

    @Test
    public void testCase01() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        System.out.println("Start of Test case - 1");
        Wrappers navigateToFlipKartPage = new Wrappers(driver);
        navigateToFlipKartPage.navigateToFlipKart();

        String currentURL = driver.getCurrentUrl();
        System.out.println(currentURL);
        Boolean status = driver.getCurrentUrl().contains("flipkart");
        Assert.assertTrue(status,"URL doesn't contains flipkart");

        
        Wrappers enterText = new Wrappers(driver);
        String text = "Washing Machine";
        enterText.enterTextSearchBox(text);
        

        Wrappers sortSearchResult = new Wrappers(driver);
        sortSearchResult.sortResults();

        Wrappers countRatings = new Wrappers(driver);
        countRatings.ratingsLessOrEqual4();

        System.out.println("End of Test case - 1");
    }

    @Test
    public void testCase02() throws InterruptedException{
        
        System.out.println("Start of Test case - 2");
        Wrappers navigateToFlipKartPage = new Wrappers(driver);
        navigateToFlipKartPage.navigateToFlipKart();


        Wrappers enterText = new Wrappers(driver);
        String text = "iPhone";
        enterText.enterTextSearchBox(text);

        Wrappers getProducts = new Wrappers(driver);
        getProducts.selectingIphone();

        System.out.println("End of Test case - 2");

    }

    @Test
    public void testCase03() throws InterruptedException{
        System.out.println("Start of Test case - 3");
        Wrappers navigateToFlipKartPage = new Wrappers(driver);
        navigateToFlipKartPage.navigateToFlipKart();

        Wrappers enterText = new Wrappers(driver);
        String text = "Coffee Mug";
        enterText.enterTextSearchBox(text);

        Wrappers selectRatings = new Wrappers(driver);
        selectRatings.selectRating4();

        Wrappers topCoffeeMugs = new Wrappers(driver);
        topCoffeeMugs.coffeMugs();

        System.out.println("End of Test case - 3");

    }
     
    /*
     * Do not change the provided methods unless necessary, they will help in automation and assessment
     */
    @BeforeTest
    public void startBrowser()
    {
        System.setProperty("java.util.logging.config.file", "logging.properties");

        // NOT NEEDED FOR SELENIUM MANAGER
        // WebDriverManager.chromedriver().timeout(30).setup();

        ChromeOptions options = new ChromeOptions();
        LoggingPreferences logs = new LoggingPreferences();

        logs.enable(LogType.BROWSER, Level.ALL);
        logs.enable(LogType.DRIVER, Level.ALL);
        options.setCapability("goog:loggingPrefs", logs);
        options.addArguments("--remote-allow-origins=*");

        System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "build/chromedriver.log"); 

        driver = new ChromeDriver(options);

        driver.manage().window().maximize();
    }

    @AfterTest
    public void endTest()
    {
        driver.close();
        driver.quit();

    }
}