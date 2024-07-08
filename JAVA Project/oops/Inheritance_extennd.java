package oops;
   

  class A{
	  int a=100;
	  void display() {
		  System.out.println(a);
	  }
	  }
  class B extends A{
	  
	  void show() {
	  int b=200;
	System.out.println(b); 
  }  
  }
 class C extends B{
	  
	  void show(int b) {
	System.out.println(b); 
  }  
  }


public class Inheritance_extennd {

	public static void main(String[] args) {
		 C bobj = new C();
		 bobj.display();
		 bobj.show();
		 bobj.show(25);
		 

	}

}
