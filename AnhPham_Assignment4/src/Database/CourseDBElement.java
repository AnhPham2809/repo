package Database;
/**
 * implements Comparable
 * @author Anh Pham
 *
 */
public class CourseDBElement implements Comparable {

	
	public String ID;
	public int crn;
	public int credits;
	public String roomNum;
	public String instructorName;
	/**
	 * Constructor that allows user to assign the credentials? idk how to spell credentials but I think this is the right word
	 * @param id
	 * @param crn
	 * @param credits
	 * @param roomNumber
	 * @param instrcutor
	 */
	public CourseDBElement(String ID, int crn, int credits, String roomNum, String instrcutorName) {
		this.ID = ID;
		this.crn = crn;
		this.credits = credits;
		this.roomNum = roomNum;
		this.instructorName = instrcutorName;
}
	public CourseDBElement() {
	
	}
		
/**
 * setCRN()
 * @param InputtedCRN
 */
 public void setCRN(int InputtedCRN) {
	 this.crn =InputtedCRN;
 }

 /**
  * getCRN()
  * @returns CRN 
  */
 
 public int getCRN() {
	 return crn;
 }
 public String getID() {
	 return this.ID;
 }
 
 public String getRoomNum() {
	 return roomNum;
 }
/**
 * toString()
 * return info of the courses 
 */
public String toString() {
			return  "\nCourse:" + ID +" CRN:" + crn +" Credits:" + credits + " Instructor:"+ instructorName + " Room:" + roomNum ;
		}
		
/**
 *hashCode()
 * @return Hashcode of the CRN
 */
public int hashCode() {
	return Integer.hashCode(crn);
}


/**
 * compareTo()
 * @param element course that neeed to be compared
 */

@Override
public int compareTo(Object o) {
	//CourseDBElement a = (CourseDBElement) o;
	return 0;
}












}


