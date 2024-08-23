package javaa.streams;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Lowest_Highest {

	public static void main(String[] args) {
		 
	List<Integer> list = Arrays.asList(10,2,5,8,10,0,65,84,101,5,8,38,55);
	
	//1.ascending order
    // list.stream().sorted().forEach(System.out :: println);
    //2.descending order
     //list.stream().sorted(Collections.reverseOrder()).forEach(System.out :: println);
       //or Comparator or Collections
   //  list.stream().sorted(Comparator.reverseOrder()).forEach(System.out :: println);
     //3.duplicate value removed
    List<Integer> list1 = list.stream().sorted().distinct().collect(Collectors.toList());
     System.out.println(list1);
     //lowest value
     int lowest = list.stream().sorted().distinct().findFirst().get();
     System.out.println("Lowest Number.. "+lowest);
     
   //Highest value
     int highest = list.stream().sorted(Collections.reverseOrder()).distinct().findFirst().get();
     System.out.println("Highgest  Number : "+highest);
     
     //second lowest value
     int lSPrice = list.stream().sorted().distinct().limit(2).skip(1).findFirst().get();
     System.out.println("Lowest Second Number.. "+lSPrice);
     
   //second Highest value
     int hSPrice = list.stream().sorted(Collections.reverseOrder()).distinct().limit(2).skip(1).findFirst().get();
     System.out.println("Highgest Second Number : "+hSPrice);
     
	}
}
