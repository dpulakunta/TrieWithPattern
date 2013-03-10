/* ClassName : Node
 * 
 * Created by: Dharmendhar Pulakunta
 * Red ID: 816324464
 * 
 * Reason: 
 * creating the structure for the Trie and also
 * functionality to add words
 * 
 * 
 * Class variables: 
 * letter: character of the Trie to store
 * child: children nodes of the parent can have upto 26 alphabets
 * 
 * This is abstract we have 3 sub-classes WordNode, NonWordNode NullNode
 * 
 */
package com.adv.sdsu.visitor;

public abstract class Node {
	private char letter;
	private Node[] child;

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

	public void setChildAt(Node child, int i) {
		this.child[i] = child;
	}
	/* Function name: createNull
	 * 
	 * This is to make all the child nodes point to null node
	 * 
	 */
	public Node[] createNull(Node[] children) {
		NullNode node = new NullNode();
		for (int i = 0; i < 26; i++)
			children[i] = node;
		return children;
	}
	/* Function name: add
	 * 
	 * Input:wordToInsert
	 * 
	 * Output:none
	 * 
	 * We need to create 3 types of nodes:
	 * WordNode
	 * NonWordNode
	 * NullNode
	 * Depending on the character we need to set the type of
	 * node
	 * 
	 */
	public void add(String wordToInsert) {
		Node traverseNode = this;
		//for all the characters in the word we loop thru
		//depending on the position we create the node types
		while (wordToInsert.length() > 0) {
			char charToInsert = wordToInsert.charAt(0);
			int index = charToInsert - 'a';
			//if it is last character we need to create WordNode
			if (wordToInsert.length() == 1) {
				//checking if the character is already present
				//if not present then we are creating the WordNode
				if (traverseNode.child[index] instanceof NullNode) {
					traverseNode.child[index] = new WordNode(charToInsert);

				}
				//character already present so traversing ahead
				traverseNode = traverseNode.child[index];
			} 
			//it is the NonWordNode part of the loop
			else {
				//checking if the character is already present
				//if not present then we are creating the NonWordNode
				if (traverseNode.child[index] instanceof NullNode) {
					traverseNode.child[index] = new NonWordNode(charToInsert);
				}
				//character already present so traversing ahead
				traverseNode = traverseNode.child[index];

			}
			wordToInsert = wordToInsert.substring(1);
		}
	}
	
	/* Function name: accept
	 * 
	 * Input: Visitor
	 * 
	 * Output:none
	 * 
	 * This is abstract method we will implement in child class
	 */
	public abstract void accept(Visitor v);

}
