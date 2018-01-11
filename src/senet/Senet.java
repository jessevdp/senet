package senet;

public class Senet {
	Dice dice;
	Board board;
	
	Input input;

	public Senet () {
		this.dice = new Dice();
		this.input = new Input();
	}
	
	public void play () {
		System.out.println("Let's play Senet!");
		
		int mode = input.selectInt(new int[] {0, 1, 2, 3}, "Before we begin: Would you like to start a normal game (0) or a test position?");
		
		if (mode == 0) {
			String[] names = input.getNames(2);
			// TODO: determine starter to get players
		} else {
			// TODO: add test players
		}
	}
	
}
