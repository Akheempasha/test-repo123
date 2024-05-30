package programs;

public class Stringss {

	public static void main(String[] args) {

        String name = new String("Akheem");
 final  String state = " Telangana";
 
     //  System.out.println(name.concat(state));
          String date= name+state;
          //1.length()-->to find number of characters give a main String
         System.out.println(date);
//       System.out.println(date.length());
//       System.out.println(date.length()-1);
         //2.charAt()-->to read specific character from main String based on given index
       System.out.println(date.charAt(0));
         // To read 2nd Character
       System.out.println(date.charAt(1));
       
       
       //3.indexOf()--->to find index of given character in main String
        String str = "Mindq systems";
       System.out.println(str.indexOf("s",7));
       
       //4.toUpperCase()-->it will convert given String into UpperCase
        System.out.println(str.toUpperCase());
       //5.toLowerCase()-->it will convert given String into LowerCase
       System.out.println(str.toLowerCase());
       //6.equals()-->compare the String values--it will return true or false
       System.out.println(str.equals("Mindq systems")); // true
       System.out.println(str.equals("mindq systems")); // false
       //7.equalsIgnoreCase()
       System.out.println(str.equalsIgnoreCase("mindq systems"));
       //8.startsWith()-->to compare prefix value of a String
       System.out.println(str.startsWith("Mindq"));
       //9.endsWith()--->to compare suffix value of a String
       System.out.println(str.endsWith("ems"));
       //10.contains()->to check substring availability in a main String
       System.out.println("contains.."+str.contains("q sys"));
       //11.isEmpty()--->to check value in a variable is Empty or not.
       
		  String n = "Akheem";
		  String e = "";

		  System.out.println(n.isEmpty()); // false
		  System.out.println(e.isEmpty()); // true
		  
	  //12.concat()-->to concat the String values(only String values)
		  
		  String name1 = "Mindq";
		  String name2 = "Systems";
		  
		  System.out.println(name1.concat(name2));
		  System.out.println(name1+name2);
		  int value = 100;
		  System.out.println(name1+value);
		  
	 //13.trim()-->it will remove leading and trailing spaces for a given String
		  String course = " Selenium ";
		  
		  System.out.println(course.length());           //10
		  System.out.println(course.trim());
		  System.out.println(course.trim().length());    //8
		  
	//14.replace()-->to replace substring in a main String
		  System.out.println(course.replace(" ", ""));
		  System.out.println(course.replace("S", "A"));
		  System.out.println(course.replace(course, "java"));
		  System.out.println(course.replaceAll(course, name2));
		  
   //15.subString()-->to read subString from mainString(end index should be Exclude one)
		  
		  String says = "Welcome to india";
		  System.out.println(says.substring(8));
		  System.out.println(says.substring(3,7));  //come
		  
		  
		  
		  
		  
   
	}

}
