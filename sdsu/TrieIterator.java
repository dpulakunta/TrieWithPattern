/* ClassName : TrieIterator
 * 
 * Created by: Dharmendhar Pulakunta
 * Red ID: 816324464
 * 
 * Reason: 
 * to implement the functionality of iterator
 * 
 * Class variables: 
 * head : is a node type variable which is used to keep track
 * of the root of the Trie.
 * charCovered: is a variable to store all the nodes that has 
 * been covered and create words using the elements in stack
 * 
 */
package com.adv.sdsu;

import java.util.Iterator;
import java.util.Stack;


public class TrieIterator implements Iterator<String> {
	private Node head;
	private Stack<Node> charCovered = new Stack<Node>();
	
	public Node getHead() {
		return head;
	}

	public void setHead(Node root) {
		this.head = root;
	}

	public Stack<Node> getCharCovered() {
		return charCovered;
	}

	public void setCharCovered(Stack<Node> charCovered) {
		this.charCovered = charCovered;
	}

	
	public TrieIterator() {

	}

	public TrieIterator(Node root) {
		head = root;
		charCovered.add(head);
	}
	/* Function name: hasNext
	 * 
	 * Input: none
	 * 
	 * Output: boolean saying if a new word is present or not
	 * 
	 * We are using the interface Iterator and overriding the
	 * functionality hasNext()
	 * 
	 * We are making a copy of the stack and checking if we can 
	 * create word using the elements in the stack
	 */
	@Override
	public boolean hasNext() {
		//Creating a copy of the stack so that we dont lose the
		//elements in the stack when we create a word
		Stack<Node> clone = (Stack<Node>)getCharCovered().clone();
		//Trying to see if could create a word using the elements 
		//on the stack
		String strWord = buildWordUsingStack(putCharsOnStack(clone));
		if(null==strWord)
			return false;
		else
			return true;
	}
	/* Function name: next
	 * 
	 * Input: none
	 * 
	 * Output: returns the string present on the trie
	 * 
	 * We are using the interface Iterator and overriding the
	 * functionality next()
	 * 
	 * We are making a copy of the stack and checking if we can 
	 * create word using the elements in the stack
	 */
	@Override
	public String next() {
		putCharsOnStack(charCovered);
		return buildWordUsingStack(charCovered);
	}
	/* Function name: putCharsOnStack
	 * 
	 * Input: 
	 * stackToStoreChar: stack to put all the character for present
	 * word
	 * 
	 * Output: returns the stack with characters
	 * 
	 * We reach till the wordNode store all the elements while 
	 * traversing the Trie to reach wordNode
	 * 
	 */
	private Stack<Node> putCharsOnStack(Stack<Node> stackToStoreChar)
	{
		boolean notReachedEndOfWord=true;
		boolean notWordNode=true;
		//We are retrieving the last visited node
		Node currentNode=stackToStoreChar.get(stackToStoreChar.size()-1);
		int charIndex=0;
		//We are keeping a true condition till we reach the 
		//word end
		while(notReachedEndOfWord)
		{
			//current index till last alphabet
			for(int index=charIndex;index<26;index++)
			{
				//loop till we find the non null node
				if(currentNode.getChild(index)!=null)
				{
					notWordNode=false;
					//adding the node into the stack
					stackToStoreChar.push(currentNode.getChild(index));
					//checking if we have reached the endOfWord
					//setting the flag
					if(currentNode.getChild(index).isWord())
					{
						notReachedEndOfWord=false;
						break;
					}
					//if not endOfWord continue loop intailise
					//few things to continue the loop
					else
					{
						notReachedEndOfWord=true;
						currentNode=stackToStoreChar.get(stackToStoreChar.size()-1);
						charIndex=0;
						break;
					}
				}
			}
			if(notWordNode)
			{
				//stack has more elements other than root
				// we are setting the charIndex and node to
				//start the loop
				if(stackToStoreChar.size()>1)
				{
					charIndex=stackToStoreChar.pop().getLetter()-'a'+1;
					currentNode=stackToStoreChar.get(stackToStoreChar.size()-1);
				}
				else
				{
					notReachedEndOfWord=false;
				}

			}
		}
		return stackToStoreChar;
	}
	/* Function name: buildWordUsingStack
	 * 
	 * Input: 
	 * stackToBuildWord: stack to create the word
	 * 
	 * 
	 * Output: returns string with word formed from elements on stack
	 * 
	 * We are looping on the stack and creating word
	 * 
	 */
	private String buildWordUsingStack(Stack<Node> stackToBuildWord)
	{
		//stack has just the root we will not be able to create words
		if(stackToBuildWord.size()==1)
			return null;
		else
		{
			//creating the string from char on stack
			StringBuilder str=new StringBuilder();
			for(int index=1;index<stackToBuildWord.size();index++)
			{
				str.append(stackToBuildWord.get(index).getLetter());
			}
			return str.toString();
		}
	}
	/* Function name: remove
	 * 
	 * Input: 
	 * none
	 * 
	 * 
	 * Output: 
	 * none
	 * 
	 * We are not supporting this operation
	 * 
	 */
	@Override
	public void remove() {
		throw new UnsupportedOperationException();
	}

}
