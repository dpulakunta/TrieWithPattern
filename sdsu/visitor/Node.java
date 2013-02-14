package com.adv.sdsu.visitor;



public abstract class Node {
	private char letter;
	public Node[] child;


	public char getLetter() {
		return letter;
	}
	public void setLetter(char letter) {
		this.letter = letter;
	}
	public Node[] getChild() {
		return child;
	}
	public void setChild(Node[] children) {
        this.child = createNull(children);
}
	public Node getChildAt(int i) {
		return child[i];
	}
	public void setChildAt(Node child,int i) {
		this.child[i] = child;
	}
	public Node[] createNull(Node[]children)
	{
		NullNode node = new NullNode();
		for(int i = 0;i <26 ; i++)
			children[i] = node;
		return children;
	}
	public void add(String wordToInsert){
		Node traverseNode = this; 
		while(wordToInsert.length() > 0){
			char charToInsert = wordToInsert.charAt(0);
			int index = charToInsert - 'a';
			if(wordToInsert.length() == 1){
				if(traverseNode.child[index] instanceof NullNode){
					//traverseNode.child = new WordNode[26];
					traverseNode.child[index] = new WordNode(charToInsert);

				}
				traverseNode=traverseNode.child[index];
			}
			else{
				if(traverseNode.child[index] instanceof NullNode){
					//traverseNode.child = new NonWordNode[26];
					traverseNode.child[index] = new NonWordNode(charToInsert);
				}
				traverseNode=traverseNode.child[index];

			}
			wordToInsert = wordToInsert.substring(1);
		}
	}


	public abstract void accept(Visitor v);

}
