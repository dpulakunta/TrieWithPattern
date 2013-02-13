package com.adv.sdsu;

import java.util.Iterator;

public class Trie implements Iterable {
	public Node head = new Node();
	
	public void add(String wordToInsert){
		head.addWord(wordToInsert);
	}
	
	public boolean contains(String searchString){
		Iterator iterateForSearch = iterator(); 
		while(iterateForSearch.hasNext()){
			String elementOnTrie = (String) iterateForSearch.next();
			if(elementOnTrie.contains(searchString))
				return true;
		}
		return false;
	}
	
	public String toString(){
		String elementsOnTrie = "[";
		Iterator iterateForSearch = iterator(); 
		while(iterateForSearch.hasNext()){
			elementsOnTrie = elementsOnTrie+ (String) iterateForSearch.next() + ", ";
		}
		elementsOnTrie = elementsOnTrie.substring(0, elementsOnTrie.length()-2)+"]";
		return elementsOnTrie;
		
	}
	
	@Override
	public Iterator iterator() {
		return new TrieIterator(head);
	}

}
