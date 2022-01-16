/*
Create a test that assert** Website URL
        ** Prepare strings variable containing the title and URL before
*/

package hw9;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class HW92AssertURL {
    private static ChromeDriver driver;
   static String URL="https://dgotlieb.github.io/WebCalculator/";


    @BeforeClass
    public static void beforeClass() {
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\Administrator\\Documents\\Natali\\לימודים\\QA_Automation\\Tools\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(URL);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public static void test_01(){
        String strUrl = driver.getCurrentUrl();
        String url = URL;
        if (Objects.equals(strUrl, url)){
           System.out.println("URL matching");
        }
       else
           System.out.println("URL does''t matching");
    }
}

