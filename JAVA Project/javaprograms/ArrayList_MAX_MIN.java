package javaprograms;

import java.util.ArrayList;
import java.util.Collections;

public class ArrayList_MAX_MIN {

	public static void main(String[] args) {

   ArrayList<Double> array = new ArrayList<Double>();
     array.add(10.25);
     array.add(85.25);
     array.add(1.5);
     array.add(155.05);
     array.add(9.21);
     array.add(850.65);
     array.add(1582.22);
     array.add(54545.25);
     array.add(258.500);
     array.add(101.35);
     array.add(385.22);
     
     System.out.println(array.size());
     
     double min = Collections.min(array);
     double max = Collections.max(array);
     System.out.println(min);
     System.out.println(max);
     
   
   
   
	}

}
