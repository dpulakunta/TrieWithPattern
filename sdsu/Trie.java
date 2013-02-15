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
 * head : is a node type variable which is used to keep track
 * of the root of the Trie.
 * 
 * Interface: we are implementing Iterable interface to create
 * create iterator
 */
package com.adv.sdsu;

import java.util.Iterator;

public class Trie implements Iterable {
	private Node head = new Node();
	
	public Node getHead() {
		return head;
	}

	public void setHead(Node head) {
		this.head = head;
	}
	
	/* Function name: add
	 * 
	 * Input: wordToInsert
	 * 
	 * Output: boolean saying if the word is inserted or not
	 * Calling the addWord in the node class
	 */
	public boolean add(String wordToInsert){
		if (wordToInsert == null) return false;
		if (wordToInsert.isEmpty() ) return false;
		head.addWord(wordToInsert);
		return true;
	}
	
	/* Function name: contains
	 * 
	 * Input: searchString
	 * 
	 * Output: boolean saying if the word is found or not
	 * We use the iterator to iterate over all the elements in the Trie
	 * We check if the currentWord contains the searchString
	 */
	public boolean contains(String searchString){
		Iterator iterateForSearch = iterator(); 
		while(iterateForSearch.hasNext()){
			String currentWord = (String) iterateForSearch.next();
			if(currentWord.contains(searchString))
				return true;
		}
		return false;
	}
	
	/* Function name: toString
	 * 
	 * Input: none
	 * 
	 * Output: String form of all the elements on the list
	 * 
	 * We use the iterator to iterate over all the elements in the Trie
	 * Store the elements by comma separation
	 */
	public String toString(){
		String elementsOnTrie = "[";
		Iterator iterateForSearch = iterator(); 
		while(iterateForSearch.hasNext()){
			elementsOnTrie = elementsOnTrie+ (String) iterateForSearch.next() + ", ";
		}
		elementsOnTrie = elementsOnTrie.substring(0, elementsOnTrie.length()-2)+"]";
		return elementsOnTrie;
	}
	/* Function name: iterator
	 * 
	 * Input: none
	 * 
	 * Output: returns the iterator
	 * 
	 * We use this to create iterator object for the Trie 
	 */
	@Override
	public Iterator iterator() {
		return new TrieIterator(head);
	}

}
