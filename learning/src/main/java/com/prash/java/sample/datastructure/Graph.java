/**
 * 
 */
package com.prash.java.sample.datastructure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Prashanth_Meka
 *
 */
public class Graph {
	
	public List<Vertex> vertices;
	public List<Edge> edges;

	class Vertex {
		public List<Edge> edges = new ArrayList<>();
		public String name;

		public Vertex(String name) {
			this.name = name;
		}

		@Override
		public String toString() {
			return "Vertex name=" + name ;//+ ", [edges=" + Arrays.toString(edges.toArray()) + "]";
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getOuterType().hashCode();
			result = prime * result + ((name == null) ? 0 : name.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Vertex other = (Vertex) obj;
			if (!getOuterType().equals(other.getOuterType()))
				return false;
			if (name == null) {
				if (other.name != null)
					return false;
			} else if (!name.equals(other.name))
				return false;
			return true;
		}

		private Graph getOuterType() {
			return Graph.this;
		}

	}

	class Edge {
		public Vertex from;
		public Vertex to;
		public int distance;

		public Edge(int distance, Vertex from, Vertex to) {
			this.distance = distance;
			this.from = from;
			this.to = to;
		}

		@Override
		public String toString() {
			return "Edge [from=" + from.name + ", to=" + to.name + ", distance=" + distance + "]";
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getOuterType().hashCode();
			result = prime * result + ((from == null) ? 0 : from.hashCode());
			result = prime * result + ((to == null) ? 0 : to.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Edge other = (Edge) obj;
			if (!getOuterType().equals(other.getOuterType()))
				return false;
			if (from == null) {
				if (other.from != null)
					return false;
			} else if (!(from.equals(other.from) || from.equals(other.to)))
				return false;
			if (to == null) {
				if (other.to != null)
					return false;
			} else if (!(to.equals(other.to) || to.equals(other.from)))
				return false;
			return true;
		}

		private Graph getOuterType() {
			return Graph.this;
		}

	}

	private Vertex createtVertex(String vertexName) {
		Vertex v = new Vertex(vertexName);
		return v;
	}

	private void createEdge(int distance, Vertex from, Vertex to) {
		Edge e = new Edge(distance, from, to);
		Edge e_ = new Edge(distance, to, from);
		from.edges.add(e);
		to.edges.add(e_);
	}

	private List<Vertex> getNeighbours(Vertex vertex) {
		List<Vertex> neighbours = new ArrayList<>();
		for(Edge edge: edges)	{
			if(edge.from.equals(vertex))	{
				neighbours.add(edge.to);
			}
		}
		return neighbours;
	}
	
	private List<Edge> getNeighbourEdges(Vertex vertex) {
		List<Edge> neighbours = new ArrayList<>();
		for(Edge edge: edges)	{
			if(edge.from.equals(vertex))	{
				neighbours.add(edge);
			}
		}
		return neighbours;
	}
	
	private int getDistance(Vertex node, Vertex target) {
		for (Edge edge : edges) {
			if ((edge.from.equals(node) && edge.to.equals(target))) {
				return edge.distance;
			}
		}
		throw new RuntimeException("Should not happen");
	}

	public static void main(String[] args) throws IllegalAccessException {
		Graph g = new Graph();
		Vertex a = g.createtVertex("A");
		Vertex b = g.createtVertex("B");
		Vertex c = g.createtVertex("C");
		Vertex d = g.createtVertex("D");
		Vertex e = g.createtVertex("E");
		Vertex f = g.createtVertex("F");
		List<Vertex> vertices = new ArrayList<>();
		vertices.add(a);
		vertices.add(b);
		vertices.add(c);
		vertices.add(d);
		vertices.add(e);
		vertices.add(f);
		g.createEdge(1, a, b);
		g.createEdge(2, b, c);
		g.createEdge(1, c, d);
		g.createEdge(2, d, e);
		g.createEdge(1, e, f);
		
		g.vertices = vertices;
		g.edges = vertices.stream().flatMap(v -> v.edges.stream()).collect(Collectors.toList());
		
		Vertex vertex = vertices.stream().filter(p -> p.name.equals("C")).findFirst().get();

		int cost = g.findCostTo(vertex, 0);
		System.out.println("Total Cost " + cost);
	}

	public int findCostTo(Vertex target, int cost)	{
		List<Edge> visitedSourceEdges = new ArrayList<>();
		for(Vertex v: vertices)	{
			if(v.equals(target))	{
				System.out.println("reversed");
				continue;
			}
			List<Edge> visitedEdges = new ArrayList<>();
			System.out.println("----------------------------");
			cost = findCostRecursive(v, target, cost, visitedEdges);
		}
		return cost;
	}
	
	private int findCostRecursive(Vertex source, Vertex target, int cost, List<Edge> visitedEdges)	{
		List<Edge> neighbourEdges = getNeighbourEdges(source);
		neighbourEdges.removeAll(visitedEdges);
		for(Edge e: neighbourEdges)	{
			cost += getDistance(source, e.to);
			System.out.println(source.name+" -> "+e.to.name+" cost "+cost);
			visitedEdges.add(e);
			if(e.to.equals(target))	{
				return cost;
			}
			cost = findCostRecursive(e.to, target, cost, visitedEdges);
		}
		return cost;	
	}
}
