package com.adv.sdsu.visitor;

public class NullNode extends Node {



	@Override
	public void accept(Visitor v) {
		v.visitNullNode(this);
		
	}

	@Override
	public void addWord(Node current, char elementToInsert) {
		int index = elementToInsert - 'a';
		
		
	}


}
