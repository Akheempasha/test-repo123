package javaa.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class FindAny_findFirst {

	public static void main(String[] args) {
		List<String> stringList = Arrays.asList("one","two","three","four");
		//findAny()
		Optional<String> ele = stringList.stream().findAny();
		System.out.println(ele.get());
		//findFirst()
		Optional<String> ele1 = stringList.stream().limit(2).skip(1).findFirst();
		System.out.println(ele1.get());
	}

}
