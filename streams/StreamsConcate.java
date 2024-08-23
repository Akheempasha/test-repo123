package javaa.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsConcate {

	public static void main(String[] args) {
		 
		List<String> animalList = Arrays.asList("Dog","Cat","Elephant");
		List<String> birdsList = Arrays.asList("peackock","Parrot","crow");
		
		Stream<String> stream1 = animalList.stream();
		Stream<String> stream2 = birdsList.stream();
		
		List<String> finalList = Stream.concat(stream1, stream2).collect(Collectors.toList());
		
		System.out.println(finalList);       //[Dog, Cat, Elephant, peackock, Parrot, crow]
		//or
		for (String s : finalList) {
			System.out.println(s);
		}
		

	}

}
