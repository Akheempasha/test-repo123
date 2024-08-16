package javaprograms;

public class ArraySum {

	public static void main(String[] args) {
		 
		int a[]= {15,20,10,25,30};
		  
		int sum = 0;
		System.out.println(a.length);
		
		for (int i = 0; i < a.length; i++) {
		//	System.out.println(a[i]);
			sum=sum+a[i];
			
		  }
		System.out.println("total value.."+sum);
}
}
