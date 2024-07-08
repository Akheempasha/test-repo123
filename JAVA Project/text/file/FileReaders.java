package text.file;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileReaders {

	public static void main(String[] args) throws IOException {
		File myfile = new File("./sample.txt");
		if(!myfile.exists()){
			myfile.createNewFile();
		}
		
		FileReader fr = new FileReader(myfile);
		System.out.println(fr.read());
		
		int asciiValue;
		
		while((asciiValue=fr.read()) != -1) {
			
			System.out.print((char)asciiValue);
		}
            System.out.println();
	}

}
