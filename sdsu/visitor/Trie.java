package com.adv.sdsu.visitor;

import java.util.ArrayList;
import java.util.Iterator;



public class Trie {
	private Node root = new NonWordNode();
	private Visitor traverser = new AllWordsVisitor();
	private PatternVisitor traverserForCK = new PatternVisitor();
	private Strategy findVowelWords = new TwoVowelStrategy();
	private Strategy findThWords = new THWordStrategy();
	private Visitor visitBasedOnStrategy1 = new StrategyVisitor(findVowelWords);
	private Visitor visitBasedOnStrategy2 = new StrategyVisitor(findVowelWords);
	
	public String toString(){
		String words = "[";
		root.accept(traverser);
		
		ArrayList<String> wordsOnTrie = traverser.getWordsInTrie();
		Iterator<String> iterateOverArrayList = wordsOnTrie.iterator();
		while(iterateOverArrayList.hasNext()){
			words = words + iterateOverArrayList.next()+", ";
		}
		words = words.substring(0,words.length()-2)+"]";
		System.out.println("Trying to check"+words);
		return words;
	}
	public void add(String wordToInsert){
		Node traverseNode = root; 
		traverseNode.add(wordToInsert);
	}

	
	public boolean contains(String searchString){
		 
		root.accept(traverserForCK);
		traverserForCK.setSearchPattern(searchString);
		ArrayList<String> wordsOnTrie = traverserForCK.getWordsInTrie();
		Iterator<String> iterateOverArrayList = wordsOnTrie.iterator();
		String words = new String();
		while(iterateOverArrayList.hasNext()){
			words = words + iterateOverArrayList.next() ;
		}
		if(wordsOnTrie == null)
			return false;
		else
			return true;
	}
	public String findWordTH(){
		
		return null;
		
	}
	public String findWordVowel(){
		return null;
		
	}
	
}
