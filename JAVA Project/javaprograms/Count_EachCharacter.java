package javaprograms;

import java.util.HashMap;
import java.util.Map;

public class Count_EachCharacter {

	public static void main(String[] args) {

		String name = "akheemPasha";

		Map<Character, Integer> map = new HashMap<Character, Integer>();

		for (int i = 0; i < name.length(); i++) {

			  char ch = name.charAt(i);

			   if (!map.containsKey(ch)) {
				    map.put(ch, 1);

			     }
			    else {
				int count = map.get(ch);
				count++;
				map.replace(ch, count);
			}
		}

		for (Character key : map.keySet()) {
			System.out.print(key + "" + map.get(key) + " ");
		}

	}

}
