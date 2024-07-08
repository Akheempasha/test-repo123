package oops;

public class StaticMethos {
	 static int result;
	
	public static void sumOf() {
		int a =10;
		int b =20;
         result  = a+b;
		System.out.println("adition given value is.."+result);
	}
    public void mulOf() {
    	String name1= "Akheem";
    	String name2= "Pasha";
    	result =10;
    
    System.out.println(name1+name2+" "+result);
    
    }

   public static void main(String[] args) {
	sumOf();
	
	StaticMethos sm = new StaticMethos();
	sm.mulOf();
	
}




}
