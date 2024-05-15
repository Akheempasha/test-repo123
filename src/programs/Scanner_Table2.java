package programs;

import java.util.Scanner;

public class Scanner_Table2 {

	public static void main(String[] args) {
		 
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter table number");
		int t=sc.nextInt();
		System.out.println("Enter table range");
		int range =sc.nextInt();
		sc.close();
		
		int i =1;
		while(i<=range) {
			System.out.println(t+"*"+i+"="+(t*i));
			i++;
		}
		
	}

}
