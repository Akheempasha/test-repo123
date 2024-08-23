package javaa.streams;

import java.util.Arrays;
import java.util.List;

public class ToArray {

	public static void main(String[] args) {
		List<Integer> numberList = Arrays.asList(1, 2, 3, 4, 5, 6, 80, 90, 0);
		List<String> stringList = Arrays.asList("akheem", "aahil", "anwar");
		
		List<Object> totalList = Arrays.asList("akheem", "aahil", "anwar", 5, 6, 10, 15);
		System.out.println(totalList);
		
		
		Object arr[] = totalList.stream().toArray();
             System.out.println(arr.length);
             for (Object o : arr) {
				System.out.print(o+" ");
			}
	}

}
