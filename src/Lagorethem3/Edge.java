package Lagorethem3;

public class Edge {
	 Vertex destination;
	    int cost;
	    int time; 
	    int dectance;
	
	    public Edge(Vertex destination, int cost, int time,int dectance) {
	    	this.dectance=dectance;
	        this.destination = destination;
	        this.cost = cost;
	        this.time = time;
	    }
	    int data;

	    @Override
	    public String toString() {
	        return "To: " + destination+"  ,dectance " +dectance+ ", Cost: " + cost + ", Time: " + time;
	    }

}
