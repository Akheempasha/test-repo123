package groups.testing;

import org.testng.annotations.Test;

public class NewTest2 {
	

	@Test(groups = {"smoke","sanity"})
	public void testCase5() {
		System.out.println("Test-5 Passed");
	}

	@Test(groups = {"functonal"})
	public void testCase6() {
		System.out.println("Test-6 Passed");
	}

	@Test(groups = {"re-testing"})
	public void testCase7() {
		System.out.println("Test-7 Passed");
	}

	@Test(groups = {"re-gression"})
	public void testCase8() {
		System.out.println("Test-8 Passed");
	}

}
