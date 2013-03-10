/* ClassName : TwoVowelStrategy
 * 
 * Created by: Dharmendhar Pulakunta
 * Red ID: 816324464
 *
 * 
 * Class variables: 
 *
 * 
 * Most of the functionality is in the base class we are providing
 * only the functionality required for this visitor 
 */
package com.adv.sdsu.visitor;


public class TwoVowelStrategy implements Strategy {
	private String presentWord = new String();
	//Finding words three or more vowels in it
	@Override
	public boolean findWords(String currentWord) {
		presentWord = currentWord;
		int count = 0;
		int index = 0;
		//looping thru each character to find the total count
		//of the number of vowels
		for(int i=0;i<currentWord.length();i++){
			char presentChar = presentWord.charAt(i);
			if(presentChar == 'a' || presentChar == 'e' || presentChar == 'i' ||presentChar == 'o' ||presentChar == 'u')
				count++;
		}
		if (count >= 3)
			return true;

		return false;
	}
}