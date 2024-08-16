package javaprograms;

public class Inc_DecQuestions {

	public static void main(String[] args) {
		int x = 5;   
		x= x++;
		x = x++ + ++x;
		System.out.println(x);
		
         //Approach -2
		int i = 0;
		i = i++ - --i + ++i - i--;
		System.out.println(i);
		  //Approach -3
		int a = 19, b = 30, c = 40; // a = 18, b = 29, c = 39

		int m = a-- - b-- - c--; // m = 19-30-40

		System.out.println("a=" + a);
		System.out.println("b=" + b);
		System.out.println("c=" + c);
		System.out.println(m);
	}
}
