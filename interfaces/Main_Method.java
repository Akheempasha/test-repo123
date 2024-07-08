package interfaces;

import java.io.IOException;

public class Main_Method {

	public static void main(String[] args) throws IOException, InterruptedException {
		FunctionalInterfaces3 method = new FunctionalInterfaces3();
		
		method.setup();
		method.homepg();
		method.login();
		method.logout();
	}

}
