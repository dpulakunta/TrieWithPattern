package com.adv.sdsu.visitor;

public class WordNode extends Node {

	public WordNode(char letterToInsert) {
		letter = letterToInsert;
	}
	@Override
	public void accept(Visitor v) {
		v.visitWordNode(this);
	}


	@Override
	public void addWord(Node current, char elementToInsert) {
		// TODO Auto-generated method stub
		
	}

}
