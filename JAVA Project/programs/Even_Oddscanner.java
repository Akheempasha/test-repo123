package programs;

import java.util.Scanner;

public class Even_Oddscanner {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Number");
		int num = sc.nextInt();
		sc.close();
		
		if(num%2==0) {
			System.out.println("Even Number");
		}
		else {
			System.out.println("Odd NUmber");
		}
	}

}
