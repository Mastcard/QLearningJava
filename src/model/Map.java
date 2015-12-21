/**
 *
 */
package model;

/**
 * The Class Map.
 * 
 * @author Adrien
 */
public class Map {

	/** The grid. */
	private Block[][] grid;
	
	/** The width. */
	private int width;
	
	/** The height. */
	private int height;
	
	/**
	 * Instantiates a new Map.
	 * 
	 * @param width
	 * @param height
	 */
	public Map(int width, int height) {
		this.width = width;
		this.height = height;
	}
	
	/**
	 * Init the map and all its blocks.
	 */
	public void init() {
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				Block block = new Block(x, y, false, 0);
				block.init();
				grid[x][y] = block;
			}
		}
	}

	/**
	 * Gets the width.
	 * 
	 * @return the width
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * Sets the width.
	 * 
	 * @param width the width to set
	 */
	public void setWidth(int width) {
		this.width = width;
	}

	/**
	 * Gets the height.
	 * 
	 * @return the height
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * Sets the height.
	 * 
	 * @param height the height to set
	 */
	public void setHeight(int height) {
		this.height = height;
	}
	
	/**
	 * Gets block at x, y.
	 * 
	 * @param x
	 * @param y
	 * @return the block
	 */
	public Block getAt(int x, int y ) {
		return grid[x][y];
	}
	
}
