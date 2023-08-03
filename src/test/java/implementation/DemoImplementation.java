package implementation;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import java.net.MalformedURLException;
import java.time.Duration;
import java.util.List;

/*
* First Step was to search for selenium and get all the results
* implicit wait to wait for the element to load
* Then the link to be searched is stored in a String url
* linkList- where all the elements with tag a going to be stored there
* infinite loop is applied so that until the link is found it should run
* int count is for when it went through all the links of the list count is also increasing when count is equal to the size of the list
* it should click on the next button
* int k is to show that everyTime when it is moving on the next page linkList is storing the links of new page
* Labeled loop is used because on breaking it is exiting from for loop to break it from while loop labeled loop is used
* and to store new links everytime it is moving on new page I have ended the for loop
*/
public class DemoImplementation {
    static WebDriver driver=new ChromeDriver();
    static JavascriptExecutor executor=(JavascriptExecutor) driver;

    public static void openAndSearch() {
        driver.getWindowHandle();
        driver.get("https://www.google.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }


    public static void searchForSelenium() {
        Actions action=new Actions(driver);
        action.moveToElement(driver.findElement(By.id("APjFqb"))).click().sendKeys("Selenium"+Keys.ENTER).build().perform();
    }

    public static void listOfLinks() throws InterruptedException, MalformedURLException {
        int count=1;
        int finalCount=1;
        int k=1;
        String url="https://saucelabs.com/resources/blog/getting-started-with-selenium";
        finalLoop:
        while (true) {
            List<WebElement> linksList = driver.findElements(By.tagName("a"));
            System.out.println("List size  = "+linksList.size());
            forLoop:
            for (WebElement link : linksList) {
                System.out.println(link.getText() + " - " + link.getAttribute("href"));
                String stringUrl=link.getAttribute("href");
                System.out.println(stringUrl);
                if(stringUrl == null){
                    continue;
                }
                else if (stringUrl.equals(url)) {
                    System.out.println("Final Count = "+finalCount);
                    executor.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//span[text()='Sauce Labs']")));
                    Thread.sleep(2000);
                   // driver.quit();
                    break finalLoop;
                }
                else {
                    count++;
                }

                if (count == linksList.size()) {
                    executor.executeScript("window.scrollTo(0,document.body.scrollHeight)");
                    driver.findElement(By.xpath("//span[text()='Next']")).click();
                    finalCount++;
                    count = 0;
                    System.out.println("-----------------------------------------------------------------------");
                    k++;
                    break forLoop;
                }
            }
        }
    }

}
