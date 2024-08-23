package javaa.streams;

import java.util.Arrays;
import java.util.List;

public class Count {

	public static void main(String[] args) {
		 
		List<Integer> numberList = Arrays.asList(1,2,3,4,5,6,80,90,0);
		List<String>  stringList = Arrays.asList("akheem","aahil","anwar");
		List<Object>  totalList = Arrays.asList("akheem","aahil","anwar",5,6,10,15);
		
		long numCount = numberList.stream().count();
		System.out.println(numCount);
		
		long strCount = stringList.stream().count();
		System.out.println(strCount);
		
		long totCount = totalList.stream().count();
		System.out.println(totCount);
	}

}
