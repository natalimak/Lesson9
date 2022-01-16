/*      Open https://dgotlieb.github.io/Controllers/
         Select “Cheese option” in radio buttons.
         Select one of the options from the drop down below.
         Print all elements in drop down.*/

package hw9;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class HW96Controllers {
    private static ChromeDriver driver;
    static String URL="https://dgotlieb.github.io/Controllers/";


    @BeforeClass
    public static void beforeClass() {
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\Administrator\\Documents\\Natali\\לימודים\\QA_Automation\\Tools\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(URL);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test(priority = 1)
    public void radioButton() {
        WebElement buttonElement = driver.findElement(By.cssSelector("input[value='Cheese'"));
        buttonElement.click();
        }
    @Test(priority = 2)
    public void dropDown() {
        Select dropdownmenu = new Select(driver.findElement(By.cssSelector("select[name='dropdownmenu'")));
        dropdownmenu.selectByVisibleText("Milk");
    }
    @Test(priority = 3)
    public void printDropDownList() {
        WebElement ddMenu = driver.findElement(By.cssSelector("select[name='dropdownmenu'"));
        System.out.println("DropDown list: " + ddMenu.getText());
    }

}