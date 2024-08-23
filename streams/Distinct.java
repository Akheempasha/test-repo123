package javaa.streams;

import java.util.Arrays;
import java.util.List;

public class Distinct {

	public static void main(String[] args) {
		 // distinct
		List<Object> vehiclesList = Arrays.asList("Inova","scoda","maruti","maruti");
		
		vehiclesList.stream().distinct().forEach(System.out :: println);  // duplication avoid
		
		

	}

}
