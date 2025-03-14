package Lagorethem3;

import java.util.Objects;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

public class Dijekstra_Table implements Comparable<Dijekstra_Table> {
	
	@Override
	public String toString() {
		return "Dijekstra_Table [vertex=" + vertex + ", Known=" + Known + ", data=" + data + ", prev=" + prev + "]";
	}
	Vertex vertex;
	boolean Known;
	int data;
	Vertex prev;

	
	
	int cost=0;
	int dectance=0;
	int time=0;

	
	
	
	
	public Vertex getVertex() {
		return vertex;
	}
	public void setVertex(Vertex vertex) {
		this.vertex = vertex;
	}
	
	public boolean getKnown() {
		return Known;
	}
	public void setKnown(boolean known) {
		Known = known;
	}
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public Vertex getPrev() {
		return prev;
	}
	public void setPrev(Vertex prev) {
		this.prev = prev;
	}

	  @Override
			public int hashCode() {
				return Math.abs(Objects.hash(vertex.name.toLowerCase()));
			}
	@Override
	public int compareTo(Dijekstra_Table o) {
		// TODO Auto-generated method stub
		return this.vertex.name.toLowerCase().compareTo(o.vertex.name.toLowerCase());
		
	}
			
			
	
	
	
	
	
	
	
	
	
	
}
