package javaprograms;

import java.util.ArrayList;
import java.util.Collections;

public class Array_To_ArrayList {

	public static void main(String[] args) {

    int [] a = {85,22,2,34,17,5};
    
    ArrayList<Integer> list = new ArrayList<Integer>();
    
 /*   for (int arr : a) {
    	list.add(arr);
    	
      }
*/    
    for (int i = 0; i < a.length; i++) {
    	   list.add(a[i]);
	  }
    
    // Collections.reverse(list);     // reverse order
    
    // Collections.sort(list);        // sorting order
    
    Collections.sort(list, Collections.reverseOrder());       // descending order
    
    System.out.println( list);
    
	}

}
