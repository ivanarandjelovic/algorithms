package org.aivan.graph.base;

import java.util.List;
import java.util.LinkedList;

public class Vertex {

	public String value;
	
	public List<Vertex> edges = new LinkedList<Vertex>();

	public Vertex(String value) {
		this.value = value;
	}
}