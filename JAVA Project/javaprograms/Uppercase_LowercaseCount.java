package javaprograms;

public class Uppercase_LowercaseCount {


	public static void main(String[] args) {
       
		String name = "Akheem";
		int smallCount = 0;
		int bigCount   = 0;
		
		for (int i = 0; i < name.length(); i++) {
			 
			char ch = name.charAt(i);
			
			if(ch >= 65 && ch < 90) {
				bigCount++;
			}
			else {
				smallCount++;
			}
			
		}
		System.out.println("Number of Small letters.."+smallCount);
		System.out.println("Number of Big letters.."+bigCount);


	}

}
