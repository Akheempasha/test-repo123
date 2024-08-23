package javaa.streams;

import java.util.ArrayList;

class Students {
	String name ;
	int score;
	char rank;
	
	public Students(String name, int score, char rank) {
		this.name = name;
		this.score = score;
		this.rank = rank;
	}
	
	public String getName() {
		return this.name;
	}
	public int getScore() {
		return score;
	}
	public char getRank() {
		return this.rank;
	}
	
}

public class ParallelStream {

	public static void main(String[] args) {
		
		ArrayList<Students> studentList = new ArrayList<Students>();
		
		studentList.add(new Students("Akheem", 65, 'B'));
		studentList.add(new Students("Aahil",  95, 'A'));
		studentList.add(new Students("Shahin", 45, 'D'));
		studentList.add(new Students("Anwar",  35, 'D'));
		studentList.add(new Students("Abedha", 75, 'A'));
		
		//1.stream()
	/*	studentList.stream().filter(s->s.getRank() >= 66)
		                    .limit(2)
		                    .forEach(str-> System.out.println(str.getName()+ "_"+str.getScore()));
	*/	
		//2.parallelStream()
		studentList.parallelStream().filter(s->s.getRank() >= 66)
				            .limit(5)
				            .forEach(str-> System.out.println(str.getName()+ "_"+str.getScore()));
		
		//3.convert stream() To parallelStream()
		studentList.stream().parallel()
				            .filter(s->s.getRank() >= 66)
						    .limit(5)
						    .forEach(str-> System.out.println(str.getName()+ "_"+str.getScore()));
						
	}
}
