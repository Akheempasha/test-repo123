package array.concept;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Array_SingleD {

	public static void main(String[] args) {
       //Approach-1
 /*    int array[]= new int[4];
     array[0]=50;
     array[1]=10;
     array[2]=20;
     array[3]=30;
     array[4]=40;
  */   
       //Approach-2
     int arr[]= {50,40,10,20,30};
     System.out.println("number of value."+arr.length);
     // read single value from array
     System.out.println("read single value.."+arr[2]);
     
     System.out.println(Arrays.toString(arr));
      //read all the values
       // forloop
     for(int i=0;i<arr.length;i++) {
    	 System.out.println(arr[i]);
     }
       // foreach
     for(int x: arr) {
    	 System.out.println(x);
     }
     
	}

}
