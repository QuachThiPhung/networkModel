package sample.Algorithm.Element;

import java.util.ArrayList;
import java.util.List;

public class Graph {
	private List<Vertex> vList = new ArrayList<>();
	private List<Edge> eList = new ArrayList<>();
	private int vCount = 0;
	private int eCount = 0;
	private int totalDegree = 0;

	public void addVertex(Vertex v) {
		vList.add(v);
	}

	public void addEdge(Edge e) {
		eList.add(e);
	}

	public void resetGraph() {
		vList.clear();
		eList.clear();
		vCount = 0;
		eCount = 0;
	}

	public Graph(int vCount) {
		this.vCount = vCount;
	}

	public int getVCount() {
		return vCount;
	}

	public int getECount() {
		return eCount;
	}

	public void setECount(int n) {
		eCount = n;
	}

	public int getTotalDegree() {
		return totalDegree;
	}

	public List<Vertex> getVList() {
		return vList;
	}

	public List<Edge> getEList() {
		return eList;
	}
}