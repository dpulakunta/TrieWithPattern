/* ClassName : Visitor
 * 
 * Created by: Dharmendhar Pulakunta
 * Red ID: 816324464
 * 
 * Reason: 
 * to give abstract functionality of the visitor
 * traverse all the 3 types of nodes
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
import java.util.Stack;

public abstract class Visitor {
	
	protected Stack<Node> elementsInTheTrie = new Stack<Node>();
	protected ArrayList<String> wordsInTrie = new ArrayList<String>();

	public Stack<Node> getElementsInTheTrie() {
		return elementsInTheTrie;
	}

	public void setElementsInTheTrie(Stack<Node> elementsInTheTrie) {
		this.elementsInTheTrie = elementsInTheTrie;
	}

	public ArrayList<String> getWordsInTrie() {
		return wordsInTrie;
	}

	public void setWordsInTrie(ArrayList<String> wordsInTrie) {
		this.wordsInTrie = wordsInTrie;
	}
	/* Function name: visitNullNode
	 * 
	 * Input: NullNode
	 * 
	 * Output: none
	 * we just return here, this does nothing
	 * this is also recursion breaking place
	 */
	void visitNullNode(NullNode n) {

	}
	/* Function name: visitWordNode
	 * 
	 * Input: WordNode
	 * 
	 * Output: none
	 * 
	 * The functionality changes in the child classes
	 * so making it abstract class
	 */
	abstract void visitWordNode(WordNode n);

	
	/* Function name: visitNonWordNode
	 * 
	 * Input: NonWordNode
	 * 
	 * Output: none
	 * This code is same in all the Visitors so moved the
	 * functionality to the base class
	 * We add the node into the stack, find the child for
	 * the current node and call the recursion
	 * 
	 * once the recursion breaks we come back to pop out the node
	 */
	void visitNonWordNode(NonWordNode n) {
		//Push the currentNode into the node
		elementsInTheTrie.push(n);
		//for all the 26 children we need to traverse it
		for (int i = 0; i < 26; i++) {
			//on each of the child we are calling recursion by 
			//calling visitor's accept method
			Node newNode = n.getChildAt(i);
			newNode.accept(this);
		}
		//we are poping the element after creating the word and 
		//recursion is complete
		elementsInTheTrie.pop();
	}

	/* Function name: buildWord
	 * 
	 * Input: 
	 * 
	 * Output: word made from the elements on the stack
	 * 
	 * This code is same in all the Visitors so moved the
	 * functionality to the base class
	 * We add the node into the stack, find the child for
	 * the current node and call the recursion
	 * 
	 * once the recursion breaks we come back to pop out the node
	 */
	String buildWord() {
		//We will not be able to create the word
		if (elementsInTheTrie.size() == 1)
			return null;
		//looping thru all the characters on the stack and returning 
		//the word formed 
		else {
			String str = new String();
			for (int index = 0; index < elementsInTheTrie.size(); index++) {
				str = str + elementsInTheTrie.get(index).getLetter();
			}
			return str;
		}
	}
}
