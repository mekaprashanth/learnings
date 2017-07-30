/**
 * 
 */
package com.prash.java.sample.arrays;

import java.util.Arrays;

/**
 * @author Prashanth_Meka
 *
 */
public class RepeatingElements {
	
	private static int[] a = {1,2,1,4,5,6,6};
	private static int size = a.length;
	
	public static void findDuplicates()	{
		
		for(int i=0; i<size; i++)	{
			if(a[Math.abs(a[i]-1)]>=0)	{
				a[Math.abs(a[i]-1)] *= -1;
//				System.out.println(Arrays.toString(a));
				continue;
			}
			else	{
				System.out.println("Duplicate value is "+a[i]);
			}
		}
	}

	public static void main(String[] args) {
		findDuplicates();
	}
}
