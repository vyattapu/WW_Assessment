package com.weightwatchers.assessment;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FileReaderSolution {
//	Since the specification is to read the file and print the words and meanings, there is no need to store the values in any data structure
//	However, I have presented both the solutions here - one using HashMap, and the other without any data structure
	private static Map<String, List<String>> dictionary = new HashMap<>();
	
	public static boolean doesFileExist(String path) throws FileNotFoundException {
		if(path == null || path.length() == 0)
			throw new IllegalArgumentException("path cannot be null or empty");
		File file = new File(".\\" + path);
		if(file.exists())
			return true;
		throw new FileNotFoundException("File not found at " + path);
//		or return false depending on the specification
	}
	
//	print file contents directly to console
	public static void printFileContentDirectly(String filePath) {
		try(BufferedReader fileReader = new BufferedReader(new FileReader(filePath))) {
			String line;
			while((line = fileReader.readLine()) != null) {
				String word = line.substring(0, line.indexOf('-')).trim();
				String[] meanings = line.substring(line.indexOf('-') + 1).trim().split(", ");
				System.out.println(word);
				for(String meaning: meanings)
					System.out.println(meaning);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
//	print contents from HashMap
//	Methods are named as such only for the sake of understanding for this assessment
	public static void printFileContentFromMap(String path) throws FileNotFoundException {
		readFileContent(path);
		
		if(!dictionary.isEmpty()) {
			for(String word: dictionary.keySet()) {
				System.out.println(word);
				for(String meaning: dictionary.get(word)) {
					System.out.println(meaning);
				}
			}	
		}
	}
	
//	Read file content to HashMap
	public static void readFileContent(String path) throws FileNotFoundException {
		if(doesFileExist(path)) {
			try(BufferedReader fileReader = new BufferedReader(new FileReader(".\\" + path))) {
				String line;
				while((line = fileReader.readLine()) != null) {
					String word = line.substring(0, line.indexOf('-')).trim();
					List<String> meanings = Arrays.asList(line.substring(line.indexOf('-') + 1).trim().split(", "));
					dictionary.put(word, meanings);
				}
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
	}
	
	
	public static boolean dictionaryContainsWord(String word) {
		if(dictionary.containsKey(word))
			return true;
		return false;
	}
	
	public static List<String> getMeaningsFromDictionary(String word) {
		if(dictionaryContainsWord(word))
			return dictionary.get(word);
		else
			return null;
	}
}
