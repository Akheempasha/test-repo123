package programs;

public class Int_String {

	public static void main(String[] args) {
		int a = 100;
		int b = 100;
		System.out.println(a+b);
		  //Approach-1
		String str1 =Integer.toString(a);
		String str2 =Integer.toString(b);
		 //Approach-2
		String str3 =String.valueOf(a);
		String str4 =String.valueOf(b);
		
		System.out.println(str3+str4);
		
		 

	}

}
