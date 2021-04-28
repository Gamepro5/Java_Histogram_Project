// Do not change any code in this class
import javax.swing.JFrame;

public class Main {
	public static void main(String[] args) {
		Die die = new Die(10);
		die.roll();
		System.out.println(die.getValue());
		Histogram hist = new Histogram();
		hist.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		hist.setVisible(true);
	}
}