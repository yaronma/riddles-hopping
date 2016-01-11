package com.algorithms.riddlehopping;

import static org.junit.Assert.assertNotNull;

import java.util.List;

public class Main {

	public static void main(String[] args) {

		Graph<Integer> graph = new Graph<Integer>();

		// Add All the nodes
		graph.add(1, Color.Red);
		graph.add(2, Color.Red);
		graph.add(3, Color.Blue);
		graph.add(4, Color.Blue);
		graph.add(5, Color.Blue);
		graph.add(6, Color.Red);
		graph.add(7, Color.Red);
		graph.add(8, Color.Red);
		graph.add(9, Color.Red);
		graph.add(10, Color.Blue);
		graph.add(11, Color.Blue);
		graph.add(12, Color.Blue);
		graph.add(13, Color.Red);
		graph.add(14, Color.Blue);
		graph.add(15, Color.Red);
		graph.add(16, Color.Blue);
		graph.add(17, Color.Red);
		graph.add(18, Color.Red);
		graph.add(19, Color.Red);
		graph.add(20, Color.Blue);
		graph.add(21, Color.Blue);
		graph.add(22, Color.Red);
		graph.add(23, Color.Red);

		// The list of the edges. This is a list of pairs of numbers
		// representing the two vertexes of each edge.
		// (The first edge connect vertexes holding values 1 & 2, the second
		// edge connecting 1 & 3, etc.)
		Integer[] edges = new Integer[] { 1, 2, 1, 3, 2, 3, 2, 4, 2, 6, 2, 9, 3, 5, 3, 7, 4, 5, 4, 6, 4, 8, 4, 9, 5, 6,
				5, 7, 5, 8, 6, 8, 6, 9, 7, 10, 8, 10, 8, 11, 8, 12, 9, 11, 9, 15, 9, 16, 10, 11, 10, 12, 11, 12, 11, 15,
				12, 13, 13, 14, 14, 15, 14, 17, 14, 18, 15, 16, 15, 17, 15, 18, 16, 19, 16, 22, 17, 18, 17, 19, 17, 20,
				17, 22, 18, 20, 18, 21, 19, 20, 19, 22, 20, 21, 20, 22, 21, 22, 21, 23, 22, 23 };

		// Add all the edges. If two edges has the same color, ignore it
		for (int i = 0; i < edges.length; i += 2) {

			Integer integer1 = edges[i];
			Vertex<Integer> node1 = graph.get(integer1);
			assertNotNull(node1);

			Integer integer2 = edges[i + 1];
			Vertex<Integer> node2 = graph.get(integer2);
			assertNotNull(node2);

			// For performance reasons, we remove edges that connect
			// the same colors since we cannot traverse between those vertexes
			if (node1.getColor().equals(node2.getColor())) {
				continue;
			}

			node1.add(node2);
			node2.add(node1);
		}

		Integer from = 1;
		Integer to = 23;

		List<List<Integer>> result = graph.getPaths(from, to);

		if (result == null) {
			System.out.println("There are no paths between " + from + " to " + to);
			return;
		}

		System.out.println("There are " + result.size() + " different paths");

		System.out.print("Shortest path is: ");
		System.out.print(shortest.size());
		System.out.print(" => ");
		System.out.println(shortest);
		
		System.out.print("Longest path is: ");
		System.out.print(longest.size());
		System.out.print(" => ");
		System.out.println(longest);
		
		/*
		// For Java 8 Enthusiasts - use the following code instead
		System.out.print("Shortest path is: ");
		System.out.println(result.stream().map(List::size).min(Integer::compare).get());

		System.out.print("Longest path is: ");
		System.out.println(result.stream().map(List::size).max(Integer::compare).get());

		System.out.println(result);
		*/
	}

}
