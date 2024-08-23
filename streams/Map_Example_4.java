package javaa.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Employees {
	int empId ;
	String empName;
	double salary;
	
	public  Employees(int empId,String empName,double salary) {
		this .empId =empId;
		this.empName =empName;
		this.salary = salary;
		
	}
}

public class Map_Example_4 {

	public static void main(String[] args) {
		
		List<Employees> employeList = Arrays.asList(
				new Employees(102, "Akheem",23500),
				new Employees(103, "Pasha",35000),
				new Employees(104, "Dabir",25000),
				new Employees(105, "Khan",28500),
				new Employees(106, "Shamshi",30000)
				);
		
	/*	//Approach-1
		employeList.stream().filter(s->s.salary > 25000).
		                        // map(s-> s.salary)
		                           map(n->n.empName)
		                          .forEach(System.out::println);  */
		
		//Approach-2
		List<Double>salaryList = employeList.stream().filter(s->s.salary<25000)
				                                     .map(s->s.salary)
				                                     .collect(Collectors.toList());
		
		System.out.println(salaryList);

	}

}
