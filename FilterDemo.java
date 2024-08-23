package javaa.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FilterDemo {

	public static void main(String[] args) {


	    List<Integer> numberlist = new ArrayList<Integer>(Arrays.asList(10,20,30,40,15));
		List<Integer> evenlist = new ArrayList<Integer>();	
		
/*		//without using Streams concept
		for (int  integer : numberlist) {
			if(integer%2 == 0)
			evenlist.add(integer);
		}
       System.out.println(evenlist);
 */      
       //With Streams
       //Approach -1
//     evenlist = numberlist.stream().filter(n-> n%2==0).collect(Collectors.toList());
//     System.out.println(evenlist);
       //Approach -2
       numberlist.stream().filter(n-> n%2==0).forEach(n->System.out.println(n));
       //Approach -3
//     numberlist.stream().filter(n-> n%2==0).forEach(System.out::println);
       
       
	}

}
