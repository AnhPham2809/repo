package town;

/**
 * Road class
 * @author Anh Pham
 *
 */
public class Road implements Comparable<Road> {
	String name; //name
	 Town source; //start - town 1
	 Town destination; //end - town 2
	int weight; //distance
	
	/**
	 * Constructor (Base)
	 */
	
	public Road(Town source, Town destination, int degrees, String name) {
		this.source = source;
		this.destination = destination;
		this.weight = degrees;
		this.name = name;
	}
	/**
	 * Constructor with weight preset at 1
	 */
	public Road(Town source, Town destination, String name) {
		this.source = source;
		this.destination = destination;
		this.weight = 1;
		this.name = name;
	}
	

	
	/**
	 * contains()
	 * @param town - Vertex
	 * @return true if edge is connected to vertex
	 */
	public boolean contains(Town town) {
		if(source.equals(town) || destination.equals(town)) {
			return true;
		}
		else {
		return false;
	}
	}
	
	
	/**
	 * toString()
	 */
	public String toString() {
		return name + " connects " + source.getName() + " and " + destination.getName() + "and is" + weight + " miles long";
	}
	
	/**
	 * getName()
	 * @return the road name
	 */
	public String getName() {
		return this.name;
	}
	/**
	 * getDestination()
	 * @return destination (town 2)
	 */
	public Town getDestination() {
		return this.destination;
	}
	
	/**
	 * getSource()
	 * @return source (town 1)
	 */
	public Town getSource() {
		return this.source;
	}
	
	/**
	 * compareTo()
	 * @return 0 if the road name are the same, a pos/neg number if its not
	 */
	@Override
	public int compareTo(Road o) {
		return this.name.compareTo(o.getName());
	}
	
	/**
	 * getWeight()
	 * @return the distance/weight of the road
	 */
	public int getWeight() {
		return this.weight;
	}

	/**
	 * equals()
	 * @param r - Road
	 * @return true if the end of road r is the same as the end of the current road. 
	 */
	
	public boolean equals(Object r) {
			if(!(r instanceof Road)) {
				return false;
			}
		String begin = ((Road) r).getSource().getName(); // get name of starting location
		String ending = ((Road) r).getDestination().getName(); //same but destination
		if((source.getName().contentEquals(begin) ||source.getName().equals(ending)
				&&(destination.getName().equals(begin) ||destination.getName().equals(ending)))){
			return true;
		}
		else {
		
		return false;
	}
}}
