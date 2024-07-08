package text.file;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileoutputStream {

	public static void main(String[] args) throws IOException {
		File myfile = new File("./sample.txt");
		if(myfile.delete()){
			myfile.createNewFile();
		}
	
	   FileOutputStream fos = new FileOutputStream(myfile);
	   String s = "Hello World ";
	   for(char ch : s.toCharArray()) {
		   fos.write((int)ch);
	   }
	   
	   
	   //asciiValues
	   fos.write(72);
	   fos.write(101);
	   fos.write(108);
	   fos.write(108);
	   fos.write(111);
	   
	   
	   fos.close();
	     // or
//	   fos.flush();
	
	}

}
