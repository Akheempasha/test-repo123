package javaa.streams;

import java.util.ArrayList;
import java.util.Arrays;

public class FilterDemo3 {

	public static void main(String[] args) {
		
		 ArrayList<String> names = new ArrayList<String>
                      (Arrays.asList("AkheemPasha", "Mohammad", "Mahamad Inaya", "Shaikh Shahin"));
		 
		// System.out.println(names.get(0).length());

		 names.stream().filter(str-> str.length() > 6 && str.length() < 10)
		                                              .forEach(System.out::println);
	}
}
