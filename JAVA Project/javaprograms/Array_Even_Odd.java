package javaprograms;

public class Array_Even_Odd {

	public static void main(String[] args) {

    int [] arry = {10,38,45,5,85,62}; 
    
    int evensum = 0;
    int oddsum  = 0;
    int count   = 0;
    for (int i = 0; i < arry.length; i++) {
		   
    	  if(arry[i]%2 == 0) {
    		  count++;
    		  System.out.println("Even >>"+arry[i]);
    		  
    		    evensum += arry[i];
    	  }
    	  else {
    		  System.out.println("Odd >>"+arry[i]);
    		  oddsum += arry[i];
    	  }
	}
    
    System.out.println("even Number total : "+evensum);
    System.out.println("even Numbers : "+count);
    System.out.println("Odd Number total : "+oddsum);

	}

}
