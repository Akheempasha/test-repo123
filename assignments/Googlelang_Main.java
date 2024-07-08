package assignments;


public class Googlelang_Main {
	 
	

	public static void main(String[] args) throws Exception {
		Googlelang lang = new Googlelang();
		lang.setUp();
		lang.langSelec("हिन्दी");
		lang.langSelec("తెలుగు");
		lang.langSelec("English");
		lang.close();
		

	}

}
