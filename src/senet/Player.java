package senet;

public class Player {
	private String name;
	private char colorsign;

	public Player(String name, char colorsign) {
		this.name = name;
		this.colorsign = colorsign;
	}
	
	// name getter
	public String getName() {
		return this.name;
	}
	
	// colorsign getter
	public char getColorsign() {
		return this.colorsign;
	}
	
	/**
	 * Print the details of a Player
	 * (uses System.out.print())
	 */
	public void print() {
		System.out.print(this.name + " (" + this.colorsign + ")");
	}
}
