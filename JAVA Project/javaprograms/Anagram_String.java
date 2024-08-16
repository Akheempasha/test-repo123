package javaprograms;

import java.util.Arrays;

public class Anagram_String {

	public static void main(String[] args) {
		String name = "selenium";
		String name2= "muineles";
		
		char[] a = name.toCharArray();
		char[] b = name2.toCharArray();
		
		Arrays.sort(a);
		Arrays.sort(b);
		
		if(Arrays.equals(a, b) == true) {
			System.out.println("It is a anagram.."+String.valueOf(a)+"..."+String.valueOf(b));
		}
		else {
			System.out.println("It is not anagram.."+a + b);
		}
	}

}
