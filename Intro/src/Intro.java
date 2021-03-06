
public class Intro {

	/**
	 * a method that returns 17 when run
	 * 
	 * @return	17
	 */
	public int ret() {
		return 17;
	}
	
	/**
	 * a method, that takes in three parameters, and returns the logical and of the parameters together
	 * 
	 * @return	true if a, b, c are true
	 * 			false if either a, b or c are false
	 */
	public boolean logic(boolean a, boolean b, boolean c) {
		if (a && b && c) {
			return true;
		}
		return false;
	}
	
	/**
	 * a function that takes in a number and returns a string of the multiline triangle of stars
	 * 
	 * @param	n	how many lines of stars there should be
	 * 
	 * @return	str a triangle of stars
	 */
	public String stars(int n) {
		String str = "";
		for (int i = 0; i < n; i++) {
			for (int j = 0; j <= i; j++) {
				str = str + "*";
			}
			str = str + "\n";
		}
		return str;
	}
	
	/**
	 * exchanges coins - prioritizes 5c coins over 2c coins in order to exchange minimum amount of coins
	 * 
	 * @param	n	value of coins to be exchanged
	 * 
	 * @return	if exchange is possible: number of coins exchanged
	 * 			if exchange is not possible: -1
	 */
	public int coins(int n) {
		int five = 0;
		int two = 0;
		five = n/5;
		two = (n - (five * 5))/2;
		int total = five * 5 + two * 2;
		if (n == total) {
			System.out.println(five + " 5c and " + two + " 2c");
			return five + two;
		}
		else
		{
			return -1;
		}
	}
}
