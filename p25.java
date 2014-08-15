/* This class finds the first "1000-Digit Fibonacci Number"
 * Idea is that it is computationally impossible to calculate a num that large.
 * My algorithm: Calculate it in the same fashion as scientific notation.
 * Keep a limit of 14 digits. All further digits should be truncated.
 * Somewhat imprecise but should work.
 * DOES NOT WORK!
 * 
 * @author Sai Naidu
 */
public class p25 {
	
	public static void main(String [] args) {
		int term = fibonacci(1000, "a");
		System.out.println(term);
	}

	private static int fibonacci(int digitGoal, String s) {
		int term = 2;
		int digits = 0;
		long [] fibonacci = new long[2];
		fibonacci[0] = 1;
		fibonacci[1] = 1;
		
		while (digits < 1000) {
			long temp = fibonacci[0]; //moving the sequence forward by 1
			fibonacci[0] = fibonacci[1];
			fibonacci[1] = temp + fibonacci[0];
			
			digits = checkDigits(fibonacci[1]);
			
			term++;
		}
		
		return term;
	}
	private static int fibonacci(int digitGoal) {
		int term = 2;
		int digits = 0;
		double [] fibonacci = new double[2];
		fibonacci[0] = 1;
		fibonacci[1] = 1;
		
		while (digits < 1000) {
			double temp = fibonacci[0]; //moving the sequence forward by 1
			fibonacci[0] = fibonacci[1];
			fibonacci[1] = temp + fibonacci[0];
			
			if (fibonacci[1] > 10) {
				fibonacci[1] = truncate(fibonacci[1]/10);
				digits++;
			}
			
			term++;
		}
		
		return term;
	}
	
	private static double truncate(double fibonacci) {
		return Math.floor(fibonacci * Math.pow(10, 25))/Math.pow(10, 25);
	}
	
	private static int checkDigits(long num) {
		return (int) Math.log(num);
	}
}