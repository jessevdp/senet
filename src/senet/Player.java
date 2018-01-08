package senet;

public class Player {
	private String name;
	private char colorsign;

	public Player() {
		
	}
	
	// name getter & setter
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return this.name;
	}
	
	// colorsign getter & setter
	public void setColorsign(char colorsign) {
		this.colorsign = colorsign;
	}
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
