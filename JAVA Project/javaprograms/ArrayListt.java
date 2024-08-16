package javaprograms;

 

public class ArrayListt {

	public static void main(String[] args) {
		 String name ="Akheem Pasha";
		 
		 int upper = 0;
		 int lower = 0;
		 
		 for(int i=0;i<name.length();i++) {
			 
			 char ch = name.charAt(i);
			  //ASCII values A=65 to Z =90
			 if(ch>=65 && ch<=90 ) {
				 upper++;
			 }
			 else {
				 lower++;
			 }
			 
		 }
		 System.out.println("upper.."+upper);
		 System.out.println("lower.."+lower);
}
}
