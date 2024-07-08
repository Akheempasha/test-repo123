package interview.questions;

import java.util.Arrays;

public class ReverseString {

	public static void main(String[] args) {
		 
		String name = "Akheempasha";
		
     int leg=name.length();
     String rev ="";
     
     for(int i=leg-1;i>=0;i--) {
    	rev=rev+name.charAt(i);
     }
         System.out.println(rev);
         
         
        //2.Approach
         String str = "Aahil";
         
         StringBuffer sb = new StringBuffer(str);
         
         
         System.out.println(sb.reverse());
         
         
        //3.Approach
         
        String num[]= {"pasha","Akeem","Akeem","zahil","yalik"};
        
        
        
       System.out.println(num.length);
       
       for(int i=0;i<=num.length;i++) {
    	   System.out.println(num[i]);
    	   Arrays.sort(num);
    	   System.out.println(num[i]);
    	   
       }
         
          
        	 
         }

 
         
         
	}


