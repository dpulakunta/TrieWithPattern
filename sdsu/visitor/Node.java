package com.adv.sdsu.visitor;



public abstract class Node {
	public char letter;
	public Node[] child = new Node[26];
	public void add(String wordToInsert){
		Node traverseNode = this; 
		while(wordToInsert.length() > 0){
			int len = wordToInsert.length();
			char charToInsert = wordToInsert.charAt(0);
			int index = charToInsert - 'a';
			if(wordToInsert.length() == 1){
				if(traverseNode.child[index] == null){
					traverseNode.child[index] = new WordNode(charToInsert);
				}
				traverseNode=traverseNode.child[index];

			}
			else{
				if(traverseNode.child[index] == null){
					traverseNode.child[index] = new NonWordNode(charToInsert);
				}
				traverseNode=traverseNode.child[index];

			}
			wordToInsert = wordToInsert.substring(1);
		}
	}
	public abstract void addWord(Node current,char elementToInsert);

	public abstract void accept(Visitor v);
}
