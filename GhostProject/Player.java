package GhostProject;


public class Player {
	// Instance variables: declared in class (not in methods), have default values (0/0.0/false/null)
	private String playerName;
	private String playerLetters=""; 
	private int roundsLost;
	

	// No argument constructor 
	public Player(){
		playerName="";
		roundsLost=0;
	}
	

	// Constructor: same name as class, no return type
	public Player(String playerName) {
		this.playerName = playerName;
		roundsLost = 0;
	}
	
	
	// Get method: returns name (matching instance variable type)
	public String getPlayerName() {
		return playerName;
	}
	
	
	// Get method: returns letter (matching instance variable type)
	public String getPlayerLetters() {
		return playerLetters;
	}
	
	
	//3 public instance methods

	// loseRound: assigns player an additional letter
	public String loseRound() {
		String[] ghostLetters = {"G","H","O","S","T"};
		playerLetters+= ghostLetters[roundsLost];
		roundsLost++;
		return playerLetters;
	}
	

	// isEliminated: returns true if player has all five letters
	public boolean isEliminated() {	
		return playerLetters.equals("GHOST"); //returns true is playerLetters equals ghost 
	}
	

	// toString: returns player's name and letters
	public String toString() { 
		return playerName + "(" + playerLetters + ")" ;
	}	
}

	

