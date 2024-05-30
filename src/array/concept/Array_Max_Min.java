package array.concept;

public class Array_Max_Min {

	public static void main(String[] args) {
		int[] arr= {90,80,60,70,50};
		
		int max = arr[0];
		for(int i =0;i<arr.length;i++) {
			if(arr[i]>max)
				max=arr[i];
		}
		System.out.println("Largest value.."+max);
		 

	}

}
