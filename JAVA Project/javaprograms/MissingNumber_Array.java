package javaprograms;

public class MissingNumber_Array {

	public static void main(String[] args) {


		int arr[] = {22,25,28,23,26,29,27};
		
		int sum = 0;
		
		for (int i = 0; i < arr.length; i++) {
			
			sum = sum+arr[i];
		}
		
		System.out.println("Sum of elements in array.."+sum);
		
		int sum2 = 0;
		
		for (int i = 22; i <= 29; i++) {
			
			sum2 +=i;
			
		}
		System.out.println("Sum of range of elements in array.."+sum2);
		
		System.out.println("Missing number is..."+(sum2-sum));
	}

}
