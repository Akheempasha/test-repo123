package programs;

public class FibonacciSeries {

	public static void main(Stringss[] args) {
	 
		int n1 = 0, n2 = 1, sum =0;
		    System.out.print(n1+" "+n2);   //0 1
		    
		    for(int i = 2; i<12; i++ ) {
		    	sum = n1+n2;   //0+1
		    	System.out.print(" "+sum);  //1 2 3 5
		    	      n1=n2;  //1
		    	      n2=sum; //1
		    }
		

	}

}
