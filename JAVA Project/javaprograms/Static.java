package javaprograms;

public class Static {
	static int a=100;
	  int b;
	  
	  Static(){   //constructor 2 types 1.default constructor 2.parameterized constructor
		  int c=100;
		  int b =200;
		  if(c<b || c>b) {
			  System.out.println("b is bigger value");
		  }
		  else {
			  System.out.println("C is small value");
		  }
	  }
	  
	final  public static void m1(int a) {
		
		  System.out.println("this is static method.."+a);
		  
	  }
	  
	   final public void m2() {
		  b=15;
		  System.out.println("non-static method.."+b);
		  
	  }
	   final public void m3() {
		  m1(10);
		  m2();
	  }

	static public  void main(String[] args) {
		/*
		   System.out.println(a);
		    m1(10);
		    Static sc = new Static();
		    sc.m2();
		  System.out.println(sc.b);
		  
		  SelStatic.math();
		  
		  SelStatic sl = new SelStatic();
		  sl.index();
		*/
		 
		 Static sc = new Static();
		 sc.m3();
		  
	}

}
