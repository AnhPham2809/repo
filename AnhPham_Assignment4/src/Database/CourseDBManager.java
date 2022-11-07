package Database;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * CourseDBManager
 * @author AnhPham
 *
 */
public class CourseDBManager implements CourseDBManagerInterface {

	CourseDBStructure structure = new CourseDBStructure(20);
	
	
	/**
	 * add()
	 * Creates a CDE to add to the Hash Table
	 */
	@Override
	public void add(String id, int crn, int credits, String roomNum, String instructor) {
		CourseDBElement cde = new CourseDBElement(id, crn, credits, roomNum, instructor);
		structure.add(cde);
	}

	@Override
	public CourseDBElement get(int crn) throws IOException {
		try {
			return structure.get(crn);
		}
		catch(IOException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	@Override
	public void readFile(File input) throws FileNotFoundException {

		Scanner reader = new Scanner(input);
		CourseDBElement cde;
		int credits;
		int crn;
		String courses;
		String[] course = new String[5];
		while(reader.hasNextLine()) {
			courses=reader.nextLine();
			course = courses.split(" ", 5);
			crn = Integer.parseInt(course[1]);
			credits = Integer.parseInt(course[2]);
			cde = new CourseDBElement(course[0], crn, credits, course[3], course[4]);
			structure.add(cde);
		}
	}

	@Override
	public ArrayList<String> showAll() {
		return structure.showAll();
	}

}
