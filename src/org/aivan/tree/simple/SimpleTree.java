package org.aivan.tree.simple;

import java.util.LinkedList;
import java.util.List;

import org.aivan.tree.base.Node;
import org.aivan.tree.base.Tree;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Simple unordered tree of any elements
 * 
 * @author aivan
 *
 * @param <T>
 */
public class SimpleTree<T extends Comparable<T>> implements Tree<T> {

	public static final Logger log = LogManager.getLogger(SimpleTree.class);

	protected Node<T> root = null;

	int counter = 0;

	@Override
	public void add(T element) {
		counter++;
		if (root == null) {
			root = createNewNode(null, element, 1);
		} else {
			add(root, element);
		}

		// if(counter % 1000 == 0) {
		// log.debug("added "+counter+" elements into the tree");
		// }

	}

	protected void add(Node<T> node, T element) {
		add(node, element, 1);
	}

	/**
	 * returun value tells us if the node was really added or existing node's
	 * count was only incremented.
	 * 
	 * @param node
	 * @param element
	 * @param elementCount
	 * @return
	 */
	protected boolean add(Node<T> node, T element, int elementCount) {
		boolean result = false;
		if (element.compareTo(node.value) == 0) {
			// These are same elements, so just increase counter:
			node.count += elementCount;
		} else {
			if (shouldWeAddNewElementToTheLeft(node, element)) {
				result = addLeft(node, element, elementCount);
				if (result) {
					node.leftCount++;
//					node.height = Math.max(node.height, node.left.height + 1);
				}
			} else {
				result = addRight(node, element, elementCount);
				if (result) {
					node.rightCount++;
//					node.height = Math.max(node.height, node.right.height + 1);
				}
			}
			if(result) {
				updateHeight(node);
			}
		}
		return result;
	}

	/**
	 * Override this method to define where new method goes
	 * 
	 * @param node
	 * @param element
	 * @return
	 */
	protected boolean shouldWeAddNewElementToTheLeft(Node<T> node, T element) {
		return node.leftCount <= node.rightCount;
	}

	private boolean addLeft(Node<T> parent, T element, int elementCount) {
		if (parent.left == null) {
			Node<T> node = createNewNode(parent, element, elementCount);
			parent.left = node;
			return true;
		} else {
			return add(parent.left, element, elementCount);
		}
	}

	private boolean addRight(Node<T> parent, T element, int elementCount) {
		if (parent.right == null) {
			Node<T> node = createNewNode(parent, element, elementCount);
			parent.right = node;
			return true;
		} else {
			return add(parent.right, element, elementCount);
		}
	}

	private Node<T> createNewNode(Node<T> parent, T element, int elementCount) {
		Node<T> node = new Node<T>();
		node.value = element;
		node.count = elementCount;
		node.parent = parent;
		if (parent != null) {
			node.level = parent.level + 1;
		}
		return node;
	}

	@Override
	public boolean delete(T element) {
		boolean result = delete(root, element);
		if (result) {
			counter--;
		}
		return result;
	}

	protected boolean delete(Node<T> node, T element) {
		if (node == null) {
			// Nothing to delete here, we hit the leaf
			return false;
		}
		if (node.value.equals(element)) {
			// we found it in current node, now delete it:
			if (node.count > 1) {
				// This is node with multiple values, simply decrement the counter:
				node.count--;
				// And we are done :)
				return true;
			}
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
				if (node.parent != null) {
					if (node.parent.left == node) {
						node.parent.left = node.left;
					} else {
						node.parent.right = node.left;
					}
					node.left.parent = node.parent;
				} else {
					// This was root:
					root = node.left;
					root.parent = null;
				}
				// Update Node levels
				decrementLevels(node.left);
				//updateHeight(node.left);
			} else {
				// replace this node with right child:
				if (node.parent != null) {
					if (node.parent.left == node) {
						node.parent.left = node.right;
					} else {
						node.parent.right = node.right;
					}
					node.right.parent = node.parent;
				} else {
					// This was root:
					root = node.right;
					root.parent = null;
				}
				// Update Node levels
				decrementLevels(node.right);
				//updateHeight(node.right);
			}
			return true;
		} else {
			// Must be in one of the children:
			boolean deletedLeft = delete(node.left, element);
			boolean deletedRight = false;
			boolean result = false;
			if (!deletedLeft) {
				deletedRight = delete(node.right, element);
				if (deletedRight) {
					node.rightCount--;
					result = true;
				} else {
					result = false;
				}
			} else {
				node.leftCount--;
				result = true;
			}
			if (result) {
				updateHeight(node);
			}
			return result;

		}

	}

	private void updateHeight(Node<T> node) {
		if (node == null) {
			return;
		}
		if (node.left != null) {
			if (node.right != null) {
				node.height = Math.max(node.left.height + 1, node.right.height + 1);
			} else {
				node.height = node.left.height + 1;
			}
		} else if (node.right != null) {
			node.height = node.right.height + 1;
		} else {
			node.height = 0;
		}

	}

	protected void decrementLevels(Node<T> node) {
		if (node != null) {
			node.level--;
			decrementLevels(node.left);
			decrementLevels(node.right);
		}
	}

	@Override
	public List<T> getAll() {
		// log.debug("start");
		List<T> result = new LinkedList<T>();
		traverseInOrder(root, result);
		// log.debug("end");
		// log.debug("root node balance: "+root.leftCount+"/"+root.rightCount);
		return result;
	}

	private void traverseInOrder(Node<T> node, List<T> result) {
		if (node != null) {
			traverseInOrder(node.left, result);
			for (int i = 0; i < node.count; i++) {
				result.add(node.value);
			}
			traverseInOrder(node.right, result);
		} else {
			return;
		}
	}

	public Node<T> getRoot() {
		return root;
	}

	public void print() {
		System.out.println("Tree element count: "+counter);
		print(root);
	}

	private void print(Node<T> node) {
		if (node != null) {
			System.out.println(node);
			print(node.left);
			print(node.right);
		}

	}

	@Override
	public int getMaxHeight() {
		if (root != null) {
			return root.height;
		}
		return 0;
	}

}
