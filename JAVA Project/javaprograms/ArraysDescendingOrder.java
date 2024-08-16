package javaprograms;

import java.util.Arrays;
import java.util.Collections;

public class ArraysDescendingOrder {

	public static void main(String[] args) {
		Integer a[]= {15,20,10,25,30};
		  
	 
		System.out.println(a.length);
		
		System.out.println("index size-1.."+a[2]);
		
		Arrays.sort(a,Collections.reverseOrder());
		
		 System.out.println(Arrays.toString(a));

	}

}
