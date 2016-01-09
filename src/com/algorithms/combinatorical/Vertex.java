package com.algorithms.riddlehopping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A Generic implementation of vertex in undirected graph
 * 
 * @author yaron
 *
 * @param <T>
 *            The value stored in the vertex
 * 
 */
public class Vertex<T> {

	// The value stored in the vertex
	protected T value;

	// The color of the vertex
	protected Color color;

	// Adjacent vertexes
	protected List<Vertex<T>> vertexes;

	// A map of all adjacent vertexes
	protected Map<T, Vertex<T>> vertexesMap;

	public Vertex(T value, Color color) {
		this.value = value;
		this.color = color;
		vertexes = new ArrayList<>();
		vertexesMap = new HashMap<>();
	}

	T getValue() {
		return value;
	}

	void setValue(T value) {
		this.value = value;
	}

	Color getColor() {
		return color;
	}

	void setColor(Color color) {
		this.color = color;
	}

	/**
	 * Adds a new vertex to the adjacent vertexes list.
	 * 
	 * @param vertex
	 *            The vertex to add
	 * @return The current vertex
	 */
	public Vertex<T> add(Vertex<T> vertex) {

		if (vertex != null) {
			vertexes.add(vertex);
			vertexesMap.put(vertex.value, vertex);
		}

		return this;
	}

	/**
	 * Returns the adjacent vertex that holds the value
	 * 
	 * @param value
	 *            Value to search
	 * @return the adjacent vertex that holds the value
	 */
	public Vertex<T> get(T value) {
		return vertexesMap.get(value);
	}

	/**
	 * Returns the list of the adjacent vertexes
	 * 
	 * @return the list of the adjacent vertexes
	 */
	public List<Vertex<T>> getAll() {
		return new ArrayList<Vertex<T>>(vertexes);
	}

	@Override
	public String toString() {

		StringBuilder sb = new StringBuilder();

		sb.append(Vertex.class.getSimpleName());
		sb.append('(');
		sb.append(value);
		sb.append(", ");
		sb.append(color.name());
		sb.append(") => [");

		if (vertexes != null) {
			for (Vertex<T> child : vertexes) {
				sb.append(' ');
				sb.append(child.value);
			}
		}

		sb.append(']');

		return sb.toString();
	}
}
