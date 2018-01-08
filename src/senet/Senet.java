package senet;

public class Senet {
	Player[] players;
	Dice dice;
	Board board;

	public Senet() {
		this.dice = new Dice();
		
		this.players = new Player[2];
		for (int i = 0; i < players.length; i++) {
			players[i] = new Player();
		}
		
		this.board = new Board();
	}
	
	public void play() {
		System.out.println("Let's play Senet!");
		
		// TEST: Dice
		int points = dice.throwSticks();
		System.out.println("Dice throw: " + points);
		
		// TEST: Player
		players[0].setName("John");
		players[0].setColorsign('X');
		System.out.print("Player print: ");
		players[0].print();
		System.out.print('\n');
		
		// TEST: Board
		board.print();
	}
}
