package org.aivan.tree.simple;

import org.aivan.tree.base.Node;

public class OrderedHeightTree<T extends Comparable<T>> extends SimpleTree<T> {

	@Override
	protected boolean shouldWeAddNewElementToTheLeft(Node<T> node, T element) {
		return element.compareTo(node.value) <= 0;
	}

}
