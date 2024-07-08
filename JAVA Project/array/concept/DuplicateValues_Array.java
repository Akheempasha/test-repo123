package array.concept;

public class DuplicateValues_Array {

	public static void main(String[] args) {
		 
		int[] a= {100,200,300,100,400,100,100};
		int num = 100;
		int count=0;
		
		for(int i =0; i<a.length;i++) {
			if(a[i]==num) {
				count++;
			//	System.out.println(count);  // 1 2 3 4
			}
		    }
             System.out.println(count);  // 4
	}

}
