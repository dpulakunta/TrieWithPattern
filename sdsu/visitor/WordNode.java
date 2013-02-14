package com.adv.sdsu.visitor;

public class WordNode extends Node {

	public WordNode(char letterToInsert) {
		super.setLetter(letterToInsert);
		setChild(new Node[26]);
		
	}
	public WordNode() {
		setChild(new Node[26]);
	}
	@Override
	public void accept(Visitor v) {
		v.visitWordNode(this);
	}
}
