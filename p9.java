/* This class finds the unique Pythagorean triplet such that
 * a + b + c = 1000
 * ALGORITHM WORKS!
 *
 * @author Sai Naidu
 */
public class p9 {

	public static void main(String [] args) {
		long start = System.nanoTime();
		findTriplet();
		long finish = System.nanoTime();
		System.out.println((finish - start)/1000000 +" milliseconds"); 
	}

	private static void findTriplet() {
		int a = 0;
		int b = 0;
		double c = 0;

		for (a = 1; a < 1000; a++) {
			for (b = (4/3)*a; b < 1000; b++) {
				c = Math.sqrt(a*a + b*b);
				if (c == (int) c)
					if (a + b + c == 1000) System.out.println("a: "+a+" b: "+b+" c: "+c+" Product: "+a*b*c);
			}
		}
	}
}