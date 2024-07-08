package interview.questions;

import java.util.Arrays;

public class MIn_Max {

	public static void main(String[] args) {
		 
		int arr[]= {8,10,15,3,1,7,11,20};
		
	int min=Arrays.stream(arr).min().getAsInt();
	System.out.println(min);
	
	
	int max=Arrays.stream(arr).max().getAsInt();
	System.out.println(max);
		
	}

}
