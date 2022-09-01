package class03;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class dataProviders {

    //    Test Scenario:
//    navigate to syntax HRMS
//    login into the webiste using the following credentials and check for correct errors
//    a.username ="Admin"  , password="12345"  ---> Error Message ="Invalid credentials"
//    b.username= "ABCD"   , password ="Hum@nhrm123" -->Error Message ="Invalid credentials"
//    c.username= ""   ,   password ="Hum@nhrm123"   -->Error Message ="Username cannot be empty"
//    d.username= "Admin" ,password= ""  -->Error Message= "Password cannot be empty"
    WebDriver driver;
    @BeforeMethod
    public  void OpenBrowser(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

    }
    @DataProvider(name="Credentials")
    public Object[][] data() {
        Object [][] login={
                { "Admin","12345","Invalid credentials"},
                {"ABCD","Hum@nhrm123","Invalid credentials"},
                {"Admin","","Password cannot be empty"},
                {"","Hum@nhrm123","Username cannot be empty"}};
        return login;
    }

    @Test(dataProvider = "Credentials")
    public void loginWithVariousCredentials(String usrname , String password ,String expectedError) throws InterruptedException {
        WebElement username = driver.findElement(By.xpath("//input[@id='txtUsername']"));
        username.sendKeys(usrname);
        WebElement pswrd = driver.findElement(By.xpath("//input[@id='txtPassword']"));
        pswrd.sendKeys(password);
        WebElement loginBtn = driver.findElement(By.xpath("//input[@id='btnLogin']"));
        loginBtn.click();
        Thread.sleep(2000);
        WebElement errorMsg = driver.findElement(By.xpath("//span[@id='spanMessage']"));
        String actualError = errorMsg.getText();
        SoftAssert soft =new SoftAssert();
        soft.assertEquals(actualError,expectedError);
        soft.assertAll();

    }

    @AfterMethod(alwaysRun = true)
    public  void  CloseBrowser(){
        driver.quit();
    }
}
