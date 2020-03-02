package turingMachine;

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
