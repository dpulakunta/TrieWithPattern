package com.adv.sdsu.visitor;

public class NonWordNode extends Node {
    public NonWordNode(char letterToInsert) {
		letter = letterToInsert;
	}
    public NonWordNode() {
		
	}
	@Override
	public void accept(Visitor v) {
		v.visitNonWordNode(this);
	}

	@Override
	public void addWord(Node current, char elementToInsert) {
		// TODO Auto-generated method stub
		
	}



}
