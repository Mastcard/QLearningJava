/**
 *
 */
package model;

/**
 * The Class DirectionEnum.
 * 
 * @author Adrien
 */
public enum DirectionEnum {

	UP ("UP"),
	DOWN ("DOWN"),
	LEFT ("LEFT"),
	RIGHT ("RIGHT");
	
	/** The direction. */
	public String direction = "";
	
	/**
	 * Instantiates a new DirectionEnum.
	 * 
	 * @param direction
	 */
	DirectionEnum(String direction) {
		this.direction = direction;
	}
	
	/**
	 * @see java.lang.Enum#toString()
	 */
	public String toString() {
		return direction;
	}
	
}
