package text.file;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Scannerclass {

	public static void main(String[] args) throws IOException {
		File myfile = new File("./sample.txt");
		if(!myfile.exists()){
			myfile.createNewFile();
		}
		
		Scanner sc = new Scanner(myfile);
		
		while(sc.hasNext()) {
			System.out.println(sc.nextLine());
		}
	}

}
