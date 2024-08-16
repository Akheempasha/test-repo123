package javaprograms;

public class Largest_3_Integers {

	public static void main(String[] args) {

    int x = 20 , y = 30 , z = 10, zz = 50;
    
    if(x > y && x > z) {
    	System.out.println(x+" is largest Number");
    }
    else if (y > x && y > zz) {
    	System.out.println(y+" is largest number");
    } 
    else if(z > x && z > y) {
    	System.out.println(z+" is largest Number");
    }
    else {
    	System.out.println(zz+" largest number");
    }

	}

}
