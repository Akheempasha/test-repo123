package interview.questions;

public class ReverseNumber {

	public static void main(String[] args) {


		int num = 123456789;
		
		//int to String convert into 2 ways
		String s = Integer.toString(num);
	//	String.valueOf(num);
		
		StringBuffer sb = new StringBuffer(s);
		System.out.println("reverse number.."+sb.reverse());
		
		
		//2.Approach
		
		StringBuilder sbb = new StringBuilder(num);
		sbb.append(num);
		System.out.println(sbb.reverse());

	}

}
