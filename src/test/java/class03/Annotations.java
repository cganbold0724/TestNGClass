package class03;

import org.testng.annotations.*;

public class Annotations {
    @BeforeSuite
    public void beforesuit(){
        System.out.println("I am before suit");
    }
    @AfterSuite
    public void aftersuit(){
        System.out.println("I am after suit");
    }
    @BeforeTest
    public void beforeTest(){
        System.out.println("I am before Test");
    }
    @BeforeClass
    public void beforeClass(){
        System.out.println("I am before class");
    }
    @Test
    public void Atest(){
        System.out.println("I am Atest");
    }
    @AfterClass
    public void afterClass(){
        System.out.println("I am after class");
    }
    @AfterTest
    public void afterTest(){
        System.out.println("I am after Test");
    }
}
