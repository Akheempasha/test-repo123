package javaprograms;

public class NumbersOfDigits {

	public static void main(String[] args) {

    int num = 3424357;
    int count = 0;
    
    while(num > 0) {
    	
    	num =num/10;
    	count++;
    }
    System.out.println(count);
	}

}
