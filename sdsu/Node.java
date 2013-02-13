package com.adv.sdsu;

import java.util.HashSet;
import java.util.Set;

public class Node {
	private char letter;
	private Node[] child = new Node[26];
	private boolean isWord;

	public Node(char letter) {
		this.letter = letter;
	}
	
	public Node() {
		
	}

	public char getLetter() {
		return letter;
	}
	public void setLetter(char letter) {
		this.letter = letter;
	}
	public Node[] getChild() {
		return child;
	}
	public Node getChild(int i) {
		return child[i];
	}
	public void setChild(Node[] children) {
		this.child = children;
	}
	public boolean isWord() {
		return isWord;
	}
	public void setWord(boolean isWord) {
		this.isWord = isWord;
	}

	public void addWord(String word) {
		if (word.length() == 0 ) {
			isWord = true;
			return;
		}
		Node forWord = nodeFor(word);
		forWord.addWord(word.substring(1));
	}
	private Node nodeFor(String word) {
		char charToInsert = word.charAt(0);
		int index = charToInsert - 'a';
		if (child[index] == null) 
			child[index] = new Node(charToInsert);
		return child[index];
	}
	public Set<Integer> getChildIndex(){
		Set<Integer> indexes = new HashSet<Integer>(); 
		for(int i=0; i <25;i++){
			if(child[i] != null)
				indexes.add(i);
		}
		return indexes;
		
	}

}
