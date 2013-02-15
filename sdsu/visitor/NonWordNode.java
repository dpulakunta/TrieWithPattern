package com.adv.sdsu.visitor;

public class NonWordNode extends Node {
	public NonWordNode(char letterToInsert) {
		super.setLetter(letterToInsert);
		setChild(new Node[26]);
	}

	public NonWordNode() {
		setChild(new Node[26]);
	}

	@Override
	public void accept(Visitor v) {
		v.visitNonWordNode(this);
	}
}
