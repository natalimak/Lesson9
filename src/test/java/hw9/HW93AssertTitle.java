/*In one of the browsers do the following:
         Create a String variable with the website’s title
         Refresh website
        Get website title and use assertion to test if website’s name is equal to
        the String variable you created in clause 1.*/

package hw9;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class HW93AssertTitle {
    private static ChromeDriver driver;
    static String URL="https://dgotlieb.github.io/WebCalculator/";
    final String title="Calculator";


    @BeforeClass
    public static void beforeClass() {
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\Administrator\\Documents\\Natali\\לימודים\\QA_Automation\\Tools\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(URL);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void test_01(){
        driver.navigate().refresh();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        String strTitle = driver.getTitle();
        if (Objects.equals(strTitle, this.title)){
            System.out.println("Title matching");
        }
        else
            System.out.println("URL does''t matching");
    }
}
