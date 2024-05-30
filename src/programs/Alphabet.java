package programs;

public class Alphabet {

	public static void main(String[] args) {

   for (char i ='a';i<='z';i++) {
       System.out.print(i+" ");
       
   }

    
   System.out.println("Alphabets from (A-Z) are:");
   // ASCII value of A=65 and Z=90
   for (int i = 65; i <= 90; i++) {
	   System.out.print((char)i+" ");
   }
   System.out.println("\nAlphabets from (a-z) are:");
   // ASCII value of a=97 and z=122
   for (int i = 97; i <= 122; i++) {
	   System.out.print((char)i+" ");
   }
   
	}

}
