/* ClassName : Node
 * 
 * Created by: Dharmendhar Pulakunta
 * Red ID: 816324464
 * 
 * Reason: 
 * To create the structure for Trie elements
 * 
 * Class variables: 
 * letter: character of the Trie to store
 * child: children nodes of the parent can have upto 26 alphabets
 * isWord: to check if we have reached the end of word
 * 
 */
package com.adv.sdsu;

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
	/* Function name: addWord
	 * 
	 * Input: word: string that we will insert into the Trie
	 * 
	 * Output: none
	 * Breaking the word into characters and storing them in Trie
	 */
	
	public void addWord(String word){
		//Condition to stop recursion and mark the end of the word
		if (word.length() == 0 ) {
			isWord = true;
			return;
		}
		//getting a new node to insert one alphabet
		Node forWord = nodeFor(word);
		forWord.addWord(word.substring(1));
	}
	
	/* Function name: nodeFor
	 * 
	 * Input: word: string that we will insert into the Trie
	 * 
	 * Output: Returns a node
	 * creates a new Node or returns and child node which already exists
	 * 
	 */
	private Node nodeFor(String word) {
		char charToInsert = word.charAt(0);
		int index = charToInsert - 'a';
		//Checking if current character already exists or a new
		//node need to be created for the present character
		if (child[index] == null) 
			child[index] = new Node(charToInsert);
		return child[index];
	}
}
