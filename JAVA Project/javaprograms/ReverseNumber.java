package javaprograms;

public class ReverseNumber {

	public static void main(String[] args) {
	int num = 543;
	int lastDigit = 0;
	int reverse   = 0;
	
	while(num > 0) {
		
		lastDigit = num%10;                        // 3
		reverse = reverse * 10 + lastDigit;        // 3*10+4 = 34
		num = num/10;                              // 54 
	}
	System.out.println(reverse);
	
	if(reverse == 543) {
		System.out.println("Palindrome");
	}
	else {
		System.out.println("Not Palimdrome");
	}

	}

}
