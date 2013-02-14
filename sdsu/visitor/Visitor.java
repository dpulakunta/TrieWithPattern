package com.adv.sdsu.visitor;

import java.util.ArrayList;
import java.util.Stack;

public abstract class Visitor {
	protected Stack<Node> elementsInTheTrie  = new Stack<Node>();
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
	void visitNullNode(NullNode n){
		
	}
	abstract void visitWordNode(WordNode n);
	
	void visitNonWordNode(NonWordNode n) {
		elementsInTheTrie.push(n);
		for(int i=0;i<26;i++){
			Node newNode =  n.getChildAt(i);
			newNode.accept(this);
		}
		elementsInTheTrie.pop();
	}
	
	String buildWord(){
		if(elementsInTheTrie.size()==1)
			return null;
		else
		{
			StringBuilder str=new StringBuilder();
			for(int index=0;index<elementsInTheTrie.size();index++)
			{
				str.append(elementsInTheTrie.get(index).getLetter());
			}
			return str.toString();
		}	
	}
}
