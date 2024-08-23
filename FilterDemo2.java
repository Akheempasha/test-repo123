package javaa.streams;

import java.util.ArrayList;
import java.util.Arrays;

public class FilterDemo2 {

	public static void main(String[] args) {

    ArrayList<Object> names = new ArrayList<Object>
                                 (Arrays.asList("AkheemPasha", "Mohammad", null, 'A',null));
    
      names.stream().filter(n-> n != null).forEach(n-> System.out.println(n));
    
  //  names.forEach(n-> System.out.println(n));
    
	}

}
