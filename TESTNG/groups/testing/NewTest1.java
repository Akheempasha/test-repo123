package groups.testing;

import org.testng.annotations.Test;

@Test(groups = {"all"})
public class NewTest1 {
	
	@Test(groups = {"smoke"})
	public void testCase1() {
		System.out.println("Test-1 Passed");
	}

	@Test(groups = {"sanity"})
	public void testCase2() {
		System.out.println("Test-2 Passed");
	}

	@Test(groups = {"re-testing","functional"})
	public void testCase3() {
		System.out.println("Test-3 Passed");
	}

	@Test
	public void testCase4() {
		System.out.println("Test-4 Passed");
	}

}
