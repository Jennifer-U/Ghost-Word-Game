package GhostProject;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class Ghost {

	public static void main(String[] args) {
		String[] words = new String[279496];
		
		// read all words into the array
		try {
			Scanner wordInput = new Scanner(new File("GhostProject/words.txt"));
			for(int i = 0; i < words.length; i++) {
				words[i] = wordInput.next();
			}
		} catch (FileNotFoundException e) {
			System.out.println("File Not Found");
			return;
		}
		

		// get number of players
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the number of players: ");
		int numPlayers = input.nextInt();

		
		// get player names 
		System.out.println("Enter the names of the players:" );
		ArrayList<Player> players = new ArrayList<>();  // object type her is Player from my class Player
		String name; 
		
		for(int i=0; i < numPlayers; i++) { // reads name of players for as many times as numPlayers
			name = input.next(); // puts name into empty string
			Player p = new Player(name);   // object declaration,creation and assignment
			players.add(p); // add players in p my Array List Players 
		 
		}
				

		int firstPlayer = 0;
		String letters = "";
		
		boolean gameContinues = true;

		while(gameContinues) { 
			int currentPlayer = firstPlayer;
			boolean finished = false;
			firstPlayer++;
			if(firstPlayer == numPlayers) {
				firstPlayer=0;
			}

			while(!finished) { // runs one round of game until conditions met as indicated when round lost
				
				// determine current player
	
				if(currentPlayer == numPlayers) {
					currentPlayer = 0;
				}
				
				
				// current player enters a letter or * 
				System.out.println( players.get(currentPlayer) + ", it's your turn. The letters are " + letters + ". Enter a letter or enter * to challenge.");
				String letter = input.next();

				
				// if * is entered
				if(letter.equals("*")) {
					finished = true;
					boolean valid = false;
					for(String word : words) {
						if(word.length() >= 4 && word.length() > letters.length() && word.substring(0, letters.length()).equals(letters)) {
							players.get(currentPlayer).loseRound();  // round is lost and prints name with letter provided by loseRound
							System.out.println(word + " begins with those letters. " + players.get(currentPlayer).toString() + " loses the round!");
							valid = true;
							letters = "";
							break;
						}
					}
					if(!valid) {
						int prevPlayer = currentPlayer - 1;
						if(prevPlayer < 0) {
							prevPlayer = numPlayers-1;
						}
						players.get(prevPlayer).loseRound();
						System.out.println("No word begins with those letters. " + players.get(prevPlayer).toString()+ " loses the round!");
						letters = "";
						
					}
					
				// if letter is entered
				}else {
					letters += letter;
					for(String word : words) {
						if(word.length() >= 4 && letters.equals(word)) {
							players.get(currentPlayer).loseRound();
							System.out.println(letters + " is a word. " + players.get(currentPlayer).toString() + " loses the round!");
							finished = true;
							letters = "";
							break;
							
						}
					}
				}
				currentPlayer++;		
			} // the round is over --while(!finished) end bracket
			
			// checks if player is eliminated from the last round
			for (int i = 0; i < numPlayers; i++) {
				if(players.get(i).isEliminated()) {
					System.out.println(players.get(i) + " is eliminated!");
					players.remove(i);
					numPlayers--; // this was to eliminate the out of bounds I get when I did more than 2 players
				}
			}
			
			if(players.size() == 1){
				System.out.println(players.get(0) + "is victorious!"); // gets last remaining player 
				gameContinues = false; // ENDS gameContinues loop
			}
		} 
				input.close();
	}
}
















