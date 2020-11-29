package edu.nyu.cs.ecs522;

import processing.core.*;


/**
 * My main class that allows for the playing of bananamuncher and interaction
 * between classes
 * 
 * @author emmasaros
 * @version 1
 */
public class PlayBananaMuncher extends PApplet {
	/**
	 * set up window size
	 */
	final private int w = 900;
	final private int h = 900;

	/**
	 * set up banana score
	 */
	private int bananascore = 0;

	/**
	 * set up font text for score printing
	 */
	private PFont score;

	/**
	 * set up font text for game over printing
	 */
	private PFont lose;

	/**
	 * set up font text for thank you printing
	 */
	private PFont thanks;

	/**
	 * set up image variable for selfie image
	 */
	private PImage selfie;

	/**
	 * set up instance of monkey class with monkey object
	 */
	Monkey monkey;
	/**
	 * set up instance of gorilla class with gorilla array for multiple gorillas
	 */
	Gorilla[] gorillasArray;
	/**
	 * set up instance of banana class with banana object array
	 */
	Banana[][] bananasMatrix;

	/**
	 * call main method to play with processing
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		PApplet.main("edu.nyu.cs.ecs522.PlayBananaMuncher");

	}

	/**
	 * set up window
	 */
	public void settings() {

		this.size(this.w, this.h);

	}

	/**
	 * set up gorillas, bananas and monkey
	 */
	public void setup() {

		monkey = new Monkey(this, 10, 10);
		setupGorillas();
		setupBananas();

	}

	/**
	 * actually draw monkey according to cursor, gorillas and banana array
	 */
	public void draw() {
		this.background(203, 232, 107);
		monkey.setX(this.mouseX - 40);
		monkey.setY(this.mouseY - 40);

		this.drawBananasArray();
		this.drawGorillasArray();
		monkey.drawMonkey();

		this.moveGorillas();
		this.checkBananaCollision();
		this.checkGorillaCollision();
	}

	/**
	 * A method that positions the gorillas on the screen
	 * 
	 * @return
	 */
	public Gorilla[] setupGorillas() {

		gorillasArray = new Gorilla[4];

		gorillasArray[0] = new Gorilla(this, 0, 10, 10, -5, 0);
		gorillasArray[1] = new Gorilla(this, 1, 800, 800, 50, 0);
		gorillasArray[2] = new Gorilla(this, 2, 450, 450, 0, -20);
		gorillasArray[3] = new Gorilla(this, 3, 10, 800, 0, 10);

		return gorillasArray;
	}

	/**
	 * A method that positions the bananas in a matrix on the screen
	 */
	public void setupBananas() {
		// initialize bananasMatrix
		int row = h / 100;
		int col = w / 100;
		bananasMatrix = new Banana[row][col];

		// filling up the bananasMatrix with Banana objects
		for (int i = 0; i < bananasMatrix.length; i++) {
			for (int j = 0; j < bananasMatrix[i].length; j++) {

				// spacing using w and h to get the x and y coordinates
				bananasMatrix[i][j] = new Banana(this, 25 + (i * 100), 20 + (j * 100), false);

			}
		}
	}

	/**
	 * A method that draws the banana matrix on the screen and erases banana
	 * according to an isEaten boolean that is affected in the bananacollision
	 * method
	 */
	public void drawBananasArray() {
		for (int i = 0; i < bananasMatrix.length; i++) {
			for (int j = 0; j < bananasMatrix[i].length; j++) {
				Banana banana = bananasMatrix[i][j];
				if (!banana.getIsEaten()) {
					banana.drawBanana();
				}
			}
		}

	}

	/**
	 * A method that draws individual gorillas
	 */
	public void drawGorillasArray() {
		for (int i = 0; i < gorillasArray.length; i++) {
			gorillasArray[i].drawGorillas();
		}
	}

	/**
	 * A method that moves gorillas on x and y axis'
	 */
	public void moveGorillas() {
		for (int i = 0; i < gorillasArray.length; i++) {
			Gorilla gorilla = gorillasArray[i];

			gorilla.checkBounds();

			if (gorilla.getxDirection() == 0) {
				gorilla.setY(gorilla.getY() + gorilla.getyDirection());
			} else {
				gorilla.setX(gorilla.getX() + gorilla.getxDirection());
			}
		}
	}

	/**
	 * A method that checks whether a banana has collided with the monkey
	 */
	public void checkBananaCollision() {
		// get x,y coordinates of monkey using getters
		monkey.setX(monkey.getX());
		monkey.setY(monkey.getY());
		// for loop through all the bananas
		for (int i = 0; i < bananasMatrix.length; i++) {
			for (int j = 0; j < bananasMatrix[i].length; j++) {
				Banana banana = bananasMatrix[i][j];
				// check if x,y coordinates of monkey is within a box around the banana position
				if (monkey.getX() > banana.getX() - 50 && monkey.getX() < banana.getX() + 50) {
					if (monkey.getY() < banana.getY() + 50 && monkey.getY() > banana.getY() - 50) { // the problem is
																									// here
						banana.setEaten(true);
						System.out.println("hit");
						bananascore++;
						// let the user know their score
						score = createFont("Arial", 16, true);
						textFont(score, 30);
						fill(0);
						text("Your time is " + bananascore, 500, 800);
					}
				}
			}
		}
	}

	/**
	 * A method that checks whether a gorilla has collided with a monkey Also
	 * considers losing options
	 */
	public void checkGorillaCollision() {
		for (int i = 0; i < gorillasArray.length; i++) {
			if (monkey.getX() > gorillasArray[i].getX() - 50 && monkey.getX() < gorillasArray[i].getX() + 50) {
				if (monkey.getY() < gorillasArray[i].getY() + 50 && monkey.getY() > gorillasArray[i].getY() - 50) {
					lose = createFont("Arial", 100, true);
					textFont(lose, 100);
					fill(0);
					text("GAME OVER", 130, 400);
					this.selfie = this.loadImage("src/selfie.png");
					this.image(selfie, 130, 450);
					thanks = createFont("Arial", 16, true);
					textFont(thanks, 20);
					fill(0);
					text("Emma thanks you for playing", 600, 700);
					noLoop();
				}
			}
		}
	}

}
