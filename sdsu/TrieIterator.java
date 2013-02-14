package com.adv.sdsu;

import java.util.Iterator;
import java.util.Stack;

public class TrieIterator implements Iterator<String> {
	public Node head;
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

	@Override
	public boolean hasNext() {
		if(buildWord() == null)
			return false;
		return true;
	}

	@Override
	public String next() {
		Node currentNode = charCovered.get(charCovered.size()-1);
		boolean loopCheck = true;
		boolean loopCheck2 = true;
		int charIndex = 0;
		while(loopCheck){
			for(int index = charIndex; index < 25; index ++){
				if(null!=currentNode.getChild(index))
				{
					loopCheck2=false;
					charCovered.push(currentNode.getChild(index));
					if(currentNode.getChild(index).isWord())
					{
						loopCheck=false;
						break;
					}
					else
					{
						loopCheck=true;
						currentNode=charCovered.get(charCovered.size()-1);
						charIndex=0;
						break;
					}
				}
			}
			if(loopCheck2)
			{
				if(charCovered.size()>1)
				{
					charIndex=charCovered.pop().getLetter() -'a';
					currentNode=charCovered.get(charCovered.size()-1);
				}
				else
				{
					loopCheck=false;
				}
			}	
		}
		return buildWord();
	}
	String buildWord(){
		if(charCovered.size()==1)
			return null;
		else
		{
			StringBuilder str=new StringBuilder();
			for(int index=0;index<charCovered.size();index++)
			{
				str.append(charCovered.get(index).getLetter());
			}
			return str.toString();
		}	
	}
	@Override
	public void remove() {
		throw new UnsupportedOperationException();
	}

}
