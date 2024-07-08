package oops;

public class OverRiding {
	int x;
	 
	public void m1() {
		 x=100;
		System.out.println(x);
		 
	}
  public void m2(int a) {
	  System.out.println(a);
  }
}

  class over2 extends OverRiding{
	 int y;
	  public void m1() {
		  y=50;
		   super.m1();
		//  System.out.println(y);
		  }
	  
	  public void m3(int a, int b) {
		  
		  System.err.println(a+b);
		  
		  
	  }
	  
	  
	  
	  
 }