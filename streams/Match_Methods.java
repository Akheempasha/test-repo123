package javaa.streams;

import java.util.HashSet;
import java.util.Set;

public class Match_Methods {
	//anyMatch()   all Methods return boolean values
	//allMatch()
	//noneMatch()

	public static void main(String[] args) {

     Set<String> fruites = new HashSet<String>();
     
     fruites.add("One Mango");
     fruites.add("One Apple");
     fruites.add("Two Bananas");
     fruites.add("More grapes");
     //anyMatch()
   boolean result =  fruites.stream().anyMatch(s-> {return s.startsWith("One");});
		System.out.println(result);   //true
		
	//allMatch()
    result =  fruites.stream().allMatch(s-> {return s.startsWith("One");});	
	System.out.println(result);	    //false
		
	//noneMatch()
	result =  fruites.stream().noneMatch(s-> {return s.startsWith("One");});	
	System.out.println(result);	   //false
		
	}

}
