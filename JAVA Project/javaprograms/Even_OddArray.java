package javaprograms;

public class Even_OddArray {

	public static void main(String[] args) {

    int a[]= {1,2,10,4,11,17};
    
    for (int i = 0; i < a.length; i++) {
		
    	if(a[i]%2==0) {
    		System.out.println("even............"+a[i]);
    	}
    	else if(a[i]%2 != 0) {
    		System.out.println("odd....."+a[i]);
    	}
    	else {
    		System.out.println("invalid number");
    	}
	}

	}

}
