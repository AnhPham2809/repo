package Database;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class CourseDBStructure implements CourseDBStructureInterface{
	
	final float LOAD_FACTOR = 1.5f;
	
    protected LinkedList<CourseDBElement>[] hashTable;
    protected int hashSize;
	
	protected int size;
	
	/**
	 * Constructors that create new Linked List
	 * @param int i
	 */
	public CourseDBStructure(int size) {
		hashTable = new LinkedList[findPrime(size)];
		/*
		 * hashTable = new LinkedList[size]; for (int j = 0; j <size; j++) {
		 * hashTable[j] = new LinkedList<CourseDBElement>(); }
		 */
		}
	/**
	 * //Testing purposes
	 * @param test
	 * @param i
	 */
	public CourseDBStructure(String testingPurposes, int size) { 
		hashTable = new LinkedList[size];
	}
	
	private int findPrime(int size) {
		size /= LOAD_FACTOR;
		
		for(int k = 0; true; k++) {
			int num = 4 * k + 3;
			if (num > size && isPrime(num))
				return num;
		}
	}
	
	private boolean isPrime(int num)
	{
		if (num == 1 || num == 2)
			return true;
		
		for(int i = 3; i < Math.sqrt(num); i+=2)
			if (num % i == 0)
				return false;
		
		return true;
	}
	
	/** 
	* Adds a CourseDBElement object to the CourseDBStructure using the hashcode
	* of the CourseDatabaseElement object's crn value.
	* If the CourseDatabaseElement already exists, exit quietly
	*  
	* @param element the CourseDBElement to be added to CourseDBStructure
	*/
	@Override
	public void add(CourseDBElement element) {
		int hash = element.hashCode() % hashTable.length;
		
		if (hashTable[hash] == null)
		{
			LinkedList<CourseDBElement> newList = new LinkedList<CourseDBElement>();
			newList.add(element);
			hashTable[hash] = newList;
			return;
		}
		
		hashTable[hash].add(0, element);
	}
	/**
	 * Find a courseDatabaseElement based on the key (crn) of the
	 * courseDatabaseElement If the CourseDatabaseElement is found return it If not,
	 * throw an IOException
	 * 
	 * @param crn crn (key) whose associated courseDatabaseElement is to be returned
	 * @return a CourseDBElement whose crn is mapped to the key
	 * @throws IOException if key is not found
	 */
	@Override
	public CourseDBElement get(int crn) throws IOException{
		int key = Integer.hashCode(crn) % hashTable.length;
		
		if (hashTable[key] == null)
			throw new IOException();
		
		return hashTable[key].get(0);

		
	}
	
	
	
	
	
	/**
	 * @return an array list of string representation of each course in 
	 * the data structure separated by a new line. 
	 * Refer to the following example:
	 * Course:CMSC500 CRN:39999 Credits:4 Instructor:Nobody InParticular Room:SC100
	 * Course:CMSC600 CRN:4000 Credits:4 Instructor:Somebody Room:SC200
	 */
	
	@Override
	public ArrayList<String> showAll() {
		ArrayList<String> info = new ArrayList<String>();
		
		for(int i = 0; i < hashTable.length; i++)
			if (hashTable[i] != null)
				info.add(hashTable[i].get(0).toString());
		
		/*
		 * for(int i =0; i <hashTable.length; i++) {
		 * 
		 * while(hashTable[i] != null) {
		 * 
		 * for(int j=0; j < hashTable[i].size(); j++) { CourseDBElement element =
		 * (CourseDBElement) hashTable[i].get(j); info.add("\n" + element.toString()); }
		 * break; } }
		 */
		return info;
	}

	/**
	 * getTableSize()
	 *@return the hash table size
	 */
	@Override
	public int getTableSize() {
		return hashTable.length;
	}

}
