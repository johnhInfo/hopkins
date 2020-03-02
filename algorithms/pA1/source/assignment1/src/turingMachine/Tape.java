package turingMachine;

public class Tape {
	
	public int length;			//The length of the tape
	public char[] tape;			//The tape modeled as an array
	public int headPosition;	//The current tape index
	
	
	/****************************************************************
	 * Tape Constructor 
	 * @param tape an array modeling the tape 
	 * @param startIndex the startIndex
	 ****************************************************************/
	public Tape(char[] tape, int startIndex)
	{
		this.tape = tape;
		this.length = tape.length;
		
		/* StartIndex is too Small*/ 
		if(startIndex <= 0)
		{
			this.headPosition = 0;
			System.out.println("Tape->Init: Start Index Set to 0");
		}
		
		/* StartIndex is too big */
		else if (startIndex >= this.tape.length)
		{
			this.headPosition = this.length - 1;
			System.out.println("Tape->Init: Start Index OOB");
		}
		/* StartIndex is in bounds */
		else { this.headPosition = startIndex; } 
		
	}
	
	/****************************************************************
	 * readHead reads the value of the tape immediately under the head
	 * 
	 ****************************************************************/
	public char readHead() {
		
		return this.tape[headPosition];
		
	}
	
	/****************************************************************
	 * writeAtHead writes a value to tape under head
	 * 
	 ****************************************************************/
	public void writeAtHead(char value) {
		
		this.tape[headPosition] = value;
	}
	
	/****************************************************************
	 * moveLeft moves the head to the left of its current position
	 * 
	 ****************************************************************/
	public boolean moveLeft() {
		
		/*Check to see if head is @ the beginning of the tape array */ 
		if(this.headPosition > 0) {
			this.headPosition--;
			return true;
		}
		/*Head is at beginning of tape array */
		else { 
			System.out.println("Tape->moveLeft Error: Tape head already at beginnging!");
			return false; 
		}
		
	}
	
	/****************************************************************
	 * moveRight moves the head to the right of its current position
	 * 
	 ****************************************************************/
	public boolean moveRight() {
		
		/*Check to see if the head is at the end of the tape array */ 
		if(this.headPosition < this.length - 1) {
			this.headPosition++;
			return true;
		}
		
		/*Head is at the end of the tape array */
		else { 
			System.out.println("Tape->moveLeft Error: Tape head already at beginnging!");
			return false; 
		}
		
	}
	
	
}
