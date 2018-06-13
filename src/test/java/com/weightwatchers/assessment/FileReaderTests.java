package com.weightwatchers.assessment;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;

import org.testng.annotations.Test;

import com.weightwatchers.assessment.FileReaderSolution;

public class FileReaderTests {
	@Test
	public void FileExistsTest() throws FileNotFoundException {
		String filePath = "src\\test\\resources\\Dictionary.txt";
		assertTrue(FileReaderSolution.doesFileExist(filePath));
	}
	
	@Test(expectedExceptions = FileNotFoundException.class)
	public void FileDoesNotExistTest() throws FileNotFoundException {
		String filePath = "src\\test\\resources\\Dict.txt";
		assertTrue(FileReaderSolution.doesFileExist(filePath));
	}
	
	@Test
	public void FileParsePassTest() throws FileNotFoundException {
		String filePath = "src\\test\\resources\\Dictionary.txt";
		List<String> meanings = Arrays.asList(new String[] {"a fruit", "a tech firm"});
		FileReaderSolution.readFileContent(filePath);
		assertTrue(FileReaderSolution.getMeaningsFromDictionary("Apple").containsAll(meanings));
	}
	
	@Test
	public void FileParseFailTest() throws FileNotFoundException {
		String filePath = "src\\test\\resources\\Dictionary.txt";
		List<String> meanings = Arrays.asList(new String[] {"a fruit", "contains rows and columns when used in context of computers"});
		FileReaderSolution.readFileContent(filePath);
		assertFalse(FileReaderSolution.getMeaningsFromDictionary("Table").containsAll(meanings));
	}
	
	@Test(expectedExceptions = IllegalArgumentException.class)
	public void FilePathNullPassTest() throws FileNotFoundException {
		assertTrue(FileReaderSolution.doesFileExist(null));
	}
	
	@Test(expectedExceptions = IllegalArgumentException.class)
	public void FilePathNullEmptyTest() throws FileNotFoundException {
		assertTrue(FileReaderSolution.doesFileExist(""));
	}
	
	@Test
	public void PrintFileContentDirectlyPassTest() {
		String filePath = "src\\test\\resources\\Dictionary.txt";
		FileReaderSolution.printFileContentDirectly(filePath);
	}
	
//	@Test
//	public void PrintFileContentFromMapPassTest() throws FileNotFoundException {
//		String filePath = "src\\test\\resources\\Dictionary.txt";
//		FileReaderSolution.printFileContentFromMap(filePath);
//	}
	
//	TO DO
//	 More tests for file parsing to validate leading and succeeding spaces for words and meanings, empty file, file size, file format,
//	 file content type, empty lines etc.
}
