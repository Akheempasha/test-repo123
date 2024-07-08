package text.file;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

public class Filewriters {

	public static void main(String[] args) throws IOException {
		File myfile = new File("./sample.txt");
		if(myfile.delete()){
			myfile.createNewFile();
		}
	
	    FileWriter fw = new FileWriter(myfile);
	    String s = "Hello World Iam Akheem";
	    fw.write(s);
	    
	    fw.flush();
	    fw.close();

	}

}
