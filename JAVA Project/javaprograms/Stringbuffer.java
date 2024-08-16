package javaprograms;

public class Stringbuffer {

	public static void main(String[] args) {
		int a = 868584;
		
		//convert to int to String
		
		StringBuffer stb = new StringBuffer(String.valueOf(a));
		System.out.println(stb.reverse());
	}

}
