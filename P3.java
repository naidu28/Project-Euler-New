/* This class is used for the "Largest Prime Factor" problem. 
 * ALGORITHM WORKS!
 * 
 * @author Sai Naidu
 */
import java.util.Scanner;

public class P3 {
	
	public static void main(String [] args) {
		Scanner inputscan = new Scanner(System.in);
		System.out.println("Enter number to factorize");
		long num = Long.parseLong(inputscan.next());
		long lrgprm = factorize(num, 2); //lrgprm is the "largest prime" factor
		System.out.println(lrgprm);
	}

	/*
	 * Builds a tree of recursive stacks to find
	 * the largest prime factor
	 */
	private static long factorize(long num, long factor) {
		if (num == factor)
			return num;
		if (num%factor == 0) {
			long f1 = factorize(factor, 2);
			long f2 = factorize(num/factor, 2);
			if (f1 > f2)
				return f1;
			else
				return f2;
		} else { //"if" (num%factor != 0) 
			if (Math.pow(factor, 2) <= num)
				return factorize(num, factor + 1);
			else
				return num; //this implies that num is prime - i.e. has no factors
		}
	}
}