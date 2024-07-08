package programs;

public class String_Reverse {

	public static void main(String[] args) {
	  // Approach-1
		String s="Welcome";
		for(int i=s.length()-1;i>=0;i--) {
			System.out.println(s.charAt(i));
		}
	        
		
		System.out.println("<------------->");
		//Approach-2
		String a = "Selenium";
		
		char[]arr=a.toCharArray();
		for(int i=arr.length-1;i>=0;i--) {
			System.out.print(arr[i]);
		}
	         System.out.println();
	
	  //Approach-3 StirngBufferClass
	         StringBuffer rev = new StringBuffer("Akheempasha");
	         System.out.println("Reverse String is.."+rev.reverse());
	         
	         StringBuilder r = new StringBuilder("Akheempasha");
	         System.out.println("Reverse String is.."+r.reverse());
	
	
	
	
	
	}

}
