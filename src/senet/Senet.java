package senet;

public class Senet {
	Dice dice;
	Board board;
	Player[] players;
	
	Input input;

	public Senet () {
		this.dice = new Dice();
		this.players = new Player[2];
		
		this.input = new Input();
	}
	
	public void play () {
		System.out.println("Let's play Senet!");
		
		int mode = input.selectInt(new int[] {0, 1, 2, 3}, "Before we begin: Would you like to start a normal game (0) or a test position?");
		
		if (mode == 0) {
			String[] names = input.getNames(players.length);
			players = determineStarter(names);
		} else {
			players[0] = new Player("John", 'x');
			players[1] = new Player("Jane", 'o');
		}
	}
	
	public Player[] determineStarter (String[] names) {
		int player = 0;
		Player[] players = new Player[2];
		
		System.out.println(); // blank line
		while (true) {
			int n = dice.throwSticks();
			System.out.println(names[player] + " has thrown " + n);
			if (n == 1) {
				break;
			}
			player ^= 1; // XOR switch
		}
		System.out.println('\n' + names[player] + " starts the game!");
		players[0] = new Player(names[player], 'x');
		players[1] = new Player(names[(player ^ 1)], 'o'); // XOR (^) to select the other name
		return players;
	}
	
}
