package javaprograms;

public class FinalkeyWord {
	static  int a ;
	static String ver = "My name is Akheem";
//	private static int ch=10;
	
	public static  void names() {
		a =10;
	}
    public static void names(int c, int b) {
   
        a=c*b;
    }
    void names(double x,int c) {
    	System.out.println(x+c);
    	
    }
    void names(String ver,double y,int b) {
    	//this.ver=ver;
    	System.out.println(this.ver=ver+" "+y+" "+b);
    }
    
    public static void main(String[] args) {
    	
    	System.out.println(args.length);
		names();
		names(18, 12);
		System.out.println(a);
		
		FinalkeyWord fk = new FinalkeyWord();
		fk.names(10.5, 12);
		fk.names(ver,10.5,25);
		
	}
    
}
