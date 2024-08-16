package javaprograms;

public class Even_Odd {

	public static void main(String[] args) {

    int num = 24;
 
    
    for (int i = 1; i <= num; i++) {
    	
    	if(i%2 == 0) {
    		System.out.println("Even Number..."+i);
    	}
    	
    	else {
    		System.out.println("Odd Number.."+i);
    	}
    	
    }
    
    if(num%2 == 0) {
    	System.out.println("Even Number");
    }
    else {
    	System.out.println("Odd Number");
    }
    
    
	 
}	
}

