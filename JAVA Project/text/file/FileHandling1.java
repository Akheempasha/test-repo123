package text.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class FileHandling1 {

	public static void main(String[] args) throws IOException {
		File myfile = new File("./sample.txt");
		if(!myfile.exists()){
			myfile.createNewFile();
		}
		
       FileInputStream fis = new FileInputStream(myfile);
      System.out.println(fis.read());  // its return asciiValue in cosole
       
      System.out.println((char)fis.read());  //returns first alphabet in txt file
       int asciiValue;
       String text = "";
       while((asciiValue=fis.read()) != -1 ) {
    	   text+=String.valueOf((char)asciiValue);
    	   System.out.print((char)asciiValue);
    	   
       }
      
		System.out.println();
		 System.out.println(text);
		
		fis.close();
	
}

}
