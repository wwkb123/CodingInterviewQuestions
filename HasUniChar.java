
/**
 * Question:
 * Implement an algorithm to determine if a string has all unique characters. 
 * What if you can not use additional data structures?
 */


public class HasUniChar {

	public static void main(String[] args) {
		
		System.out.println("Does the String 'Tommy' has all unique characters? "+hasUniChar("Tommy"));
		
	}

	
	public static boolean hasUniChar(String word){
		boolean[] char_arr = new boolean[256]; // ASCII value 0~255
		
		for(int i=0;i<word.length();i++){
			int val = word.charAt(i); //take the ASCII value out
			if(char_arr[val]) return false;  //if the character already exists, return false 
			char_arr[val] = true; //a new character is found
		}
		return true;  //all unique
	}
}
