package assignments;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

public class PropPractice {

	public static void main(String[] args) throws IOException {
		 
		File file = new File("./Prop\\test.properties");
	//	System.out.println(file.exists());
		
		Properties prop = new Properties();
	/*	
		prop.setProperty("url", "google.co.in");
		prop.setProperty("username", "Akheem");
		prop.setProperty("password", "dsd123");
		
		FileOutputStream fos = new FileOutputStream(file);
		prop.store(fos, null);
*/
		FileInputStream  fis = new FileInputStream(file);
	 	prop.load(fis);
	 	prop.values();
		System.out.println(prop.keySet());
		System.out.println(prop.values());
		System.out.println(prop.getProperty("url"));
		
	    for(Object keys : prop.keySet()) {
	    	System.out.println(keys+"<-->"+prop.get(keys));
	    	
	    }
		

		
		

	}

}
