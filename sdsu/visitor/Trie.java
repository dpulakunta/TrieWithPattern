package com.adv.sdsu.visitor;



public class Trie {
	public Node root = new NonWordNode();
	Visitor traverser = new TraverseVisitor();
	
	public String toString(){
		
		root.accept(traverser);
		return null;
		
	}
	public void add(String wordToInsert){
		Node traverseNode = root; 
		traverseNode.add(wordToInsert);
	}

	
	public boolean contains(String searchString){
		return false;
	}
	
}
