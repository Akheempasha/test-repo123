package javaa.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FlatMap_Example1 {

	public static void main(String[] args) {
		 
		List<Integer> list1 = new ArrayList<Integer>(Arrays.asList(1,2,3));
		List<Integer> list2 = Arrays.asList(4,5,6);
		List<Integer> list3 = new ArrayList<>();
		list3.add(7);
		list3.add(8);
		list3.add(9);
		
	//	List<List<Integer>> priceList = Arrays.asList(list1,list2,list3);
		List<List<Integer>> priceList =  new ArrayList<List<Integer>>();
		priceList.add(list1);
		priceList.add(list2);
		priceList.add(list3);
		
	/*	for (List<Integer> list : priceList) {
			 for (Integer list4 : list) {
				System.out.println(list4);
			}
		}
	*/
		
//	List<Integer> totalList = priceList.stream().flatMap(l-> l.stream()).collect(Collectors.toList());
//	System.out.println(totalList);
	
	priceList.stream().flatMap(l-> l.stream())
	                  .forEach(System.out :: println);
		
		
		
		
	}

}
