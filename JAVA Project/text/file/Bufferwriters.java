package text.file;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Bufferwriters {

	public static void main(String[] args) throws IOException {
		File myfile = new File("./sample.txt");
		if(myfile.delete()){
			myfile.createNewFile();
		}
		
		BufferedWriter bw = new BufferedWriter(new FileWriter(myfile));
		String a = "Akheem pasha";
		bw.write(a);
		String b = "Aahil";
		bw.write(b);
		
		bw.flush();
		bw.close();
	}

}
