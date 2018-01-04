package com.model;

public class Sorting {

	private Integer[] array;
	private String[] array1;

	private Integer[] tempMergArr;
	private String[] tempMergArr1;
	private int length;

	public String sort(Integer inputArr[], String label[]) {

		int h = 0, c = 0, w = 0;

		this.array = inputArr;
		this.array1 = label;
		this.length = inputArr.length;
		this.tempMergArr = new Integer[length];
		this.tempMergArr1 = new String[length];
		doMergeSort(0, length - 1);

		for (int i = 0; i < 3; i++) {

			if (array1[i].equals("hot")) {

				h++;
			} else if (array1[i].equals("warm")) {

				w++;
			} else if (array1[i].equals("cold")) {

				c++;
			}

		}

		if (h > w && h > c)
			return "hot";
		else if (w > h && w > c)
			return "warm";
		else
			return "cold";

	}

	private void doMergeSort(int lowerIndex, int higherIndex) {

		if (lowerIndex < higherIndex) {
			int middle = lowerIndex + (higherIndex - lowerIndex) / 2;
			// Below step sorts the left side of the array
			doMergeSort(lowerIndex, middle);
			// Below step sorts the right side of the array
			doMergeSort(middle + 1, higherIndex);
			// Now merge both sides
			mergeParts(lowerIndex, middle, higherIndex);
		}
	}

	private void mergeParts(int lowerIndex, int middle, int higherIndex) {

		for (int i = lowerIndex; i <= higherIndex; i++) {
			tempMergArr[i] = array[i];
			tempMergArr1[i] = array1[i];
		}
		int i = lowerIndex;
		int j = middle + 1;
		int k = lowerIndex;
		while (i <= middle && j <= higherIndex) {
			if (tempMergArr[i] <= tempMergArr[j]) {
				array[k] = tempMergArr[i];
				array1[k] = tempMergArr1[i];
				i++;
			} else {
				array[k] = tempMergArr[j];
				array1[k] = tempMergArr1[j];
				j++;
			}
			k++;
		}
		while (i <= middle) {
			array[k] = tempMergArr[i];
			array1[k] = tempMergArr1[i];
			k++;
			i++;
		}

	}
}
