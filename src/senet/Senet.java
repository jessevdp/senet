package senet;

public class Senet {
	Dice dice;

	public Senet () {
		this.dice = new Dice();
	}
	
	public void play () {
		System.out.println(dice.throwSticks());
	}
	
}
