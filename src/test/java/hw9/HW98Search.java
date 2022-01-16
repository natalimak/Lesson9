/*Open any browser on "The Marker" website.
         https://www.themarker.com/
         Check how many times the word "news" exists in the page
        source.

        Print the current page (The same as if you pressed file 
        print in your browser).*/


package hw9;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

public class HW98Search {
    private static ChromeDriver driver;
    static String URL = "https://www.themarker.com/";


    @BeforeClass
    public static void beforeClass() {
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\Administrator\\Documents\\Natali\\לימודים\\QA_Automation\\Tools\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(URL);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test //Check how many times the word "news" exists in the page source.

    public void test_01() {
        int size = driver.getPageSource().split("news").length-1;
        System.out.println(size);
    }
    @Test /*Print the current page (The same as if you pressed file 
            print in your browser)*/
    public void test_02() {
        ((JavascriptExecutor)driver).executeScript("window.print()");

    }
}