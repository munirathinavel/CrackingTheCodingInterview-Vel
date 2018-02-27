package graph;

public class SimpleGraphTest {

	public static void main(String[] args) {
		MyGraph graph = new MyGraph(5);
		SimpleGraph g = new SimpleGraph();
		g.addEdge(graph, 0, 1);
		g.addEdge(graph, 0, 4);
		g.addEdge(graph, 1, 2);
		g.addEdge(graph, 1, 3);
		g.addEdge(graph, 1, 4);
		g.addEdge(graph, 2, 3);
		g.addEdge(graph, 3, 4);

		g.printGraph(graph);

	}
}
