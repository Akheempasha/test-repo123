package javaprograms;

public class Count_Spaces {

	public static void main(String[] args) {

    String name = "Mohd Akheem Pasha";
              
    int[] n = new int [128];
    
    for (int i = 0; i < name.length(); i++) {
    	
    	n[name.charAt(i)]++;
		
	}
    System.out.println("Total spaces in String.."+n[32]);  //32 is blank space for Ascll value
    
	}

}
