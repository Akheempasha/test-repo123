package javaa.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Max_Min {

	public static void main(String[] args) {
		
		//Max
		List<Integer> numberList = Arrays.asList(1,2,3,4,5,6,80,90,0);
		
	    Optional<Integer> max = numberList.stream().max((val1,val2)-> 
		                                   {
		                                	  return val1.compareTo(val2);
		                                   });
	
	    System.out.println(max.get());
	    
	    //Min
	    
	    Optional<Integer> min = numberList.stream().min((val1,va2)-> 
	                                       {
	                                    	   return val1.compareTo(va2);
	                                       });
		System.out.println(min.get());
		
		
	}

}
