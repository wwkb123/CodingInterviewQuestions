import java.util.HashSet;

/**Question:
 * Design an algorithm and write code to remove the duplicate characters in a string without using any additional buffer. 
 * NOTE: One or two additional variables are fine. An extra copy of the array is not.
 * Write the test cases for this method.
 */



public class RemoveDuplicate {

	public static void main(String[] args) {
		
		String x = "ababababababbabababababbcccascsacsa";
		char[] y = x.toCharArray();
		removeDuplicate(y);
		System.out.println("");
		removeDuplicateWithHashSet("ababababababbabababababbcccascsacsa".toCharArray()); //with HashSet
	}
	
	public static void removeDuplicate(char[] word){
		
		if(word == null){ //address null value
			return;
		}
		
		System.out.print(word[0]); //print first character
		
		if(word.length<2){ //address value with 0 or 1 character
			return;
		}
	
		int tail = 1;
		for(int i = 1; i<word.length;i++){
			int j;
			for(j = 0;j<tail;j++){
				if(word[i]==word[j]){
					break;
				}
			}
			
			if(j==tail){
				word[tail] = word[i];
				System.out.print(word[tail]);
				tail++;
			}
			
		}
		word[tail] = 0; //empty
		
	}
	
	public static void removeDuplicateWithHashSet(char[] word){
		HashSet<Character> charSet = new HashSet<Character>();
		
		for (char c:word){
			charSet.add(c);
		}
		
		for(char c:charSet){
			System.out.print(c);
		}
	}

}
