package interview.questions;

import java.util.HashSet;
import java.util.Set;

public class DuplicateElement {

	public static void main(String[] args) {
		
		Set<String> testData = new HashSet<String>();
		testData.add("Akheem");
		testData.add("Pasha");
		testData.add("Akheem");
		
		System.out.println(testData);
		
		//Approach-2
		
		String[] dup= {"pasha","akheem","akheem"};
		
		System.out.println(dup.length);
		
		for(int i=0;i<dup.length;i++) {
			//System.out.print(dup[i]+" ");
			for(int j=i+1;j<dup.length;j++) {
				if(dup[i] == dup[j]) {
					System.out.println("found duplicate element.."+dup[i]);
				}
			}
		}

	}

}
