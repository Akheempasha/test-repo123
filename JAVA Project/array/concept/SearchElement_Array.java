package array.concept;

public class SearchElement_Array {

	public static void main(String[] args) {
		 //search an element in array(linear search)
		int[] arr= {10,20,58,54,25,12};
		int search_Element = 10;
		boolean status=false;
		
		for(int i=0; i<arr.length;i++) {
		 if(arr[i]==search_Element) {
				status=true;
				System.out.println("Found the element");
				break;
			}
		    }
       if(status==false) {
    	   System.out.println("Not found the element");
       }
	}

}
