package class02;

import org.testng.annotations.Test;

public class priority {
    @Test(priority = 4)
    public void FirstTest(){
        System.out.println("Hello 1");
    }
    @Test(priority = 1)
    public void SecondTest(){
        System.out.println("Hello 2");
    }
    @Test(priority =3)
    public void ThirdTest(){
        System.out.println("Hello 3");
    }
    @Test(priority = 2)
    public void FourthTest(){
        System.out.println("Hello 4");
    }

}
