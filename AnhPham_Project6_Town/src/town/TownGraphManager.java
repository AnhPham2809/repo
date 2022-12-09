package town;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Set;

public class TownGraphManager implements TownGraphManagerInterface {
	Graph graph;
	/**
	 * Constructor
	 */
	public TownGraphManager() {
		graph = new Graph();
	}
	
	/**
	 * addRoad()
	 * add road to the graph
	 */
	@Override
	public boolean addRoad(String town1, String town2, int weight, String roadName) {
		Town source = this.getTown(town1);
		Town destination = this.getTown(town2);
		
		if(source == null || destination == null) {
			return false;
		}
		if(this.graph.containsEdge(source, destination) == false) {
			this.graph.addEdge(source, destination, weight, roadName);
		}
		
		return true;
	}
/**
 * getRoad()
 * Road that connect from source to destination
 */
	@Override
	public String getRoad(String town1, String town2) {
		Road r = this.graph.getEdge(new Town(town1), new Town(town2));
		
		
		return r == null ? "" : r.getName();
	}
/**
 * addTown()
 * Add Town to Graph
 */
	@Override
	public boolean addTown(String v) {
		return this.graph.addVertex(new Town(v));
	}
/**
 * getTown()
 * Get the Town
 */
	@Override
	public Town getTown(String name) {
		Set<Town> townList = this.graph.vertexSet();
		Town r = null;
		for(Town t: townList) {
			if (t.getName().equals(name) == false) {
				continue;
			}
			
			r = t;
			break;
		}
		
		
		return r;
	}
	
	/**
	 * containsTown()
	 * Check if the town exists
	 */
	@Override
	public boolean containsTown(String v) {
	
		return this.getTown(v)  == null ? false : true;
	}
/**
 * containsRoadConnection()
 * Get the Road between two towns
 */
	@Override
	public boolean containsRoadConnection(String town1, String town2) {
		return this.graph.containsEdge(this.getTown(town1), this.getTown(town2));
	}

	/**
	 * allRoads()
	 * Get the Road List
	 */
	@Override
	public ArrayList<String> allRoads() {
		ArrayList<String> r = new ArrayList<String>();
		Set<Road> roadList = this.graph.edgeSet();
		
		for (Road a : roadList) {
			r.add(a.toString());
		}
		
		Collections.sort(r, new Comparator<String>(){

			@Override
			public int compare(String a0, String a1) {
				
				return Collator.getInstance().compare(a0, a1);
			}
			
		});
		return r;
	}

	/**
	 * deleteRoadConnection()
	 * remove road connection betwen two towns
	 */
	@Override
	public boolean deleteRoadConnection(String town1, String town2, String road) {
		return this.graph.removeEdge(this.getTown(town1), this.getTown(town2), -1, road) == null ? false : true;
	}

	/**
	 * deleteTown()
	 * Remove the Town 
	 */
	@Override
	public boolean deleteTown(String v) {

		return this.graph.removeVertex(this.getTown(v));
	}
/**
 * allTowns()
 * Get the Town List
 */
	@Override
	public ArrayList<String> allTowns() {
		ArrayList<String> r = new ArrayList<String>();
		Set<Town> townList = graph.vertexSet();
		
		for(Town t : townList) {
			r.add(t.toString());
		}
		
		Collections.sort(r, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				
				return Collator.getInstance().compare(o1, o2);
			}
			
		});
		
		
		return r;
	}

	
	/**
	 * getPath()
	 * Calculate the shortest path to town
	 */
	@Override
	public ArrayList<String> getPath(String town1, String town2) {
		return this.graph.shortestPath(this.getTown(town1), this.getTown(town2));
	}

}
