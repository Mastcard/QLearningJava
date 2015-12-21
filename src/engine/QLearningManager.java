/**
 *
 */
package engine;

import util.Constants;
import model.Block;
import model.DirectionEnum;
import model.Map;
import model.Robot;

/**
 * The Class QLearningManager.
 * 
 * @author Adrien
 */
public class QLearningManager {

	/** The instance. */
	private static QLearningManager instance = new QLearningManager();
	
	/** The map. */
	private Map map;
	
	/** The robot. */
	private Robot robot;
	
	/**
	 * Instantiates a new QLearningManager.
	 *
	 */
	private QLearningManager() {
	}
	
	/**
	 * Gets the instance.
	 * 
	 * @return the instance
	 */
	public static QLearningManager getInstance() {
		return instance;
	}

	/**
	 * Execute.
	 */
	public void execute() {
		int currentX = robot.getX();
		int currentY = robot.getY();
		Block block = map.getAt(currentX, currentY);
		
		// Choose the greatest Q(s,a)
		// And move robot
		DirectionEnum direction = null;
		do {
			direction = chooseDirection(block);
		} while (moveRobot(robot, direction) == false);
		
		// Update Q(s,a)
		double Q = block.getQ().get(direction);
		int newX = robot.getX();
		int newY = robot.getY();
		Block newBlock = map.getAt(newX, newY);
		double maxQprime = newBlock.getQ().get(chooseDirection(newBlock));
		
		double newQ = (1-Constants.ALPHA)*Q + Constants.ALPHA*(block.getEnhancement() + Constants.GAMMA*maxQprime);
		block.getQ().put(direction, newQ);
	}
	
	/**
	 * Move robot.
	 */
	private boolean moveRobot(Robot robot, DirectionEnum direction) {
		int x = robot.getX();
		int y = robot.getY();
		boolean wellMoved = true;
		
		switch (direction) {
			case UP:
				if (y == 0) {
					wellMoved = false;
				} else {
					robot.setY(--y);
				}
				break;
			case DOWN:
				if (y == map.getHeight() - 1) {
					wellMoved = false;
				} else {
					robot.setX(++y);
				}
				break;
			case LEFT:
				if (x == 0) {
					wellMoved = false;
				} else {
					robot.setX(--x);
				}
			case RIGHT:
				if (x == map.getWidth() - 1) {
					wellMoved = false;
				} else {
					robot.setX(++x);
				}
				break;
		}
		
		return wellMoved;
	}
	
	/**
	 * Choose direction.
	 * 
	 * @param block
	 * @return the direction
	 */
	private DirectionEnum chooseDirection(Block block) {
		DirectionEnum result = null;
		double Q_max = -999999;
		
		for (int i = 0; i < DirectionEnum.values().length; i++) {
			DirectionEnum direction = DirectionEnum.values()[i];
			double Q = block.getQ().get(direction);
			if (Q > Q_max) {
				Q_max = Q;
				result = direction;
			}
		}
		
		if (Q_max == 0) {
			do {
				Q_max = block.getQ().get(chooseRandomDirection());
			} while (Q_max < 0);
		}
		
		return result;
	}
	
	/**
	 * Choose random direction.
	 * 
	 * @return the direction
	 */
	private DirectionEnum chooseRandomDirection() {
		return DirectionEnum.values()[(int) (Math.random()%4)];
	}

	/**
	 * Gets the map.
	 * 
	 * @return the map
	 */
	public Map getMap() {
		return map;
	}

	/**
	 * Sets the map.
	 * 
	 * @param map the map to set
	 */
	public void setMap(Map map) {
		this.map = map;
	}

	/**
	 * Gets the robot.
	 * 
	 * @return the robot
	 */
	public Robot getRobot() {
		return robot;
	}

	/**
	 * Sets the robot.
	 * 
	 * @param robot the robot to set
	 */
	public void setRobot(Robot robot) {
		this.robot = robot;
	}
	
}
