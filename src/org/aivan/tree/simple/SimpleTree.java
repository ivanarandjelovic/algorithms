package org.aivan.tree.simple;

import java.util.LinkedList;
import java.util.List;

import org.aivan.tree.base.Node;
import org.aivan.tree.base.Tree;

/**
 * Simple unordered tree of any elements
 * 
 * @author aivan
 *
 * @param <T>
 */
public class SimpleTree<T> implements Tree<T> {

	Node<T> root = null;

	@Override
	public void add(T element) {
		if (root == null) {
			root = new Node<T>();
			root.value = element;
		} else {
			add(root, element);
		}

	}

	private void add(Node<T> node, T element) {
		if (node.leftCount <= node.rightCount) {
			addLeft(node, element);
			node.leftCount++;
		} else {
			addRight(node, element);
			node.rightCount++;
		}
	}

	private void addLeft(Node<T> parent, T element) {
		if (parent.left == null) {
			Node<T> node = new Node<T>();
			node.value = element;
			node.parent = parent;
			parent.left = node;
		} else {
			add(parent.left, element);
		}
	}

	private void addRight(Node<T> parent, T element) {
		if (parent.right == null) {
			Node<T> node = new Node<T>();
			node.value = element;
			node.parent = parent;
			parent.right = node;
		} else {
			add(parent.right, element);
		}
	}

	@Override
	public boolean delete(T element) {
		return delete(root, element);
	}

	private boolean delete(Node<T> node, T element) {
		if (node == null) {
			// Nothing to delete here, we hit the leaf
			return false;
		}
		if (node.value.equals(element)) {
			// we found it in current node, now delete it:
			if (node.left == null && node.right == null) {
				// no childrent, simply kill this node
				if (node.parent != null) {
					// this is not root
					if (node.parent.left == node) {
						// We are left child:
						node.parent.left = null;
					} else {
						// We are right child:
						node.parent.right = null;
					}
				} else {
					// this is root node
					root = null;
				}
			} else if (node.left != null) {
				// replace this node with left child:
				if (node.parent.left == node) {
					node.parent.left = node.left;
				} else {
					node.parent.right = node.left;
				}
			} else {
				// replace this node with right child:
				if (node.parent.left == node) {
					node.parent.left = node.right;
				} else {
					node.parent.right = node.right;
				}
			}
			return true;
		} else {
			// Must be in one of the children:
			boolean deletedLeft = delete(node.left, element);
			if (!deletedLeft) {
				boolean deletedRight = delete(node.right, element);
				if (deletedRight) {
					node.rightCount--;
					return true;
				}
				return false;
			} else {
				node.leftCount--;
				return true;
			}
		}

	}

	@Override
	public List<T> getAll() {
		List<T> result = new LinkedList<T>();
		traverseInOrder(root, result);
		return result;
	}

	private void traverseInOrder(Node<T> node, List<T> result) {
		if (node != null) {
			traverseInOrder(node.left, result);
			result.add(node.value);
			traverseInOrder(node.right, result);
		} else {
			return;
		}
	}
	
	public Node<T> getRoot() {
		return root;
	}

}
