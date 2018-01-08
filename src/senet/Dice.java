package senet;

import java.util.Random;

public class Dice {

	public Dice() {
		
	}
	
	/**
	 * A dice throw that can only return a certain set of integers
	 * @return either 1, 2, 3, 4 or 6
	 */
	public int throwSticks() {
		int n;
		while (true) {
			Random random = new Random();
			n = random.nextInt(6) + 1;
			if (n != 5) {
				break;
			}
		}
		return n;
	}
}
