package array.concept;

public class TwoDimensional_Array {

	public static void main(String[] args) {
		    //Approach-1
	/*	int[] [] a= new int[3][2];
		a[0][0]=10;
		a[0][1]=30;
		a[1][0]=45;
		a[1][1]=55;
		a[2][0]=25;
		a[2][1]=22;
	*/
		        //Approach-2
		int[][] a = {{10,30},{45,55},{25,22}};
		
		System.out.println("number of Rows.."+a.length);
		System.out.println("number of colums.."+a[0].length);
		
		
		System.out.println("Read a single value.."+a[0][1]);
		 //Approach-1 forloop
		for(int r=0; r<a.length;r++) {
			for(int c=0;c<a[0].length;c++) {
				System.out.print(a[r][c]);
			}
		        System.out.println();
		    }

		//Approach-2 foreach
		for (int[] arr : a) {
			for (int is : arr) {
				System.out.print(is+" ");
			}
			System.out.println();
		    }
			
}

}
