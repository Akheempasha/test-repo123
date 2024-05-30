package array.concept;

public class Object_Array {

	public static void main(String[] args) {
		Object[] allData = {10,'A',"Akheem",true,10.5};
		
		System.out.println(allData.length);
		System.out.println(allData[2]);
		for(Object data : allData) {
			System.out.print(data+", ");
			}
	        System.out.println(); 
	        
	        
	  Object[][] allValues = new Object[3][2];
	  
	  allValues[0][0]=100;
	  allValues[0][1]=250;
	  
	  allValues[1][0]="Akheem";
	  allValues[1][1]="Pasha";
	  
	  allValues[2][0]='a';
	  allValues[2][1]=10.5;
	  
	  for(int r=0;r<allValues.length;r++) {
		  for(int c=0;c<allValues[0].length;c++) {
			  System.out.print(" "+allValues[r][c]);
		  }
	       System.out.println();
	  }
	        
	        
	        
	}

}
