/**
 * 
 */
package com.prash.java.sample.arrays;

/**
 * @author Prashanth_Meka
 *
 */
public class KadanesAlgorithm {
	
	private static int[] a = {400,100,-50,100,200,300};
	private static int size = a.length;
	
	public static void findMaxSubSeq()	{
		int totMax = 0;
		int currMax = a[0];
		for(int i=1; i<size; i++ )	{
			currMax = Math.max(a[i], currMax+a[i]);
			totMax = Math.max(currMax, totMax);
		}
		System.out.println("total max sub sum "+totMax);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		findMaxSubSeq();
	}
}
