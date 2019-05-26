import java.util.*;

public class Test {
	public static int test(String s) {
		if(s == null || s.length() == 0) return 0;
		Map<Character, Integer> map = new HashMap<>();
		int left = 0, right = 0;
		int counter = 0, result = 0;

		while(right < s.length()){
			char c = s.charAt(right);
			if(!map.containsKey(c)) map.put(c, 0);
			map.put(c, map.get(c)+1);
			if(map.get(c) == 1) counter++;
			while(counter > 2){
				char old = s.charAt(left);
				map.put(old, map.get(old) - 1);
				if(map.get(old) == 0) counter--;
				left++;
			}
			result = Math.max(result, right - left + 1);
			right++;
		}
		return result;
	}

	public static void main(String[] args){
		System.out.println(test("eceba"));
		System.out.println(test("ccaabbb"));
		System.out.println(test("ccaabbbccaabbbccaaaaaaaaaaaaaaaaaaaaaaaaabbbccaabbb"));
	}
}
