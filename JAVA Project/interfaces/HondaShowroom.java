package interfaces;

public interface HondaShowroom {
	// variable is compalsary is final & static
	public static final String carModel = "";
	// abstract Method

	public void HondaCity();

	public void HondaAmaze();

	public void HondaElevate();

	public void HondaJazz();

	// default Method (After java 8 version this method is worked)
	default void HondaSuv() {
		System.out.println("");
	}

	// static Method
	static void Hondaaxis() {
		System.out.println("All cars available");

	}

}
