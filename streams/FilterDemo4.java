package javaa.streams;

import java.util.ArrayList;

class Product {
	 int id;
	 String name;
	 double price;
	 
	 public Product( int id, String name, double price) {
		 this.id = id ;
		 this.name = name;
		 this.price = price; 
	 }
}

public class FilterDemo4 {
	public static void main(String[] args) {
		
		ArrayList<Product> productList = new ArrayList<Product>();
		
		productList.add(new Product(1, "Dell Laptop", 28000));
		productList.add(new Product(2, "HP Laptop",   56500));
		productList.add(new Product(3, "Lenova Laptop",45000));
		productList.add(new Product(4, "LG Laptop",   65000));
		productList.add(new Product(5, "Apple Laptop",85000));
		
//		productList.stream().filter(p-> p.price > 50000)
//		                 .forEach(p->System.out.println(p.price+" "+p.id+" "+p.name));
		
		productList.stream().filter(p-> p .id >2 && p .id <4)
		.forEach(p->System.out.println(p.name));
		
	}

}
