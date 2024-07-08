package oops;

public class Constructor_Overloading {
	int a;
	int b;

	public Constructor_Overloading() {
		a = b = 0;
		System.out.println(a + b);
	}

	Constructor_Overloading(int x, int y) {
		a = x;
		b = y;
	}

	Constructor_Overloading(int x, int y, double a) {
		System.out.println(x + y + a);
	}

	public static void main(String[] args) {
		Constructor_Overloading co = new Constructor_Overloading(10,20,10.5);

	}

}
