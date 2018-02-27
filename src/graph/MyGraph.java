package graph;

import java.util.LinkedList;

class MyGraph {
	int v;
	LinkedList<Integer> adjacency[];

	MyGraph(int v) {
		this.v = v;
		adjacency = new LinkedList[v];

		for (int i = 0; i < v; i++) {
			adjacency[i] = new LinkedList<>();
		}
	}
}