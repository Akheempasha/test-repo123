package javaprograms;

public class Arrays2D_Sum {

	public static void main(String[] args) {
		 
		int[][]a= {{100,200},
  		           {200,300},
  		           {300,600}};
		int sum = 0;
		
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length-1; j++) {
			sum	=sum + a[i][j];
			}
		  }
	     	System.out.println(sum);

	}

}
