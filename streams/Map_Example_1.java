package javaa.streams;

import java.util.Arrays;
import java.util.List;

public class Map_Example_1 {

	public static void main(String[] args) {
		 
	  List<String> names = Arrays.asList("Akheem","Mohammad","Inaaya","Mohammad Aahil");
	  
	/* for (String n : names) {
		  System.out.println(n.length());
	   }*/
	  
	//	names.stream().map(n-> n.length()).forEach(System.out::println);
		names.stream().map(n-> n.toUpperCase()).forEach(System.out::println);
		
	//	names.forEach(n->System.out.println(n));
		
	}
}
