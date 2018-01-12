package senet;

public class Player {
	private String name;
	private char colorsign;
	private boolean computer;

	public Player (String name, char colorsign, boolean computer) {
		this.name = name;
		this.colorsign = colorsign;
		this.computer = computer;
	}
	
	public Player (String name, char colorsign) {
		this.name = name;
		this.colorsign = colorsign;
		this.computer = false;
	}
	
	/**
	 * Check if the player is a computer
	 * @return
	 */
	public boolean isComputer () {
		return this.computer;
	}
	
	/**
	 * Get's the colorsign of the player
	 * @return colorsign
	 */
	public char getColorsign() {
		return this.colorsign;
	}
	
	/**
	 * Get's the print string of the player
	 * @return print (name + colorsign)
	 */
	public String getPrint() {
		return this.name + " (" + this.colorsign + ")";
	}
}
