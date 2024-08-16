package javaprograms;

public class Print1To100_WithoutLoop {

	public static void main(String[] args) {
	//	printNum(1);
		printNumer(1, 100);

	}
	
	/**
     * print 1 to 100 without using any loop
     * 1.recursive functions
     * 2.Java Streams
     */
    public static void printNum(int num) {
    if(num <= 100) {
   	 System.out.println(num);
   	 num++;
   	 printNum(num);
    } 
    }
    
    public static void printNumer(int stgNum , int endNum) {
        if(stgNum <= endNum) {
       	 System.out.println(stgNum);
       	stgNum++;
       	 printNumer(stgNum , endNum);
        } 
        }

}
