public class Test {
	public static String nextClosestTime(String time) {
		int[] digits = new int[4];

		digits[0] = time.charAt(0)-'0';
		digits[1] = time.charAt(1)-'0';
		digits[2] = time.charAt(3)-'0';
		digits[3] = time.charAt(4)-'0';

		int originalTime = (digits[0]*10 + digits[1])*60 + (digits[2]*10 + digits[3]);
		int minTimeNeeded = 24*60;
		int min = originalTime;

		for(int digit1 : digits){
			for(int digit2 : digits){
				if(digit1*10 + digit2 < 24){
					for(int digit3 : digits){
						for(int digit4 : digits){
							if(digit3*10 + digit4 < 60){
								int newTime = (digit1*10 + digit2)*60 + (digit3*10 + digit4);
								int newTimeNeeded = newTime - originalTime;
								if(newTimeNeeded < 0) newTimeNeeded = newTimeNeeded + 24*60;
								if(newTimeNeeded != 0 && newTimeNeeded < minTimeNeeded) {
									minTimeNeeded = newTimeNeeded;
									min = newTime;
								}
							}
						}
					}
				}
				
			}
		}

		return String.format("%02d:%02d", min / 60, min % 60);

	}

	public static void main(String[] args){
		System.out.println(nextClosestTime("19:34"));
		System.out.println(nextClosestTime("23:59"));
		System.out.println(nextClosestTime("00:00"));
	}
}
