package collections;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayList1 {

	public static void main(String[] args) {

	 ArrayList<Object> mylist = new ArrayList<Object>();

	//	List<String> list = new ArrayList();
	//	ArrayList mylist = new ArrayList();
		
		mylist.add("Akheem");
		mylist.add('B');
		mylist.add(100);
		mylist.add(null);
		mylist.add(true);
		mylist.add("Akheem");
		mylist.add(null);
		mylist.add(10.5);
		mylist.add("Akheem");
		
		   //size of ArrayList  
		System.out.println("size of arraylist.."+mylist.size());   //9
		   //Printing ArrayList
		System.out.println("printing data from arraylist.."+mylist);
		 //ans-[Akheem, A, 100, null, true, Akheem, null, 10.5, Akheem]
		   //Remove element from arraylist
		mylist.remove(3);   //index number
		System.out.println("After removing.."+mylist); //[Akheem, A, 100, true, Akheem, null, 10.5, Akheem]
		//Insert element in the arraylist
		mylist.add(1, "Java");
		System.out.println("Afetr adding element.."+mylist); // [Akheem, Java, A, 100, true, Akheem, null, 10.5, Akheem]
		//modify element in the arraylist
		 mylist.set(8, "python");
		 System.out.println("after replacing.."+mylist); //.[Akheem, Java, A, 100, true, Akheem, null, 10.5, python]

		 
		 //Access specific element from arraylist
		 System.out.println("get specific element.."+mylist.get(8));  //python
		 
		 //Reading all the data from arraylist
		      //1.Approach
	/*	 for(int i = 0; i<mylist.size();i++) {
			 System.out.println(mylist.get(i));
		 }
	*/	 
		      //2.Approach
	/*	 for(Object list : mylist) {
			 System.out.println(list);
		 }
		*/
		 
		 //3.Approach-->Iterator
		 
	/*	 Iterator list = mylist.iterator();
		 System.out.println(list.next());  // only print first value
		 
		 while(list.hasNext()) {
			 System.out.println(list.next());
		 }
	*/	
		 //checking arraylist is empty or not
		  System.out.println(mylist.isEmpty());
		 
		 //remove multiple elements in arraylist
		  ArrayList<String> mylist2 = new ArrayList<>();
		  mylist2.add("Akheem");
		  mylist2.add(null);
		  
		  mylist.removeAll(mylist2);
		  System.out.println("After removing multiple elements.."+mylist);
		  //ans-->[Java, A, 100, true, 10.5, python]
		  
		  //remove the all tha elements(using clear method)
		  mylist.clear();
		  System.out.println(mylist.size());  // no elements
		  System.out.println("Is arraylist is empty.."+mylist.isEmpty());
		  
		  
		  
		  
		  
		 
		 
		 
	}

}
