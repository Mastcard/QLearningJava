/**
 *
 */
package model;

import java.util.HashMap;
import java.util.Map;

/**
 * The Class Block.
 * 
 * @author Adrien
 */
public class Block {

	/** The x. */
	private int x;

	/** The y. */
	private int y;
	
	/** The is wall. */
	private boolean isWall;
	
	/** The enhancement. */
	private int enhancement;
	
	/** The Q(s, a). */
	private Map<DirectionEnum, Integer> Q = new HashMap<DirectionEnum, Integer>();
	
	/**
	 * Instantiates a new Block.
	 *
	 */
	public Block() {
		this.x = 0;
		this.y = 0;
		this.isWall = false;
		this.enhancement = 0;
	}
	
	/**
	 * Instantiates a new Block.
	 * 
	 * @param x
	 * @param y
	 */
	public Block(int x, int y) {
		this.x = x;
		this.y = y;
		this.isWall = false;
		this.enhancement = 0;
	}
	
	/**
	 * Instantiates a new Block.
	 * 
	 * @param x
	 * @param y
	 * @param isWall
	 */
	public Block(int x, int y, boolean isWall) {
		this.x = x;
		this.y = y;
		this.isWall = isWall;
		this.enhancement = 0;
	}

	/**
	 * Instantiates a new Block.
	 * 
	 * @param x
	 * @param y
	 * @param isWall
	 * @param enhancement
	 */
	public Block(int x, int y, boolean isWall, int enhancement) {
		this.x = x;
		this.y = y;
		this.isWall = isWall;
		this.enhancement = enhancement;
	}
	
	/**
	 * Init the block's Q(s, a).
	 */
	public void init() {
		if (!Q.isEmpty()) {
			Q.clear();
		}
		for (int i = 0; i < DirectionEnum.values().length; i++) {
			DirectionEnum direction = DirectionEnum.values()[i];
			Q.put(direction, 0);
		}
	}
	
	/**
	 * Gets the x.
	 * 
	 * @return the x
	 */
	public int getX() {
		return x;
	}

	/**
	 * Sets the x.
	 * 
	 * @param x the x to set
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * Gets the y.
	 * 
	 * @return the y
	 */
	public int getY() {
		return y;
	}

	/**
	 * Sets the y.
	 * 
	 * @param y the y to set
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * Gets the isWall.
	 * 
	 * @return the isWall
	 */
	public boolean isWall() {
		return isWall;
	}

	/**
	 * Sets the isWall.
	 * 
	 * @param isWall the isWall to set
	 */
	public void setWall(boolean isWall) {
		this.isWall = isWall;
	}

	/**
	 * Gets the enhancement.
	 * 
	 * @return the enhancement
	 */
	public int getEnhancement() {
		return enhancement;
	}

	/**
	 * Sets the enhancement.
	 * 
	 * @param enhancement the enhancement to set
	 */
	public void setEnhancement(int enhancement) {
		this.enhancement = enhancement;
	}

	/**
	 * Gets the Q.
	 * 
	 * @return the Q
	 */
	public Map<DirectionEnum, Integer> getQ() {
		return Q;
	}
	
	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		String result = "";
		result += "Block (" + x + "," + y + ")\n";
		result += "		isWall = " + isWall + "\n";
		result += "		enhancement = " + enhancement + "\n";
		result += "		Q =>\n";
		for (int i = 0; i < DirectionEnum.values().length; i++) {
			DirectionEnum direction = DirectionEnum.values()[i];
			result += "			" + direction + " = " + Q.get(direction);
		}
		return result;
	}
	
}
