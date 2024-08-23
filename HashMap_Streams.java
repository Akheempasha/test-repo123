package javaa.streams;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HashMap_Streams {

	public static void main(String[] args) {
		Map<String, Integer> mymap = new HashMap<String, Integer>();
		
		mymap.put("Akheem", 15000);
		mymap.put("Johny", 22000);
		mymap.put("Tony", 35000);
		mymap.put("Mitchel", 21500);
		mymap.put("Starc", 18000);
		
       ArrayList<Object> list = new ArrayList<Object>();
       list.add(mymap);
       
       list.stream()
       .forEach(l->System.out.println(l));
 
	}

}
