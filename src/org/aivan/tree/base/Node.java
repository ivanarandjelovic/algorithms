package org.aivan.tree.base;

/**
 * Basic implementation of tree node
 * 
 * @author aivan
 *
 * @param <T>
 */
public class Node<T> {
	public T value = null;

	public Node<T> parent;
	public Node<T> left;
	public Node<T> right;

	public int leftCount = 0;
	public int rightCount = 0;

}
