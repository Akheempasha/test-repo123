package oops;

public class MethodTypes {
	int marks;
	String name;
	char grade;
	
	void StudentDetailes() {
		System.out.println(marks+" "+name+" "+grade);
	}
	
	void Studet(int id , String sname, char cgp) {
		id=100;
		sname="jho";
		cgp = 'B';
		System.out.println(id+" "+sname+" "+cgp);
		
	}
	
	MethodTypes(int id , String sname, char cgp){
		System.out.println(id+" "+sname+" "+cgp);
	}
	
	
	
	
	

}
