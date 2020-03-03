/******************************************************************************
 * File: Alphabet.java
 * Assignment: PA1
 * Author: John A. Herrmann
 * Class: EN.605.621.82.SP20 Foundations of Algorithms
 * Date: 3/2/2020
 *******************************************************************************/

package turingMachine;

/******************************************************************************
 * Alphabet Object Models a Turing Machine's alphabet
 * 
 ******************************************************************************/
public class Alphabet {

	public char[] alphabet;			//Alphabet modeled as array
	
	/***************************************************************
	 * Constructor - Initializes an object of the alphabet class
	 * 
	 * @param aplhabet A char[] modeling an alphabet
	 ****************************************************************/
	public Alphabet(char[] inputAlphabet) {
		this.alphabet = inputAlphabet;
	}
	
	/****************************************************************
	 * inAlphabet confirms a character is either in the alphabet or
	 *           ... a compatible blank symbol
	 *           
	 * @param element A character to be verified against alphabet
	 * @param blankSymbol a compatible blankSymbol
	 * @return boolean true if valid, false otherwise
	 ***************************************************************/
	boolean inAlphabet(char element, char blankSymbol)
	{
		boolean inVocab = false;
		
		for(int i = 0; i < this.alphabet.length; i++)
		{
			if(element == this.alphabet[i] || element == blankSymbol)
			{
				inVocab = true;
				break;
			}
		}
		return inVocab;
	}
}
