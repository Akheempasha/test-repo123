package array.concept;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class AscendingOrder {

	public static void main(String[] args) {
		 
		Integer array[]= {10,2,5,8,1,7,3,4,9,6};
		
     	int n = array.length;
		
		Arrays.sort(array,Collections.reverseOrder());
		System.out.println(Arrays.toString(array));
		
		
		  // Ascending order
		for (int i = 0; i < array.length; i++) {
			System. out. println(array[i]);
		
		}
		System.out.println("Smallest number is.."+array[0]);
		
		System.out.println("Second smallest number is.."+array[1]);
		
	}

}
