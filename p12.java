/* This class is used to solve the "Highly Divisible Triangle Number" problem.
 * Triangle number: a number nsub(i) formed by adding together the first "i" natural numbers
 * This algorithm is looking for the 1st triangle # w/ at least 500 factors.
 * ALGORITHM WORKS!
 * 
 * @author Sai Naidu
 */
public class p12 {
	
	public static void main(String [] args) {
		int i = 0;
		int runningSum = 0;
		while (!triCheck(runningSum)) {
			runningSum = i + runningSum;
			i++;
		}
	}
	
	private static boolean triCheck(int num) {
		int factorC = 0;
		
		for (int i = 1; i <= Math.sqrt(num); i++) {
			if (num%i == 0)
				factorC = factorC + 2;
		}
		
		if (factorC > 500) {
			System.out.println(num);
			return true;
		}
		else
			return false;
	}
}