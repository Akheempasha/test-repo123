package interview.questions;

import java.util.Arrays;

public class BothArrays_Concate {

	public static void main(String[] args) {
		 
		int first[]= {8,10,15,3,1,7,11,20};
		int second[]= {100,150,200};
		
		int fal =first.length;
		int sec =second.length;
		
		int result[] = new int[fal+sec];
		
		 System.arraycopy(first,0,  result,0, fal);
		 System.arraycopy(second,0,  result,0,sec);
		 
		 System.out.println(Arrays.toString(result) );
		 
		 
		 
	}

}
