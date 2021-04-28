import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import java.util.Arrays;

import javax.swing.JFrame;

public class Histogram extends JFrame implements MouseListener {
	private int NUM_DICE = 4;
	private int MIN_ROLL = NUM_DICE;
	private int NUM_SIDES = 6;
	private int MAX_ROLL = NUM_DICE * NUM_SIDES;

	// Use this array to store the number of times each result is produced.
	// I.e., results[19] will contain the number of times the sum
	// of the dice was 19.
	private int[] results;

	public Histogram () {
		init();
	}

	public void init() {
		setSize(650,700);
		setBackground(Color.WHITE);
		setTitle("Histogram Thing");
		addMouseListener(this);
		computeResults();
		repaint();
	}

	// Roll four dice 1000 times, keeping track of the results.
	// The number of times each result is produced will be presented
	// visually in drawBars().
	public void computeResults() {
		Die[] die = new Die[NUM_DICE];  // Create array of Die references
		results = new int[MAX_ROLL+1];  // Don't use results[0..3]
		final int TRIALS = 1000; // #times to roll four dice

		// Actually create the dice to go in the array
		// Remember: An object is only created if new with parentheses
		// is used.  New with square brackets creates an array, but
		// not any individual objects that go in the array.
		for (int i = 0; i < die.length; i++) {
			die[i] = new Die(NUM_SIDES);
		}

		// Keep rolling dice and keep track of how many time
		// a result is generated in the array.  Use the sum of
		// the dice as the index.
		//
		// Example: If the sum of the four dice is 17, then add
		// one to the 17th element of the array
		for (int i = 0; i < TRIALS; i++) {
			int rollSum = 0;
			for (int j = 0; j < die.length; j++) {
				die[j].roll();
				rollSum += die[j].getValue();
			}
			results[rollSum] += 1;
		}
		
		System.out.println(Arrays.toString(results));
	}

	public void paint(Graphics g) {
		int yAxisXPos = 50;
		int xAxisYPos = getHeight() - 50;
		clearDisplay(g);
		g.setColor(Color.BLACK);
		drawAxes(g, yAxisXPos, xAxisYPos);
		drawNums(g, yAxisXPos, xAxisYPos);
		g.setColor(Color.BLUE);
		drawBars(g, yAxisXPos, xAxisYPos);
	}

	public void clearDisplay(Graphics g) {
		Color c = g.getColor();
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, getWidth(), getHeight());
		g.setColor(c);
	}

	public void drawAxes(Graphics g, int xPos, int yPos) {
		g.drawLine(xPos, yPos, xPos, 0);
		g.drawLine(xPos, yPos, getWidth(), yPos);
	}

	public void drawNums(Graphics g, int xPos, int yPos) {
		g.setFont(new Font("Courier", Font.ITALIC, 12));
		for (int i = MIN_ROLL; i < results.length; i++) {
			if (i < 10) {
				g.drawString("" + i, xPos + 24 * (i-MIN_ROLL) + 13, yPos + 12);
			} else {
				g.drawString("" + i, xPos + 24 * (i-MIN_ROLL) + 10, yPos + 12);
			}
		}
	}

	// Draw bars for each outcome total.
	public void drawBars(Graphics g, int xPos, int yPos) {
		
		for (int i=MIN_ROLL; i<results.length; i++) {
			g.fillRect(i*22, 650, 10, -results[i]);
			//a lot of trial and error to put it in the right place. don't rescale the window!!
		}
		
	}

	public void mouseClicked(MouseEvent arg0) {
		computeResults();
		repaint();
	}

	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}
}