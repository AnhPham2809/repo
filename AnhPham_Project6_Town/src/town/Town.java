package town;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Town class
 * @author Anh Pham
 *
 */
public class Town implements Comparable<Town> {

	private String name;
	int weight;
	Town previous = null;
	Set<Town> townList = new HashSet<Town>();
	
	/**
	 * Constructor
	 */
	
	public Town(String name) {
		this.name = name;
	}
	
	/**
	 * Copy Constructor
	 */
	public Town (Town templateTown) {
		this.name = templateTown.getName();
		
	}
	
	
	/**
	 * getName()
	 * @returns the town name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * compareTo()
	 * compareTo method to compare
	 */
	@Override
	public int compareTo(Town o) {
		if(o.getName().equals(name)) {
			return 0;
		}
		else {
	return this.name.compareTo(o.getName());
			}
	}
	
	/**
	 * toString()
	 * @return the town name
	 */
	public String toString() {
		return this.name;
	}
	
	/**
	 * hashCode()
	 * @returns the hashcode for the name of the town
	 */
	public int hashCode() {
		return name.hashCode();
	}
	
	/**
	 * equals()
	 * compare town names
	 * @return true if they are the same/equal, false if not
	 */
	public boolean equals(Object obj) {
		Town a = (Town)obj;
		return this.name.equals(a.getName());
	}

	
	
	/**
	 * reset()
	 * AADDED , NOT FROM INTERFACE
	 * purely used to change weight
	 */
	public void reset() {
		this.weight = Integer.MAX_VALUE;
		this.previous = null;
		
	}

}
