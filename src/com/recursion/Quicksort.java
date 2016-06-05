package com.recursion;

import java.util.Arrays;

public class Quicksort {

	public static void main(String[] args)
	{
		int[] array = {4,15,7,9,3,1,12,2,5,6,10};
		
		sort(0, array.length-1, array);
		
		System.out.println(Arrays.toString(array));
		
	}
	
	public static void sort(int startIndex, int endIndex, int[] array)
	{
		// Recursion Base Case
		if (startIndex == endIndex || endIndex < startIndex)
			return;
			
		// Calculates the middle position
		int middleIndex = (endIndex + startIndex)/2;
		
		System.out.println("Initial Array: " + Arrays.toString(array));
		
		// Puts the element located in the middle of the array at the starting index
		swap(startIndex, middleIndex, array);
		
		// Gets the pivot element which is the element that used to be in the middle position but now
		// it is located at the start index
		int pivot = array[startIndex];
		
		System.out.println("Pivot: " + pivot);
				
		int pivotIndex = startIndex;
		
		// Defines a pointer for the elements that are swapped with the pivot
		int startPointer = startIndex + 1;
		
		// Defines a pointer for the elements that are inserted at the end of the array
		int endPointer = endIndex;
				
		System.out.println("Array with Pivot at Beginning: " + Arrays.toString(array));
		System.out.println("Start Index: " + startIndex);
		System.out.println("End Index: " + endIndex);
		
		// Iterate over the array and arranges elements lesser than the pivot to the left and the greater to the right
		while (startPointer <= endPointer)
		{	
			// The element is lesser than the pivot
			if (array[startPointer] < pivot)
			{ // Swaps the element with the pivot
				swap(startPointer, startPointer-1, array);
				startPointer++;
				pivotIndex++;
			}
			else if (array[startPointer] > pivot)
			{
				swap(startPointer, endPointer, array);
				endPointer--;
			}
			else
				startPointer++;
		}

		System.out.println("Sorted Array: " + Arrays.toString(array));
		System.out.println("-------------------------------------------");
		System.out.println("");
		
		// Recursive call to sort elements smaller than the pivot
		sort(startIndex, pivotIndex-1, array);
		
		// Recursive call to sort elements greater than the pivot
		sort(pivotIndex+1, endIndex, array);		
	}
	
	private static void swap(int index1, int index2, int[] array)
	{
		int temp = array[index1];
		array[index1] = array[index2];
		array[index2] = temp;
	}
}
