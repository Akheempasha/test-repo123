package javaprograms;

public class Array_Jagged {

	public static void main(String[] args) {
		 //Approach -1
//		int [][] jag =   {{1,6,3},
//				          {2,8},
//				          {10,9,55,4}};
		//Approach -2
		int [][] jag = new int[3][];
		
		 jag[0] = new int[] {1,6,3};    
		 jag[1] = new int[2];
		 jag[2] = new int[4];
		
		 //Approach-3
		 
//		  jag[0][0] = 1;
//		  jag[0][1] = 6;
//		  jag[0][2] = 3;
		  
		  jag[1][0] = 2;
		  jag[1][1] = 8;
		  
		  jag[2][0] = 10;
		  jag[2][1] = 9;
		  jag[2][2] = 55;
		  jag[2][3] = 4;
		  
		  System.out.println(jag.length);
		  System.out.println(jag[2].length);
		 
		  
		  for (int i = 0; i < jag.length; i++) {
			for (int j = 0; j < jag[i].length; j++) {
				
				System.out.print( jag[i][j]+" ");
			}
			System.out.println();
		}
		  

	}

}
