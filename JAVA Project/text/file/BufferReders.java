package text.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class BufferReders {
	
	public static void main(String[] args) throws IOException {
		
		File myfile = new File("./sample.txt");
		if(!myfile.exists()){
			myfile.createNewFile();
		}
		FileReader fr = new FileReader(myfile); 
		
	   BufferedReader br = new BufferedReader(fr);
	   String line = new String();
	  String text = new String();
	 
	 while((text=br.readLine()) != null) {
		 
		 line += text +"\n";
	 }
	 
	 System.out.println(line);
		
		
	}

}
