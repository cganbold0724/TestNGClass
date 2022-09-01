package class02;

import org.testng.annotations.Test;

public class dependsOn {
    @Test
    public void login(){
        System.out.println("I have logged in successfully");
     //   System.out.println(0/0);
    }
    @Test(dependsOnMethods = "login")
    public void verificationOfDashBoardPage(){
        System.out.println("I am on dashboard page");

    }
}
