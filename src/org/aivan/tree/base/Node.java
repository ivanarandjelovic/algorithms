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

	/**
	 * If the value is inserted many times here we keep count of them
	 */
	public int count = 0;

	public Node<T> parent;
	public Node<T> left;
	public Node<T> right;

	public int leftCount = 0;
	public int rightCount = 0;

	/**
	 * Node's level
	 */
	public int level = 0;

	/**
	 * Maximum height of the tree including this node (0 - no children, only this
	 * node)
	 */
	public int height = 0;

	@Override
	public String toString() {
		return String.format("Prn: %s, Val: %s, Cnt: %d, Lvl: %d, Hih: %d, lCount: %d, rCount: %d",
		    (this.parent != null ? parent.value : "nil"), value, count, level, height, leftCount, rightCount);
	}

}
