package javaprograms;

public class Fibanoci_Series {

	public static void main(String[] args) {

    int a=0;
    int b=1;
    int sum;
    
    System.out.print(a+" "+b);    // 0 1
    
    for (int i = 2; i <=10; i++) {
    	
    	sum = a+b;
    	System.out.print(" "+sum); // 1 2 
    	
    	a=b;     // 1
    	b=sum;   // 1
    	 
	}
    
    
	}

}
