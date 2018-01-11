package senet;

import java.util.Random;

public class Dice {
	/**
	 * A dice throw that can only return a certain set of integers
	 * @return either 1, 2, 3, 4 or 6
	 */
	public int throwSticks() {
		int n = 0;
		int score;
		
		// Throw 4 two-sided dice
		for (int i = 0; i < 4; i++) {
			Random random = new Random();
			n += random.nextInt(2);
		}
		
		// special rule
		score = (n == 0) ? 6 : n;
		
		return score;
	}
}
