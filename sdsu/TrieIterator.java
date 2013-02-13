package com.adv.sdsu;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

import com.sdsu.edu.corrected.TrieNode;

public class TrieIterator implements Iterator<String> {
	Node head;
	Stack<Node> charCovered = new Stack<Node>();
	int indexCovered;
	
	public TrieIterator() {

	}

	public TrieIterator(Node root) {
		head = root;
		charCovered.add(head);
	}

	@Override
	public boolean hasNext() {
		
		return true;
	}

	@Override
	public String next() {
		
		return null;
	}
	
	@Override
	public void remove() {
		throw new UnsupportedOperationException();
	}

}
