package javaprograms;

import java.util.Iterator;

public class Arrays2D {

	public static void main(String[] args) {
     
           int[][]a= {{100,200},
        		      {200,300},
        		      {300,400}};
           
           System.out.println(a.length); //rows
	       System.out.println(a[0].length);//col
	         //read single value
	       System.out.println(a[0][0]+" "+a[0][1]);
	       
	         //read all values
	       for (int r = 0; r < 3; r++) {
			   for (int c = 0; c < 2; c++) {
				 System.out.print(a[r][c]+"\t");
			}
			    System.out.println();
		    }
	       
	       System.out.println("<==============>");
	       
	       for (int[] is : a) {
			for (int is2 : is) {
				System.out.print(is2+"\t");
			}
			    System.out.println();
		}
	       
	
}
}
