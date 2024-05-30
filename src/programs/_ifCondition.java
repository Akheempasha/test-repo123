package programs;

import java.util.Scanner;

public class _ifCondition {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Student Marks");
		int marks = sc.nextInt();
		sc.close();
		
		if(marks < 30) {
			System.out.println(" Failed");
			
		}
		else if(marks < 35) {
			System.out.println("Border passed");
		}
		else if (marks < 65) {
			System.out.println("passed a1");
		}
		else if (marks < 90) {
			System.out.println("1st Rank Passed");
		}
		else {
			System.out.println("no xeam ");
		}
	}
	

}
