package javaprograms;

import java.util.Arrays;

public class Merge_2_Arrays {

	public static void main(String[] args) {

		int a[] = { 150, 85, 98, 5 };
		int b[] = { 2, 380, 650, 22, 50 };
		int count = 0;

		int c[] = new int[a.length + b.length];

		for (int i = 0; i < a.length; i++) {

		    c[count++] = a[i];
			 
		}
		for (int i = 0; i < b.length; i++) {

			c[count++] = b[i];
			 
		}

	   System.out.println(Arrays.toString(c));
	}

}
