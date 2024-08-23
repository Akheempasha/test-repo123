package javaa.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FlatMap_Example2 {

	public static void main(String[] args) {

	Set<String> name = new HashSet<>();
	name.add("Akheem");
    name.add("Mohamad");
    name.add("Anwar");
    Set<String>  name1 = new HashSet<>();
    name1.add("Pasha");
    name1.add("Aahil");
    
    Collection<Set<String>> nameList = new HashSet<Set<String>>();
    nameList.add(name);
    nameList.add(name1);
		
  //  nameList.stream().flatMap(n-> n.stream()).forEach(System.out :: println);
    
    nameList.stream().flatMap(n-> n.stream()).filter(s-> s.length() > 6)
                     .forEach(System.out :: println);
		
		
	}

}
