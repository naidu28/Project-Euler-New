/* This class finds the "Largest Palindrome Product"
 * ALGORITHM WORKS!
 * 
 * @author Sai Naidu
 */
package p4;

public class P4 {
	
	public static void main(String [] args) {
		System.out.println(findPal());
	}
	
	private static int findPal() {
		int largestPal = 0;
		
		for (int i = 999; i >= 101; i--) {
			for (int j = 999; j >= 101; j--) {
				if (checkPal(i*j))
					if (i*j > largestPal) {
						System.out.println(i+" "+j); //Debug code
						largestPal = i*j;
					}
			}
		}
			
		if (largestPal > 0) return largestPal;
		
		return -1;
	}
	
	private static boolean checkPal(int num) {
		String s = "" + num;
		
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) != s.charAt(s.length() - i - 1))
				return false;
		}
		
		return true;
	}
	
	
}
