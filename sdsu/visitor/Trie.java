/* ClassName : Trie
 * 
 * Created by: Dharmendhar Pulakunta
 * Red ID: 816324464
 * 
 * Reason: 
 * Trie class with the functionality of
 * add
 * contains
 * toString
 * 
 * Class variables: 
 * root : is a node type variable which is used to keep track
 * of the root of the Trie.
 * traverser: visitor for visiting all the nodes
 * traverserForPattern: visitor for particular pattern
 * 
 */
package com.adv.sdsu.visitor;

import java.util.ArrayList;
import java.util.Iterator;

public class Trie {
	private Node root = new NonWordNode();


	/* Function name: add
	 * 
	 * Input: wordToInsert
	 * 
	 * Output: boolean saying if the word is inserted or not
	 * Calling the addWord in the node class
	 */
	public boolean add(String wordToInsert) {
		if (wordToInsert == null) return false;
		if (wordToInsert.isEmpty() ) return false;
		Node traverseNode = root;
		root.add(wordToInsert);
		return true;
	}
	/* Function name: toString
	 * 
	 * Input: none
	 * 
	 * Output: String form of all the elements on the list
	 * 
	 * Use the visitor to traverse over all the elements in the Trie
	 * Store the elements by comma separation
	 */
	public String toString() {
		String words = "[";
		Visitor traverser = new AllWordsVisitor();
		//we accepting the visitor and calling the visitor to traverse
		root.accept(traverser);
		//we are accessing the arrayList of the visitor
		ArrayList<String> wordsOnTrie = traverser.getWordsInTrie();
		//iterating over the arrayList to build the string
		Iterator<String> iterateOverArrayList = wordsOnTrie.iterator();
		while (iterateOverArrayList.hasNext()) {
			words = words + iterateOverArrayList.next() + ", ";
		}
		words = words.substring(0, words.length() - 2) + "]";
		return words;
	}
	/* Function name: contains
	 * 
	 * Input: searchString
	 * 
	 * Output: boolean saying if the word is found or not
	 * 
	 * We are creating a visitor which will traverse Trie
	 * and store all the words containing the pattern
	 */
	public boolean contains(String searchString) {
		//we accepting the visitor and calling the visitor to traverse
		PatternVisitor traverserForPattern = new PatternVisitor();
		root.accept(traverserForPattern);
		traverserForPattern.setSearchPattern(searchString);
		//we are accessing the arrayList of the visitor
		ArrayList<String> wordsOnTrie = traverserForPattern.getWordsInTrie();
		if(wordsOnTrie.contains(searchString))
			return true;

		return false;
	}
	void accept(Visitor v){
		root.accept(v);
	}

}
