package com.adv.sdsu.visitor;

import java.util.ArrayList;
import java.util.Iterator;

public class Trie {
	private Node root = new NonWordNode();
	private Visitor traverser = new AllWordsVisitor();
	private PatternVisitor traverserForCK = new PatternVisitor();


	public String toString() {
		String words = "[";
		root.accept(traverser);

		ArrayList<String> wordsOnTrie = traverser.getWordsInTrie();
		Iterator<String> iterateOverArrayList = wordsOnTrie.iterator();
		while (iterateOverArrayList.hasNext()) {
			words = words + iterateOverArrayList.next() + ", ";
		}
		words = words.substring(0, words.length() - 2) + "]";
		return words;
	}

	public void add(String wordToInsert) {
		Node traverseNode = root;
		traverseNode.add(wordToInsert);
	}

	public boolean contains(String searchString) {

		root.accept(traverserForCK);
		traverserForCK.setSearchPattern(searchString);
		ArrayList<String> wordsOnTrie = traverserForCK.getWordsInTrie();
		Iterator<String> iterateOverArrayList = wordsOnTrie.iterator();
		String word = new String();
		while (iterateOverArrayList.hasNext()) {
			word = iterateOverArrayList.next();
			if(word.contains(searchString))
				return true;
		}
			return false;
	}

}
