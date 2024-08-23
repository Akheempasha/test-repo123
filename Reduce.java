package javaa.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Reduce {

	public static void main(String[] args) {
		List<Integer> numberList = Arrays.asList(1, 2, 3, 4, 5, 6, 80, 90, 0);
		List<String> stringList = Arrays.asList("akheem", "aahil", "anwar");
		List<Object> totalList = Arrays.asList("akheem", "aahil", "anwar", 5, 6, 10, 15);

		Optional<Integer> reduce = numberList.stream().reduce((val1, val2) -> 
		                                                {
			                                              return val1 + val2;
		                                                 });

		System.out.println(reduce.get());

		Optional<String> reduceStr = stringList.stream().reduce((val1, val2) ->
		                                                {
			                                              return val1+val2; 
			                                           
		                                                 });

		System.out.println(reduceStr.get());
		
		Optional<Object> reduceTot = totalList.stream().reduce((val1, val2) ->
                                                         {
                                                           return val1; 
                                                          });

        System.out.println(reduceTot.get());
 

	}

}
