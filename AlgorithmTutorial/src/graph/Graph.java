package graph;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;

public class Graph {
	private Set<Vertex> vertices;
	private Set<Edge> edges;
	private Map<Vertex, Set<Edge>> adjList;

	public Graph() {
		this.vertices = new HashSet<Vertex>();
		this.edges = new HashSet<Edge>();
		this.adjList = new HashMap<Vertex, Set<Edge>>();
	}

	public boolean addVertex(int value) {
		return this.vertices.add(new Vertex(value));
	}

	public boolean addVertex(Vertex vertex) {
		return this.vertices.add(vertex);
	}

	public boolean addVertices(Collection<Vertex> vertices) {
		return this.vertices.addAll(vertices);
	}

	public boolean removeVertex(int value) {
		return this.vertices.remove(new Vertex(value));
	}

	public boolean removeVertex(Vertex vertex) {
		return this.vertices.remove(vertex);
	}

	public boolean addEdge(Edge e) {
		if (!edges.add(e))
			return false;
		this.adjList.putIfAbsent(e.getV1(), new HashSet<Edge>());
		this.adjList.putIfAbsent(e.getV2(), new HashSet<Edge>());

		this.adjList.get(e.getV1()).add(e);
		this.adjList.get(e.getV2()).add(e);
		return true;
	}

	public boolean addEdge(int value1, int value2) {
		return this.addEdge(new Edge(new Vertex(value1), new Vertex(value2)));
	}

	public boolean removeEdge(Edge e) {
		if (!this.edges.remove(e))
			return false;
		Set<Edge> edgesOfV1 = this.adjList.get(e.getV1());
		Set<Edge> edgesOfV2 = this.adjList.get(e.getV2());

		if (edgesOfV1 != null)
			edgesOfV1.remove(e);
		if (edgesOfV2 != null)
			edgesOfV2.remove(e);
		return true;
	}

	public boolean removeEdge(int value1, int value2) {
		return this.removeEdge(new Edge(new Vertex(value1), new Vertex(value2)));
	}

	public Set<Vertex> getVertices() {
		return Collections.unmodifiableSet(this.vertices);

	}

	public void setVertices(Set<Vertex> vertices) {
		this.vertices = vertices;
	}

	public Set<Edge> getEdges() {
		return Collections.unmodifiableSet(this.edges);
	}

	public void setEdges(Set<Edge> edges) {
		this.edges = edges;
	}

	public Map<Vertex, Set<Edge>> getAdjList() {
		return Collections.unmodifiableMap(this.adjList);
	}

	public void setAdjList(Map<Vertex, Set<Edge>> adjList) {
		this.adjList = adjList;
	}

	public Set<Vertex> getAllAdjVertices(Vertex v) {
		return this.adjList.get(v).stream().map(e -> e.getV1().equals(v) ? e.getV2() : e.getV1())
				.collect(Collectors.toSet());
	}

	public void unVistiAllVertices() {
		for (Vertex v : this.getVertices()) {
			v.setVisited(false);
		}
	}

	public void applyDFS(Vertex node) {
		this.unVistiAllVertices();
		this.dfs(node);
	}

	public void dfs(Vertex node) {
		System.out.println(node.getData());
		Set<Vertex> adjacentVertices = this.getAllAdjVertices(node);
		node.setVisited(true);
		for (Vertex vertex : adjacentVertices) {
			if (vertex != null && !vertex.isVisited()) {
				dfs(vertex);
			}
		}
	}

	public void applyBFS(Vertex node) {
		this.unVistiAllVertices();
		this.bFS(node);
	}

	public void bFS(Vertex node) {
		Queue<Vertex> queue = new LinkedList<Vertex>();
		node.setVisited(true);
		queue.add(node);

		while (!queue.isEmpty()) {

			Vertex v = queue.poll();
			System.out.println(v.getData());
			for (Vertex vertex : this.getAllAdjVertices(v)) {
				if (vertex != null && !vertex.isVisited()) {

					vertex.setVisited(true);
					queue.add(vertex);
				}
			}

		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
