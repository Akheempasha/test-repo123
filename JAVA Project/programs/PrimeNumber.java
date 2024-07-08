package programs;

public class PrimeNumber {

	public static void main(Stringss[] args) {
		int i,j;
		
		for(i=0;i<=100;i++) {   // reverse order //for(i=100;i<=0;i--)//
			for(j=2;j<i;j++) {
				if(i%j==0) {
				  break;	
				}
			}
                if(i==j) {
                	System.out.print(i+" ");
                }
			}
		}

	}


