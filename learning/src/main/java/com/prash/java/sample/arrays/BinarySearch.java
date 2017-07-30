package com.prash.java.sample.arrays;

public class BinarySearch {
	private static int[] a = {1,2,3,6,10,100,101,208,277,300 };
	private static int size = a.length;
	
	public static int findIndex(int left, int right, int number)	{
		if(left>=right)	{
			return -1;
		}
		int mid = (left + right) / 2;
		if(a[mid] == number)	{
			return mid;
		}
		if(a[mid]>number)	{
			right = mid;
		}else	{
			left = mid+1;
		}
		return findIndex(left, right, number);
	}
	
	public static void main(String[] args) {
		System.out.println(findIndex(0, size-1, 10));
	}

}
