package org.aivan.tree.base;

import java.util.List;

public interface Tree<T> {

	/**
	 * Add an element into the three
	 * 
	 * @param element
	 */
	public void add(T element);

/**
 * Remove an element from the three
 * @param element
 * @return true if element was found and removed
 */
	public boolean delete(T element);

	/**
	 * Get all elements from the three
	 * @return
	 */
	public List<T> getAll();
	
}
