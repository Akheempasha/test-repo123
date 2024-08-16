package javaprograms;

public class Sum_Digit {

	public static void main(String[] args) {

    int num = 1500;
    int sum = 0;
    int temp = 0;
    
    while(num > 0) {              //Description
    	
    	temp = num%10;   // 1500%10 = 0       2. 150%10 = 0    3. 15%10 = 5   4. 1
    	sum = sum+temp;  //  0 =0+0           2. 0 = 0+0       3.  5 =0+5     4. 5+1 = 6
    	num = num/10;    //  1500/10 = 150    2. 150/10 = 15   3.  15/10 = 1  4. num value = 0
    	                                                                   //  while condition false  
    	
    }
     System.out.println(sum);
	}

}
