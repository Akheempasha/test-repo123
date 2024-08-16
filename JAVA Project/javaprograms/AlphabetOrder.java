package javaprograms;


public class AlphabetOrder {

	public static void main(String[] args) {
		 
		String name = "akheem pasha";
		
		for(char x = 'a'; x <= 'z';x++) {
			for (int i = 0; i < name.length(); i++) {
				 
                char alp= name.charAt(i);	
                
                if(alp == x) {
    	        System.out.print(alp);
                }						
			}
		}
	}

}
