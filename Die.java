import java.util.Random;

public class Die {
	private int sides;  // number of sides of die
	private int value;  // current value that the die is showing

	public Die(int sides) {
		this.sides = sides;
	}
	
	public int roll() {
		Random random = new Random();
		value = random.nextInt(sides - 1 + 1) + 1;
		return value;
		//credit: https://stackoverflow.com/questions/20389890/generating-a-random-number-between-1-and-10-java
	}
	
	public int getValue() {
		return value;
	}
}