package edu.nyu.cs.ecs522;

import processing.core.*;

/**
 * A banana class that creates banana objects
 * 
 * @author emmasaros
 * @version 1
 */

public class Banana extends PApplet {
	/**
	 * x coordinate
	 */
	private int x;
	/**
	 * y coordinate
	 */
	private int y;
	/**
	 * banana image variable
	 */
	private PImage bananaImage;
	/**
	 * parent class caller
	 */
	private PlayBananaMuncher parent;
	/**
	 * boolean flag for banana collision and erasing
	 */
	private boolean isEaten;

	/**
	 * Overloaded default banana constructor
	 */
	public Banana() {
		x = y = 0;
		bananaImage = null;
		parent = null;
		isEaten = false;
	}

	/**
	 * Banana constructor that creates our banana object
	 * 
	 * @param p     calls parent class
	 * @param x     x coordinate
	 * @param y     y coordinate
	 * @param eaten boolean for banana erasing and collision
	 */
	public Banana(PlayBananaMuncher p, int x, int y, boolean eaten) {
		this.x = x;
		this.y = y;
		this.parent = p;
		this.bananaImage = parent.loadImage("src/banana.png");
		this.isEaten = eaten;
	}

	/**
	 * boolean IsEaten getter
	 * 
	 * @return
	 */
	public boolean getIsEaten() {
		return isEaten;
	}

	/**
	 * A method that draws a banana
	 */
	public void drawBanana() {
		if (this.isEaten == false) {
			parent.image(bananaImage, x, y);
			bananaImage.resize(0, 30);
		}
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

	/**
	 * x coordinate setter
	 * 
	 * @param x
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * y coordinate setter
	 * 
	 * @param y
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * boolean isEaten setter
	 * 
	 * @param isEaten
	 */
	public void setEaten(boolean isEaten) {
		this.isEaten = isEaten;
	}

}
