package Lagorethem3;

import java.util.ArrayList;
import java.util.Objects;

public class Vertex  implements Comparable<Vertex>{
	  String name; 
	  double x;
	  double y;
	  ArrayList<Edge> edges; 
	    public Vertex(String name) {
	        this.name = name;
	        this.edges = new ArrayList<>();
	    }
	    public void addEdge(Vertex destination, int cost, int time,int dectance) {
	        edges.add(new Edge(destination, cost, time,dectance));
	    }

	    @Override
		public int hashCode() {
			return Math.abs(Objects.hash(name.toLowerCase()));
		}
		
		@Override
	    public String toString() {
	        return name ;
	    }
		@Override
		public int compareTo(Vertex o) {
			return this.name.toLowerCase().compareTo(o.name.toLowerCase());
		}
}
