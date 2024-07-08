package testng.frameworkk;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Dependency_Method {
	
	@Test(priority = 0,dependsOnMethods = {"userLogin"})
		public void userReg() {
		System.out.println("Successful user registration");	
		Assert.assertEquals("Akheem", "Akheem");
		
		}
    @Test (priority = 1)
    public void userLogin() {
    	System.out.println("Successful user Login");
        Assert.assertEquals("akheem", "akhsbamb");
    }


}



