package com.weightwatchers.assessment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class RandomNumbers {
	
	public static int getNthSmallestFromRandomList(int minRange, int maxRange, int listSize, int n) {		
		if(n > listSize)
			throw new IllegalArgumentException("\'n\' should less than or equal to listSize");
		
		if(minRange >= maxRange)
			throw new IllegalArgumentException("minRange should be less than maxRange");
		
		if(listSize <= 0)
			throw new IllegalArgumentException("listSize should be greater than 0");
		
//		TO DO
//		Add validation for Integer overflow for ranges and list size
		
		List<Integer> randomList = new ArrayList<>(listSize);
		
		generateRandomList(randomList, minRange, maxRange, listSize);
		
		System.out.println("Original Random List: " + randomList);
		
//		Sort the items in randomList
		Collections.sort(randomList);
		
		System.out.println("Sorted Random List: " + randomList);
		
		Set<Integer> randomSet = new HashSet<>();
		int i = 0;
		
//		Add the randomList items one-by-one to HashSet to skip past duplicate values until the nth smallest element is reached
		while(randomSet.size() < n && i < randomList.size())
			randomSet.add(randomList.get(i++));
				
//		Return the nth smallest element
//		if 'i' equals randomList.size() before finding the nth smallest element, element at index 'randomList.size() - 1' will be returned
//		This can be modified as per the specification
		return randomList.get(i - 1);
	}
	
	private static void generateRandomList(List<Integer> randomList, int minRange, int maxRange, int listSize) {		
		Random rand = new Random();
		
		while(randomList.size() < listSize) {
//			Generate random integers in the range min and max inclusive
			randomList.add(rand.nextInt(maxRange - minRange + 1) + minRange);
		}
	}
}