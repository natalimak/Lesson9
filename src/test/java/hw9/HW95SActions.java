/*Create a TestNG test with the following:
         Enter https://dgotlieb.github.io/Actions
         Take a screenshot of the box element
         Double click the text “Double-click…” check what happened
        and create assertion on result.
         Make a mouse hover on X image.
         Select two items from food list.
         Upload a file.
         Scroll down to “click me button” try both scroll to element
        and scroll to location.*/

package hw9;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class HW95SActions {
    private static ChromeDriver driver;
    static String URL="https://dgotlieb.github.io/Actions";


    @BeforeClass
    public static void beforeClass() {
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\Administrator\\Documents\\Natali\\לימודים\\QA_Automation\\Tools\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(URL);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }
    @Test (priority = 1) //Take a screenshot of the box element
    public void elementScreenshotTest() {
        takeElementScreenshot(driver.findElement(By.id("drag1")));
    }

    /*Double click the text “Double-click…” check what happened
    and create assertion on result*/

    @Test (priority = 2)
    public void doubleClick(){
        WebElement buttonElement = driver.findElement(By.cssSelector("p[ondblclick='doubleClickFunction()'"));
        Actions myAction = new Actions(driver);
        myAction.doubleClick(buttonElement);
        myAction.perform();
        removeFocus();
    }

    @Test (priority = 3) //Make a mouse hover on X image.
    public void test03_focusOnClose() throws InterruptedException {
        WebElement buttonElement = driver.findElement(By.id("close"));
        Actions myAction = new Actions(driver);
        Thread.sleep(2000);
        myAction.moveToElement(buttonElement);
        myAction.build().perform();
    }

    @Test (priority = 4) //Select two items from food list.
    public void selectItems() throws InterruptedException {
        List<WebElement> mySelection=driver.findElements(By.name("kind"));
        Actions myAction = new Actions(driver);
        Thread.sleep(2000);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
                driver.findElement(By.name("food")));
        myAction.keyDown(Keys.CONTROL).
                click(mySelection.get(0)).
                click(mySelection.get(1)).
                keyUp(Keys.CONTROL);
        myAction.build().perform();
    }

    @Test (priority = 5) //Upload a file.
    public void addFiles() {
        WebElement fileElement = driver.findElement(By.cssSelector("input[type='file'"));
        fileElement.sendKeys("C:\\Users\\Administrator\\Downloads\\ClassPupilsList (1).xlsx");
    }
//Scroll down to “click me button” try both scroll to element
//and scroll to location.
    @Test (priority = 6)
    public void scrollDownAndUpAndDown() throws InterruptedException {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
                driver.findElement(By.id("clickMe"))); //scroll to Element
        Thread.sleep(2000);

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
                driver.findElement(By.id("title"))); //scroll to Element
        Thread.sleep(2000);

        driver.executeScript("window.scrollTo(0, " +
                "document.body.scrollHeight)"); //scroll the till the end of the page
    }

    private static void takeElementScreenshot(WebElement element){
        File screenShotFile = element.getScreenshotAs(OutputType.FILE); // take the screenshot
        try {
            FileUtils.copyFile(screenShotFile, new File("element-screenshot.png")); // save screenshot to disk
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void removeFocus(){
        driver.findElement(By.cssSelector("p[ondblclick='doubleClickFunction()'")).click();
    }
}
