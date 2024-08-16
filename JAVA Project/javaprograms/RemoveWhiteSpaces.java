package javaprograms;

public class RemoveWhiteSpaces {

	public static void main(String[] args) {
		String name = "Mohd  Akheem  Pasha";
		
    	name=name.replaceAll(" ", "");
    	
    	System.out.println("After Removing the white Space.."+name);

	}

}
