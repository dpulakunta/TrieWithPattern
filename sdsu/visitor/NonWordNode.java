/* ClassName : NonWordNode
 * 
 * Created by: Dharmendhar Pulakunta
 * Red ID: 816324464
 * 
 * Reason: 
 * To implement the visitor pattern we are using the accept
 * method which needs to be implemented
 * 
 * We are extending from the Node class
 */
package com.adv.sdsu.visitor;

public class NonWordNode extends Node {
	public NonWordNode(char letterToInsert) {
		super.setLetter(letterToInsert);
		setChild(new Node[26]);
	}

	public NonWordNode() {
		setChild(new Node[26]);
	}
	/* Function name: accept
	 * Input: Visitor
	 * Output:none
	 * We are calling the particular method in the Visitor
	 */
	@Override
	public void accept(Visitor v) {
		v.visitNonWordNode(this);
	}
}
