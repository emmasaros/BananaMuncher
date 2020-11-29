package edu.nyu.cs.ecs522;

import edu.nyu.cs.ecs522.Monkey;
import edu.nyu.cs.ecs522.PlayBananaMuncher;
import processing.core.*;

/**
 * Gorilla class that extends the monkey superclass
 * 
 * @author emmasaros
 * @version 1
 *
 */

public class Gorilla extends Monkey {
	/**
	 * xDirection tracker
	 */
	private int xDirection;
	/**
	 * yDirection tracker
	 */
	private int yDirection;

	/**
	 * Gorilla overloaded default constructor that inherits from the monkey class
	 * 
	 * @param gorilla      gorilla image
	 * @param x            x coordinate
	 * @param y            y coordinate
	 * @param xDirection   x direction tracker
	 * @param yDirection   y direction tracker
	 * @param gorillaImage gorilla image
	 * @param parent       tester class for processing
	 */
	public Gorilla(PImage gorilla, int x, int y, int xDirection, int yDirection, PImage gorillaImage,
			PlayBananaMuncher parent) {
		super(x, y, gorillaImage, parent);// monkey constructor w/ x, y, image, parent

		this.xDirection = 0;
		this.yDirection = 0;
	}

	/**
	 * Gorilla constructr to build a gorilla object that inherits from the monkey
	 * class
	 * 
	 * @param p          parent tester class
	 * @param id         choose a gorilla image to upload
	 * @param x          x coordinate
	 * @param y          y coordinate
	 * @param xDirection x direction tracking
	 * @param yDirection y direction tracking
	 */
	public Gorilla(PlayBananaMuncher p, int id, int x, int y, int xDirection, int yDirection) {

		super(p, x, y);

		this.xDirection = xDirection;
		this.yDirection = yDirection;

		switch (id) {
		case 0:
			this.image = parent.loadImage("src/gorilla1.png");
			break;
		case 1:
			this.image = parent.loadImage("src/gorilla2.png");
			break;
		case 2:
			this.image = parent.loadImage("src/gorilla3.png");
			break;
		case 3:
			this.image = parent.loadImage("src/gorilla4.png");
			break;
		}
	}

	/**
	 * A method that draws the gorilla images
	 */
	public void drawGorillas() {
		parent.image(image, x, y);
		image.resize(0, 90);
	}

	/**
	 * A method that checks the moving gorillas on screen, with window set
	 * boundaries
	 */
	public void checkBounds() {
		if (x < 0 || x > 900) {
			xDirection = xDirection * (-1);
		}
		if (y < 0 || y > 900) {
			yDirection = yDirection * (-1);
		}
	}

	/**
	 * x direction getter
	 * 
	 * @return xDirection
	 */
	public int getxDirection() {
		return xDirection;
	}

	/**
	 * y direction getter
	 * 
	 * @return yDirection
	 */
	public int getyDirection() {
		return yDirection;
	}

	/**
	 * X direction setter
	 * 
	 * @param xDirection
	 */
	public void setxDirection(int xDirection) {
		this.xDirection = xDirection;
	}

	/**
	 * y direction setter
	 * 
	 * @param yDirection
	 */
	public void setyDirection(int yDirection) {
		this.yDirection = yDirection;
	}
}
