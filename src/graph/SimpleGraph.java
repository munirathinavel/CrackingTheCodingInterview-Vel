package graph;

import java.util.LinkedList;

public class SimpleGraph {

	void addEdge(MyGraph graph, int src, int dest) {
		graph.adjacency[src].addFirst(dest);
		graph.adjacency[dest].addFirst(src);
	}

	void printGraph(MyGraph graph) {
		for (int i = 0; i < graph.v; i++) {
			System.out.println("Adjacency Matrix:" + i);
			LinkedList<Integer> list = graph.adjacency[i];
			System.out.print("head");
			for (int j : list) {
				System.out.print("->" + j);
			}
			System.out.println("\n");
		}
	}
}
