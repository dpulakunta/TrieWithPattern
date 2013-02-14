package com.adv.sdsu.visitor;

public class StrategyVisitor extends Visitor {
	private Strategy algoToFind;
	
	public Strategy getAlgoToFind() {
		return algoToFind;
	}

	public void setAlgoToFind(Strategy algoToFind) {
		this.algoToFind = algoToFind;
	}

	public StrategyVisitor(Strategy findWord) {
		algoToFind = findWord;
	}

	@Override
	void visitWordNode(WordNode n) {
		elementsInTheTrie.push(n);
		
		if(algoToFind.findWords(buildWord()))
			wordsInTrie.add(buildWord());
		
		for(int i=0;i<26;i++){
			Node newNode =  n.getChildAt(i);
			newNode.accept(this);
		}
		elementsInTheTrie.pop();
		
	}

}
