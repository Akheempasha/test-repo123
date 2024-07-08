package collections;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class HashSet1 {

	public static void main(String[] args) {
		
		//Duplicate values not allowed
		//multiple nulls not allowed but single null allowed
		//insertion order not allowed
		
		
		  //Declaration
	//	HashSet myset = new HashSet();
	//	HashSet<String> myset = new HashSet<String>();
	//	HashSet<String> myset = new HashSet<>();
		Set<Object> myset = new HashSet<>();
		
		myset.add(25);
		myset.add("akheem");
		myset.add(10.5);
		myset.add(25);
		myset.add(null);
		myset.add(true);
		myset.add(null);
		
		System.out.println(myset.size());  //5
		
		System.out.println(myset);   // [null, akheem, 10.5, 25, true]
		
		//Insert element not possible 
		//Access(get) specific element not possible
		        //alternative Approach
		  // convert HashSet to ArrayList
		List mylist = new ArrayList(myset);
		System.out.println(mylist);
		System.out.println(mylist.get(1));  // akheem
		
		myset.remove(null);
		System.out.println(myset);
		
	  // read all HashSet data
		  Iterator<Object> list= myset.iterator();
		  
		  while(list.hasNext()) {
			  System.out.println(list.next());
		  }
		
		myset.clear();
		System.out.println(myset);   // clear all o/p--> []
		
		System.out.println(myset.isEmpty());  //true
		
		
	}

}
