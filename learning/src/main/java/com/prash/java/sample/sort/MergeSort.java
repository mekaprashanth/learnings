package com.prash.java.sample.sort;

public class MergeSort {
	int array[];
	int size;

	public MergeSort(int n) {
		size = n;
		array = new int[n];
		for (int i = 0; i < n; i++) {
			array[i] = (int) Math.round(Math.random() * 89 + 10);
		}
	}

	public int getSize() {
		return size;
	}

	public void merge(int left, int mid, int right) {
		int temp[] = new int[right - left + 1];
		int i = left;
		int j = mid + 1;
		int k = 0;
		while (i <= mid && j <= right) {
			if (array[i] <= array[j]) {
				temp[k] = array[i];
				k++;
				i++;
			} else { // array[i]>array[j]
				temp[k] = array[j];
				k++;
				j++;
			}
		}
		while (j <= right)
			temp[k++] = array[j++];
		while (i <= mid)
			temp[k++] = array[i++];

		for (k = 0; k < temp.length; k++)
			array[left + k] = temp[k];
	}

	public void merge_sort(int left, int right) {
		if (left < right) {
			int mid = (left + right) / 2;
			merge_sort(left, mid);
			merge_sort(mid + 1, right);
			merge(left, mid, right);
		}

	}

	public void print() {
		System.out.println("Contents of the Array");
		for (int k = 0; k < 10; k++) {
			System.out.print(array[k] + " | ");
		}
		System.out.println();

	}

	public static void main(String args[]) {
		MergeSort m = new MergeSort(15);
		m.array= new int[] {4,5,7,6,0,1,4,3,2,9,8};
		System.out.println("Before Sort <<<<<<<<<<<<<<<<<<<<<");
		m.print();
		m.merge_sort(0, m.getSize() - 1);
		System.out.println("After Sort > > > > > > > > > > > >");
		m.print();
		System.out.println("=======+============+=======+============+=========");
//		MergeSort m2 = new MergeSort(25);
//		System.out.println("Before Sort <<<<<<<<<<<<<<<<<<<<<");
//		m2.print();
//		m2.merge_sort(0, m2.getSize() - 1);
//		System.out.println("After Sort > > > > > > > > > > > >");
//		m2.print();
//		System.out.println("=======+============+=======+============+=========");
//		MergeSort m3 = new MergeSort(30);
//		System.out.println("Before Sort <<<<<<<<<<<<<<<<<<<<<");
//		m3.print();
//		m3.merge_sort(0, m3.getSize() - 1);
//		System.out.println("After Sort > > > > > > > > > > > >");
//		m3.print();
//		System.out.println("=======+============+=======+============+=========");

	}
}