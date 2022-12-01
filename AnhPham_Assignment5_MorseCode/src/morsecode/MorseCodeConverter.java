package morsecode;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class MorseCodeConverter {
	private static MorseCodeTree tree = new MorseCodeTree();
	
	/**
	 * printTree()
	 * @returns a string with all the data in LNR order with a space between them
	 */
	
	public static String printTree() {
		String data = "";
		ArrayList<String>list = new ArrayList<String>();
		list = tree.toArrayList();
		
		for(int i = 0; i < list.size(); i++) {
			data += list.get(i);
		}
		
		return data.trim();		
	}
	
	
	
	/**
	 * convertToEnglish()
	 * @param code - The morse code 
	 * @return English Text Translation
	 */
	public static String convertToEnglish(String code) {
		String[] codeWords;
		String[] codeLetters;
		String result = "";
		codeWords = code.split("/");
		
		for(int i = 0; i < codeWords.length; i++) {
			codeWords[i] = codeWords[i].trim();
			codeLetters = codeWords[i].split(" ");
			for(int j = 0; j < codeLetters.length; j++) {
				result += tree.fetch(codeLetters[j]);
			}
			result += " ";
		}
		result = result.trim();
		return result;
	}
	
	/**
	 * convertToEnglish()
	 * @param codeFile
	 * @return English Translation of File
	 * @throws FileNotFoundException
	 */
	public static String convertToEnglish(File codeFile) throws FileNotFoundException{
		Scanner input = new Scanner(codeFile);
		String output = "";
		while(input.hasNext()) {
			output +=convertToEnglish(input.nextLine());
		}
		return output;
	}
}
