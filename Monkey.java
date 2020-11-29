package edu.nyu.cs.ecs522;

import edu.nyu.cs.ecs522.PlayBananaMuncher;
import processing.core.*;

/**
 * Monkey super class that creates a monkey that follows your mouse
 * 
 * @author emmasaros
 * @extends PApplet
 * @version 1
 */

public class Monkey extends PApplet {
	/**
	 * A method that loads the image and draws a the monkey
	 */
	public void drawMonkey() {
		image = parent.loadImage("src/monkey.png");
		parent.image(this.image, x, y, 80, 80);
	}

	/**
	 * Overloaded default monkey constructor
	 * 
	 * @param x           x position
	 * @param y           y position
	 * @param monkeyImage monkey loaded image
	 * @param parent      call parent, playbananamucher in order to allow processing
	 *                    commands
	 */
	public Monkey(int x, int y, PImage monkeyImage, PlayBananaMuncher parent) {
		this.x = 0;
		this.y = 0;
		this.image = null;
		this.parent = null;
	}

	/**
	 * x coordinate variable that can only be accessed by associated classes
	 */
	protected int x;
	/**
	 * y coordinate variable that can only be accessed by associated classes
	 */
	protected int y;
	/**
	 * image variable that can only be accessed by associated classes
	 */
	protected PImage image;
	/**
	 * parent class that can only be accessed by associated classes
	 */
	protected PlayBananaMuncher parent;

	/**
	 * Monkey constructor that creates our monkey object
	 * 
	 * @param p, parent class
	 * @param x, x coordinate
	 * @param y, y coordinate
	 */
	public Monkey(PlayBananaMuncher p, int x, int y) {
		this.x = x;
		this.y = y;
		this.parent = p;
		this.image = parent.loadImage("src/monkey.png");
	}

	/**
	 * monkey image getter
	 * 
	 * @return this.image
	 */
	public PImage getMonkey() {
		return this.image;
	}

	/**
	 * x coordinate setter
	 * 
	 * @param posX
	 */
	public void setX(int posX) {
		this.x = posX;
	}

	/**
	 * y coordinate setter
	 * 
	 * @param posY
	 */
	public void setY(int posY) {
		this.y = posY;
	}

	/**
	 * x coordinate getter
	 * 
	 * @return x
	 */
	public int getX() {
		return x;
	}

	/**
	 * y coordinate getter
	 * 
	 * @return y
	 */
	public int getY() {
		return y;
	}

}
