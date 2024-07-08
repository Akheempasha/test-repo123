package oops;

public class Method_Overloading {
	int f;
	int g;
	
	
	
	void add1() {
		System.out.println(f+g);
	}
	void add1(int a , int b) {
		System.out.println(a+b);
	}
	
	void add1(int a , char grade) {
		System.out.println(a);
		System.out.println(grade);
		
		
	}
	
	void add1(char grade , int a) {
		System.out.println(grade+a);
	}
	
	void add1(int x, int y, int z) {
		System.out.println(x+y+z);
	}
	
	
	
	

	public static void main(String[] args) {
		Method_Overloading mo =new Method_Overloading();
		mo.add1();
		mo.add1(10, 20);
		mo.add1(25, 'A');
		mo.add1(5, 11, 10);
		mo.add1('d', 50);
		

	}

}
