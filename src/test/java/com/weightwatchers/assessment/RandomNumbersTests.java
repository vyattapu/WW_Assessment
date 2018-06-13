package com.weightwatchers.assessment;

import org.testng.annotations.Test;

import com.weightwatchers.assessment.RandomNumbers;

public class RandomNumbersTests {
	@Test
	public void GetNthSmallestElementFromRandomListPassTest() {
		int n = 10;
		int minRange = -100;
		int maxRange = 100;
		int listSize = 500;
		int smallestElement = RandomNumbers.getNthSmallestFromRandomList(minRange, maxRange, listSize, n);
		System.out.println(n + "th smallest element in the random list is: " + smallestElement);
	}
}
