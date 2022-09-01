package class01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class testNGannotations {
    //writing down my first test case
    @Test //test annotation is used to indicate that this is a test case
    public void firstTestCase(){

        System.out.println("Hey i am first test case");
    }
    //writing down another test case
    @Test
    public void secondTestCase(){

        System.out.println("Hey i am second test case");
    }
    @Test
    public void thirdTestCase(){

        System.out.println("Hey i am third test case");
    }
    @BeforeMethod
    public void beforeMethod(){
        System.out.println("Hey i am a before method");
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("Hey i am a after method");
    }

}
