package javaprograms;

public class Palindrome {

	public static void main(String[] args) {

		String name = "Akheem";
		String rev = "";

		for (int i = name.length() - 1; i >= 0; i--) {
			//System.out.print(name.charAt(i));

			rev += name.charAt(i);

		}

		if (name.equalsIgnoreCase(rev)) {
			System.out.println(rev + "...It is Palindrome");
		}
		else {
			System.out.println(rev + "... not Palindrome");
		}

	}

}
