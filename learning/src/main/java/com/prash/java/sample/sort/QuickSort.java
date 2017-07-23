/**
 * 
 */
package com.prash.java.sample.sort;

/**
 * @author Prashanth_Meka
 *
 */
public class QuickSort {

	int partition(int arr[], int left, int right) {
		int i = left, j = right;
		int tmp;
		int pivot = arr[(left + right) / 2];

		while (i <= j) {
			while (arr[i] < pivot)
				i++;
			while (arr[j] > pivot)
				j--;
			if (i <= j) {
				tmp = arr[i];
				arr[i] = arr[j];
				arr[j] = tmp;
				i++;
				j--;
			}
		}
		;

		return i;
	}

	void quickSort(int arr[], int left, int right) {
		int index = partition(arr, left, right);
		if (left < index - 1)
			quickSort(arr, left, index - 1);
		if (index < right)
			quickSort(arr, index, right);
	}
	
	static void printArray(int arr[]) {
		int n = arr.length;
		for (int i = 0; i < n; ++i)
			System.out.print(arr[i] + " ");
		System.out.println();
	}


	public static void main(String[] args) {
		int arr[] = { 12, 11, 13, 5, 6, 45, 88, 99, 22, 33, 58, 34, 7 };

		System.out.println("Given Array");
		printArray(arr);

		QuickSort quickSort = new QuickSort();
		int length = arr.length;
		int left = 0;
		int right = length-1;
		quickSort.quickSort(arr, left, right);
		System.out.println("\nSorted array");
		printArray(arr);

	}

}
