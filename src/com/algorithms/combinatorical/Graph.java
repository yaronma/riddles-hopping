package com.algorithms.riddlehopping;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.stream.Collectors;

public class Graph<T> {

	protected Map<T, Vertex<T>> vertextes;

	public Graph() {
		vertextes = new HashMap<T, Vertex<T>>();
	}

	/**
	 * Add a value (list of symbols) to the graph.
	 * 
	 * @param value
	 *            The value (list of symbols) to store in the graph.
	 */
	public void add(T value, Color color) {

		// First check if the vertex is in our tree
		Vertex<T> vertex = vertextes.get(value);

		if (vertex != null) {
			return;
		}

		vertex = new Vertex<T>(value, color);

		vertextes.put(value, vertex);
	}

	/**
	 * Returns the vertex in the graph with the specified value
	 * 
	 * @param value
	 *            The value to search
	 * @return the vertex with in the graph the specified value
	 */
	public Vertex<T> get(T value) {
		return vertextes.get(value);
	}

	/**
	 * Returns all the paths between two vertexes in an undirected graph.
	 * <p>
	 * This method is implemented without using recursion.
	 * 
	 * @param from
	 *            The Source vertex
	 * @param to
	 *            The destination vertex
	 * @return A List of Lists. Each list contains the path from the source
	 *         vertex to the destination vertex
	 */
	public List<List<T>> getPaths(T from, T to) {

		if (from == null || to == null || get(from) == null || get(to) == null) {
			return Collections.emptyList();
		}

		// Since we want to skip recursion, we need to maintain a visited
		// vertex indication for all the vertexes in the stack
		Map<T, List<Vertex<T>>> visited = new HashMap<>();

		Vertex<T> vertex = get(from);
		
		// stack holds the current path
		Stack<Vertex<T>> stack = new Stack<>();
		
		// Put the source vertex
		stack.push(vertex);
		
		List<List<T>> result = new ArrayList<List<T>>();

		while (!stack.isEmpty()) {

			vertex = stack.pop();

			// If this is the first time we handle this node, add the adjacent
			// vertexes list
			List<Vertex<T>> visits = visited.get(vertex.getValue());
			if (visits == null) {
				visits = new ArrayList<Vertex<T>>();
				visited.put(vertex.getValue(), visits);
			}

			// Check that we reach the 'to' node
			if (to.equals(vertex.getValue())) {
				List<T> path = stack.stream().map(Vertex::getValue).collect(Collectors.toList());
				path.add(to); // Since we pop'ed the last element
				result.add(path);
				continue;
			}

			// Check which adjacent vertex we have to check next
			for (Vertex<T> edge : vertex.getAll()) {

				// If we have already checked this vertex
				if (visits.contains(edge)) {
					continue;
				}

				// Did we visit this node in our current path? (Avoid loops)
				if (stack.contains(edge)) {
					continue;
				}

				// We have more siblings to traverse
				visits.add(edge);
				stack.push(vertex);
				stack.push(edge);
				break;
			}

			// We completed handling this node. Remove the visited indication
			if (!stack.contains(vertex)) {
				visited.remove(vertex.getValue());
			}
		}

		return result;
	}
}
