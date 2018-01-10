package senet;

public class Player {
	private String name;
	private char colorsign;

	public Player (String name, char colorsign) {
		this.name = name;
		this.colorsign = colorsign;
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
