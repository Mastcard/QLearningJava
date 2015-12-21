/**
 *
 */
package model;

/**
 * The Class Robot.
 * 
 * @author Adrien
 */
public class Robot {

	/** The x. */
	private int x;
	
	/** The y. */
	private int y;
	
	/**
	 * Instantiates a new Robot.
	 *
	 */
	public Robot() {
		this.x = 0;
		this.y = 0;
	}
	
	/**
	 * Instantiates a new Robot.
	 * 
	 * @param x
	 * @param y
	 */
	public Robot(int x, int y) {
		this.x = x;
		this.y = y;
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
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return "Robot is at (" + x + "," + y + ")";
	}
	
}
