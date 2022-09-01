package class02;

import org.testng.annotations.Test;

public class enableDisable {

    @Test(enabled = false)
    public void FirstTest(){
        System.out.println("Hello 1");
    }
    @Test
    public void SecondTest(){

        System.out.println("Hello 2");

    }
    @Test(groups = "smoke")
    public void ThirdTest(){

        System.out.println("Hello 3");


    }

}
