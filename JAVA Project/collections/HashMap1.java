package collections;

import java.util.*;

public class HashMap1 {

	public static void main(String[] args) {

		Map<Integer, String> mymap = new HashMap<>();

		mymap.put(102356, "Id-102,name-Akheem,salary-100");
		mymap.put(102357, "Id-103,name-Akhe,salary-1000");
		mymap.put(102358, "Id-104,name-Akhim,salary-$200");
		mymap.put(506368, "Mahabubabad");
		mymap.put(506369, "Mahabubabad");

		System.out.println(mymap.size());

		// to read all tha values
		System.out.println(mymap);

		// only key values read
		System.out.println(mymap.keySet());

		// only read all value pair
		System.out.println(mymap.values());

		// te read all tha values
		System.out.println(mymap.entrySet());

		// to read specific value
		System.out.println(mymap.get(102356)); // Id-102,name-Akheem,salary-100
		// delete specific Key&value

		mymap.remove(102358);
		System.out.println(mymap);
		// add element

		mymap.put(102359, "Id-105,name-Ahim,salary-$250");
		System.out.println(mymap);

		System.out.println("<------------->");

		mymap.replace(102358, "Id-104,name-Akhim,salary-$2000");
		System.out.println(mymap);

		// particular value or key present or not
		System.out.println(mymap.containsKey(102356)); // true
		System.out.println(mymap.containsValue("Akhim")); // false
		// read all tha keys

		Set<Integer> map = mymap.keySet();
		for (Integer maps : map) {
			System.out.println("number of keys." + maps);
		}

		System.out.println("<----------->");

		/*
		 * //read all the value pair
		 *  Collection<String>mymappp = mymap.values();
		 *   
		 * for(String i : mymappp) {
		 *  System.out.println("number of value pair.."+i);
		 *   }
		 * 
		 * System.out.println("<----------->");
		 * 
		 * // read all keys & values 
		 * for(int all:mymap.keySet()) {
		 * System.out.println(all+"<-->"+mymap.get(all)); }
		 */
		// 3.Iterator
		Iterator<Integer> data = mymap.keySet().iterator();
		Iterator<String> dataa = mymap.values().iterator();
		while (data.hasNext() && dataa.hasNext()) {
			System.out.println("I." + data.next() + "<-->" + dataa.next());
		}

		// remove all the keys & values
		mymap.clear();
		System.out.println(mymap); // []

		System.out.println(mymap.isEmpty()); // true

	}
}
