package town;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.Comparator;
/**
 * 
 * @author Anh
 *
 */
public class Graph implements GraphInterface<Town, Road>{

	
	private Set<Town> townList = new HashSet<Town>();
	private Set<Road> roadList = new HashSet<Road>();
	Map<Town, Town> previousNode = new HashMap<>();
	protected Set<Town> checked;
	protected Set<Town> unchecked;
	
/**
 * getEdge()
 * @return an edge that is connecting between source and destination vertexes
 */
	@Override
	public Road getEdge(Town sourceVertex, Town destinationVertex) {
		Road r = null;
		
		for(Road a: roadList) {
			
			if(a.contains(sourceVertex)==false || a.contains(destinationVertex)==false) {
				continue;
			}
			
			r = a;
			break;
		}
		
		return r;
	}
	
	
	/**
	 * addEdge()
	 * Creates an edge from source to destination vertex
	 * @reutrn the edge
	 */
	@Override
	public Road addEdge(Town sourceVertex, Town destinationVertex, int weight, String description) {
		if(sourceVertex == null || destinationVertex==null) {
			throw new NullPointerException();
		}
		if(this.containsVertex(sourceVertex)==false || this.containsVertex(destinationVertex)==false) {
			throw new IllegalArgumentException();
		}
		
		sourceVertex.townList.add(destinationVertex);
		destinationVertex.townList.add(sourceVertex);
		Road r = new Road(sourceVertex, destinationVertex, weight, description);
		
		this.roadList.add(r);
		return r;
	}
	
	/**
	 * addVertex()
	 * add a vertex if theres none
	 */
	@Override
	public boolean addVertex(Town v) {
		if(this.townList.contains(v))
		{
			return false;
		}
		this.townList.add(v);
		return true;
	}
	@Override
	public boolean containsEdge(Town sourceVertex, Town destinationVertex) {
		 if(this.getEdge(sourceVertex, destinationVertex) != null) {
			 return true;
		 }
		 else {
			 return false;
		 }
	}
	/**
	 * containsVertex()
	 * Checks if there is a vertex on the graph
	 */
	@Override
	public boolean containsVertex(Town v) {
		boolean r = false;
		
		for(Town a : this.townList) {
			if(v.equals(a)) {
				r = true;
				break;
			}
		}
		
		return r;
	}
	/**
	 * edgeSet()
	 * get all the edges of the graph
	 */
	@Override
	public Set<Road> edgeSet() {
	
		return this.roadList;
	}
	
	/*8
	 * edgesOf()
	 * Get all the edges/roads in the town
	 */
	@Override
	public Set<Road> edgesOf(Town vertex) {
		Set<Road> r = new HashSet<Road>();
				
				for(Road a : this.roadList) {
					if(!a.contains(vertex))
					{
						continue;
					}
					r.add(a);
				}
				return r;
	}
	
	/**
	 * removeEdge()
	 * remove an edge
	 * @return road
	 */
	@Override
	public Road removeEdge(Town sourceVertex, Town destinationVertex, int weight, String description) {
		Road r = null;
		
		for(Road a : this.roadList) {
			if(a.contains(sourceVertex)==false || a.contains(destinationVertex)== false) {
				continue;
			}
			if(weight > -1 && a.weight != weight) {
				continue;
			}
			
			if(description != null && a.name.toLowerCase().equals(description.toLowerCase()) == false) {
				continue;
			}
			
			sourceVertex.townList.remove(destinationVertex);
			destinationVertex.townList.remove(sourceVertex);
			this.roadList.remove(r);
			r=a;
			break;
			
		}
		return r;
	}
	
	
	/**
	 * removeVertex()
	 * remove vertex
	 */
	@Override
	public boolean removeVertex(Town v) {
		if(v==null) {
			return false;
		}
		if(this.townList.contains(v) == false) {
			return false;
		}
		
		for(Road a : this.edgesOf(v)) {
			this.removeEdge(a.source, a.destination, a.weight, a.name);
		}
		return this.townList.remove(v);
	}
	/**
	 * vertexSet()
	 * @return all vertexes from the graph
	 */
	@Override
	public Set<Town> vertexSet() {
	return this.townList;
	}
	/**
	 * shortestPath()
	 * Calculate the shortest path between two towns
	 */
	@Override
	public ArrayList<String> shortestPath(Town sourceVertex, Town destinationVertex) {
	
		ArrayList<String> path = new ArrayList<String>();
		String edgeName;
		String firstPath = "";
		this.dijkstraShortestPath(sourceVertex);
		Town thisTown = destinationVertex;
		Town beforeTown = previousNode.get(destinationVertex);

		while(thisTown.compareTo(sourceVertex)!=0) {
			edgeName = getEdge(thisTown, beforeTown).getName();
			firstPath = beforeTown.getName()+ " via " + edgeName + " to " + thisTown.getName() + " " + getEdge(thisTown, beforeTown).getWeight()+" mi";
			path.add(0, firstPath);
			thisTown = beforeTown;
			beforeTown = previousNode.get(thisTown);
		}
		return path;
	}
	



	@Override
	public void dijkstraShortestPath(Town sourceVertex) {
		boolean found = true;
		Town shortest = null;
		int shortDistance = Integer.MAX_VALUE;
		
		for(Town visit:this.checked) {
			Set<Town> a = visit.townList;
			Set<Town> b = new HashSet<Town>();
		
		
		for(Town t: a) {
			if(unchecked.contains(t)==false) {
				continue;
			}
			
			b.add(t);
		}
		for(Town t : b) {
			int weight = this.weightCalculate(t, visit, sourceVertex);
			if(weight < shortDistance) {
				shortDistance = weight;
				shortest = t;
				t.previous=visit;
			}
		}
	}
if(shortest != null) {
	found = false;
	shortest.weight = shortDistance;
	checked.add(shortest);
	unchecked.remove(shortest);
}
	}

/**
 * Calculate the weight
 * @param t
 * @param visit
 * @param sourceVertex
 * @return
 */
	private int weightCalculate(Town t, Town visit, Town sourceVertex) {
		return t.equals(sourceVertex) ? 0: visit.weight + this.getEdge(visit, t).weight;
	}

}