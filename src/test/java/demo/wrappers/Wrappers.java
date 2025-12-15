package demo.wrappers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.NumberFormat;
import java.time.Duration;
import org.openqa.selenium.Keys;
import org.testng.Assert;

public class Wrappers {
    /*
     * Write your selenium wrappers here
     */

    ChromeDriver driver;

    public Wrappers(ChromeDriver driver) {
        this.driver = driver;
    }

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    String flipKartURL = "http://www.flipkart.com/";

    // TestCase - 1 (Search for Washing Machine)

    // Navigate to flipKart
    public void navigateToFlipKart() {
        driver.get(this.flipKartURL);
    }

    // Enter Text into search box
    public void enterTextSearchBox(String text) throws InterruptedException {
        WebElement searchBox = driver.findElement(By.xpath("//input[contains(@title,'Search')]"));
        searchBox.sendKeys(Keys.CONTROL + "a");
        searchBox.sendKeys(Keys.DELETE);

        searchBox.sendKeys(text, Keys.ENTER);
        Thread.sleep(3000);

    }

    // Sort by popularity
    public void sortResults() throws InterruptedException {
        List<WebElement> sortR = driver.findElements(By.xpath("//div[@class='s6YJlm']//div"));
        for (WebElement elem : sortR) {
            if (elem.getText().equals("Popularity")) {
                wait.until(ExpectedConditions.elementToBeClickable(elem));
                elem.click();
                Thread.sleep(3000);
                System.out.println(driver.getCurrentUrl());
                break;
            }
        }
    }

    // Count of items with ratings less or equal to 4 stars
    public void ratingsLessOrEqual4() {
        int count = 0;
        List<WebElement> ratings = driver.findElements(By.xpath("//div[@class='a7saXW']//div[@class='MKiFS6']"));
        for (WebElement rating : ratings) {
            if ((Double.parseDouble(rating.getText())) <= 4.0) {
                count = count + 1;
            }
        }
        System.out.println("Count of items which has ratings less than or equal to 4 is = " + count);

    }

    // TestCase - 2 (Search for Washing Machine)

    // Getting the iphone with offers in %

    public void selectingIphone() {
        Boolean found = false;
        List<WebElement> offers = driver.findElements(By.xpath("//div[@class='HQe8jr']//span"));
        for(WebElement offer : offers){
            if((Integer.parseInt(offer.getText().replaceAll("[^0-9]","").trim())) > 17){
               WebElement title = offer.findElement(By.xpath("./ancestor::div[contains(@class,'col ')]/preceding-sibling::*//div[@class='RG5Slk']"));
               System.out.println("Title of product - "+title.getText()+" and discount is - " +offer.getText());
               found = true;
            }
        }
        if(!found){
            System.out.println("There are no iphones with more than 17% off!");
        }
    }

    //  TestCase - 3 (Search for Coffee Mug)

    // Selecting ratings 4 and above
    public void selectRating4() throws InterruptedException{
        WebElement chkBox = driver.findElement(By.xpath("(//div[@class='ybaCDx'])[1]"));
        wait.until(ExpectedConditions.elementToBeClickable(chkBox));
        chkBox.click();
        Thread.sleep(3000);
    }

    // Getting the list of mugs has ratings 4 & above
    public void coffeMugs() throws InterruptedException{
        List<Integer> mugs = new ArrayList<>();
        List<WebElement> listOfMugs = driver.findElements(By.xpath("(//span[@class='PvbNMB'])"));
        for(WebElement list : listOfMugs){
           String l = list.getText().replaceAll("[^0-9]","").trim();
           mugs.add(Integer.parseInt(l));
        }

        // Sorting the list of mugs in descending order
        List<Integer> topFiveMugs = new ArrayList<>();
        Collections.sort(mugs, Collections.reverseOrder());

        // Getting top 5 in list of mugs in descending order
        for(int i=0; i<5; i++){
            topFiveMugs.add(mugs.get(i));
        }

        System.out.println("Top five highest number of reviews = " + topFiveMugs);

        // Printing the Title and Image url of top 5 mugs
        NumberFormat formatter = NumberFormat.getInstance(Locale.US);
        for(Integer getMugs : topFiveMugs){
            String val = formatter.format(getMugs);
            System.out.println("Numner of reviews = " + val);
            WebElement mugTitle = driver.findElement(By.xpath("(//span[contains(text(),'"+ val +"')])/parent::*/preceding-sibling::*[2]"));
            System.out.println("Tiltle of Mug is = " + mugTitle.getText());
            WebElement mugImageUrl = driver.findElement(By.xpath("(//span[contains(text(),'"+ val +"')])/parent::*/preceding-sibling::*//img"));
            System.out.println("Image Url of Mug is = " + mugImageUrl.getAttribute("src"));
        }



        
    }
        
        


}
