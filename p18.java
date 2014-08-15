/* This class finds the maximum path sum in a triangle of random integers.
 * Each level must be visited and a single number must be chosen at each level.
 * An edge can only be formed btwn. adjacent numbers.
 * ALGORITHM WORKS!
 *
 * @author Sai Naidu
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Stack;
import java.util.Scanner;

public class p18 {
	
	public static void main (String [] args) {
		File file = new File("C:/Users/Sai/Documents/Seagate120_Sai/New Desktop/CSProjects/Project Euler/p18/src/triangle.txt");
		int [][] triTable = new int[15][15];
		
		try {
			Scanner fileScan = new Scanner(file);
			for (int i = 0; i < 15; i++) { //Copies elements from triangle.txt to array
				for (int j = 0; j < 15; j++) {
					if (j > i)
						triTable[i][j] = 0;
					else
						triTable[i][j] = fileScan.nextInt();
				}
				fileScan.nextLine();
			}
			print(triTable);
			System.out.println(pathFind(triTable, 0, 0));
			
		} catch (FileNotFoundException f) {
			System.out.println("Invalid file.");
		}
	}
	
	private static void print(int [][] t) {
		for (int i = 0; i < 15; i++) {
			for (int j = 0; j < 15; j++) {
				System.out.print(t[i][j]+" "); 
			}
			System.out.println();
		}
	}
	
	private static int pathFind(int [][] t, int i, int j) { //brute force max path finding algorithm
		if (i < t.length - 1) { //vertical bounds check
			int max = t[i][j] + pathFind(t, i+1, j); //essentially the "left" subtree
			int max2 = 0;
			if (j < t[i].length - 1 && t[i+1][j+1] != 0) //horizontal bounds check 
				max2 = t[i][j] + pathFind(t, i+1, j+1); //"right" subtree
			if (max > max2) //right vs. left subtree
				return max;
			else
				return max2;
		} else
			return t[i][j];
	}
}
		
		/*System.out.println("How tall will this triangle be?");
		int height = Integer.parseInt(inputScan.next());
		TriangleTable maxPath = new TriangleTable(height);
		buildTable(maxPath);
	}
	
	private static void buildTable(TriangleTable maxPath) {
		boolean flag = true;
		int levelIndex = 0;;
		int listIndex = -1;
		
		
		while (flag) {
			System.out.println("Enter elements from triangle left -> right. -1 to exit. -2 for debug. -3 for more options.");
			int input = Integer.parseInt(inputScan.next());
			if (input == -1) //exit
				flag = false;
			else if (input == -2) //debug
				maxPath.debug();
			else if (input == -3) { //index add or remove - this code is really ugly and buggy. Fix it up.
				System.out.println("Enter 'add' or 'remove'");
				String s = inputScan.next().toLowerCase();
				if (s.equals("add")) {
					System.out.println("Enter levelIndex, then listIndex, then element");
					int lvl = Integer.parseInt(inputScan.next());
					int list = Integer.parseInt(inputScan.next());
					maxPath.add(lvl, list, Integer.parseInt(inputScan.next()));
				} else
					System.out.println("Enter levelIndex, then listIndex");
					int lvl = Integer.parseInt(inputScan.next());
					maxPath.remove(lvl, Integer.parseInt(inputScan.next()));
			} else {
				if (listIndex == levelIndex) // if row filled, then true
					if (levelIndex == maxPath.getTable().length - 1) // if every level filled, then true
						System.out.println("No space");
					else { //every level is not filled; increment to next level
						listIndex = 0;
						levelIndex++;
						maxPath.add(levelIndex, listIndex, input);
					}
				else { // row is not filled, increment one
					listIndex++;
					maxPath.add(levelIndex, listIndex, input);
				}
			}
		}
	}*/